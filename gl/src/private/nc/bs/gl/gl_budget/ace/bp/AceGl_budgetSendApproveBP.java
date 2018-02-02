package nc.bs.gl.gl_budget.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.gl.budget.AggBudgetVO;
import nc.vo.pub.VOStatus;
import nc.vo.pub.pf.BillStatusEnum;

/**
 * 标准单据送审的BP
 */
public class AceGl_budgetSendApproveBP {
	/**
	 * 送审动作
	 * 
	 * @param vos
	 *            单据VO数组
	 * @param script
	 *            单据动作脚本对象
	 * @return 送审后的单据VO数组
	 */

	public AggBudgetVO[] sendApprove(AggBudgetVO[] clientBills,
			AggBudgetVO[] originBills) {
		for (AggBudgetVO clientFullVO : clientBills) {
			clientFullVO.getParentVO().setAttributeValue("${vmObject.billstatus}",
					BillStatusEnum.COMMIT.value());
			clientFullVO.getParentVO().setStatus(VOStatus.UPDATED);
		}
		// 数据持久化
		AggBudgetVO[] returnVos = new BillUpdate<AggBudgetVO>().update(
				clientBills, originBills);
		return returnVos;
	}
}
