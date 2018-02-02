package nc.vo.gl.budget;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

/***
 * 预算单明细VO
 * 
 * @author yegz
 * @Date 2017-11-16
 *
 */

public class BudgetBVO extends SuperVO {

	private static final long serialVersionUID = 6278180821538589639L;
	/**
	 * 预算明细主键
	 */
	private String pk_budget_b;
	/**
	 * 产成品
	 */
	private String cprodid;
	/**
	 * 原材料
	 */
	private String cmaterialid;
	/**
	 * 主单位
	 */
	private String cunitid;
	/**
	 * 辅单位
	 */
	private String castunitid;
	/**
	 * 主数量
	 */
	private UFDouble nnum;
	/**
	 * 辅数量
	 */
	private UFDouble nastnum;
	/**
	 * 单价
	 */
	private UFDouble nprice;
	/**
	 * 是否关联方
	 */
	private UFBoolean isrelated;
	/**
	 * 赠送主数量
	 */
	private UFDouble nblargessnum;
	/**
	 * 赠送辅数量
	 */
	private UFDouble nblargessastnum;
	/**
	 * 折扣额
	 */
	private UFDouble ndiscount;
	/**
	 * 销售费用
	 */
	private UFDouble nsalescost;
	/**
	 * 外仓费用
	 */
	private UFDouble noutstorcost;
	/**
	 * 包装费用
	 */
	private UFDouble npackingcharge;
	/**
	 * 人工
	 */
	private UFDouble ncost1;
	/**
	 * 折旧
	 */
	private UFDouble ncost2;
	/**
	 * 电耗
	 */
	private UFDouble ncost3;
	/**
	 * 能耗
	 */
	private UFDouble ncost4;
	/**
	 * 物耗
	 */
	private UFDouble ncost5;
	/**
	 * 其他制造费用
	 */
	private UFDouble ncost6;
	/**
	 * 行号
	 */
	private String crowno;
	/**
	 * 备注
	 */
	private String vrownote;
	/**
	 * 自定义项1
	 */
	private String vbdef1;
	/**
	 * 自定义项2
	 */
	private String vbdef2;
	/**
	 * 自定义项3
	 */
	private String vbdef3;
	/**
	 * 自定义项4
	 */
	private String vbdef4;
	/**
	 * 自定义项5
	 */
	private String vbdef5;
	/**
	 * 自定义项6
	 */
	private String vbdef6;
	/**
	 * 自定义项7
	 */
	private String vbdef7;
	/**
	 * 自定义项8
	 */
	private String vbdef8;
	/**
	 * 自定义项9
	 */
	private String vbdef9;
	/**
	 * 自定义项10
	 */
	private String vbdef10;
	/**
	 * 自定义项11
	 */
	private String vbdef11;
	/**
	 * 自定义项12
	 */
	private String vbdef12;
	/**
	 * 自定义项13
	 */
	private String vbdef13;
	/**
	 * 自定义项14
	 */
	private String vbdef14;
	/**
	 * 自定义项15
	 */
	private String vbdef15;
	/**
	 * 自定义项16
	 */
	private String vbdef16;
	/**
	 * 自定义项17
	 */
	private String vbdef17;
	/**
	 * 自定义项18
	 */
	private String vbdef18;
	/**
	 * 自定义项19
	 */
	private String vbdef19;
	/**
	 * 自定义项20
	 */
	private String vbdef20;
	/**
	 * 上层单据主键
	 */
	private String pk_budget;
	/**
	 * 时间戳
	 */
	private UFDateTime ts;

