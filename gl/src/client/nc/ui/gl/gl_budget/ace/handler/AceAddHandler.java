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
 * 单据新增事件
 * 
 * @author yegz
 * @Date 2017-11-17
 * @since NC65
 */
public class AceAddHandler implements IAppEventHandler<AddEvent> {

  @Override
  public void handleAppEvent(AddEvent e) {
		//单据类型编码
		String vbilltypecode="";
	   //功能编码
	    String funcode=e.getContext().getNodeCode();
		String pk_group = e.getContext().getPk_group();
		String pk_org = e.getContext().getPk_org();
		String pk_user = AppContext.getInstance().getPkUser();
		UFDate busiDate = AppContext.getInstance().getBusiDate();
		UFDateTime busiDateTime = AppContext.getInstance().getServerTime();
		BillCardPanel panel = e.getBillForm().getBillCardPanel();
		// 设置主组织默认值
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
			 new BusinessException("组织不能为空，原因可能是集团用户未切换到具体业务公司!");
		}
		// 设置单据状态、日期默认值
		panel.setHeadItem(BudgetVO.FBILLFLAG, BillStatusEnum.FREE.value());
		panel.setHeadItem(BudgetVO.DBILLDATE, busiDate);
		
	    //单据类型编码、单据类型主键
		if(BudgetConstant.YSDYX_FUNCODE.equals(funcode)){//营销
			vbilltypecode=BudgetConstant.YSDYX_TYPECODE;
		    panel.setHeadItem(BudgetVO.BILLTYPECODE, vbilltypecode); 
		    panel.setHeadItem(BudgetVO.BILLTYPE, PfDataCache.getBillTypeInfo(vbilltypecode).getPk_billtypeid());
		}else if(BudgetConstant.YSDGC_FUNCODE.equals(funcode)){//工程
			vbilltypecode=BudgetConstant.YSDGC_TYPECODE;
		    panel.setHeadItem(BudgetVO.BILLTYPECODE, vbilltypecode); 
		    panel.setHeadItem(BudgetVO.BILLTYPE, PfDataCache.getBillTypeInfo(vbilltypecode).getPk_billtypeid());
		}else if(BudgetConstant.YSDCG_FUNCODE.equals(funcode)){//采购
			vbilltypecode=BudgetConstant.YSDCG_TYPECODE;
		    panel.setHeadItem(BudgetVO.BILLTYPECODE, vbilltypecode); 
		    panel.setHeadItem(BudgetVO.BILLTYPE, PfDataCache.getBillTypeInfo(vbilltypecode).getPk_billtypeid());
		}else if(BudgetConstant.YSDSC_FUNCODE.equals(funcode)){//生产
			vbilltypecode=BudgetConstant.YSDSC_TYPECODE;
		    panel.setHeadItem(BudgetVO.BILLTYPECODE, vbilltypecode); 
		    panel.setHeadItem(BudgetVO.BILLTYPE, PfDataCache.getBillTypeInfo(vbilltypecode).getPk_billtypeid());
		}else if(BudgetConstant.YSDCW_FUNCODE.equals(funcode)){//财务
			vbilltypecode=BudgetConstant.YSDCW_TYPECODE;
		    panel.setHeadItem(BudgetVO.BILLTYPECODE, vbilltypecode); 
		    panel.setHeadItem(BudgetVO.BILLTYPE, PfDataCache.getBillTypeInfo(vbilltypecode).getPk_billtypeid());
		}
	    //制单人、制单日期
		panel.setTailItem(BudgetVO.BILLMAKER, pk_user);
		panel.setTailItem(BudgetVO.DMAKEDATE, busiDate);
		//预算期间
		//panel.setHeadItem(BudgetVO.BPERIOD, busiDate.toString().substring(0, 7)); 
		// 创建人、创建时间
		panel.setTailItem(BudgetVO.CREATOR, pk_user);
		panel.setTailItem(BudgetVO.CREATIONTIME, busiDateTime); 
  }

}
