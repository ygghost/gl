package nc.vo.gl.budget;

import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;
/***
 * Ԥ�㵥Ԫ���ݰ�װVO
 * 
 * @author yegz
 * @Date 2017-11-16
 *
 */
public class AggBudgetVOMeta extends AbstractBillMeta{
	
	public AggBudgetVOMeta(){
		this.init();
	}
	
	private void init() {
		this.setParent(nc.vo.gl.budget.BudgetVO.class);
		this.addChildren(nc.vo.gl.budget.BudgetBVO.class);
	}
}