	public static final String PK_BUDGET = "pk_budget";
	public static final String PK_BUDGET_B = "pk_budget_b";
	public static final String CPRODID = "cprodid";
	public static final String CMATERIALID = "cmaterialid";
	public static final String CUNITID = "cunitid";
	public static final String CASTUNITID = "castunitid";
	public static final String NNUM = "nnum";
	public static final String NASTNUM = "nastnum";
	public static final String NPRICE = "nprice";
	public static final String ISRELATED = "isrelated";
	public static final String NBLARGESSNUM = "nblargessnum";
	public static final String NBLARGESSASTNUM = "nblargessastnum";
	public static final String NDISCOUNT = "ndiscount";
	public static final String NSALESCOST = "nsalescost";
	public static final String NOUTSTORCOST = "noutstorcost";
	public static final String NPACKINGCHARGE = "npackingcharge";
	public static final String NCOST1 = "ncost1";
	public static final String NCOST2 = "ncost2";
	public static final String NCOST3 = "ncost3";
	public static final String NCOST4 = "ncost4";
	public static final String NCOST5 = "ncost5";
	public static final String NCOST6 = "ncost6";
	public static final String CROWNO = "crowno";
	public static final String VROWNOTE = "vrownote";
	public static final String VBDEF1 = "vbdef1";
	public static final String VBDEF2 = "vbdef2";
	public static final String VBDEF3 = "vbdef3";
	public static final String VBDEF4 = "vbdef4";
	public static final String VBDEF5 = "vbdef5";
	public static final String VBDEF6 = "vbdef6";
	public static final String VBDEF7 = "vbdef7";
	public static final String VBDEF8 = "vbdef8";
	public static final String VBDEF9 = "vbdef9";
	public static final String VBDEF10 = "vbdef10";
	public static final String VBDEF11 = "vbdef11";
	public static final String VBDEF12 = "vbdef12";
	public static final String VBDEF13 = "vbdef13";
	public static final String VBDEF14 = "vbdef14";
	public static final String VBDEF15 = "vbdef15";
	public static final String VBDEF16 = "vbdef16";
	public static final String VBDEF17 = "vbdef17";
	public static final String VBDEF18 = "vbdef18";
	public static final String VBDEF19 = "vbdef19";
	public static final String VBDEF20 = "vbdef20";

	/**
	 * 属性 pk_budget_b的Getter方法.属性名：预算明细主键 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getPk_budget_b() {
		return this.pk_budget_b;
	}

	/**
	 * 属性pk_budget_b的Setter方法.属性名：预算明细主键 创建日期:2017-11-16
	 * 
	 * @param newPk_budget_b
	 *            java.lang.String
	 */
	public void setPk_budget_b(String pk_budget_b) {
		this.pk_budget_b = pk_budget_b;
	}

	/**
	 * 属性 cprodid的Getter方法.属性名：产成品 创建日期:2017-11-16
	 * 
	 * @return nc.vo.bd.material.MaterialVO
	 */
	public String getCprodid() {
		return this.cprodid;
	}

	/**
	 * 属性cprodid的Setter方法.属性名：产成品 创建日期:2017-11-16
	 * 
	 * @param newCprodid
	 *            nc.vo.bd.material.MaterialVO
	 */
	public void setCprodid(String cprodid) {
		this.cprodid = cprodid;
	}

	/**
	 * 属性 cmaterialid的Getter方法.属性名：原材料 创建日期:2017-11-16
	 * 
	 * @return nc.vo.bd.material.MaterialVO
	 */
	public String getCmaterialid() {
		return this.cmaterialid;
	}

	/**
	 * 属性cmaterialid的Setter方法.属性名：原材料 创建日期:2017-11-16
	 * 
	 * @param newCmaterialid
	 *            nc.vo.bd.material.MaterialVO
	 */
	public void setCmaterialid(String cmaterialid) {
		this.cmaterialid = cmaterialid;
	}

	/**
	 * 属性 cunitid的Getter方法.属性名：主单位 创建日期:2017-11-16
	 * 
	 * @return nc.vo.bd.material.measdoc.MeasdocVO
	 */
	public String getCunitid() {
		return this.cunitid;
	}

	/**
	 * 属性cunitid的Setter方法.属性名：主单位 创建日期:2017-11-16
	 * 
	 * @param newCunitid
	 *            nc.vo.bd.material.measdoc.MeasdocVO
	 */
	public void setCunitid(String cunitid) {
		this.cunitid = cunitid;
	}

	/**
	 * 属性 castunitid的Getter方法.属性名：辅单位 创建日期:2017-11-16
	 * 
	 * @return nc.vo.bd.material.measdoc.MeasdocVO
	 */
	public String getCastunitid() {
		return this.castunitid;
	}

