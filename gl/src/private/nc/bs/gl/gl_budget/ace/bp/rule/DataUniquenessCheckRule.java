package nc.bs.gl.gl_budget.ace.bp.rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nc.impl.gl.AggBudgetVOService;
import nc.impl.pubapp.pattern.database.DataAccessUtils;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.md.data.access.NCObject;
import nc.vo.gl.budget.AggBudgetVO;
import nc.vo.gl.budget.BudgetBVO;
import nc.vo.gl.budget.BudgetVO;
import nc.vo.gl.budget.constant.BudgetConstant;
import nc.vo.pub.BusinessException;
import nc.vo.pub.VOStatus;
import nc.vo.pubapp.pattern.data.IRowSet;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import org.apache.commons.lang.StringUtils;

public class DataUniquenessCheckRule implements IRule<AggBudgetVO> {

	@Override
	public void process(AggBudgetVO[] vos) {
		if (vos == null || vos.length == 0) {
			return;
		}
		this.checkBillUniqueness(vos);
	}

	@SuppressWarnings("deprecation")
	private void checkBillUniqueness(AggBudgetVO[] bills) {
		if (bills == null || bills.length == 0) {
			return;
		}

		AggBudgetVOService aggBudgetVOService = new AggBudgetVOService();
		DataAccessUtils dataAccessUtils = new DataAccessUtils();

		for (AggBudgetVO bill : bills) {
			String billtype = bill.getParentVO().getBilltypecode()
					.toUpperCase();
			String tablename = bill.getParentVO().getTableName();
			String pk = bill.getPrimaryKey();
			String pk_org = bill.getParentVO().getPk_org();
			String bperiod = bill.getParentVO().getBperiod();
			String sql = null;
			IRowSet rowSet = null;
			boolean existed = false;
			String errMsg = null;
			BudgetBVO[] billItems = null;
			List<String> mcodes = null;
			AggBudgetVO[] aggBudgetVOs = null;

			switch (billtype) {
			case BudgetConstant.YSDGC_TYPECODE:

				// 校验单据表头信息是否唯一
				String cprodid = bill.getParentVO().getCprodid();
				String djglx = bill.getParentVO().getDef1();// 代加工类型
				String glgs = bill.getParentVO().getDef2();// 关联公司
				String zclx = bill.getParentVO().getDef3();// 自产类型
				djglx = (null == djglx ? "~" : djglx);
				glgs = (null == glgs ? "~" : glgs);
				zclx = (null == zclx ? "~" : zclx);

				sql = String
						.format("select b.pk_org,b.bperiod,m.code cpcode from %1$s b,bd_material m"
								+ " where b.dr=0 and b.cprodid=m.pk_material"
								+ " and (b.pk_org='%2$s' and b.bperiod='%3$s'"
								+ " and b.cprodid='%4$s' and b.def1='%5$s'"
								+ " and b.def2='%6$s' and b.def3='%7$s' and upper(b.billtypecode)='%8$s')",
								tablename, pk_org, bperiod, cprodid, djglx,
								glgs, zclx, billtype);

				rowSet = dataAccessUtils.query(sql);

				// 根据单据主键判断是否为新增单据
				if (null == pk) {
					// 如单据主键为空，说明为新增单据，如在数据库查到有记录(>0)，则判断为重复。
					existed = rowSet.size() > 0;
				} else {
					// 单据主键不为空，根据主键查询单据原信息
					try {
						aggBudgetVOs = aggBudgetVOService.getService()
								.queryBillByPK(new String[] { pk });
					} catch (BusinessException e) {
						e.printStackTrace();
						aggBudgetVOs = null;
					}
					if (null != aggBudgetVOs && aggBudgetVOs.length > 0) {
						BudgetVO vo = aggBudgetVOs[0].getParentVO();
						if (null != vo) {
							String pk_org1 = vo.getPk_org();
							String bperiod1 = vo.getBperiod();
							String cprodid1 = vo.getCprodid();
							String djglx1 = vo.getDef1();// 代加工类型
							String glgs1 = vo.getDef2();// 关联公司
							String zclx1 = vo.getDef3();// 自产类型
							djglx1 = (null == djglx1 ? "~" : djglx1);
							glgs1 = (null == glgs1 ? "~" : glgs1);
							zclx1 = (null == zclx1 ? "~" : zclx1);

							// 单据原关键字段值拼接
							StringBuilder before = new StringBuilder()
									.append(pk_org).append(bperiod)
									.append(cprodid).append(djglx).append(glgs)
									.append(zclx);

							// 前台界面修改后（尚未保存进数据库）单据关键字段值拼接
							StringBuilder after = new StringBuilder()
									.append(pk_org1).append(bperiod1)
									.append(cprodid1).append(djglx1)
									.append(glgs1).append(zclx1);

							// 比较单据修改前后关键字段值
							if (before.toString().equals(after.toString())) {
								// 界面上的关键字段值没被修改，当前单据符合原有唯一性查询条件，
								// 因此至少会在数据库查到1条记录，故记录数要大于1才算重复。
								existed = rowSet.size() > 1;
							} else {
								// 界面上的关键字段值已被修改，根据当前单据修改后的关键字段值进行查找,
								// 如在数据库查到有记录(>0)，则判断为重复。
								existed = rowSet.size() > 0;
							}
						}
					}
				}

				if (existed) {
					String[][] strArr = rowSet.toTwoDimensionStringArray();
					String cpcode = (null != strArr && strArr.length > 0) ? strArr[0][2]
							: "";
					errMsg = String.format(
							"保存失败，当前新增或修改的信息(预算期间[%1$s]和产成品[%2$s])已经存在相同的记录！",
							bperiod, cpcode);
					ExceptionUtils.wrappBusinessException(errMsg);
				}

				// 校验单据表体项是否重复
				billItems = bill.getBodyVOs();
				mcodes = new ArrayList<String>();
				for (BudgetBVO item : billItems) {
					if (VOStatus.DELETED != item.getStatus()) {
						String mcode = NCObject.newInstance(item)
								.getAttributeValue("cmaterialid.code")
								.toString();
						mcodes.add(mcode);
					}
				}
				for (String mc : mcodes) {
					// 统计重复项次数
					int count = Collections.frequency(mcodes, mc);
					if (count > 1) {
						errMsg = String.format(
								"保存失败，当前单据表体项(原料编码[%1$s])存在相同的记录！", mc);
						ExceptionUtils.wrappBusinessException(errMsg);
					}
				}

				break;
			case BudgetConstant.YSDYX_TYPECODE:
				String dglfjg = bill.getParentVO().getDef4();// 是否代关联方加工
				dglfjg = (null == dglfjg ? "~" : dglfjg);

				sql = String
						.format("select b.pk_org,b.bperiod from %1$s b"
								+ " where b.dr=0 and (b.pk_org='%2$s' and b.bperiod='%3$s'"
								+ " and b.def4='%4$s' and upper(b.billtypecode)='%5$s')",
								tablename, pk_org, bperiod, dglfjg, billtype);

				rowSet = dataAccessUtils.query(sql);

				// 根据单据主键判断是否为新增单据
				if (null == pk) {
					// 如单据主键为空，说明为新增单据，如在数据库查到有记录(>0)，则判断为重复。
					existed = rowSet.size() > 0;
				} else {
					// 单据主键不为空，根据主键查询单据原信息
					try {
						aggBudgetVOs = aggBudgetVOService.getService()
								.queryBillByPK(new String[] { pk });
					} catch (BusinessException e) {
						e.printStackTrace();
						aggBudgetVOs = null;
					}
					if (null != aggBudgetVOs && aggBudgetVOs.length > 0) {
						BudgetVO vo = aggBudgetVOs[0].getParentVO();
						if (null != vo) {
							String pk_org1 = vo.getPk_org();
							String bperiod1 = vo.getBperiod();
							String dglfjg1 = vo.getDef4();// 是否代关联方加工
							dglfjg1 = (null == dglfjg1 ? "~" : dglfjg1);

							// 单据原关键字段值拼接
							StringBuilder before = new StringBuilder()
									.append(pk_org).append(bperiod)
									.append(dglfjg);

							// 前台界面修改后（尚未保存进数据库）单据关键字段值拼接
							StringBuilder after = new StringBuilder()
									.append(pk_org1).append(bperiod1)
									.append(dglfjg1);

							// 比较单据修改前后关键字段值
							if (before.toString().equals(after.toString())) {
								// 界面上的关键字段值没被修改，当前单据符合原有唯一性查询条件，
								// 因此至少会在数据库查到1条记录，故记录数要大于1才算重复。
								existed = rowSet.size() > 1;
							} else {
								// 界面上的关键字段值已被修改，根据当前单据修改后的关键字段值进行查找,
								// 如在数据库查到有记录(>0)，则判断为重复。
								existed = rowSet.size() > 0;
							}
						}
					}
				}

				if (existed) {
					errMsg = String.format(
							"保存失败，当前新增或修改的信息(预算期间[%1$s])已经存在相同的记录！", bperiod);
					ExceptionUtils.wrappBusinessException(errMsg);
				}

				// 校验单据表体项是否重复
				billItems = bill.getBodyVOs();
				mcodes = new ArrayList<String>();
				for (BudgetBVO item : billItems) {
					if (VOStatus.DELETED != item.getStatus()) {
						String mcode = NCObject.newInstance(item)
								.getAttributeValue("cprodid.code").toString();
						String vbdef1 = item.getVbdef1();// 代加工类型
						String vbdef2 = item.getVbdef2();// 关联公司
						String vbdef3 = item.getVbdef3();// 自产类型

						mcodes.add(mcode + "_" + vbdef1 + "_" + vbdef2 + "_"
								+ vbdef3);
					}
				}
				for (String mc : mcodes) {
					// 统计重复项次数
					int count = Collections.frequency(mcodes, mc);
					if (count > 1) {
						errMsg = String.format(
								"保存失败，当前单据表体项(产成品编码[%1$s])存在相同的记录！",
								StringUtils.substringBefore(mc, "_"));
						ExceptionUtils.wrappBusinessException(errMsg);
					}
				}

				break;
			case BudgetConstant.YSDCW_TYPECODE:
			case BudgetConstant.YSDSC_TYPECODE:
				sql = String
						.format("select b.pk_org,b.bperiod from %1$s b"
								+ " where b.dr=0 and (b.pk_org='%2$s' and b.bperiod='%3$s' and upper(b.billtypecode)='%4$s')",
								tablename, pk_org, bperiod, billtype);

				rowSet = dataAccessUtils.query(sql);

				// 根据单据主键判断是否为新增单据
				if (null == pk) {
					// 如单据主键为空，说明为新增单据，如在数据库查到有记录(>0)，则判断为重复。
					existed = rowSet.size() > 0;
				} else {
					// 单据主键不为空，根据主键查询单据原信息
					try {
						aggBudgetVOs = aggBudgetVOService.getService()
								.queryBillByPK(new String[] { pk });
					} catch (BusinessException e) {
						e.printStackTrace();
						aggBudgetVOs = null;
					}
					if (null != aggBudgetVOs && aggBudgetVOs.length > 0) {
						BudgetVO vo = aggBudgetVOs[0].getParentVO();
						if (null != vo) {
							String pk_org1 = vo.getPk_org();
							String bperiod1 = vo.getBperiod();

							// 单据原关键字段值拼接
							StringBuilder before = new StringBuilder().append(
									pk_org).append(bperiod);

							// 前台界面修改后（尚未保存进数据库）单据关键字段值拼接
							StringBuilder after = new StringBuilder().append(
									pk_org1).append(bperiod1);

							// 比较单据修改前后关键字段值
							if (before.toString().equals(after.toString())) {
								// 界面上的关键字段值没被修改，当前单据符合原有唯一性查询条件，
								// 因此至少会在数据库查到1条记录，故记录数要大于1才算重复。
								existed = rowSet.size() > 1;
							} else {
								// 界面上的关键字段值已被修改，根据当前单据修改后的关键字段值进行查找,
								// 如在数据库查到有记录(>0)，则判断为重复。
								existed = rowSet.size() > 0;
							}
						}
					}
				}

				if (existed) {
					errMsg = String.format(
							"保存失败，当前新增或修改的信息(预算期间[%1$s])已经存在相同的记录！", bperiod);
					ExceptionUtils.wrappBusinessException(errMsg);
				}

				// 校验单据表体项是否重复
				billItems = bill.getBodyVOs();
				mcodes = new ArrayList<String>();
				for (BudgetBVO item : billItems) {
					if (VOStatus.DELETED != item.getStatus()) {
						String mcode = NCObject.newInstance(item)
								.getAttributeValue("cprodid.code").toString();
						String vbdef1 = item.getVbdef1();// 代加工类型
						String vbdef2 = item.getVbdef2();// 关联公司
						String vbdef3 = item.getVbdef3();// 自产类型

						mcodes.add(mcode + "_" + vbdef1 + "_" + vbdef2 + "_"
								+ vbdef3);
					}
				}
				for (String mc : mcodes) {
					// 统计重复项次数
					int count = Collections.frequency(mcodes, mc);
					if (count > 1) {
						errMsg = String.format(
								"保存失败，当前单据表体项(产成品编码[%1$s])存在相同的记录！",
								StringUtils.substringBefore(mc, "_"));
						ExceptionUtils.wrappBusinessException(errMsg);
					}
				}

				break;
			case BudgetConstant.YSDCG_TYPECODE:
				sql = String
						.format("select b.pk_org,b.bperiod from %1$s b"
								+ " where b.dr=0 and (b.pk_org='%2$s' and b.bperiod='%3$s' and upper(b.billtypecode)='%4$s')",
								tablename, pk_org, bperiod, billtype);

				rowSet = dataAccessUtils.query(sql);

				// 根据单据主键判断是否为新增单据
				if (null == pk) {
					// 如单据主键为空，说明为新增单据，如在数据库查到有记录(>0)，则判断为重复。
					existed = rowSet.size() > 0;
				} else {
					// 单据主键不为空，根据主键查询单据原信息
					try {
						aggBudgetVOs = aggBudgetVOService.getService()
								.queryBillByPK(new String[] { pk });
					} catch (BusinessException e) {
						e.printStackTrace();
						aggBudgetVOs = null;
					}
					if (null != aggBudgetVOs && aggBudgetVOs.length > 0) {
						BudgetVO vo = aggBudgetVOs[0].getParentVO();
						if (null != vo) {
							String pk_org1 = vo.getPk_org();
							String bperiod1 = vo.getBperiod();

							// 单据原关键字段值拼接
							StringBuilder before = new StringBuilder().append(
									pk_org).append(bperiod);

							// 前台界面修改后（尚未保存进数据库）单据关键字段值拼接
							StringBuilder after = new StringBuilder().append(
									pk_org1).append(bperiod1);

							// 比较单据修改前后关键字段值
							if (before.toString().equals(after.toString())) {
								// 界面上的关键字段值没被修改，当前单据符合原有唯一性查询条件，
								// 因此至少会在数据库查到1条记录，故记录数要大于1才算重复。
								existed = rowSet.size() > 1;
							} else {
								// 界面上的关键字段值已被修改，根据当前单据修改后的关键字段值进行查找,
								// 如在数据库查到有记录(>0)，则判断为重复。
								existed = rowSet.size() > 0;
							}
						}
					}
				}

				if (existed) {
					errMsg = String.format(
							"保存失败，当前新增或修改的信息(预算期间[%1$s])已经存在相同的记录！", bperiod);
					ExceptionUtils.wrappBusinessException(errMsg);
				}

				// 校验单据表体项是否重复
				billItems = bill.getBodyVOs();
				mcodes = new ArrayList<String>();
				for (BudgetBVO item : billItems) {
					if (VOStatus.DELETED != item.getStatus()) {
						String mcode = NCObject.newInstance(item)
								.getAttributeValue("cmaterialid.code")
								.toString();
						mcodes.add(mcode);
					}
				}
				for (String mc : mcodes) {
					// 统计重复项次数
					int count = Collections.frequency(mcodes, mc);
					if (count > 1) {
						errMsg = String.format(
								"保存失败，当前单据表体项(原料编码[%1$s])存在相同的记录！", mc);
						ExceptionUtils.wrappBusinessException(errMsg);
					}
				}

				break;
			default:

				break;
			}

		}

	}
}
