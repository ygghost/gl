package nc.bs.gl.gl_budget.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.gl.budget.AggBudgetVO;
import nc.vo.pub.VOStatus;
import nc.vo.pub.pf.BillStatusEnum;

/**
 * ��׼�����ջص�BP
 */
public class AceGl_budgetUnSendApproveBP {

	public AggBudgetVO[] unSend(AggBudgetVO[] clientBills,
			AggBudgetVO[] originBills) {
		// ��VO�־û������ݿ���
		this.setHeadVOStatus(clientBills);
		BillUpdate<AggBudgetVO> update = new BillUpdate<AggBudgetVO>();
		AggBudgetVO[] returnVos = update.update(clientBills, originBills);
		return returnVos;
	}

	private void setHeadVOStatus(AggBudgetVO[] clientBills) {
		for (AggBudgetVO clientBill : clientBills) {
			clientBill.getParentVO().setAttributeValue("${vmObject.billstatus}",
					BillStatusEnum.FREE.value());
			clientBill.getParentVO().setStatus(VOStatus.UPDATED);
		}
	}
}