	/**
	 * 属性castunitid的Setter方法.属性名：辅单位 创建日期:2017-11-16
	 * 
	 * @param newCastunitid
	 *            nc.vo.bd.material.measdoc.MeasdocVO
	 */
	public void setCastunitid(String castunitid) {
		this.castunitid = castunitid;
	}

	/**
	 * 属性 nnum的Getter方法.属性名：主数量 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNnum() {
		return this.nnum;
	}

	/**
	 * 属性nnum的Setter方法.属性名：主数量 创建日期:2017-11-16
	 * 
	 * @param newNnum
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNnum(UFDouble nnum) {
		this.nnum = nnum;
	}

	/**
	 * 属性 nastnum的Getter方法.属性名：辅数量 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNastnum() {
		return this.nastnum;
	}

	/**
	 * 属性nastnum的Setter方法.属性名：辅数量 创建日期:2017-11-16
	 * 
	 * @param newNastnum
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNastnum(UFDouble nastnum) {
		this.nastnum = nastnum;
	}

	/**
	 * 属性 nprice的Getter方法.属性名：单价 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNprice() {
		return this.nprice;
	}

	/**
	 * 属性nprice的Setter方法.属性名：单价 创建日期:2017-11-16
	 * 
	 * @param newNprice
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNprice(UFDouble nprice) {
		this.nprice = nprice;
	}

	/**
	 * 属性 isrelated的Getter方法.属性名：是否关联方 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFBoolean
	 */
	public UFBoolean getIsrelated() {
		return this.isrelated;
	}

	/**
	 * 属性isrelated的Setter方法.属性名：是否关联方 创建日期:2017-11-16
	 * 
	 * @param newIsrelated
	 *            nc.vo.pub.lang.UFBoolean
	 */
	public void setIsrelated(UFBoolean isrelated) {
		this.isrelated = isrelated;
	}

