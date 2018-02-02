package nc.ui.gl.gl_budget.action;

import java.awt.event.ActionEvent;
import nc.ui.pubapp.pub.power.PowerCheckUtils;
import nc.ui.pubapp.uif2app.actions.EditAction;
import nc.vo.pubapp.pattern.model.entity.bill.IBill;
import nc.vo.pubapp.pub.power.PowerActionEnum;
/**
 * Ԥ�㵥�޸İ�ť
 * 
 * @author yegz
 * @Date 2017-11-17
 * @since NC65
 */
public class BudgetEditAction extends EditAction {

	private static final long serialVersionUID = 5023827721919492816L;

	private String billType;

	private String billCodeName;

	private boolean powercheck;

	@Override
	public void doAction(ActionEvent e) throws Exception {
		if (this.isPowercheck()) {
			IBill bill = (IBill) this.getModel().getSelectedData();
			PowerCheckUtils.checkHasPermission(new IBill[] { bill },
					this.getBillType(), PowerActionEnum.EDIT.getActioncode(),
					this.getBillCodeName());
		}
		super.doAction(e);
	}

	public String getBillType() {
		return this.billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getBillCodeName() {
		return this.billCodeName;
	}

	public void setBillCodeName(String billCodeName) {
		this.billCodeName = billCodeName;
	}

	public boolean isPowercheck() {
		return this.powercheck;
	}

	public void setPowercheck(boolean powercheck) {
		this.powercheck = powercheck;
	}

}
