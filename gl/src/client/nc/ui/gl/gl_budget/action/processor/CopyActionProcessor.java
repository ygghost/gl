package nc.ui.gl.gl_budget.action.processor;

import nc.desktop.ui.ServerTimeProxy;
import nc.ui.pubapp.uif2app.actions.intf.ICopyActionProcessor;
import nc.vo.gl.budget.AggBudgetVO;
import nc.vo.gl.budget.BudgetBVO;
import nc.vo.gl.budget.BudgetVO;
import nc.vo.pub.ISuperVO;
import nc.vo.pub.IVOMeta;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.pf.BillStatusEnum;
import nc.vo.pubapp.AppContext;
import nc.vo.uif2.LoginContext;

/**
 * Ԥ�㵥���ư�ť������
 * 
 * @author yegz
 * @Date 2017-11-17
 * 
 */
public class CopyActionProcessor implements ICopyActionProcessor<AggBudgetVO> {

	// ���Ƶ���ʱ��ͷ�ֶ���Ҫ����Ϊ�յ��ֶα���
	private static String[] CopyBillHeadItemkeySetNull = new String[] {
			BudgetVO.BILLNO, BudgetVO.APPROVER, BudgetVO.TAUDITTIME,
			BudgetVO.MODIFIER, BudgetVO.MODIFIEDTIME, BudgetVO.CREATOR,
			BudgetVO.CREATIONTIME, /*BudgetVO.CPRODID, */BudgetVO.PK_BUDGET,
			BudgetVO.BUSITYPE };
	// ���Ƶ���ʱ�����ֶ���Ҫ����Ϊ�յ��ֶα���
	private static String[] CopyBillBodyItemkeySetNull = new String[] {
			BudgetBVO.PK_BUDGET, BudgetBVO.PK_BUDGET_B/*, BudgetBVO.CPRODID,
			BudgetBVO.CMATERIALID, BudgetBVO.CUNITID, BudgetBVO.CASTUNITID,
			BudgetBVO.NNUM, BudgetBVO.NASTNUM, BudgetBVO.NPRICE,
			BudgetBVO.ISRELATED, BudgetBVO.NBLARGESSNUM,
			BudgetBVO.NBLARGESSASTNUM, BudgetBVO.NDISCOUNT,
			BudgetBVO.NSALESCOST, BudgetBVO.NOUTSTORCOST,
			BudgetBVO.NPACKINGCHARGE, BudgetBVO.NCOST1, BudgetBVO.NCOST2,
			BudgetBVO.NCOST3, BudgetBVO.NCOST4, BudgetBVO.NCOST5,
			BudgetBVO.NCOST6*/ };

	@Override
	public void processVOAfterCopy(AggBudgetVO billVO, LoginContext context) {
		this.processHeadVO(billVO, context);
		this.processBodyVO(billVO);
	}

	private void processBodyVO(AggBudgetVO vo) {
		vo.getParent().setAttributeValue(
				vo.getMetaData().getParent().getPrimaryAttribute().getName(),
				null);
		vo.getParent().setAttributeValue("ts", null);
		for (IVOMeta meta : vo.getMetaData().getChildren()) {
			if (vo.getChildren(meta) == null)
				continue;
			for (ISuperVO childvo : vo.getChildren(meta)) {
				childvo.setAttributeValue(meta.getPrimaryAttribute().getName(),
						null);
				// ����ʱ������岿���ֶ�ֵΪ��
				for (String bodykey : CopyBillBodyItemkeySetNull) {
					childvo.setAttributeValue(bodykey, null);
				}
				// �������κ�1-20���Զ�����1-20�ֶ�ֵΪ��
				for (int i = 1; i <= 20; i++) {
					childvo.setAttributeValue("vbdef" + i, null);
				}
			}
		}
	}

	private void processHeadVO(AggBudgetVO vo, LoginContext context) {
		UFDateTime datetime = ServerTimeProxy.getInstance().getServerTime();
		String pk_user = AppContext.getInstance().getPkUser();
		BudgetVO hvo = vo.getParentVO();
		// ��ͷ�ֶ����ÿմ���
		for (String headitemkey : CopyBillHeadItemkeySetNull) {
			hvo.setAttributeValue(headitemkey, null);
		}
		// ���ñ�ͷ�Զ�����1-20�ֶ�ֵΪ��
		for (int i = 1; i <= 20; i++) {
			hvo.setAttributeValue("def" + i, null);
		}
		// ����Ĭ��ֵ
		hvo.setDbilldate(datetime.getDate());
		//hvo.setBperiod(datetime.toString().substring(0, 7));
		//hvo.setPk_group(context.getPk_group());
		//hvo.setPk_org(context.getPk_org());
		hvo.setAttributeValue("fbillflag", BillStatusEnum.FREE.value());
		hvo.setCreator(pk_user);
		hvo.setCreationtime(datetime);
		hvo.setDmakedate(datetime.getDate());
		hvo.setBillmaker(pk_user);
	}

}
