package nc.vo.gl.budget;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

/***
 * 预算单表头VO
 * 
 * @author yegz
 * @Date 2017-11-16
 * 
 */

public class BudgetVO extends SuperVO {

	private static final long serialVersionUID = 8524295426470519747L;

	/**
	 * 预算单主键
	 */
	private String pk_budget;
	/**
	 * 集团
	 */
	private String pk_group;
	/**
	 * 财务组织
	 */
	private String pk_org;
	/**
	 * 财务组织版本
	 */
	private String pk_org_v;
	/**
	 * 单据类型
	 */
	private String billtype;
	/**
	 * 单据类型编码
	 */
	private String billtypecode;
	/**
	 * 单据号
	 */
	private String billno;
	/**
	 * 单据日期
	 */
	private UFDate dbilldate;
	/**
	 * 单据状态
	 */
	private Integer fbillflag;
	/**
	 * 业务流程
	 */
	private String busitype;
	/**
	 * 备注
	 */
	private String vnote;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 创建时间
	 */
	private UFDateTime creationtime;
	/**
	 * 最后修改人
	 */
	private String modifier;
	/**
	 * 最后修改时间
	 */
	private UFDateTime modifiedtime;
	/**
	 * 制单人
	 */
	private String billmaker;
	/**
	 * 制单日期
	 */
	private UFDate dmakedate;
	/**
	 * 审批人
	 */
	private String approver;
	/**
	 * 审批时间
	 */
	private UFDateTime taudittime;
	/**
	 * 自定义项1
	 */
	private String def1;
	/**
	 * 自定义项2
	 */
	private String def2;
	/**
	 * 自定义项3
	 */
	private String def3;
	/**
	 * 自定义项4
	 */
	private String def4;
	/**
	 * 自定义项5
	 */
	private String def5;
	/**
	 * 自定义项6
	 */
	private String def6;
	/**
	 * 自定义项7
	 */
	private String def7;
	/**
	 * 自定义项8
	 */
	private String def8;
	/**
	 * 自定义项9
	 */
	private String def9;
	/**
	 * 自定义项10
	 */
	private String def10;
	/**
	 * 自定义项11
	 */
	private String def11;
	/**
	 * 自定义项12
	 */
	private String def12;
	/**
	 * 自定义项13
	 */
	private String def13;
	/**
	 * 自定义项14
	 */
	private String def14;
	/**
	 * 自定义项15
	 */
	private String def15;
	/**
	 * 自定义项16
	 */
	private String def16;
	/**
	 * 自定义项17
	 */
	private String def17;
	/**
	 * 自定义项18
	 */
	private String def18;
	/**
	 * 自定义项19
	 */
	private String def19;
	/**
	 * 自定义项20
	 */
	private String def20;
	/**
	 * 预算期间
	 */
	private String bperiod;
	/**
	 * 产成品
	 */
	private String cprodid;
	/**
	 * 时间戳
	 */
	private UFDateTime ts;

	public static final String PK_BUDGET = "pk_budget";
	public static final String PK_GROUP = "pk_group";
	public static final String PK_ORG = "pk_org";
	public static final String PK_ORG_V = "pk_org_v";
	public static final String BILLTYPE = "billtype";
	public static final String BILLTYPECODE = "billtypecode";
	public static final String BILLNO = "billno";
	public static final String DBILLDATE = "dbilldate";
	public static final String FBILLFLAG = "fbillflag";
	public static final String BUSITYPE = "busitype";
	public static final String VNOTE = "vnote";
	public static final String CREATOR = "creator";
	public static final String CREATIONTIME = "creationtime";
	public static final String MODIFIER = "modifier";
	public static final String MODIFIEDTIME = "modifiedtime";
	public static final String BILLMAKER = "billmaker";
	public static final String DMAKEDATE = "dmakedate";
	public static final String APPROVER = "approver";
	public static final String TAUDITTIME = "taudittime";
	public static final String DEF1 = "def1";
	public static final String DEF2 = "def2";
	public static final String DEF3 = "def3";
	public static final String DEF4 = "def4";
	public static final String DEF5 = "def5";
	public static final String DEF6 = "def6";
	public static final String DEF7 = "def7";
	public static final String DEF8 = "def8";
	public static final String DEF9 = "def9";
	public static final String DEF10 = "def10";
	public static final String DEF11 = "def11";
	public static final String DEF12 = "def12";
	public static final String DEF13 = "def13";
	public static final String DEF14 = "def14";
	public static final String DEF15 = "def15";
	public static final String DEF16 = "def16";
	public static final String DEF17 = "def17";
	public static final String DEF18 = "def18";
	public static final String DEF19 = "def19";
	public static final String DEF20 = "def20";
	public static final String BPERIOD = "bperiod";
	public static final String CPRODID = "cprodid";

