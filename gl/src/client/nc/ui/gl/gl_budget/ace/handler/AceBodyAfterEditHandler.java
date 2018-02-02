package nc.ui.gl.gl_budget.ace.handler;

import nc.bs.framework.common.NCLocator;
import nc.itf.bd.material.baseinfo.IMaterialBaseInfoQueryService;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.BeanProcessor;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardBodyAfterEditEvent;
import nc.vo.bd.material.MaterialConvertVO;
import nc.vo.bd.material.MaterialVO;
import nc.vo.gl.budget.BudgetBVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.lang.UFDouble;
/**
 * 单据表体字段编辑后事件
 * 
 * @author yegz
 * @Date 2017-11-17
 * @since NC65
 */
public class AceBodyAfterEditHandler implements IAppEventHandler<CardBodyAfterEditEvent> {
	/*****物料基本信息查询接口*******/
	private IMaterialBaseInfoQueryService queryService;
	/*****表体需要清空的字段key[]*******/
	private static String[] BodyItemkeySetNull = new String[] {
		BudgetBVO.CPRODID,BudgetBVO.CMATERIALID, BudgetBVO.CUNITID, 
		BudgetBVO.CASTUNITID,BudgetBVO.NNUM, BudgetBVO.NASTNUM, 
		BudgetBVO.NPRICE,BudgetBVO.ISRELATED, BudgetBVO.NBLARGESSNUM,
		BudgetBVO.NBLARGESSASTNUM, BudgetBVO.NDISCOUNT,
		BudgetBVO.NSALESCOST, BudgetBVO.NOUTSTORCOST,BudgetBVO.NPACKINGCHARGE, 
		BudgetBVO.NCOST1, BudgetBVO.NCOST2,BudgetBVO.NCOST3, 
		BudgetBVO.NCOST4, BudgetBVO.NCOST5,BudgetBVO.NCOST6 };
	
