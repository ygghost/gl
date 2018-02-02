package nc.ui.gl.gl_budget.ace.handler;

import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardBodyBeforeEditEvent;
/**
 * 表体字段编辑前事件处理类
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
