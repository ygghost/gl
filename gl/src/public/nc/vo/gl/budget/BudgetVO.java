package nc.vo.gl.budget;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

/***
 * Ԥ�㵥��ͷVO
 * 
 * @author yegz
 * @Date 2017-11-16
 * 
 */

public class BudgetVO extends SuperVO {

	private static final long serialVersionUID = 8524295426470519747L;

	/**
	 * Ԥ�㵥����
	 */
	private String pk_budget;
	/**
	 * ����
	 */
	private String pk_group;
	/**
	 * ������֯
	 */
	private String pk_org;
	/**
	 * ������֯�汾
	 */
	private String pk_org_v;
	/**
	 * ��������
	 */
	private String billtype;
	/**
	 * �������ͱ���
	 */
	private String billtypecode;
	/**
	 * ���ݺ�
	 */
	private String billno;
	/**
	 * ��������
	 */
	private UFDate dbilldate;
	/**
	 * ����״̬
	 */
	private Integer fbillflag;
	/**
	 * ҵ������
	 */
	private String busitype;
	/**
	 * ��ע
	 */
	private String vnote;
	/**
	 * ������
	 */
	private String creator;
	/**
	 * ����ʱ��
	 */
	private UFDateTime creationtime;
	/**
	 * ����޸���
	 */
	private String modifier;
	/**
	 * ����޸�ʱ��
	 */
	private UFDateTime modifiedtime;
	/**
	 * �Ƶ���
	 */
	private String billmaker;
	/**
	 * �Ƶ�����
	 */
	private UFDate dmakedate;
	/**
	 * ������
	 */
	private String approver;
	/**
	 * ����ʱ��
	 */
	private UFDateTime taudittime;
	/**
	 * �Զ�����1
	 */
	private String def1;
	/**
	 * �Զ�����2
	 */
	private String def2;
	/**
	 * �Զ�����3
	 */
	private String def3;
	/**
	 * �Զ�����4
	 */
	private String def4;
	/**
	 * �Զ�����5
	 */
	private String def5;
	/**
	 * �Զ�����6
	 */
	private String def6;
	/**
	 * �Զ�����7
	 */
	private String def7;
	/**
	 * �Զ�����8
	 */
	private String def8;
	/**
	 * �Զ�����9
	 */
	private String def9;
	/**
	 * �Զ�����10
	 */
	private String def10;
	/**
	 * �Զ�����11
	 */
	private String def11;
	/**
	 * �Զ�����12
	 */
	private String def12;
	/**
	 * �Զ�����13
	 */
	private String def13;
	/**
	 * �Զ�����14
	 */
	private String def14;
	/**
	 * �Զ�����15
	 */
	private String def15;
	/**
	 * �Զ�����16
	 */
	private String def16;
	/**
	 * �Զ�����17
	 */
	private String def17;
	/**
	 * �Զ�����18
	 */
	private String def18;
	/**
	 * �Զ�����19
	 */
	private String def19;
	/**
	 * �Զ�����20
	 */
	private String def20;
	/**
	 * Ԥ���ڼ�
	 */
	private String bperiod;
	/**
	 * ����Ʒ
	 */
	private String cprodid;
	/**
	 * ʱ���
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
	 * ���� pk_budget��Getter����.��������Ԥ�㵥���� ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getPk_budget() {
		return this.pk_budget;
	}

	/**
	 * ����pk_budget��Setter����.��������Ԥ�㵥���� ��������:2017-11-16
	 * 
	 * @param newPk_budget
	 *            java.lang.String
	 */
	public void setPk_budget(String pk_budget) {
		this.pk_budget = pk_budget;
	}

	/**
	 * ���� pk_group��Getter����.������������ ��������:2017-11-16
	 * 
	 * @return nc.vo.org.GroupVO
	 */
	public String getPk_group() {
		return this.pk_group;
	}

	/**
	 * ����pk_group��Setter����.������������ ��������:2017-11-16
	 * 
	 * @param newPk_group
	 *            nc.vo.org.GroupVO
	 */
	public void setPk_group(String pk_group) {
		this.pk_group = pk_group;
	}

