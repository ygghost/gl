package nc.ui.gl.gl_budget.ace.handler;

import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardBodyBeforeEditEvent;
/**
 * �����ֶα༭ǰ�¼�������
 * 
 * @author yegz
 * @Date 2017-11-17
 * @since NC65
 */
public class AceBodyBeforeEditHandler implements IAppEventHandler<CardBodyBeforeEditEvent> {

    @Override
    public void handleAppEvent(CardBodyBeforeEditEvent e) {
        e.setReturnValue(Boolean.TRUE);
        //String key = e.getKey();
        
    }

}
