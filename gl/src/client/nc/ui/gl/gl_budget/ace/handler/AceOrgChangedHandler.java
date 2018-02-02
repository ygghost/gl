package nc.ui.gl.gl_budget.ace.handler;

import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.OrgChangedEvent;
import nc.ui.pubapp.uif2app.view.BillForm;
import nc.ui.pubapp.uif2app.view.util.BillPanelUtils;
import nc.vo.uif2.LoginContext;

/**
 * ��֯�л��¼�
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
            // �ڱ༭״̬�£�����֯�л�ʱ����ս������ݣ��Զ��������У��������к�
            this.billfrom.addNew();
        }
        LoginContext context = this.billfrom.getModel().getContext();
        // ���в��չ���
        BillPanelUtils.setOrgForAllRef(this.billfrom.getBillCardPanel(), context);
    }

}