	/**
	 * ���� pk_org��Getter����.��������������֯ ��������:2017-11-16
	 * 
	 * @return nc.vo.org.FinanceOrgVO
	 */
	public String getPk_org() {
		return this.pk_org;
	}

	/**
	 * ����pk_org��Setter����.��������������֯ ��������:2017-11-16
	 * 
	 * @param newPk_org
	 *            nc.vo.org.FinanceOrgVO
	 */
	public void setPk_org(String pk_org) {
		this.pk_org = pk_org;
	}

	/**
	 * ���� pk_org_v��Getter����.��������������֯�汾 ��������:2017-11-16
	 * 
	 * @return nc.vo.vorg.FinanceOrgVersionVO
	 */
	public String getPk_org_v() {
		return this.pk_org_v;
	}

	/**
	 * ����pk_org_v��Setter����.��������������֯�汾 ��������:2017-11-16
	 * 
	 * @param newPk_org_v
	 *            nc.vo.vorg.FinanceOrgVersionVO
	 */
	public void setPk_org_v(String pk_org_v) {
		this.pk_org_v = pk_org_v;
	}

	/**
	 * ���� billtype��Getter����.���������������� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.billtype.BilltypeVO
	 */
	public String getBilltype() {
		return this.billtype;
	}

	/**
	 * ����billtype��Setter����.���������������� ��������:2017-11-16
	 * 
	 * @param newBilltype
	 *            nc.vo.pub.billtype.BilltypeVO
	 */
	public void setBilltype(String billtype) {
		this.billtype = billtype;
	}

	/**
	 * ���� billtypecode��Getter����.���������������ͱ��� ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getBilltypecode() {
		return this.billtypecode;
	}

	/**
	 * ����billtypecode��Setter����.���������������ͱ��� ��������:2017-11-16
	 * 
	 * @param newBilltypecode
	 *            java.lang.String
	 */
	public void setBilltypecode(String billtypecode) {
		this.billtypecode = billtypecode;
	}

	/**
	 * ���� billno��Getter����.�����������ݺ� ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getBillno() {
		return this.billno;
	}

	/**
	 * ����billno��Setter����.�����������ݺ� ��������:2017-11-16
	 * 
	 * @param newBillno
	 *            java.lang.String
	 */
	public void setBillno(String billno) {
		this.billno = billno;
	}

	/**
	 * ���� dbilldate��Getter����.���������������� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDate
	 */
	public UFDate getDbilldate() {
		return this.dbilldate;
	}

	/**
	 * ����dbilldate��Setter����.���������������� ��������:2017-11-16
	 * 
	 * @param newDbilldate
	 *            nc.vo.pub.lang.UFDate
	 */
	public void setDbilldate(UFDate dbilldate) {
		this.dbilldate = dbilldate;
	}

	/**
	 * ���� fbillflag��Getter����.������������״̬ ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.pf.BillStatusEnum
	 */
	public Integer getFbillflag() {
		return this.fbillflag;
	}

	/**
	 * ����fbillflag��Setter����.������������״̬ ��������:2017-11-16
	 * 
	 * @param newFbillflag
	 *            nc.vo.pub.pf.BillStatusEnum
	 */
	public void setFbillflag(Integer fbillflag) {
		this.fbillflag = fbillflag;
	}

	/**
	 * ���� busitype��Getter����.��������ҵ������ ��������:2017-11-16
	 * 
	 * @return nc.vo.pf.pub.BusitypeVO
	 */
	public String getBusitype() {
		return this.busitype;
	}

	/**
	 * ����busitype��Setter����.��������ҵ������ ��������:2017-11-16
	 * 
	 * @param newBusitype
	 *            nc.vo.pf.pub.BusitypeVO
	 */
	public void setBusitype(String busitype) {
		this.busitype = busitype;
	}

