package nc.ui.gl.gl_budget.query;

import nc.ui.pubapp.uif2app.query2.IQueryConditionDLGInitializer;
import nc.ui.pubapp.uif2app.query2.QueryConditionDLGDelegator;
import nc.ui.pubapp.uif2app.query2.refregion.QueryDefaultOrgFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * 预算单查询过滤器
 * 
 * @author yegz
 * @Date 2017-11-17
 * @since NC65
 */
public class BudgetQueryConditionInitializer implements
		IQueryConditionDLGInitializer {

	@Override
	public void initQueryConditionDLG(
			QueryConditionDLGDelegator condDLGDelegator) {
		// TODO 初始化查询模板逻辑
		// 这个数组目前是空的，请业务组把需要按组织过滤的参照字段加入到这个数组中
		List<String> targetFields = new ArrayList<String>();
		// TODO 加入需要按组织过滤的参照字段
		QueryDefaultOrgFilter orgFilter = new QueryDefaultOrgFilter(
				condDLGDelegator, "pk_org", targetFields);
		orgFilter.addEditorListener();
	}

}