	/**
	 * 属性 nblargessnum的Getter方法.属性名：赠送主数量 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNblargessnum() {
		return this.nblargessnum;
	}

	/**
	 * 属性nblargessnum的Setter方法.属性名：赠送主数量 创建日期:2017-11-16
	 * 
	 * @param newNblargessnum
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNblargessnum(UFDouble nblargessnum) {
		this.nblargessnum = nblargessnum;
	}

	/**
	 * 属性 nblargessastnum的Getter方法.属性名：赠送辅数量 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNblargessastnum() {
		return this.nblargessastnum;
	}

	/**
	 * 属性nblargessastnum的Setter方法.属性名：赠送辅数量 创建日期:2017-11-16
	 * 
	 * @param newNblargessastnum
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNblargessastnum(UFDouble nblargessastnum) {
		this.nblargessastnum = nblargessastnum;
	}

	/**
	 * 属性 ndiscount的Getter方法.属性名：折扣额 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNdiscount() {
		return this.ndiscount;
	}

	/**
	 * 属性ndiscount的Setter方法.属性名：折扣额 创建日期:2017-11-16
	 * 
	 * @param newNdiscount
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNdiscount(UFDouble ndiscount) {
		this.ndiscount = ndiscount;
	}

	/**
	 * 属性 nsalescost的Getter方法.属性名：销售费用 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNsalescost() {
		return this.nsalescost;
	}

	/**
	 * 属性nsalescost的Setter方法.属性名：销售费用 创建日期:2017-11-16
	 * 
	 * @param newNsalescost
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNsalescost(UFDouble nsalescost) {
		this.nsalescost = nsalescost;
	}

	/**
	 * 属性 noutstorcost的Getter方法.属性名：外仓费用 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNoutstorcost() {
		return this.noutstorcost;
	}

	/**
	 * 属性noutstorcost的Setter方法.属性名：外仓费用 创建日期:2017-11-16
	 * 
	 * @param newNoutstorcost
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNoutstorcost(UFDouble noutstorcost) {
		this.noutstorcost = noutstorcost;
	}

	/**
	 * 属性 npackingcharge的Getter方法.属性名：包装费用 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNpackingcharge() {
		return this.npackingcharge;
	}

	/**
	 * 属性npackingcharge的Setter方法.属性名：包装费用 创建日期:2017-11-16
	 * 
	 * @param newNpackingcharge
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNpackingcharge(UFDouble npackingcharge) {
		this.npackingcharge = npackingcharge;
	}

	/**
	 * 属性 ncost1的Getter方法.属性名：人工 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNcost1() {
		return this.ncost1;
	}

	/**
	 * 属性ncost1的Setter方法.属性名：人工 创建日期:2017-11-16
	 * 
	 * @param newNcost1
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNcost1(UFDouble ncost1) {
		this.ncost1 = ncost1;
	}

	/**
	 * 属性 ncost2的Getter方法.属性名：折旧 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNcost2() {
		return this.ncost2;
	}

	/**
	 * 属性ncost2的Setter方法.属性名：折旧 创建日期:2017-11-16
	 * 
	 * @param newNcost2
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNcost2(UFDouble ncost2) {
		this.ncost2 = ncost2;
	}

	/**
	 * 属性 ncost3的Getter方法.属性名：电耗 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNcost3() {
		return this.ncost3;
	}

	/**
	 * 属性ncost3的Setter方法.属性名：电耗 创建日期:2017-11-16
	 * 
	 * @param newNcost3
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNcost3(UFDouble ncost3) {
		this.ncost3 = ncost3;
	}

	/**
	 * 属性 ncost4的Getter方法.属性名：能耗 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNcost4() {
		return this.ncost4;
	}

	/**
	 * 属性ncost4的Setter方法.属性名：能耗 创建日期:2017-11-16
	 * 
	 * @param newNcost4
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNcost4(UFDouble ncost4) {
		this.ncost4 = ncost4;
	}

	/**
	 * 属性 ncost5的Getter方法.属性名：物耗 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNcost5() {
		return this.ncost5;
	}

	/**
	 * 属性ncost5的Setter方法.属性名：物耗 创建日期:2017-11-16
	 * 
	 * @param newNcost5
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNcost5(UFDouble ncost5) {
		this.ncost5 = ncost5;
	}

	/**
	 * 属性 ncost6的Getter方法.属性名：其他制造费用 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNcost6() {
		return this.ncost6;
	}

	/**
	 * 属性ncost6的Setter方法.属性名：其他制造费用 创建日期:2017-11-16
	 * 
	 * @param newNcost6
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNcost6(UFDouble ncost6) {
		this.ncost6 = ncost6;
	}

	/**
	 * 属性 crowno的Getter方法.属性名：行号 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getCrowno() {
		return this.crowno;
	}

	/**
	 * 属性crowno的Setter方法.属性名：行号 创建日期:2017-11-16
	 * 
	 * @param newCrowno
	 *            java.lang.String
	 */
	public void setCrowno(String crowno) {
		this.crowno = crowno;
	}

	/**
	 * 属性 vrownote的Getter方法.属性名：备注 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVrownote() {
		return this.vrownote;
	}

	/**
	 * 属性vrownote的Setter方法.属性名：备注 创建日期:2017-11-16
	 * 
	 * @param newVrownote
	 *            java.lang.String
	 */
	public void setVrownote(String vrownote) {
		this.vrownote = vrownote;
	}

	/**
	 * 属性 vbdef1的Getter方法.属性名：自定义项1 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef1() {
		return this.vbdef1;
	}

	/**
	 * 属性vbdef1的Setter方法.属性名：自定义项1 创建日期:2017-11-16
	 * 
	 * @param newVbdef1
	 *            java.lang.String
	 */
	public void setVbdef1(String vbdef1) {
		this.vbdef1 = vbdef1;
	}

	/**
	 * 属性 vbdef2的Getter方法.属性名：自定义项2 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef2() {
		return this.vbdef2;
	}

	/**
	 * 属性vbdef2的Setter方法.属性名：自定义项2 创建日期:2017-11-16
	 * 
	 * @param newVbdef2
	 *            java.lang.String
	 */
	public void setVbdef2(String vbdef2) {
		this.vbdef2 = vbdef2;
	}

	/**
	 * 属性 vbdef3的Getter方法.属性名：自定义项3 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef3() {
		return this.vbdef3;
	}

	/**
	 * 属性vbdef3的Setter方法.属性名：自定义项3 创建日期:2017-11-16
	 * 
	 * @param newVbdef3
	 *            java.lang.String
	 */
	public void setVbdef3(String vbdef3) {
		this.vbdef3 = vbdef3;
	}