	/**
	 * ���� vnote��Getter����.����������ע ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVnote() {
		return this.vnote;
	}

	/**
	 * ����vnote��Setter����.����������ע ��������:2017-11-16
	 * 
	 * @param newVnote
	 *            java.lang.String
	 */
	public void setVnote(String vnote) {
		this.vnote = vnote;
	}

	/**
	 * ���� creator��Getter����.�������������� ��������:2017-11-16
	 * 
	 * @return nc.vo.sm.UserVO
	 */
	public String getCreator() {
		return this.creator;
	}

	/**
	 * ����creator��Setter����.�������������� ��������:2017-11-16
	 * 
	 * @param newCreator
	 *            nc.vo.sm.UserVO
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * ���� creationtime��Getter����.������������ʱ�� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public UFDateTime getCreationtime() {
		return this.creationtime;
	}

	/**
	 * ����creationtime��Setter����.������������ʱ�� ��������:2017-11-16
	 * 
	 * @param newCreationtime
	 *            nc.vo.pub.lang.UFDateTime
	 */
	public void setCreationtime(UFDateTime creationtime) {
		this.creationtime = creationtime;
	}

	/**
	 * ���� modifier��Getter����.������������޸��� ��������:2017-11-16
	 * 
	 * @return nc.vo.sm.UserVO
	 */
	public String getModifier() {
		return this.modifier;
	}

