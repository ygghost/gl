package nc.vo.gl.budget;

import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.ISuperVO;
import nc.vo.pub.IVOMeta;
import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;
import nc.vo.pubapp.pattern.model.meta.entity.bill.BillMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;

/***
 * Ô¤Ëãµ¥¾ÛºÏVO
 * 
 * @author yegz
 * @Date 2017-11-16
 * 
 */
@nc.vo.annotation.AggVoInfo(parentVO = "nc.vo.gl.budget.BudgetVO")
public class AggBudgetVO extends AbstractBill {

	private static final long serialVersionUID = -903291217086909605L;

	@Override
	public IBillMeta getMetaData() {
		IBillMeta billMeta = BillMetaFactory.getInstance().getBillMeta(
				AggBudgetVOMeta.class);
		return billMeta;
	}

	@Override
	public BudgetVO getParentVO() {
		return (BudgetVO) this.getParent();
	}

	// public BudgetVO getHeadVO() {
	// return (BudgetVO) this.getParent();
	// }

	public BudgetBVO[] getBodyVOs() {
		try {
			return (BudgetBVO[]) super.getChildrenVO();
		} catch (java.lang.ClassCastException e) {
			int length = super.getChildrenVO().length;
			BudgetBVO[] ret = new BudgetBVO[length];
			System.arraycopy(super.getChildrenVO(), 0, ret, 0, length);
			this.setChildrenVO(ret);
			return ret;
		}
	}

	@Override
	public CircularlyAccessibleValueObject[] getChildrenVO() {
		return getBodyVOs();
	}

	@Override
	public CircularlyAccessibleValueObject[] getTableVO(String tableCode) {
		AbstractBillMeta meta = (AbstractBillMeta) getMetaData();
		IVOMeta vometa = meta.getVOMeta(tableCode);
		ISuperVO[] vos = getChildren(vometa);
		return (CircularlyAccessibleValueObject[]) vos;
	}

	@Override
	public Object clone() {
		AggBudgetVO aggvo = new AggBudgetVO();
		aggvo.setParentVO((BudgetVO) this.getParentVO().clone());
		BudgetBVO[] children = new BudgetBVO[this.getChildrenVO().length];
		for (int i = 0; i < this.getChildrenVO().length; i++) {
			children[i] = (BudgetBVO) this.getChildrenVO()[i].clone();
		}
		aggvo.setChildrenVO(children);
		return aggvo;
	}

}