	/**
	 * 属性 vbdef4的Getter方法.属性名：自定义项4 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef4() {
		return this.vbdef4;
	}

	/**
	 * 属性vbdef4的Setter方法.属性名：自定义项4 创建日期:2017-11-16
	 * 
	 * @param newVbdef4
	 *            java.lang.String
	 */
	public void setVbdef4(String vbdef4) {
		this.vbdef4 = vbdef4;
	}

	/**
	 * 属性 vbdef5的Getter方法.属性名：自定义项5 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef5() {
		return this.vbdef5;
	}

	/**
	 * 属性vbdef5的Setter方法.属性名：自定义项5 创建日期:2017-11-16
	 * 
	 * @param newVbdef5
	 *            java.lang.String
	 */
	public void setVbdef5(String vbdef5) {
		this.vbdef5 = vbdef5;
	}

	/**
	 * 属性 vbdef6的Getter方法.属性名：自定义项6 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef6() {
		return this.vbdef6;
	}

	/**
	 * 属性vbdef6的Setter方法.属性名：自定义项6 创建日期:2017-11-16
	 * 
	 * @param newVbdef6
	 *            java.lang.String
	 */
	public void setVbdef6(String vbdef6) {
		this.vbdef6 = vbdef6;
	}

	/**
	 * 属性 vbdef7的Getter方法.属性名：自定义项7 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef7() {
		return this.vbdef7;
	}

	/**
	 * 属性vbdef7的Setter方法.属性名：自定义项7 创建日期:2017-11-16
	 * 
	 * @param newVbdef7
	 *            java.lang.String
	 */
	public void setVbdef7(String vbdef7) {
		this.vbdef7 = vbdef7;
	}

	/**
	 * 属性 vbdef8的Getter方法.属性名：自定义项8 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef8() {
		return this.vbdef8;
	}

	/**
	 * 属性vbdef8的Setter方法.属性名：自定义项8 创建日期:2017-11-16
	 * 
	 * @param newVbdef8
	 *            java.lang.String
	 */
	public void setVbdef8(String vbdef8) {
		this.vbdef8 = vbdef8;
	}

	/**
	 * 属性 vbdef9的Getter方法.属性名：自定义项9 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef9() {
		return this.vbdef9;
	}

	/**
	 * 属性vbdef9的Setter方法.属性名：自定义项9 创建日期:2017-11-16
	 * 
	 * @param newVbdef9
	 *            java.lang.String
	 */
	public void setVbdef9(String vbdef9) {
		this.vbdef9 = vbdef9;
	}

	/**
	 * 属性 vbdef10的Getter方法.属性名：自定义项10 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef10() {
		return this.vbdef10;
	}

	/**
	 * 属性vbdef10的Setter方法.属性名：自定义项10 创建日期:2017-11-16
	 * 
	 * @param newVbdef10
	 *            java.lang.String
	 */
	public void setVbdef10(String vbdef10) {
		this.vbdef10 = vbdef10;
	}

	/**
	 * 属性 vbdef11的Getter方法.属性名：自定义项11 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef11() {
		return this.vbdef11;
	}

	/**
	 * 属性vbdef11的Setter方法.属性名：自定义项11 创建日期:2017-11-16
	 * 
	 * @param newVbdef11
	 *            java.lang.String
	 */
	public void setVbdef11(String vbdef11) {
		this.vbdef11 = vbdef11;
	}

	/**
	 * 属性 vbdef12的Getter方法.属性名：自定义项12 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef12() {
		return this.vbdef12;
	}

	/**
	 * 属性vbdef12的Setter方法.属性名：自定义项12 创建日期:2017-11-16
	 * 
	 * @param newVbdef12
	 *            java.lang.String
	 */
	public void setVbdef12(String vbdef12) {
		this.vbdef12 = vbdef12;
	}

	/**
	 * 属性 vbdef13的Getter方法.属性名：自定义项13 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef13() {
		return this.vbdef13;
	}

	/**
	 * 属性vbdef13的Setter方法.属性名：自定义项13 创建日期:2017-11-16
	 * 
	 * @param newVbdef13
	 *            java.lang.String
	 */
	public void setVbdef13(String vbdef13) {
		this.vbdef13 = vbdef13;
	}

