package nc.bs.pub.action;

import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.bs.pubapp.pub.rule.UncommitStatusCheckRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import nc.bs.gl.gl_budget.plugin.bpplugin.Gl_budgetPluginPoint;
import nc.vo.gl.budget.AggBudgetVO;
import nc.itf.gl.IGl_budgetMaintain;

public class N_YSDJ_UNSAVEBILL extends AbstractPfAction<AggBudgetVO> {

	@Override
	protected CompareAroundProcesser<AggBudgetVO> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggBudgetVO> processor = new CompareAroundProcesser<AggBudgetVO>(
				Gl_budgetPluginPoint.UNSEND_APPROVE);
		// TODO 在此处添加前后规则
		processor.addBeforeRule(new UncommitStatusCheckRule());

		return processor;
	}

	@Override
	protected AggBudgetVO[] processBP(Object userObj,
			AggBudgetVO[] clientFullVOs, AggBudgetVO[] originBills) {
		IGl_budgetMaintain operator = NCLocator.getInstance().lookup(
				IGl_budgetMaintain.class);
		AggBudgetVO[] bills = null;
		try {
			bills = operator.unsave(clientFullVOs, originBills);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}

}
