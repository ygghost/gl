package nc.bs.pub.action;

import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import nc.bs.gl.gl_budget.plugin.bpplugin.Gl_budgetPluginPoint;
import nc.vo.gl.budget.AggBudgetVO;
import nc.itf.gl.IGl_budgetMaintain;

public class N_YSDJ_SAVEBASE extends AbstractPfAction<AggBudgetVO> {

	@Override
	protected CompareAroundProcesser<AggBudgetVO> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggBudgetVO> processor = null;
		AggBudgetVO[] clientFullVOs = (AggBudgetVO[]) this.getVos();
		if (!StringUtil.isEmptyWithTrim(clientFullVOs[0].getParentVO()
				.getPrimaryKey())) {
			processor = new CompareAroundProcesser<AggBudgetVO>(
					Gl_budgetPluginPoint.SCRIPT_UPDATE);
		} else {
			processor = new CompareAroundProcesser<AggBudgetVO>(
					Gl_budgetPluginPoint.SCRIPT_INSERT);
		}
		// TODO 在此处添加前后规则
		IRule<AggBudgetVO> rule = null;

		return processor;
	}

	@Override
	protected AggBudgetVO[] processBP(Object userObj,
			AggBudgetVO[] clientFullVOs, AggBudgetVO[] originBills) {

		AggBudgetVO[] bills = null;
		try {
			IGl_budgetMaintain operator = NCLocator.getInstance()
					.lookup(IGl_budgetMaintain.class);
			if (!StringUtil.isEmptyWithTrim(clientFullVOs[0].getParentVO()
					.getPrimaryKey())) {
				bills = operator.update(clientFullVOs, originBills);
			} else {
				bills = operator.insert(clientFullVOs, originBills);
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}
}
