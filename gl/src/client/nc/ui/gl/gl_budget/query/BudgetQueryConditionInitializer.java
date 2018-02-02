package nc.ui.gl.gl_budget.query;

import nc.ui.pubapp.uif2app.query2.IQueryConditionDLGInitializer;
import nc.ui.pubapp.uif2app.query2.QueryConditionDLGDelegator;
import nc.ui.pubapp.uif2app.query2.refregion.QueryDefaultOrgFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Ԥ�㵥��ѯ������
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
		// TODO ��ʼ����ѯģ���߼�
		// �������Ŀǰ�ǿյģ���ҵ�������Ҫ����֯���˵Ĳ����ֶμ��뵽���������
		List<String> targetFields = new ArrayList<String>();
		// TODO ������Ҫ����֯���˵Ĳ����ֶ�
		QueryDefaultOrgFilter orgFilter = new QueryDefaultOrgFilter(
				condDLGDelegator, "pk_org", targetFields);
		orgFilter.addEditorListener();
	}

}