	@Override
	public void handleAppEvent(CardBodyAfterEditEvent e) {
		String key = e.getKey();
		Object oldValue=e.getOldValue();
		Object newValue=e.getValue();
		int row=e.getRow();
    	BillCardPanel panel = e.getBillCardPanel();
    	//产成品编与原材料编辑后
    	if(BudgetBVO.CPRODID.equals(key)||BudgetBVO.CMATERIALID.equals(key)){
    		if(null==newValue){
    			for (String itemkey : BodyItemkeySetNull) {
    				panel.setBodyValueAt(null, row, itemkey);
				}
    			//执行行公式
				panel.getBillModel().execEditFormulas(row);
				//行参照字段刷新
				panel.getBillModel().loadLoadRelationItemValue(row);
    		}
    		if(null!=newValue&&newValue!=oldValue){
    			String pk_material=newValue.toString();
    			MaterialVO vo=queryMaterialVOByPk(pk_material);
    			if(null==vo)return;
				String sql="select * from bd_materialconvert where nvl(dr,0)=0 and pk_material='"+pk_material+"'";
				MaterialConvertVO mconvertVO=queryMaterialConvertVO(sql);
				panel.setBodyValueAt(vo.getPk_measdoc(), row, BudgetBVO.CUNITID);
				panel.setBodyValueAt(mconvertVO.getPk_measdoc(), row, BudgetBVO.CASTUNITID);
				panel.setBodyValueAt(null, row, BudgetBVO.NNUM);
				panel.setBodyValueAt(null, row, BudgetBVO.NASTNUM);
    			//执行行公式
				panel.getBillModel().execEditFormulas(row);
				//行参照字段刷新
				panel.getBillModel().loadLoadRelationItemValue(row);
    		}
    	}
    	//主数量或者辅数量编辑后联动
    	if(BudgetBVO.NNUM.equals(key)||BudgetBVO.NASTNUM.equals(key)){
    		if(null==newValue){
				panel.setBodyValueAt(null, row, BudgetBVO.NNUM);
				panel.setBodyValueAt(null, row, BudgetBVO.NASTNUM);
    			//执行行公式
				panel.getBillModel().execEditFormulas(row);
				//行参照字段刷新
				panel.getBillModel().loadLoadRelationItemValue(row);
    		}
    		if(null!=newValue){
    			UFDouble dnum=new UFDouble(newValue.toString());
    			if(dnum.toDouble()==0){
    				return;
    			}else{
    				Object pk_material=panel.getBodyValueAt(row, BudgetBVO.CPRODID);
    				if(null==pk_material){
    					pk_material=panel.getBodyValueAt(row, BudgetBVO.CMATERIALID);
    				}
    				if(null==pk_material){
    					panel.setBodyValueAt(null, row, BudgetBVO.NNUM);
    					panel.setBodyValueAt(null, row, BudgetBVO.NASTNUM);
    	    			//执行行公式
    					panel.getBillModel().execEditFormulas(row);
    					//行参照字段刷新
    					panel.getBillModel().loadLoadRelationItemValue(row);
    					return;
    				}
        			String cmaterialid=pk_material.toString();
    				String sql="select * from bd_materialconvert where nvl(dr,0)=0 and pk_material='"+cmaterialid+"'";
    				MaterialConvertVO mconvertVO=queryMaterialConvertVO(sql);
    				if(null==mconvertVO)return;
    				//辅计量管理的 主辅单位换算份数，例如1/100
    				String score[]=mconvertVO.getMeasrate().split("/");
    				//换算率=1/100
    				UFDouble rate=(new UFDouble(score[0])).div(new UFDouble(score[1]));
    				UFDouble num=new UFDouble(0);
    				if(BudgetBVO.NNUM.equals(key)){//若是编辑主数量则设置辅数量值
    					num=dnum.div(rate);
    					panel.setBodyValueAt(num, row, BudgetBVO.NASTNUM);
    	    			//执行行公式
    					panel.getBillModel().execEditFormulas(row);
    					//行参照字段刷新
    					panel.getBillModel().loadLoadRelationItemValue(row);
    				}else{//反之
    					num=dnum.multiply(rate);
    					panel.setBodyValueAt(num, row, BudgetBVO.NNUM);
    	    			//执行行公式
    					panel.getBillModel().execEditFormulas(row);
    					//行参照字段刷新
    					panel.getBillModel().loadLoadRelationItemValue(row);
    				}
    			}
    			
    		}
    		
    	}
    	
	}

	/***
	 * 查询物料辅计量管理VO
	 * @param sql
	 * @author yegz 
	 * @Date 2017-11-17
	 * @return
	 * @throws BusinessException 
	 */
	private MaterialConvertVO queryMaterialConvertVO(String sql){
		IUAPQueryBS queryservice=(IUAPQueryBS) NCLocator.getInstance().lookup(IUAPQueryBS.class.getName());
		MaterialConvertVO  fjlglVO=null;
		Object obj=null;;
		try {
			obj = queryservice.executeQuery(sql, new BeanProcessor(MaterialConvertVO.class));
		} catch (BusinessException e) {
			e.printStackTrace();
			return fjlglVO;
		}
	    if(null!=obj){
	    	fjlglVO=(MaterialConvertVO) obj;
	    }
		return fjlglVO;
	}
	
	/***
	 * 查询物料基本信息
	 * 
	 * @param pk_material 物料主键
	 * @return
	 */
	private MaterialVO queryMaterialVOByPk(String pk_material) {
		MaterialVO vo=null;
		MaterialVO[] vos=null;
		try {
			vos=getQueryService().queryDataByPks(new String[]{pk_material});
		} catch (BusinessException e1) {
			e1.printStackTrace();
			return null;
		}
		if(vos!=null&&vos.length>0){
			vo=vos[0];
		}
		return vo;
	}
	
	/**获取 物料基本信息查询接口
	 * 
	 * @return queryService
	 */
	private IMaterialBaseInfoQueryService getQueryService() {
		if(queryService==null){
			queryService=NCLocator.getInstance().lookup(IMaterialBaseInfoQueryService.class);
		}
		return queryService;
	}
	
}
