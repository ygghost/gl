package nc.bs.gl.gl_budget.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.gl.budget.AggBudgetVO;
import nc.vo.pub.VOStatus;

/**
 * 标准单据弃审的BP
 */
public class AceGl_budgetUnApproveBP {

	public AggBudgetVO[] unApprove(AggBudgetVO[] clientBills,
			AggBudgetVO[] originBills) {
		for (AggBudgetVO clientBill : clientBills) {
			clientBill.getParentVO().setStatus(VOStatus.UPDATED);
		}
		BillUpdate<AggBudgetVO> update = new BillUpdate<AggBudgetVO>();
		AggBudgetVO[] returnVos = update.update(clientBills, originBills);
		return returnVos;
	}
}