	/**
	 * 属性 pk_budget的Getter方法.属性名：预算单主键 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getPk_budget() {
		return this.pk_budget;
	}

	/**
	 * 属性pk_budget的Setter方法.属性名：预算单主键 创建日期:2017-11-16
	 * 
	 * @param newPk_budget
	 *            java.lang.String
	 */
	public void setPk_budget(String pk_budget) {
		this.pk_budget = pk_budget;
	}

	/**
	 * 属性 pk_group的Getter方法.属性名：集团 创建日期:2017-11-16
	 * 
	 * @return nc.vo.org.GroupVO
	 */
	public String getPk_group() {
		return this.pk_group;
	}

	/**
	 * 属性pk_group的Setter方法.属性名：集团 创建日期:2017-11-16
	 * 
	 * @param newPk_group
	 *            nc.vo.org.GroupVO
	 */
	public void setPk_group(String pk_group) {
		this.pk_group = pk_group;
	}

	/**
	 * 属性 pk_org的Getter方法.属性名：财务组织 创建日期:2017-11-16
	 * 
	 * @return nc.vo.org.FinanceOrgVO
	 */
	public String getPk_org() {
		return this.pk_org;
	}

	/**
	 * 属性pk_org的Setter方法.属性名：财务组织 创建日期:2017-11-16
	 * 
	 * @param newPk_org
	 *            nc.vo.org.FinanceOrgVO
	 */
	public void setPk_org(String pk_org) {
		this.pk_org = pk_org;
	}

	/**
	 * 属性 pk_org_v的Getter方法.属性名：财务组织版本 创建日期:2017-11-16
	 * 
	 * @return nc.vo.vorg.FinanceOrgVersionVO
	 */
	public String getPk_org_v() {
		return this.pk_org_v;
	}

	/**
	 * 属性pk_org_v的Setter方法.属性名：财务组织版本 创建日期:2017-11-16
	 * 
	 * @param newPk_org_v
	 *            nc.vo.vorg.FinanceOrgVersionVO
	 */
	public void setPk_org_v(String pk_org_v) {
		this.pk_org_v = pk_org_v;
	}

	/**
	 * 属性 billtype的Getter方法.属性名：单据类型 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.billtype.BilltypeVO
	 */
	public String getBilltype() {
		return this.billtype;
	}

	/**
	 * 属性billtype的Setter方法.属性名：单据类型 创建日期:2017-11-16
	 * 
	 * @param newBilltype
	 *            nc.vo.pub.billtype.BilltypeVO
	 */
	public void setBilltype(String billtype) {
		this.billtype = billtype;
	}

	/**
	 * 属性 billtypecode的Getter方法.属性名：单据类型编码 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getBilltypecode() {
		return this.billtypecode;
	}

	/**
	 * 属性billtypecode的Setter方法.属性名：单据类型编码 创建日期:2017-11-16
	 * 
	 * @param newBilltypecode
	 *            java.lang.String
	 */
	public void setBilltypecode(String billtypecode) {
		this.billtypecode = billtypecode;
	}

	/**
	 * 属性 billno的Getter方法.属性名：单据号 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getBillno() {
		return this.billno;
	}

	/**
	 * 属性billno的Setter方法.属性名：单据号 创建日期:2017-11-16
	 * 
	 * @param newBillno
	 *            java.lang.String
	 */
	public void setBillno(String billno) {
		this.billno = billno;
	}

	/**
	 * 属性 dbilldate的Getter方法.属性名：单据日期 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDate
	 */
	public UFDate getDbilldate() {
		return this.dbilldate;
	}

	/**
	 * 属性dbilldate的Setter方法.属性名：单据日期 创建日期:2017-11-16
	 * 
	 * @param newDbilldate
	 *            nc.vo.pub.lang.UFDate
	 */
	public void setDbilldate(UFDate dbilldate) {
		this.dbilldate = dbilldate;
	}

