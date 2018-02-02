package nc.bs.gl.gl_budget.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.pub.VOStatus;
import nc.vo.gl.budget.AggBudgetVO;

/**
 * ��׼������˵�BP
 */
public class AceGl_budgetApproveBP {

	/**
	 * ��˶���
	 * 
	 * @param vos
	 * @param script
	 * @return
	 */
	public AggBudgetVO[] approve(AggBudgetVO[] clientBills,
			AggBudgetVO[] originBills) {
		for (AggBudgetVO clientBill : clientBills) {
			clientBill.getParentVO().setStatus(VOStatus.UPDATED);
		}
		BillUpdate<AggBudgetVO> update = new BillUpdate<AggBudgetVO>();
		AggBudgetVO[] returnVos = update.update(clientBills, originBills);
		return returnVos;
	}

}