	/**
	 * 属性 vbdef14的Getter方法.属性名：自定义项14 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef14() {
		return this.vbdef14;
	}

	/**
	 * 属性vbdef14的Setter方法.属性名：自定义项14 创建日期:2017-11-16
	 * 
	 * @param newVbdef14
	 *            java.lang.String
	 */
	public void setVbdef14(String vbdef14) {
		this.vbdef14 = vbdef14;
	}

	/**
	 * 属性 vbdef15的Getter方法.属性名：自定义项15 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef15() {
		return this.vbdef15;
	}

	/**
	 * 属性vbdef15的Setter方法.属性名：自定义项15 创建日期:2017-11-16
	 * 
	 * @param newVbdef15
	 *            java.lang.String
	 */
	public void setVbdef15(String vbdef15) {
		this.vbdef15 = vbdef15;
	}

	/**
	 * 属性 vbdef16的Getter方法.属性名：自定义项16 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef16() {
		return this.vbdef16;
	}

	/**
	 * 属性vbdef16的Setter方法.属性名：自定义项16 创建日期:2017-11-16
	 * 
	 * @param newVbdef16
	 *            java.lang.String
	 */
	public void setVbdef16(String vbdef16) {
		this.vbdef16 = vbdef16;
	}

	/**
	 * 属性 vbdef17的Getter方法.属性名：自定义项17 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef17() {
		return this.vbdef17;
	}

	/**
	 * 属性vbdef17的Setter方法.属性名：自定义项17 创建日期:2017-11-16
	 * 
	 * @param newVbdef17
	 *            java.lang.String
	 */
	public void setVbdef17(String vbdef17) {
		this.vbdef17 = vbdef17;
	}

	/**
	 * 属性 vbdef18的Getter方法.属性名：自定义项18 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef18() {
		return this.vbdef18;
	}

	/**
	 * 属性vbdef18的Setter方法.属性名：自定义项18 创建日期:2017-11-16
	 * 
	 * @param newVbdef18
	 *            java.lang.String
	 */
	public void setVbdef18(String vbdef18) {
		this.vbdef18 = vbdef18;
	}

	/**
	 * 属性 vbdef19的Getter方法.属性名：自定义项19 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef19() {
		return this.vbdef19;
	}

	/**
	 * 属性vbdef19的Setter方法.属性名：自定义项19 创建日期:2017-11-16
	 * 
	 * @param newVbdef19
	 *            java.lang.String
	 */
	public void setVbdef19(String vbdef19) {
		this.vbdef19 = vbdef19;
	}

	/**
	 * 属性 vbdef20的Getter方法.属性名：自定义项20 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef20() {
		return this.vbdef20;
	}

	/**
	 * 属性vbdef20的Setter方法.属性名：自定义项20 创建日期:2017-11-16
	 * 
	 * @param newVbdef20
	 *            java.lang.String
	 */
	public void setVbdef20(String vbdef20) {
		this.vbdef20 = vbdef20;
	}

	/**
	 * 属性 生成上层主键的Getter方法.属性名：上层主键 创建日期:2017-11-16
	 * 
	 * @return String
	 */
	public String getPk_budget() {
		return this.pk_budget;
	}

	/**
	 * 属性生成上层主键的Setter方法.属性名：上层主键 创建日期:2017-11-16
	 * 
	 * @param newPk_budget
	 *            String
	 */
	public void setPk_budget(String pk_budget) {
		this.pk_budget = pk_budget;
	}

	/**
	 * 属性 生成时间戳的Getter方法.属性名：时间戳 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public UFDateTime getTs() {
		return this.ts;
	}

	/**
	 * 属性生成时间戳的Setter方法.属性名：时间戳 创建日期:2017-11-16
	 * 
	 * @param newts
	 *            nc.vo.pub.lang.UFDateTime
	 */
	public void setTs(UFDateTime ts) {
		this.ts = ts;
	}

	@Override
	public IVOMeta getMetaData() {
		return VOMetaFactory.getInstance().getVOMeta("gl.budget_b");
	}
}