	/**
	 * 属性 fbillflag的Getter方法.属性名：单据状态 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.pf.BillStatusEnum
	 */
	public Integer getFbillflag() {
		return this.fbillflag;
	}

	/**
	 * 属性fbillflag的Setter方法.属性名：单据状态 创建日期:2017-11-16
	 * 
	 * @param newFbillflag
	 *            nc.vo.pub.pf.BillStatusEnum
	 */
	public void setFbillflag(Integer fbillflag) {
		this.fbillflag = fbillflag;
	}

	/**
	 * 属性 busitype的Getter方法.属性名：业务流程 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pf.pub.BusitypeVO
	 */
	public String getBusitype() {
		return this.busitype;
	}

	/**
	 * 属性busitype的Setter方法.属性名：业务流程 创建日期:2017-11-16
	 * 
	 * @param newBusitype
	 *            nc.vo.pf.pub.BusitypeVO
	 */
	public void setBusitype(String busitype) {
		this.busitype = busitype;
	}

	/**
	 * 属性 vnote的Getter方法.属性名：备注 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVnote() {
		return this.vnote;
	}

	/**
	 * 属性vnote的Setter方法.属性名：备注 创建日期:2017-11-16
	 * 
	 * @param newVnote
	 *            java.lang.String
	 */
	public void setVnote(String vnote) {
		this.vnote = vnote;
	}

	/**
	 * 属性 creator的Getter方法.属性名：创建人 创建日期:2017-11-16
	 * 
	 * @return nc.vo.sm.UserVO
	 */
	public String getCreator() {
		return this.creator;
	}

	/**
	 * 属性creator的Setter方法.属性名：创建人 创建日期:2017-11-16
	 * 
	 * @param newCreator
	 *            nc.vo.sm.UserVO
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * 属性 creationtime的Getter方法.属性名：创建时间 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public UFDateTime getCreationtime() {
		return this.creationtime;
	}

	/**
	 * 属性creationtime的Setter方法.属性名：创建时间 创建日期:2017-11-16
	 * 
	 * @param newCreationtime
	 *            nc.vo.pub.lang.UFDateTime
	 */
	public void setCreationtime(UFDateTime creationtime) {
		this.creationtime = creationtime;
	}

	/**
	 * 属性 modifier的Getter方法.属性名：最后修改人 创建日期:2017-11-16
	 * 
	 * @return nc.vo.sm.UserVO
	 */
	public String getModifier() {
		return this.modifier;
	}

