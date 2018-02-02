package nc.itf.gl;

import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.gl.budget.AggBudgetVO;
import nc.vo.pub.BusinessException;

public interface IGl_budgetMaintain {

	public void delete(AggBudgetVO[] clientFullVOs, AggBudgetVO[] originBills)
			throws BusinessException;

	public AggBudgetVO[] insert(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException;

	public AggBudgetVO[] update(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException;

	public String[] queryPKs(IQueryScheme queryScheme) throws BusinessException;

	public AggBudgetVO[] queryBillByPK(String[] pks) throws BusinessException;

	public AggBudgetVO[] save(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException;

	public AggBudgetVO[] unsave(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException;

	public AggBudgetVO[] approve(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException;

	public AggBudgetVO[] unapprove(AggBudgetVO[] clientFullVOs,
			AggBudgetVO[] originBills) throws BusinessException;
}
