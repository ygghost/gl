package nc.bs.gl.gl_budget.ace.bp;

import nc.bs.gl.gl_budget.ace.bp.rule.DataUniquenessCheckRule;
import nc.bs.gl.gl_budget.plugin.bpplugin.Gl_budgetPluginPoint;
import nc.impl.pubapp.pattern.data.bill.template.UpdateBPTemplate;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.gl.budget.AggBudgetVO;

/**
 * 修改保存的BP
 * 
 */
public class AceGl_budgetUpdateBP {

	public AggBudgetVO[] update(AggBudgetVO[] bills, AggBudgetVO[] originBills) {
		// 调用修改模板
		UpdateBPTemplate<AggBudgetVO> bp = new UpdateBPTemplate<AggBudgetVO>(
				Gl_budgetPluginPoint.UPDATE);
		// 执行前规则
		this.addBeforeRule(bp.getAroundProcesser());
		// 执行后规则
		this.addAfterRule(bp.getAroundProcesser());
		return bp.update(bills, originBills);
	}

	private void addAfterRule(CompareAroundProcesser<AggBudgetVO> processer) {
		// TODO 后规则
		IRule<AggBudgetVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.BillCodeCheckRule();
		((nc.bs.pubapp.pub.rule.BillCodeCheckRule) rule).setCbilltype("YSDJ");
		((nc.bs.pubapp.pub.rule.BillCodeCheckRule) rule).setCodeItem("billno");
		((nc.bs.pubapp.pub.rule.BillCodeCheckRule) rule)
				.setGroupItem("pk_group");
		((nc.bs.pubapp.pub.rule.BillCodeCheckRule) rule).setOrgItem("pk_org");
		processer.addAfterRule(rule);
	}

	private void addBeforeRule(CompareAroundProcesser<AggBudgetVO> processer) {
		// TODO 前规则
		IRule<AggBudgetVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.FillUpdateDataRule();
		processer.addBeforeRule(rule);
		nc.impl.pubapp.pattern.rule.ICompareRule<AggBudgetVO> ruleCom = new nc.bs.pubapp.pub.rule.UpdateBillCodeRule();
		((nc.bs.pubapp.pub.rule.UpdateBillCodeRule) ruleCom)
				.setCbilltype("YSDJ");
		((nc.bs.pubapp.pub.rule.UpdateBillCodeRule) ruleCom)
				.setCodeItem("billno");
		((nc.bs.pubapp.pub.rule.UpdateBillCodeRule) ruleCom)
				.setGroupItem("pk_group");
		((nc.bs.pubapp.pub.rule.UpdateBillCodeRule) ruleCom)
				.setOrgItem("pk_org");
		processer.addBeforeRule(ruleCom);
		// 数据唯一性规则
		processer.addBeforeRule(new DataUniquenessCheckRule());
	}

}
