package nc.ui.gl.gl_budget.ace.handler;

import nc.bs.framework.common.NCLocator;
import nc.bs.pf.pub.PfDataCache;
import nc.itf.org.IOrgUnitQryService;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.billform.AddEvent;
import nc.vo.gl.budget.BudgetVO;
import nc.vo.gl.budget.constant.BudgetConstant;
import nc.vo.pub.BusinessException;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.pf.BillStatusEnum;
import nc.vo.pubapp.AppContext;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

/**
 * ���������¼�
 * 
 * @author yegz
 * @Date 2017-11-17
 * @since NC65
 */
public class AceAddHandler implements IAppEventHandler<AddEvent> {

  @Override
  public void handleAppEvent(AddEvent e) {
		//�������ͱ���
		String vbilltypecode="";
	   //���ܱ���
	    String funcode=e.getContext().getNodeCode();
		String pk_group = e.getContext().getPk_group();
		String pk_org = e.getContext().getPk_org();
		String pk_user = AppContext.getInstance().getPkUser();
		UFDate busiDate = AppContext.getInstance().getBusiDate();
		UFDateTime busiDateTime = AppContext.getInstance().getServerTime();
		BillCardPanel panel = e.getBillForm().getBillCardPanel();
		// ��������֯Ĭ��ֵ
		panel.setHeadItem(BudgetVO.PK_GROUP, pk_group);
		panel.setHeadItem(BudgetVO.PK_ORG, pk_org);
		if (null != pk_org) {
			try {
				String pk_org_v = NCLocator.getInstance().lookup(IOrgUnitQryService.class).getOrg(pk_org).getPk_vid();
				if (null != pk_org_v) {
					panel.setHeadItem(BudgetVO.PK_ORG_V, pk_org_v);
				}
			} catch (BusinessException e1) {
				ExceptionUtils.wrappException(e1);
			}
		}else{
			 new BusinessException("��֯����Ϊ�գ�ԭ������Ǽ����û�δ�л�������ҵ��˾!");
		}
		// ���õ���״̬������Ĭ��ֵ
		panel.setHeadItem(BudgetVO.FBILLFLAG, BillStatusEnum.FREE.value());
		panel.setHeadItem(BudgetVO.DBILLDATE, busiDate);
		
	    //�������ͱ��롢������������
		if(BudgetConstant.YSDYX_FUNCODE.equals(funcode)){//Ӫ��
			vbilltypecode=BudgetConstant.YSDYX_TYPECODE;
		    panel.setHeadItem(BudgetVO.BILLTYPECODE, vbilltypecode); 
		    panel.setHeadItem(BudgetVO.BILLTYPE, PfDataCache.getBillTypeInfo(vbilltypecode).getPk_billtypeid());
		}else if(BudgetConstant.YSDGC_FUNCODE.equals(funcode)){//����
			vbilltypecode=BudgetConstant.YSDGC_TYPECODE;
		    panel.setHeadItem(BudgetVO.BILLTYPECODE, vbilltypecode); 
		    panel.setHeadItem(BudgetVO.BILLTYPE, PfDataCache.getBillTypeInfo(vbilltypecode).getPk_billtypeid());
		}else if(BudgetConstant.YSDCG_FUNCODE.equals(funcode)){//�ɹ�
			vbilltypecode=BudgetConstant.YSDCG_TYPECODE;
		    panel.setHeadItem(BudgetVO.BILLTYPECODE, vbilltypecode); 
		    panel.setHeadItem(BudgetVO.BILLTYPE, PfDataCache.getBillTypeInfo(vbilltypecode).getPk_billtypeid());
		}else if(BudgetConstant.YSDSC_FUNCODE.equals(funcode)){//����
			vbilltypecode=BudgetConstant.YSDSC_TYPECODE;
		    panel.setHeadItem(BudgetVO.BILLTYPECODE, vbilltypecode); 
		    panel.setHeadItem(BudgetVO.BILLTYPE, PfDataCache.getBillTypeInfo(vbilltypecode).getPk_billtypeid());
		}else if(BudgetConstant.YSDCW_FUNCODE.equals(funcode)){//����
			vbilltypecode=BudgetConstant.YSDCW_TYPECODE;
		    panel.setHeadItem(BudgetVO.BILLTYPECODE, vbilltypecode); 
		    panel.setHeadItem(BudgetVO.BILLTYPE, PfDataCache.getBillTypeInfo(vbilltypecode).getPk_billtypeid());
		}
	    //�Ƶ��ˡ��Ƶ�����
		panel.setTailItem(BudgetVO.BILLMAKER, pk_user);
		panel.setTailItem(BudgetVO.DMAKEDATE, busiDate);
		//Ԥ���ڼ�
		//panel.setHeadItem(BudgetVO.BPERIOD, busiDate.toString().substring(0, 7)); 
		// �����ˡ�����ʱ��
		panel.setTailItem(BudgetVO.CREATOR, pk_user);
		panel.setTailItem(BudgetVO.CREATIONTIME, busiDateTime); 
  }

}
