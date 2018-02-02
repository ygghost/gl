package nc.impl.gl;

import nc.impl.pub.ace.AceGl_budgetPubServiceImpl;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.gl.budget.AggBudgetVO;
import nc.itf.gl.IGl_budgetMaintain;
import nc.vo.pub.BusinessException;

public class Gl_budgetMaintainImpl extends AceGl_budgetPubServiceImpl
		implements IGl_budgetMaintain {

	@Override
	public void delete(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		super.pubdeleteBills(clientFullVOs, originBills);
	}

	@Override
	public AggBudgetVO[] insert(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		return super.pubinsertBills(clientFullVOs, originBills);
	}

	@Override
	public AggBudgetVO[] update(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		return super.pubupdateBills(clientFullVOs, originBills);
	}

	@Override
	public String[] queryPKs(IQueryScheme queryScheme) throws BusinessException {
		return super.pubquerypkbills(queryScheme);
	}

	@Override
	public AggBudgetVO[] queryBillByPK(String[] pks)
			throws BusinessException {
		return super.pubquerybillbypkbills(pks);
	}


	@Override
	public AggBudgetVO[] save(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		return super.pubsendapprovebills(clientFullVOs, originBills);
	}

	@Override
	public AggBudgetVO[] unsave(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		return super.pubunsendapprovebills(clientFullVOs, originBills);
	}

	@Override
	public AggBudgetVO[] approve(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		return super.pubapprovebills(clientFullVOs, originBills);
	}

	@Override
	public AggBudgetVO[] unapprove(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException {
		return super.pubunapprovebills(clientFullVOs, originBills);
	}

}
