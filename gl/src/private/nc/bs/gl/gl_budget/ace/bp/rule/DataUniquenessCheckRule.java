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

				// У�鵥�ݱ�ͷ��Ϣ�Ƿ�Ψһ
				String cprodid = bill.getParentVO().getCprodid();
				String djglx = bill.getParentVO().getDef1();// ���ӹ�����
				String glgs = bill.getParentVO().getDef2();// ������˾
				String zclx = bill.getParentVO().getDef3();// �Բ�����
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

				// ���ݵ��������ж��Ƿ�Ϊ��������
				if (null == pk) {
					// �絥������Ϊ�գ�˵��Ϊ�������ݣ��������ݿ�鵽�м�¼(>0)�����ж�Ϊ�ظ���
					existed = rowSet.size() > 0;
				} else {
					// ����������Ϊ�գ�����������ѯ����ԭ��Ϣ
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
							String djglx1 = vo.getDef1();// ���ӹ�����
							String glgs1 = vo.getDef2();// ������˾
							String zclx1 = vo.getDef3();// �Բ�����
							djglx1 = (null == djglx1 ? "~" : djglx1);
							glgs1 = (null == glgs1 ? "~" : glgs1);
							zclx1 = (null == zclx1 ? "~" : zclx1);

							// ����ԭ�ؼ��ֶ�ֵƴ��
							StringBuilder before = new StringBuilder()
									.append(pk_org).append(bperiod)
									.append(cprodid).append(djglx).append(glgs)
									.append(zclx);

							// ǰ̨�����޸ĺ���δ��������ݿ⣩���ݹؼ��ֶ�ֵƴ��
							StringBuilder after = new StringBuilder()
									.append(pk_org1).append(bperiod1)
									.append(cprodid1).append(djglx1)
									.append(glgs1).append(zclx1);

							// �Ƚϵ����޸�ǰ��ؼ��ֶ�ֵ
							if (before.toString().equals(after.toString())) {
								// �����ϵĹؼ��ֶ�ֵû���޸ģ���ǰ���ݷ���ԭ��Ψһ�Բ�ѯ������
								// ������ٻ������ݿ�鵽1����¼���ʼ�¼��Ҫ����1�����ظ���
								existed = rowSet.size() > 1;
							} else {
								// �����ϵĹؼ��ֶ�ֵ�ѱ��޸ģ����ݵ�ǰ�����޸ĺ�Ĺؼ��ֶ�ֵ���в���,
								// �������ݿ�鵽�м�¼(>0)�����ж�Ϊ�ظ���
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
							"����ʧ�ܣ���ǰ�������޸ĵ���Ϣ(Ԥ���ڼ�[%1$s]�Ͳ���Ʒ[%2$s])�Ѿ�������ͬ�ļ�¼��",
							bperiod, cpcode);
					ExceptionUtils.wrappBusinessException(errMsg);
				}

				// У�鵥�ݱ������Ƿ��ظ�
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
					// ͳ���ظ������
					int count = Collections.frequency(mcodes, mc);
					if (count > 1) {
						errMsg = String.format(
								"����ʧ�ܣ���ǰ���ݱ�����(ԭ�ϱ���[%1$s])������ͬ�ļ�¼��", mc);
						ExceptionUtils.wrappBusinessException(errMsg);
					}
				}

				break;
			case BudgetConstant.YSDYX_TYPECODE:
				String dglfjg = bill.getParentVO().getDef4();// �Ƿ���������ӹ�
				dglfjg = (null == dglfjg ? "~" : dglfjg);

				sql = String
						.format("select b.pk_org,b.bperiod from %1$s b"
								+ " where b.dr=0 and (b.pk_org='%2$s' and b.bperiod='%3$s'"
								+ " and b.def4='%4$s' and upper(b.billtypecode)='%5$s')",
								tablename, pk_org, bperiod, dglfjg, billtype);

				rowSet = dataAccessUtils.query(sql);

				// ���ݵ��������ж��Ƿ�Ϊ��������
				if (null == pk) {
					// �絥������Ϊ�գ�˵��Ϊ�������ݣ��������ݿ�鵽�м�¼(>0)�����ж�Ϊ�ظ���
					existed = rowSet.size() > 0;
				} else {
					// ����������Ϊ�գ�����������ѯ����ԭ��Ϣ
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
							String dglfjg1 = vo.getDef4();// �Ƿ���������ӹ�
							dglfjg1 = (null == dglfjg1 ? "~" : dglfjg1);

							// ����ԭ�ؼ��ֶ�ֵƴ��
							StringBuilder before = new StringBuilder()
									.append(pk_org).append(bperiod)
									.append(dglfjg);

							// ǰ̨�����޸ĺ���δ��������ݿ⣩���ݹؼ��ֶ�ֵƴ��
							StringBuilder after = new StringBuilder()
									.append(pk_org1).append(bperiod1)
									.append(dglfjg1);

							// �Ƚϵ����޸�ǰ��ؼ��ֶ�ֵ
							if (before.toString().equals(after.toString())) {
								// �����ϵĹؼ��ֶ�ֵû���޸ģ���ǰ���ݷ���ԭ��Ψһ�Բ�ѯ������
								// ������ٻ������ݿ�鵽1����¼���ʼ�¼��Ҫ����1�����ظ���
								existed = rowSet.size() > 1;
							} else {
								// �����ϵĹؼ��ֶ�ֵ�ѱ��޸ģ����ݵ�ǰ�����޸ĺ�Ĺؼ��ֶ�ֵ���в���,
								// �������ݿ�鵽�м�¼(>0)�����ж�Ϊ�ظ���
								existed = rowSet.size() > 0;
							}
						}
					}
				}

				if (existed) {
					errMsg = String.format(
							"����ʧ�ܣ���ǰ�������޸ĵ���Ϣ(Ԥ���ڼ�[%1$s])�Ѿ�������ͬ�ļ�¼��", bperiod);
					ExceptionUtils.wrappBusinessException(errMsg);
				}

				// У�鵥�ݱ������Ƿ��ظ�
				billItems = bill.getBodyVOs();
				mcodes = new ArrayList<String>();
				for (BudgetBVO item : billItems) {
					if (VOStatus.DELETED != item.getStatus()) {
						String mcode = NCObject.newInstance(item)
								.getAttributeValue("cprodid.code").toString();
						String vbdef1 = item.getVbdef1();// ���ӹ�����
						String vbdef2 = item.getVbdef2();// ������˾
						String vbdef3 = item.getVbdef3();// �Բ�����

						mcodes.add(mcode + "_" + vbdef1 + "_" + vbdef2 + "_"
								+ vbdef3);
					}
				}
				for (String mc : mcodes) {
					// ͳ���ظ������
					int count = Collections.frequency(mcodes, mc);
					if (count > 1) {
						errMsg = String.format(
								"����ʧ�ܣ���ǰ���ݱ�����(����Ʒ����[%1$s])������ͬ�ļ�¼��",
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

				// ���ݵ��������ж��Ƿ�Ϊ��������
				if (null == pk) {
					// �絥������Ϊ�գ�˵��Ϊ�������ݣ��������ݿ�鵽�м�¼(>0)�����ж�Ϊ�ظ���
					existed = rowSet.size() > 0;
				} else {
					// ����������Ϊ�գ�����������ѯ����ԭ��Ϣ
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

							// ����ԭ�ؼ��ֶ�ֵƴ��
							StringBuilder before = new StringBuilder().append(
									pk_org).append(bperiod);

							// ǰ̨�����޸ĺ���δ��������ݿ⣩���ݹؼ��ֶ�ֵƴ��
							StringBuilder after = new StringBuilder().append(
									pk_org1).append(bperiod1);

							// �Ƚϵ����޸�ǰ��ؼ��ֶ�ֵ
							if (before.toString().equals(after.toString())) {
								// �����ϵĹؼ��ֶ�ֵû���޸ģ���ǰ���ݷ���ԭ��Ψһ�Բ�ѯ������
								// ������ٻ������ݿ�鵽1����¼���ʼ�¼��Ҫ����1�����ظ���
								existed = rowSet.size() > 1;
							} else {
								// �����ϵĹؼ��ֶ�ֵ�ѱ��޸ģ����ݵ�ǰ�����޸ĺ�Ĺؼ��ֶ�ֵ���в���,
								// �������ݿ�鵽�м�¼(>0)�����ж�Ϊ�ظ���
								existed = rowSet.size() > 0;
							}
						}
					}
				}

				if (existed) {
					errMsg = String.format(
							"����ʧ�ܣ���ǰ�������޸ĵ���Ϣ(Ԥ���ڼ�[%1$s])�Ѿ�������ͬ�ļ�¼��", bperiod);
					ExceptionUtils.wrappBusinessException(errMsg);
				}

				// У�鵥�ݱ������Ƿ��ظ�
				billItems = bill.getBodyVOs();
				mcodes = new ArrayList<String>();
				for (BudgetBVO item : billItems) {
					if (VOStatus.DELETED != item.getStatus()) {
						String mcode = NCObject.newInstance(item)
								.getAttributeValue("cprodid.code").toString();
						String vbdef1 = item.getVbdef1();// ���ӹ�����
						String vbdef2 = item.getVbdef2();// ������˾
						String vbdef3 = item.getVbdef3();// �Բ�����

						mcodes.add(mcode + "_" + vbdef1 + "_" + vbdef2 + "_"
								+ vbdef3);
					}
				}
				for (String mc : mcodes) {
					// ͳ���ظ������
					int count = Collections.frequency(mcodes, mc);
					if (count > 1) {
						errMsg = String.format(
								"����ʧ�ܣ���ǰ���ݱ�����(����Ʒ����[%1$s])������ͬ�ļ�¼��",
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

				// ���ݵ��������ж��Ƿ�Ϊ��������
				if (null == pk) {
					// �絥������Ϊ�գ�˵��Ϊ�������ݣ��������ݿ�鵽�м�¼(>0)�����ж�Ϊ�ظ���
					existed = rowSet.size() > 0;
				} else {
					// ����������Ϊ�գ�����������ѯ����ԭ��Ϣ
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

							// ����ԭ�ؼ��ֶ�ֵƴ��
							StringBuilder before = new StringBuilder().append(
									pk_org).append(bperiod);

							// ǰ̨�����޸ĺ���δ��������ݿ⣩���ݹؼ��ֶ�ֵƴ��
							StringBuilder after = new StringBuilder().append(
									pk_org1).append(bperiod1);

							// �Ƚϵ����޸�ǰ��ؼ��ֶ�ֵ
							if (before.toString().equals(after.toString())) {
								// �����ϵĹؼ��ֶ�ֵû���޸ģ���ǰ���ݷ���ԭ��Ψһ�Բ�ѯ������
								// ������ٻ������ݿ�鵽1����¼���ʼ�¼��Ҫ����1�����ظ���
								existed = rowSet.size() > 1;
							} else {
								// �����ϵĹؼ��ֶ�ֵ�ѱ��޸ģ����ݵ�ǰ�����޸ĺ�Ĺؼ��ֶ�ֵ���в���,
								// �������ݿ�鵽�м�¼(>0)�����ж�Ϊ�ظ���
								existed = rowSet.size() > 0;
							}
						}
					}
				}

				if (existed) {
					errMsg = String.format(
							"����ʧ�ܣ���ǰ�������޸ĵ���Ϣ(Ԥ���ڼ�[%1$s])�Ѿ�������ͬ�ļ�¼��", bperiod);
					ExceptionUtils.wrappBusinessException(errMsg);
				}

				// У�鵥�ݱ������Ƿ��ظ�
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
					// ͳ���ظ������
					int count = Collections.frequency(mcodes, mc);
					if (count > 1) {
						errMsg = String.format(
								"����ʧ�ܣ���ǰ���ݱ�����(ԭ�ϱ���[%1$s])������ͬ�ļ�¼��", mc);
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
