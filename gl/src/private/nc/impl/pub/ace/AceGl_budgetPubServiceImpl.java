package nc.impl.pub.ace;

import nc.bs.gl.gl_budget.ace.bp.AceGl_budgetApproveBP;
import nc.bs.gl.gl_budget.ace.bp.AceGl_budgetDeleteBP;
import nc.bs.gl.gl_budget.ace.bp.AceGl_budgetInsertBP;
import nc.bs.gl.gl_budget.ace.bp.AceGl_budgetSendApproveBP;
import nc.bs.gl.gl_budget.ace.bp.AceGl_budgetUnApproveBP;
import nc.bs.gl.gl_budget.ace.bp.AceGl_budgetUnSendApproveBP;
import nc.bs.gl.gl_budget.ace.bp.AceGl_budgetUpdateBP;
import nc.impl.pubapp.pattern.data.bill.BillQuery;
import nc.impl.pubapp.pattern.data.bill.tool.BillTransferTool;
import nc.impl.pubapp.pattern.database.DataAccessUtils;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.util.mmf.framework.base.MMValueCheck;
import nc.vo.gl.budget.AggBudgetVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.VOStatus;
import nc.vo.pubapp.bill.pagination.util.PaginationUtils;
import nc.vo.pubapp.pattern.data.IRowSet;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.pubapp.query2.sql.process.QuerySchemeProcessor;
import nc.vo.tmpub.util.SqlUtil;

public abstract class AceGl_budgetPubServiceImpl {
	// ����
	public AggBudgetVO[] pubinsertBills(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		try {
			// ���ݿ������ݺ�ǰ̨���ݹ����Ĳ���VO�ϲ���Ľ��
			BillTransferTool<AggBudgetVO> transferTool = new BillTransferTool<AggBudgetVO>(
					clientFullVOs);
			// ����BP
			AceGl_budgetInsertBP action = new AceGl_budgetInsertBP();
			AggBudgetVO[] retvos = action.insert(clientFullVOs);
			// ���췵������
			return transferTool.getBillForToClient(retvos);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	// ɾ��
	public void pubdeleteBills(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		try {
			// ����BP
			new AceGl_budgetDeleteBP().delete(clientFullVOs);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
	}

	// �޸�
	public AggBudgetVO[] pubupdateBills(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		try {
			// ���� + ���ts
			BillTransferTool<AggBudgetVO> transferTool = new BillTransferTool<AggBudgetVO>(
					clientFullVOs);
			AceGl_budgetUpdateBP bp = new AceGl_budgetUpdateBP();
			AggBudgetVO[] retvos = bp.update(clientFullVOs, originBills);
			// ���췵������
			return transferTool.getBillForToClient(retvos);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	// ��ҳ��ѯ��������ѯ����PK
	@SuppressWarnings("deprecation")
	public String[] pubquerypkbills(IQueryScheme queryScheme)
			throws BusinessException {
		StringBuffer sql = new StringBuffer();
		QuerySchemeProcessor processor = new QuerySchemeProcessor(queryScheme);
		String mainAlias = processor.getMainTableAlias();
		String[] periods = processor.getLogicalCondition("period") == null ? null
				: processor.getLogicalCondition("period").getValues();
		if (MMValueCheck.isNotEmpty(periods)) {
			String wheresql = " and "
					+ SqlUtil.buildSqlForIn(mainAlias + ".bperiod", periods);
			processor.appendWhere(wheresql);
		}
		sql.append(" select distinct ");
		sql.append(mainAlias);
		sql.append(".");
		sql.append("pk_budget");
		sql.append(processor.getFinalFromWhere());
		DataAccessUtils dao = new DataAccessUtils();
		IRowSet rowset = dao.query(sql.toString());
		String[] keys = rowset.toOneDimensionStringArray();
		return keys;
	}

	// ��ҳ��ѯ����������PK�鵥��
	public AggBudgetVO[] pubquerybillbypkbills(String[] pks)
			throws BusinessException {
		AggBudgetVO[] bills = null;
		BillQuery<AggBudgetVO> query = new BillQuery<AggBudgetVO>(
				AggBudgetVO.class);
		bills = query.query(pks);
		return PaginationUtils.filterNotExistBills(bills, pks);
	}

	// �ύ
	public AggBudgetVO[] pubsendapprovebills(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		AceGl_budgetSendApproveBP bp = new AceGl_budgetSendApproveBP();
		AggBudgetVO[] retvos = bp.sendApprove(clientFullVOs, originBills);
		return retvos;
	}

	// �ջ�
	public AggBudgetVO[] pubunsendapprovebills(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		AceGl_budgetUnSendApproveBP bp = new AceGl_budgetUnSendApproveBP();
		AggBudgetVO[] retvos = bp.unSend(clientFullVOs, originBills);
		return retvos;
	};

	// ����
	public AggBudgetVO[] pubapprovebills(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		for (int i = 0; clientFullVOs != null && i < clientFullVOs.length; i++) {
			clientFullVOs[i].getParentVO().setStatus(VOStatus.UPDATED);
		}
		AceGl_budgetApproveBP bp = new AceGl_budgetApproveBP();
		AggBudgetVO[] retvos = bp.approve(clientFullVOs, originBills);
		return retvos;
	}

	// ����

	public AggBudgetVO[] pubunapprovebills(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		for (int i = 0; clientFullVOs != null && i < clientFullVOs.length; i++) {
			clientFullVOs[i].getParentVO().setStatus(VOStatus.UPDATED);
		}
		AceGl_budgetUnApproveBP bp = new AceGl_budgetUnApproveBP();
		AggBudgetVO[] retvos = bp.unApprove(clientFullVOs, originBills);
		return retvos;
	}

}