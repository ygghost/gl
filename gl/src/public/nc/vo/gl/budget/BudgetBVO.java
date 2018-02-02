package nc.vo.gl.budget;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

/***
 * Ԥ�㵥��ϸVO
 * 
 * @author yegz
 * @Date 2017-11-16
 *
 */

public class BudgetBVO extends SuperVO {

	private static final long serialVersionUID = 6278180821538589639L;
	/**
	 * Ԥ����ϸ����
	 */
	private String pk_budget_b;
	/**
	 * ����Ʒ
	 */
	private String cprodid;
	/**
	 * ԭ����
	 */
	private String cmaterialid;
	/**
	 * ����λ
	 */
	private String cunitid;
	/**
	 * ����λ
	 */
	private String castunitid;
	/**
	 * ������
	 */
	private UFDouble nnum;
	/**
	 * ������
	 */
	private UFDouble nastnum;
	/**
	 * ����
	 */
	private UFDouble nprice;
	/**
	 * �Ƿ������
	 */
	private UFBoolean isrelated;
	/**
	 * ����������
	 */
	private UFDouble nblargessnum;
	/**
	 * ���͸�����
	 */
	private UFDouble nblargessastnum;
	/**
	 * �ۿ۶�
	 */
	private UFDouble ndiscount;
	/**
	 * ���۷���
	 */
	private UFDouble nsalescost;
	/**
	 * ��ַ���
	 */
	private UFDouble noutstorcost;
	/**
	 * ��װ����
	 */
	private UFDouble npackingcharge;
	/**
	 * �˹�
	 */
	private UFDouble ncost1;
	/**
	 * �۾�
	 */
	private UFDouble ncost2;
	/**
	 * ���
	 */
	private UFDouble ncost3;
	/**
	 * �ܺ�
	 */
	private UFDouble ncost4;
	/**
	 * ���
	 */
	private UFDouble ncost5;
	/**
	 * �����������
	 */
	private UFDouble ncost6;
	/**
	 * �к�
	 */
	private String crowno;
	/**
	 * ��ע
	 */
	private String vrownote;
	/**
	 * �Զ�����1
	 */
	private String vbdef1;
	/**
	 * �Զ�����2
	 */
	private String vbdef2;
	/**
	 * �Զ�����3
	 */
	private String vbdef3;
	/**
	 * �Զ�����4
	 */
	private String vbdef4;
	/**
	 * �Զ�����5
	 */
	private String vbdef5;
	/**
	 * �Զ�����6
	 */
	private String vbdef6;
	/**
	 * �Զ�����7
	 */
	private String vbdef7;
	/**
	 * �Զ�����8
	 */
	private String vbdef8;
	/**
	 * �Զ�����9
	 */
	private String vbdef9;
	/**
	 * �Զ�����10
	 */
	private String vbdef10;
	/**
	 * �Զ�����11
	 */
	private String vbdef11;
	/**
	 * �Զ�����12
	 */
	private String vbdef12;
	/**
	 * �Զ�����13
	 */
	private String vbdef13;
	/**
	 * �Զ�����14
	 */
	private String vbdef14;
	/**
	 * �Զ�����15
	 */
	private String vbdef15;
	/**
	 * �Զ�����16
	 */
	private String vbdef16;
	/**
	 * �Զ�����17
	 */
	private String vbdef17;
	/**
	 * �Զ�����18
	 */
	private String vbdef18;
	/**
	 * �Զ�����19
	 */
	private String vbdef19;
	/**
	 * �Զ�����20
	 */
	private String vbdef20;
	/**
	 * �ϲ㵥������
	 */
	private String pk_budget;
	/**
	 * ʱ���
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
	 * ���� pk_budget_b��Getter����.��������Ԥ����ϸ���� ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getPk_budget_b() {
		return this.pk_budget_b;
	}

	/**
	 * ����pk_budget_b��Setter����.��������Ԥ����ϸ���� ��������:2017-11-16
	 * 
	 * @param newPk_budget_b
	 *            java.lang.String
	 */
	public void setPk_budget_b(String pk_budget_b) {
		this.pk_budget_b = pk_budget_b;
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
	 * ���� cmaterialid��Getter����.��������ԭ���� ��������:2017-11-16
	 * 
	 * @return nc.vo.bd.material.MaterialVO
	 */
	public String getCmaterialid() {
		return this.cmaterialid;
	}

	/**
	 * ����cmaterialid��Setter����.��������ԭ���� ��������:2017-11-16
	 * 
	 * @param newCmaterialid
	 *            nc.vo.bd.material.MaterialVO
	 */
	public void setCmaterialid(String cmaterialid) {
		this.cmaterialid = cmaterialid;
	}

	/**
	 * ���� cunitid��Getter����.������������λ ��������:2017-11-16
	 * 
	 * @return nc.vo.bd.material.measdoc.MeasdocVO
	 */
	public String getCunitid() {
		return this.cunitid;
	}

	/**
	 * ����cunitid��Setter����.������������λ ��������:2017-11-16
	 * 
	 * @param newCunitid
	 *            nc.vo.bd.material.measdoc.MeasdocVO
	 */
	public void setCunitid(String cunitid) {
		this.cunitid = cunitid;
	}

	/**
	 * ���� castunitid��Getter����.������������λ ��������:2017-11-16
	 * 
	 * @return nc.vo.bd.material.measdoc.MeasdocVO
	 */
	public String getCastunitid() {
		return this.castunitid;
	}

	/**
	 * ����castunitid��Setter����.������������λ ��������:2017-11-16
	 * 
	 * @param newCastunitid
	 *            nc.vo.bd.material.measdoc.MeasdocVO
	 */
	public void setCastunitid(String castunitid) {
		this.castunitid = castunitid;
	}

	/**
	 * ���� nnum��Getter����.�������������� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNnum() {
		return this.nnum;
	}

	/**
	 * ����nnum��Setter����.�������������� ��������:2017-11-16
	 * 
	 * @param newNnum
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNnum(UFDouble nnum) {
		this.nnum = nnum;
	}

	/**
	 * ���� nastnum��Getter����.�������������� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNastnum() {
		return this.nastnum;
	}

	/**
	 * ����nastnum��Setter����.�������������� ��������:2017-11-16
	 * 
	 * @param newNastnum
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNastnum(UFDouble nastnum) {
		this.nastnum = nastnum;
	}

	/**
	 * ���� nprice��Getter����.������������ ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNprice() {
		return this.nprice;
	}

	/**
	 * ����nprice��Setter����.������������ ��������:2017-11-16
	 * 
	 * @param newNprice
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNprice(UFDouble nprice) {
		this.nprice = nprice;
	}

	/**
	 * ���� isrelated��Getter����.���������Ƿ������ ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFBoolean
	 */
	public UFBoolean getIsrelated() {
		return this.isrelated;
	}

	/**
	 * ����isrelated��Setter����.���������Ƿ������ ��������:2017-11-16
	 * 
	 * @param newIsrelated
	 *            nc.vo.pub.lang.UFBoolean
	 */
	public void setIsrelated(UFBoolean isrelated) {
		this.isrelated = isrelated;
	}

	/**
	 * ���� nblargessnum��Getter����.������������������ ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNblargessnum() {
		return this.nblargessnum;
	}

	/**
	 * ����nblargessnum��Setter����.������������������ ��������:2017-11-16
	 * 
	 * @param newNblargessnum
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNblargessnum(UFDouble nblargessnum) {
		this.nblargessnum = nblargessnum;
	}

	/**
	 * ���� nblargessastnum��Getter����.�����������͸����� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNblargessastnum() {
		return this.nblargessastnum;
	}

	/**
	 * ����nblargessastnum��Setter����.�����������͸����� ��������:2017-11-16
	 * 
	 * @param newNblargessastnum
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNblargessastnum(UFDouble nblargessastnum) {
		this.nblargessastnum = nblargessastnum;
	}

	/**
	 * ���� ndiscount��Getter����.���������ۿ۶� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNdiscount() {
		return this.ndiscount;
	}

	/**
	 * ����ndiscount��Setter����.���������ۿ۶� ��������:2017-11-16
	 * 
	 * @param newNdiscount
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNdiscount(UFDouble ndiscount) {
		this.ndiscount = ndiscount;
	}

	/**
	 * ���� nsalescost��Getter����.�����������۷��� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNsalescost() {
		return this.nsalescost;
	}

	/**
	 * ����nsalescost��Setter����.�����������۷��� ��������:2017-11-16
	 * 
	 * @param newNsalescost
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNsalescost(UFDouble nsalescost) {
		this.nsalescost = nsalescost;
	}

	/**
	 * ���� noutstorcost��Getter����.����������ַ��� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNoutstorcost() {
		return this.noutstorcost;
	}

	/**
	 * ����noutstorcost��Setter����.����������ַ��� ��������:2017-11-16
	 * 
	 * @param newNoutstorcost
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNoutstorcost(UFDouble noutstorcost) {
		this.noutstorcost = noutstorcost;
	}

	/**
	 * ���� npackingcharge��Getter����.����������װ���� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNpackingcharge() {
		return this.npackingcharge;
	}

	/**
	 * ����npackingcharge��Setter����.����������װ���� ��������:2017-11-16
	 * 
	 * @param newNpackingcharge
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNpackingcharge(UFDouble npackingcharge) {
		this.npackingcharge = npackingcharge;
	}

	/**
	 * ���� ncost1��Getter����.���������˹� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNcost1() {
		return this.ncost1;
	}

	/**
	 * ����ncost1��Setter����.���������˹� ��������:2017-11-16
	 * 
	 * @param newNcost1
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNcost1(UFDouble ncost1) {
		this.ncost1 = ncost1;
	}

	/**
	 * ���� ncost2��Getter����.���������۾� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNcost2() {
		return this.ncost2;
	}

	/**
	 * ����ncost2��Setter����.���������۾� ��������:2017-11-16
	 * 
	 * @param newNcost2
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNcost2(UFDouble ncost2) {
		this.ncost2 = ncost2;
	}

	/**
	 * ���� ncost3��Getter����.����������� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNcost3() {
		return this.ncost3;
	}

	/**
	 * ����ncost3��Setter����.����������� ��������:2017-11-16
	 * 
	 * @param newNcost3
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNcost3(UFDouble ncost3) {
		this.ncost3 = ncost3;
	}

	/**
	 * ���� ncost4��Getter����.���������ܺ� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNcost4() {
		return this.ncost4;
	}

	/**
	 * ����ncost4��Setter����.���������ܺ� ��������:2017-11-16
	 * 
	 * @param newNcost4
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNcost4(UFDouble ncost4) {
		this.ncost4 = ncost4;
	}

	/**
	 * ���� ncost5��Getter����.����������� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNcost5() {
		return this.ncost5;
	}

	/**
	 * ����ncost5��Setter����.����������� ��������:2017-11-16
	 * 
	 * @param newNcost5
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNcost5(UFDouble ncost5) {
		this.ncost5 = ncost5;
	}

	/**
	 * ���� ncost6��Getter����.������������������� ��������:2017-11-16
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public UFDouble getNcost6() {
		return this.ncost6;
	}

	/**
	 * ����ncost6��Setter����.������������������� ��������:2017-11-16
	 * 
	 * @param newNcost6
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNcost6(UFDouble ncost6) {
		this.ncost6 = ncost6;
	}

	/**
	 * ���� crowno��Getter����.���������к� ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getCrowno() {
		return this.crowno;
	}

	/**
	 * ����crowno��Setter����.���������к� ��������:2017-11-16
	 * 
	 * @param newCrowno
	 *            java.lang.String
	 */
	public void setCrowno(String crowno) {
		this.crowno = crowno;
	}

	/**
	 * ���� vrownote��Getter����.����������ע ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVrownote() {
		return this.vrownote;
	}

	/**
	 * ����vrownote��Setter����.����������ע ��������:2017-11-16
	 * 
	 * @param newVrownote
	 *            java.lang.String
	 */
	public void setVrownote(String vrownote) {
		this.vrownote = vrownote;
	}

	/**
	 * ���� vbdef1��Getter����.���������Զ�����1 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef1() {
		return this.vbdef1;
	}

	/**
	 * ����vbdef1��Setter����.���������Զ�����1 ��������:2017-11-16
	 * 
	 * @param newVbdef1
	 *            java.lang.String
	 */
	public void setVbdef1(String vbdef1) {
		this.vbdef1 = vbdef1;
	}

	/**
	 * ���� vbdef2��Getter����.���������Զ�����2 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef2() {
		return this.vbdef2;
	}

	/**
	 * ����vbdef2��Setter����.���������Զ�����2 ��������:2017-11-16
	 * 
	 * @param newVbdef2
	 *            java.lang.String
	 */
	public void setVbdef2(String vbdef2) {
		this.vbdef2 = vbdef2;
	}

	/**
	 * ���� vbdef3��Getter����.���������Զ�����3 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef3() {
		return this.vbdef3;
	}

	/**
	 * ����vbdef3��Setter����.���������Զ�����3 ��������:2017-11-16
	 * 
	 * @param newVbdef3
	 *            java.lang.String
	 */
	public void setVbdef3(String vbdef3) {
		this.vbdef3 = vbdef3;
	}

	/**
	 * ���� vbdef4��Getter����.���������Զ�����4 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef4() {
		return this.vbdef4;
	}

	/**
	 * ����vbdef4��Setter����.���������Զ�����4 ��������:2017-11-16
	 * 
	 * @param newVbdef4
	 *            java.lang.String
	 */
	public void setVbdef4(String vbdef4) {
		this.vbdef4 = vbdef4;
	}

	/**
	 * ���� vbdef5��Getter����.���������Զ�����5 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef5() {
		return this.vbdef5;
	}

	/**
	 * ����vbdef5��Setter����.���������Զ�����5 ��������:2017-11-16
	 * 
	 * @param newVbdef5
	 *            java.lang.String
	 */
	public void setVbdef5(String vbdef5) {
		this.vbdef5 = vbdef5;
	}

	/**
	 * ���� vbdef6��Getter����.���������Զ�����6 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef6() {
		return this.vbdef6;
	}

	/**
	 * ����vbdef6��Setter����.���������Զ�����6 ��������:2017-11-16
	 * 
	 * @param newVbdef6
	 *            java.lang.String
	 */
	public void setVbdef6(String vbdef6) {
		this.vbdef6 = vbdef6;
	}

	/**
	 * ���� vbdef7��Getter����.���������Զ�����7 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef7() {
		return this.vbdef7;
	}

	/**
	 * ����vbdef7��Setter����.���������Զ�����7 ��������:2017-11-16
	 * 
	 * @param newVbdef7
	 *            java.lang.String
	 */
	public void setVbdef7(String vbdef7) {
		this.vbdef7 = vbdef7;
	}

	/**
	 * ���� vbdef8��Getter����.���������Զ�����8 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef8() {
		return this.vbdef8;
	}

	/**
	 * ����vbdef8��Setter����.���������Զ�����8 ��������:2017-11-16
	 * 
	 * @param newVbdef8
	 *            java.lang.String
	 */
	public void setVbdef8(String vbdef8) {
		this.vbdef8 = vbdef8;
	}

	/**
	 * ���� vbdef9��Getter����.���������Զ�����9 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef9() {
		return this.vbdef9;
	}

	/**
	 * ����vbdef9��Setter����.���������Զ�����9 ��������:2017-11-16
	 * 
	 * @param newVbdef9
	 *            java.lang.String
	 */
	public void setVbdef9(String vbdef9) {
		this.vbdef9 = vbdef9;
	}

	/**
	 * ���� vbdef10��Getter����.���������Զ�����10 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef10() {
		return this.vbdef10;
	}

	/**
	 * ����vbdef10��Setter����.���������Զ�����10 ��������:2017-11-16
	 * 
	 * @param newVbdef10
	 *            java.lang.String
	 */
	public void setVbdef10(String vbdef10) {
		this.vbdef10 = vbdef10;
	}

	/**
	 * ���� vbdef11��Getter����.���������Զ�����11 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef11() {
		return this.vbdef11;
	}

	/**
	 * ����vbdef11��Setter����.���������Զ�����11 ��������:2017-11-16
	 * 
	 * @param newVbdef11
	 *            java.lang.String
	 */
	public void setVbdef11(String vbdef11) {
		this.vbdef11 = vbdef11;
	}

	/**
	 * ���� vbdef12��Getter����.���������Զ�����12 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef12() {
		return this.vbdef12;
	}

	/**
	 * ����vbdef12��Setter����.���������Զ�����12 ��������:2017-11-16
	 * 
	 * @param newVbdef12
	 *            java.lang.String
	 */
	public void setVbdef12(String vbdef12) {
		this.vbdef12 = vbdef12;
	}

	/**
	 * ���� vbdef13��Getter����.���������Զ�����13 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef13() {
		return this.vbdef13;
	}

	/**
	 * ����vbdef13��Setter����.���������Զ�����13 ��������:2017-11-16
	 * 
	 * @param newVbdef13
	 *            java.lang.String
	 */
	public void setVbdef13(String vbdef13) {
		this.vbdef13 = vbdef13;
	}

	/**
	 * ���� vbdef14��Getter����.���������Զ�����14 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef14() {
		return this.vbdef14;
	}

	/**
	 * ����vbdef14��Setter����.���������Զ�����14 ��������:2017-11-16
	 * 
	 * @param newVbdef14
	 *            java.lang.String
	 */
	public void setVbdef14(String vbdef14) {
		this.vbdef14 = vbdef14;
	}

	/**
	 * ���� vbdef15��Getter����.���������Զ�����15 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef15() {
		return this.vbdef15;
	}

	/**
	 * ����vbdef15��Setter����.���������Զ�����15 ��������:2017-11-16
	 * 
	 * @param newVbdef15
	 *            java.lang.String
	 */
	public void setVbdef15(String vbdef15) {
		this.vbdef15 = vbdef15;
	}

	/**
	 * ���� vbdef16��Getter����.���������Զ�����16 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef16() {
		return this.vbdef16;
	}

	/**
	 * ����vbdef16��Setter����.���������Զ�����16 ��������:2017-11-16
	 * 
	 * @param newVbdef16
	 *            java.lang.String
	 */
	public void setVbdef16(String vbdef16) {
		this.vbdef16 = vbdef16;
	}

	/**
	 * ���� vbdef17��Getter����.���������Զ�����17 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef17() {
		return this.vbdef17;
	}

	/**
	 * ����vbdef17��Setter����.���������Զ�����17 ��������:2017-11-16
	 * 
	 * @param newVbdef17
	 *            java.lang.String
	 */
	public void setVbdef17(String vbdef17) {
		this.vbdef17 = vbdef17;
	}

	/**
	 * ���� vbdef18��Getter����.���������Զ�����18 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef18() {
		return this.vbdef18;
	}

	/**
	 * ����vbdef18��Setter����.���������Զ�����18 ��������:2017-11-16
	 * 
	 * @param newVbdef18
	 *            java.lang.String
	 */
	public void setVbdef18(String vbdef18) {
		this.vbdef18 = vbdef18;
	}

	/**
	 * ���� vbdef19��Getter����.���������Զ�����19 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef19() {
		return this.vbdef19;
	}

	/**
	 * ����vbdef19��Setter����.���������Զ�����19 ��������:2017-11-16
	 * 
	 * @param newVbdef19
	 *            java.lang.String
	 */
	public void setVbdef19(String vbdef19) {
		this.vbdef19 = vbdef19;
	}

	/**
	 * ���� vbdef20��Getter����.���������Զ�����20 ��������:2017-11-16
	 * 
	 * @return java.lang.String
	 */
	public String getVbdef20() {
		return this.vbdef20;
	}

	/**
	 * ����vbdef20��Setter����.���������Զ�����20 ��������:2017-11-16
	 * 
	 * @param newVbdef20
	 *            java.lang.String
	 */
	public void setVbdef20(String vbdef20) {
		this.vbdef20 = vbdef20;
	}

	/**
	 * ���� �����ϲ�������Getter����.���������ϲ����� ��������:2017-11-16
	 * 
	 * @return String
	 */
	public String getPk_budget() {
		return this.pk_budget;
	}

	/**
	 * ���������ϲ�������Setter����.���������ϲ����� ��������:2017-11-16
	 * 
	 * @param newPk_budget
	 *            String
	 */
	public void setPk_budget(String pk_budget) {
		this.pk_budget = pk_budget;
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
		return VOMetaFactory.getInstance().getVOMeta("gl.budget_b");
	}
}