	/**
	 * ����modifier��Setter����.������������޸��� ��������:2017-11-16
	 * 
	 * @param newModifier
	 *            nc.vo.sm.UserVO
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	/**
	 * ���� modifiedtime��Getter����.������������޸�ʱ�� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public UFDateTime getModifiedtime() {
		return this.modifiedtime;
	}

	/**
	 * ����modifiedtime��Setter����.������������޸�ʱ�� ��������:2017-11-16
	 * 
	 * @param newModifiedtime
	 *            nc.vo.pub.lang.UFDateTime
	 */
	public void setModifiedtime(UFDateTime modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	/**
	 * ���� billmaker��Getter����.���������Ƶ��� ��������:2017-11-16
	 * 
	 * @return nc.vo.sm.UserVO
	 */
	public String getBillmaker() {
		return this.billmaker;
	}

	/**
	 * ����billmaker��Setter����.���������Ƶ��� ��������:2017-11-16
	 * 
	 * @param newBillmaker
	 *            nc.vo.sm.UserVO
	 */
	public void setBillmaker(String billmaker) {
		this.billmaker = billmaker;
	}

	/**
	 * ���� dmakedate��Getter����.���������Ƶ����� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDate
	 */
	public UFDate getDmakedate() {
		return this.dmakedate;
	}

	/**
	 * ����dmakedate��Setter����.���������Ƶ����� ��������:2017-11-16
	 * 
	 * @param newDmakedate
	 *            nc.vo.pub.lang.UFDate
	 */
	public void setDmakedate(UFDate dmakedate) {
		this.dmakedate = dmakedate;
	}

	/**
	 * ���� approver��Getter����.�������������� ��������:2017-11-16
	 * 
	 * @return nc.vo.sm.UserVO
	 */
	public String getApprover() {
		return this.approver;
	}

	/**
	 * ����approver��Setter����.�������������� ��������:2017-11-16
	 * 
	 * @param newApprover
	 *            nc.vo.sm.UserVO
	 */
	public void setApprover(String approver) {
		this.approver = approver;
	}

	/**
	 * ���� taudittime��Getter����.������������ʱ�� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public UFDateTime getTaudittime() {
		return this.taudittime;
	}

	/**
	 * ����taudittime��Setter����.������������ʱ�� ��������:2017-11-16
	 * 
	 * @param newTaudittime
	 *            nc.vo.pub.lang.UFDateTime
	 */
	public void setTaudittime(UFDateTime taudittime) {
		this.taudittime = taudittime;
	}

	/**
	 * ���� def1��Getter����.���������Զ�����1 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef1() {
		return this.def1;
	}

	/**
	 * ����def1��Setter����.���������Զ�����1 ��������:2017-11-16
	 * 
	 * @param newDef1
	 *            java.lang.String
	 */
	public void setDef1(String def1) {
		this.def1 = def1;
	}

	/**
	 * ���� def2��Getter����.���������Զ�����2 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef2() {
		return this.def2;
	}

	/**
	 * ����def2��Setter����.���������Զ�����2 ��������:2017-11-16
	 * 
	 * @param newDef2
	 *            java.lang.String
	 */
	public void setDef2(String def2) {
		this.def2 = def2;
	}

	/**
	 * ���� def3��Getter����.���������Զ�����3 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef3() {
		return this.def3;
	}

	/**
	 * ����def3��Setter����.���������Զ�����3 ��������:2017-11-16
	 * 
	 * @param newDef3
	 *            java.lang.String
	 */
	public void setDef3(String def3) {
		this.def3 = def3;
	}

	/**
	 * ���� def4��Getter����.���������Զ�����4 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef4() {
		return this.def4;
	}

	/**
	 * ����def4��Setter����.���������Զ�����4 ��������:2017-11-16
	 * 
	 * @param newDef4
	 *            java.lang.String
	 */
	public void setDef4(String def4) {
		this.def4 = def4;
	}

	/**
	 * ���� def5��Getter����.���������Զ�����5 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef5() {
		return this.def5;
	}

	/**
	 * ����def5��Setter����.���������Զ�����5 ��������:2017-11-16
	 * 
	 * @param newDef5
	 *            java.lang.String
	 */
	public void setDef5(String def5) {
		this.def5 = def5;
	}

	/**
	 * ���� def6��Getter����.���������Զ�����6 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef6() {
		return this.def6;
	}

	/**
	 * ����def6��Setter����.���������Զ�����6 ��������:2017-11-16
	 * 
	 * @param newDef6
	 *            java.lang.String
	 */
	public void setDef6(String def6) {
		this.def6 = def6;
	}

	/**
	 * ���� def7��Getter����.���������Զ�����7 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef7() {
		return this.def7;
	}

	/**
	 * ����def7��Setter����.���������Զ�����7 ��������:2017-11-16
	 * 
	 * @param newDef7
	 *            java.lang.String
	 */
	public void setDef7(String def7) {
		this.def7 = def7;
	}

	/**
	 * ���� def8��Getter����.���������Զ�����8 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef8() {
		return this.def8;
	}

	/**
	 * ����def8��Setter����.���������Զ�����8 ��������:2017-11-16
	 * 
	 * @param newDef8
	 *            java.lang.String
	 */
	public void setDef8(String def8) {
		this.def8 = def8;
	}

	/**
	 * ���� def9��Getter����.���������Զ�����9 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef9() {
		return this.def9;
	}

	/**
	 * ����def9��Setter����.���������Զ�����9 ��������:2017-11-16
	 * 
	 * @param newDef9
	 *            java.lang.String
	 */
	public void setDef9(String def9) {
		this.def9 = def9;
	}

	/**
	 * ���� def10��Getter����.���������Զ�����10 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef10() {
		return this.def10;
	}

	/**
	 * ����def10��Setter����.���������Զ�����10 ��������:2017-11-16
	 * 
	 * @param newDef10
	 *            java.lang.String
	 */
	public void setDef10(String def10) {
		this.def10 = def10;
	}

	/**
	 * ���� def11��Getter����.���������Զ�����11 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef11() {
		return this.def11;
	}

	/**
	 * ����def11��Setter����.���������Զ�����11 ��������:2017-11-16
	 * 
	 * @param newDef11
	 *            java.lang.String
	 */
	public void setDef11(String def11) {
		this.def11 = def11;
	}

	/**
	 * ���� def12��Getter����.���������Զ�����12 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef12() {
		return this.def12;
	}

	/**
	 * ����def12��Setter����.���������Զ�����12 ��������:2017-11-16
	 * 
	 * @param newDef12
	 *            java.lang.String
	 */
	public void setDef12(String def12) {
		this.def12 = def12;
	}

	/**
	 * ���� def13��Getter����.���������Զ�����13 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef13() {
		return this.def13;
	}

	/**
	 * ����def13��Setter����.���������Զ�����13 ��������:2017-11-16
	 * 
	 * @param newDef13
	 *            java.lang.String
	 */
	public void setDef13(String def13) {
		this.def13 = def13;
	}

	/**
	 * ���� def14��Getter����.���������Զ�����14 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef14() {
		return this.def14;
	}

	/**
	 * ����def14��Setter����.���������Զ�����14 ��������:2017-11-16
	 * 
	 * @param newDef14
	 *            java.lang.String
	 */
	public void setDef14(String def14) {
		this.def14 = def14;
	}

	/**
	 * ���� def15��Getter����.���������Զ�����15 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef15() {
		return this.def15;
	}

	/**
	 * ����def15��Setter����.���������Զ�����15 ��������:2017-11-16
	 * 
	 * @param newDef15
	 *            java.lang.String
	 */
	public void setDef15(String def15) {
		this.def15 = def15;
	}

	/**
	 * ���� def16��Getter����.���������Զ�����16 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef16() {
		return this.def16;
	}

	/**
	 * ����def16��Setter����.���������Զ�����16 ��������:2017-11-16
	 * 
	 * @param newDef16
	 *            java.lang.String
	 */
	public void setDef16(String def16) {
		this.def16 = def16;
	}

	/**
	 * ���� def17��Getter����.���������Զ�����17 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef17() {
		return this.def17;
	}

	/**
	 * ����def17��Setter����.���������Զ�����17 ��������:2017-11-16
	 * 
	 * @param newDef17
	 *            java.lang.String
	 */
	public void setDef17(String def17) {
		this.def17 = def17;
	}

	/**
	 * ���� def18��Getter����.���������Զ�����18 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef18() {
		return this.def18;
	}

	/**
	 * ����def18��Setter����.���������Զ�����18 ��������:2017-11-16
	 * 
	 * @param newDef18
	 *            java.lang.String
	 */
	public void setDef18(String def18) {
		this.def18 = def18;
	}

	/**
	 * ���� def19��Getter����.���������Զ�����19 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef19() {
		return this.def19;
	}

	/**
	 * ����def19��Setter����.���������Զ�����19 ��������:2017-11-16
	 * 
	 * @param newDef19
	 *            java.lang.String
	 */
	public void setDef19(String def19) {
		this.def19 = def19;
	}

	/**
	 * ���� def20��Getter����.���������Զ�����20 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getDef20() {
		return this.def20;
	}

	/**
	 * ����def20��Setter����.���������Զ�����20 ��������:2017-11-16
	 * 
	 * @param newDef20
	 *            java.lang.String
	 */
	public void setDef20(String def20) {
		this.def20 = def20;
	}

	/**
	 * ���� bperiod��Getter����.��������Ԥ���ڼ� ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getBperiod() {
		return this.bperiod;
	}

	/**
	 * ����bperiod��Setter����.��������Ԥ���ڼ� ��������:2017-11-16
	 * 
	 * @param newBperiod
	 *            java.lang.String
	 */
	public void setBperiod(String bperiod) {
		this.bperiod = bperiod;
	}

	/**
	 * ���� cprodid��Getter����.������������Ʒ ��������:2017-11-16
	 * 
	 * @return nc.vo.bd.material.MaterialVO
	 */
	public String getCprodid() {
		return this.cprodid;
	}

	/**
	 * ����cprodid��Setter����.������������Ʒ ��������:2017-11-16
	 * 
	 * @param newCprodid
	 *            nc.vo.bd.material.MaterialVO
	 */
	public void setCprodid(String cprodid) {
		this.cprodid = cprodid;
	}

	/**
	 * ���� ����ʱ�����Getter����.��������ʱ��� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public UFDateTime getTs() {
		return this.ts;
	}

	/**
	 * ��������ʱ�����Setter����.��������ʱ��� ��������:2017-11-16
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
