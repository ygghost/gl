package nc.ui.gl.gl_budget.ace.serviceproxy;

import nc.bs.framework.common.NCLocator;
import nc.itf.gl.IGl_budgetMaintain;
import nc.ui.uif2.components.pagination.IPaginationQueryService;
import nc.vo.gl.budget.AggBudgetVO;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
/**
 * 示例单据的操作代理
 * 
 * @author yegz
 * @Date 2017-11-17
 * @version NC65
 */
public class AceGl_budgetMaintainProxy implements IPaginationQueryService {
	@Override
	public Object[] queryObjectByPks(String[] pks) throws BusinessException {
		AggBudgetVO[] rets = null;
		IGl_budgetMaintain service = NCLocator.getInstance().lookup(IGl_budgetMaintain.class);
		try {
			rets = service.queryBillByPK(pks);
		} catch (BusinessException e) {
			ExceptionUtils.wrappException(e);
		}
		return rets;
	}

}