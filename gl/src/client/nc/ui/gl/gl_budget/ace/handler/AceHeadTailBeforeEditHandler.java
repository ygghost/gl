package nc.ui.gl.gl_budget.ace.handler;

import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardHeadTailBeforeEditEvent;
import nc.vo.gl.budget.BudgetVO;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillCardPanel;
/**
 * ���ݱ�ͷ��β�ֶα༭ǰ�¼�������
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
    	//�������ͱ༭ǰ����
    	if(BudgetVO.BILLTYPE.equals(key)){
    		UIRefPane refPane =(UIRefPane) panel.getHeadItem(key).getComponent();
    		refPane.setWhereString("pk_billtypecode like'YSDJ-%' ");
    		refPane.getRefModel().reloadData();
    	}
    	
    }

}
