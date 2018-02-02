package nc.ui.gl.gl_budget.ace.handler;

import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardHeadTailBeforeEditEvent;
import nc.vo.gl.budget.BudgetVO;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillCardPanel;
/**
 * 单据表头表尾字段编辑前事件处理类
 * 
 * @author yegz
 * @Date 2017-11-17
 * @since NC65
 */
public class AceHeadTailBeforeEditHandler implements IAppEventHandler<CardHeadTailBeforeEditEvent> {

    @Override
    public void handleAppEvent(CardHeadTailBeforeEditEvent e) {
    	BillCardPanel panel = e.getBillCardPanel();
    	String key=e.getKey();
    	//单据类型编辑前过滤
    	if(BudgetVO.BILLTYPE.equals(key)){
    		UIRefPane refPane =(UIRefPane) panel.getHeadItem(key).getComponent();
    		refPane.setWhereString("pk_billtypecode like'YSDJ-%' ");
    		refPane.getRefModel().reloadData();
    	}
    	
    }

}
