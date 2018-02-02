package nc.ui.gl.gl_budget.ace.handler;

import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.OrgChangedEvent;
import nc.ui.pubapp.uif2app.view.BillForm;
import nc.ui.pubapp.uif2app.view.util.BillPanelUtils;
import nc.vo.uif2.LoginContext;

/**
 * 组织切换事件
 * 
 * @author yegz
 * @Date 2017-11-17
 * @since NC65
 */
public class AceOrgChangedHandler implements IAppEventHandler<OrgChangedEvent> {

  private BillForm billfrom;

    public AceOrgChangedHandler(BillForm bill) {
        this.billfrom = bill;
    }
    @Override
    public void handleAppEvent(OrgChangedEvent e) {
        if (this.billfrom.isEditable()) {
            // 在编辑状态下，主组织切换时，清空界面数据，自动表体增行，并设置行号
            this.billfrom.addNew();
        }
        LoginContext context = this.billfrom.getModel().getContext();
        // 进行参照过滤
        BillPanelUtils.setOrgForAllRef(this.billfrom.getBillCardPanel(), context);
    }

}