	/**
	 * 属性modifier的Setter方法.属性名：最后修改人 创建日期:2017-11-16
	 * 
	 * @param newModifier
	 *            nc.vo.sm.UserVO
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	/**
	 * 属性 modifiedtime的Getter方法.属性名：最后修改时间 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public UFDateTime getModifiedtime() {
		return this.modifiedtime;
	}

	/**
	 * 属性modifiedtime的Setter方法.属性名：最后修改时间 创建日期:2017-11-16
	 * 
	 * @param newModifiedtime
	 *            nc.vo.pub.lang.UFDateTime
	 */
	public void setModifiedtime(UFDateTime modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	/**
	 * 属性 billmaker的Getter方法.属性名：制单人 创建日期:2017-11-16
	 * 
	 * @return nc.vo.sm.UserVO
	 */
	public String getBillmaker() {
		return this.billmaker;
	}

	/**
	 * 属性billmaker的Setter方法.属性名：制单人 创建日期:2017-11-16
	 * 
	 * @param newBillmaker
	 *            nc.vo.sm.UserVO
	 */
	public void setBillmaker(String billmaker) {
		this.billmaker = billmaker;
	}

	/**
	 * 属性 dmakedate的Getter方法.属性名：制单日期 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDate
	 */
	public UFDate getDmakedate() {
		return this.dmakedate;
	}

	/**
	 * 属性dmakedate的Setter方法.属性名：制单日期 创建日期:2017-11-16
	 * 
	 * @param newDmakedate
	 *            nc.vo.pub.lang.UFDate
	 */
	public void setDmakedate(UFDate dmakedate) {
		this.dmakedate = dmakedate;
	}

	/**
	 * 属性 approver的Getter方法.属性名：审批人 创建日期:2017-11-16
	 * 
	 * @return nc.vo.sm.UserVO
	 */
	public String getApprover() {
		return this.approver;
	}

	/**
	 * 属性approver的Setter方法.属性名：审批人 创建日期:2017-11-16
	 * 
	 * @param newApprover
	 *            nc.vo.sm.UserVO
	 */
	public void setApprover(String approver) {
		this.approver = approver;
	}

	/**
	 * 属性 taudittime的Getter方法.属性名：审批时间 创建日期:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public UFDateTime getTaudittime() {
		return this.taudittime;
	}

	/**
	 * 属性taudittime的Setter方法.属性名：审批时间 创建日期:2017-11-16
	 * 
	 * @param newTaudittime
	 *            nc.vo.pub.lang.UFDateTime
	 */
	public void setTaudittime(UFDateTime taudittime) {
		this.taudittime = taudittime;
	}

	/**
	 * 属性 def1的Getter方法.属性名：自定义项1 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef1() {
		return this.def1;
	}

	/**
	 * 属性def1的Setter方法.属性名：自定义项1 创建日期:2017-11-16
	 * 
	 * @param newDef1
	 *            java.lang.String
	 */
	public void setDef1(String def1) {
		this.def1 = def1;
	}

	/**
	 * 属性 def2的Getter方法.属性名：自定义项2 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef2() {
		return this.def2;
	}

	/**
	 * 属性def2的Setter方法.属性名：自定义项2 创建日期:2017-11-16
	 * 
	 * @param newDef2
	 *            java.lang.String
	 */
	public void setDef2(String def2) {
		this.def2 = def2;
	}

	/**
	 * 属性 def3的Getter方法.属性名：自定义项3 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef3() {
		return this.def3;
	}

	/**
	 * 属性def3的Setter方法.属性名：自定义项3 创建日期:2017-11-16
	 * 
	 * @param newDef3
	 *            java.lang.String
	 */
	public void setDef3(String def3) {
		this.def3 = def3;
	}

	/**
	 * 属性 def4的Getter方法.属性名：自定义项4 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef4() {
		return this.def4;
	}

	/**
	 * 属性def4的Setter方法.属性名：自定义项4 创建日期:2017-11-16
	 * 
	 * @param newDef4
	 *            java.lang.String
	 */
	public void setDef4(String def4) {
		this.def4 = def4;
	}

	/**
	 * 属性 def5的Getter方法.属性名：自定义项5 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef5() {
		return this.def5;
	}

	/**
	 * 属性def5的Setter方法.属性名：自定义项5 创建日期:2017-11-16
	 * 
	 * @param newDef5
	 *            java.lang.String
	 */
	public void setDef5(String def5) {
		this.def5 = def5;
	}

	/**
	 * 属性 def6的Getter方法.属性名：自定义项6 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef6() {
		return this.def6;
	}

	/**
	 * 属性def6的Setter方法.属性名：自定义项6 创建日期:2017-11-16
	 * 
	 * @param newDef6
	 *            java.lang.String
	 */
	public void setDef6(String def6) {
		this.def6 = def6;
	}

	/**
	 * 属性 def7的Getter方法.属性名：自定义项7 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef7() {
		return this.def7;
	}

	/**
	 * 属性def7的Setter方法.属性名：自定义项7 创建日期:2017-11-16
	 * 
	 * @param newDef7
	 *            java.lang.String
	 */
	public void setDef7(String def7) {
		this.def7 = def7;
	}

	/**
	 * 属性 def8的Getter方法.属性名：自定义项8 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef8() {
		return this.def8;
	}

	/**
	 * 属性def8的Setter方法.属性名：自定义项8 创建日期:2017-11-16
	 * 
	 * @param newDef8
	 *            java.lang.String
	 */
	public void setDef8(String def8) {
		this.def8 = def8;
	}

	/**
	 * 属性 def9的Getter方法.属性名：自定义项9 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef9() {
		return this.def9;
	}

	/**
	 * 属性def9的Setter方法.属性名：自定义项9 创建日期:2017-11-16
	 * 
	 * @param newDef9
	 *            java.lang.String
	 */
	public void setDef9(String def9) {
		this.def9 = def9;
	}

	/**
	 * 属性 def10的Getter方法.属性名：自定义项10 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef10() {
		return this.def10;
	}

	/**
	 * 属性def10的Setter方法.属性名：自定义项10 创建日期:2017-11-16
	 * 
	 * @param newDef10
	 *            java.lang.String
	 */
	public void setDef10(String def10) {
		this.def10 = def10;
	}

	/**
	 * 属性 def11的Getter方法.属性名：自定义项11 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef11() {
		return this.def11;
	}

	/**
	 * 属性def11的Setter方法.属性名：自定义项11 创建日期:2017-11-16
	 * 
	 * @param newDef11
	 *            java.lang.String
	 */
	public void setDef11(String def11) {
		this.def11 = def11;
	}

	/**
	 * 属性 def12的Getter方法.属性名：自定义项12 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef12() {
		return this.def12;
	}

	/**
	 * 属性def12的Setter方法.属性名：自定义项12 创建日期:2017-11-16
	 * 
	 * @param newDef12
	 *            java.lang.String
	 */
	public void setDef12(String def12) {
		this.def12 = def12;
	}

	/**
	 * 属性 def13的Getter方法.属性名：自定义项13 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef13() {
		return this.def13;
	}

	/**
	 * 属性def13的Setter方法.属性名：自定义项13 创建日期:2017-11-16
	 * 
	 * @param newDef13
	 *            java.lang.String
	 */
	public void setDef13(String def13) {
		this.def13 = def13;
	}

	/**
	 * 属性 def14的Getter方法.属性名：自定义项14 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef14() {
		return this.def14;
	}

	/**
	 * 属性def14的Setter方法.属性名：自定义项14 创建日期:2017-11-16
	 * 
	 * @param newDef14
	 *            java.lang.String
	 */
	public void setDef14(String def14) {
		this.def14 = def14;
	}

	/**
	 * 属性 def15的Getter方法.属性名：自定义项15 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef15() {
		return this.def15;
	}

	/**
	 * 属性def15的Setter方法.属性名：自定义项15 创建日期:2017-11-16
	 * 
	 * @param newDef15
	 *            java.lang.String
	 */
	public void setDef15(String def15) {
		this.def15 = def15;
	}

	/**
	 * 属性 def16的Getter方法.属性名：自定义项16 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef16() {
		return this.def16;
	}

	/**
	 * 属性def16的Setter方法.属性名：自定义项16 创建日期:2017-11-16
	 * 
	 * @param newDef16
	 *            java.lang.String
	 */
	public void setDef16(String def16) {
		this.def16 = def16;
	}

	/**
	 * 属性 def17的Getter方法.属性名：自定义项17 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef17() {
		return this.def17;
	}

	/**
	 * 属性def17的Setter方法.属性名：自定义项17 创建日期:2017-11-16
	 * 
	 * @param newDef17
	 *            java.lang.String
	 */
	public void setDef17(String def17) {
		this.def17 = def17;
	}

	/**
	 * 属性 def18的Getter方法.属性名：自定义项18 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef18() {
		return this.def18;
	}

	/**
	 * 属性def18的Setter方法.属性名：自定义项18 创建日期:2017-11-16
	 * 
	 * @param newDef18
	 *            java.lang.String
	 */
	public void setDef18(String def18) {
		this.def18 = def18;
	}

	/**
	 * 属性 def19的Getter方法.属性名：自定义项19 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef19() {
		return this.def19;
	}

	/**
	 * 属性def19的Setter方法.属性名：自定义项19 创建日期:2017-11-16
	 * 
	 * @param newDef19
	 *            java.lang.String
	 */
	public void setDef19(String def19) {
		this.def19 = def19;
	}

	/**
	 * 属性 def20的Getter方法.属性名：自定义项20 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef20() {
		return this.def20;
	}

	/**
	 * 属性def20的Setter方法.属性名：自定义项20 创建日期:2017-11-16
	 * 
	 * @param newDef20
	 *            java.lang.String
	 */
	public void setDef20(String def20) {
		this.def20 = def20;
	}

	/**
	 * 属性 bperiod的Getter方法.属性名：预算期间 创建日期:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getBperiod() {
		return this.bperiod;
	}

	/**
	 * 属性bperiod的Setter方法.属性名：预算期间 创建日期:2017-11-16
	 * 
	 * @param newBperiod
	 *            java.lang.String
	 */
	public void setBperiod(String bperiod) {
		this.bperiod = bperiod;
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
		return VOMetaFactory.getInstance().getVOMeta("gl.budget");
	}
}
