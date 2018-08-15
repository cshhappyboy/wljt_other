package com.fgc.pojo;

import java.math.BigDecimal;

public class FinprodinHVO {
	
	private String cmaterial;

	private String effectbillcode_con;

	private String dbilldatestart;

	private String dbilldateend;

	private String id;

	private String pkGroup;

	private String pkOrg;

	private String vbilltype;

	private Long vbillstatus;

	private String cbilltype;

	private String dbilldate;

	private String vbillcode;

	private BigDecimal ntotalnum;

	private String salesman;

	private String cdptid;

	private String cdept;

	private String cwarehouseid;

	private String memo;

	private String vdef1;

	private String vdef2;

	private String vdef3;

	private String vdef4;

	private String vdef5;

	private String vdef6;

	private String vdef7;

	private String vdef8;

	private String vdef9;

	private String vdef10;

	private String billmaker;

	private String billmaketime;

	private String modifier;

	private String modifiedtime;

	private String approver;

	private String approvetime;

	private String ts;

	private BigDecimal dr;

	private Short issync;

	private String vorderbillcode;

	private String vsrcid;

	private String vsrccode;

	private String effectbillcode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getPkGroup() {
		return pkGroup;
	}

	public void setPkGroup(String pkGroup) {
		this.pkGroup = pkGroup == null ? null : pkGroup.trim();
	}

	public String getPkOrg() {
		return pkOrg;
	}

	public void setPkOrg(String pkOrg) {
		this.pkOrg = pkOrg == null ? null : pkOrg.trim();
	}

	public String getVbilltype() {
		return vbilltype;
	}

	public void setVbilltype(String vbilltype) {
		this.vbilltype = vbilltype == null ? null : vbilltype.trim();
	}

	public Long getVbillstatus() {
		return vbillstatus;
	}

	public void setVbillstatus(Long vbillstatus) {
		this.vbillstatus = vbillstatus;
	}

	public String getCbilltype() {
		return cbilltype;
	}

	public void setCbilltype(String cbilltype) {
		this.cbilltype = cbilltype == null ? null : cbilltype.trim();
	}

	public String getDbilldate() {
		return dbilldate;
	}

	public void setDbilldate(String dbilldate) {
		this.dbilldate = dbilldate == null ? null : dbilldate.trim();
	}

	public String getVbillcode() {
		return vbillcode;
	}

	public void setVbillcode(String vbillcode) {
		this.vbillcode = vbillcode == null ? null : vbillcode.trim();
	}

	public BigDecimal getNtotalnum() {
		return ntotalnum;
	}

	public void setNtotalnum(BigDecimal ntotalnum) {
		this.ntotalnum = ntotalnum;
	}

	public String getSalesman() {
		return salesman;
	}

	public void setSalesman(String salesman) {
		this.salesman = salesman == null ? null : salesman.trim();
	}

	public String getCdptid() {
		return cdptid;
	}

	public void setCdptid(String cdptid) {
		this.cdptid = cdptid == null ? null : cdptid.trim();
	}

	public String getCdept() {
		return cdept;
	}

	public void setCdept(String cdept) {
		this.cdept = cdept == null ? null : cdept.trim();
	}

	public String getCwarehouseid() {
		return cwarehouseid;
	}

	public void setCwarehouseid(String cwarehouseid) {
		this.cwarehouseid = cwarehouseid == null ? null : cwarehouseid.trim();
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}

	public String getVdef1() {
		return vdef1;
	}

	public void setVdef1(String vdef1) {
		this.vdef1 = vdef1 == null ? null : vdef1.trim();
	}

	public String getVdef2() {
		return vdef2;
	}

	public void setVdef2(String vdef2) {
		this.vdef2 = vdef2 == null ? null : vdef2.trim();
	}

	public String getVdef3() {
		return vdef3;
	}

	public void setVdef3(String vdef3) {
		this.vdef3 = vdef3 == null ? null : vdef3.trim();
	}

	public String getVdef4() {
		return vdef4;
	}

	public void setVdef4(String vdef4) {
		this.vdef4 = vdef4 == null ? null : vdef4.trim();
	}

	public String getVdef5() {
		return vdef5;
	}

	public void setVdef5(String vdef5) {
		this.vdef5 = vdef5 == null ? null : vdef5.trim();
	}

	public String getVdef6() {
		return vdef6;
	}

	public void setVdef6(String vdef6) {
		this.vdef6 = vdef6 == null ? null : vdef6.trim();
	}

	public String getVdef7() {
		return vdef7;
	}

	public void setVdef7(String vdef7) {
		this.vdef7 = vdef7 == null ? null : vdef7.trim();
	}

	public String getVdef8() {
		return vdef8;
	}

	public void setVdef8(String vdef8) {
		this.vdef8 = vdef8 == null ? null : vdef8.trim();
	}

	public String getVdef9() {
		return vdef9;
	}

	public void setVdef9(String vdef9) {
		this.vdef9 = vdef9 == null ? null : vdef9.trim();
	}

	public String getVdef10() {
		return vdef10;
	}

	public void setVdef10(String vdef10) {
		this.vdef10 = vdef10 == null ? null : vdef10.trim();
	}

	public String getBillmaker() {
		return billmaker;
	}

	public void setBillmaker(String billmaker) {
		this.billmaker = billmaker == null ? null : billmaker.trim();
	}

	public String getBillmaketime() {
		return billmaketime;
	}

	public void setBillmaketime(String billmaketime) {
		this.billmaketime = billmaketime == null ? null : billmaketime.trim();
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier == null ? null : modifier.trim();
	}

	public String getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime == null ? null : modifiedtime.trim();
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver == null ? null : approver.trim();
	}

	public String getApprovetime() {
		return approvetime;
	}

	public void setApprovetime(String approvetime) {
		this.approvetime = approvetime == null ? null : approvetime.trim();
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts == null ? null : ts.trim();
	}

	public BigDecimal getDr() {
		return dr;
	}

	public void setDr(BigDecimal dr) {
		this.dr = dr;
	}

	public Short getIssync() {
		return issync;
	}

	public void setIssync(Short issync) {
		this.issync = issync;
	}

	public String getVorderbillcode() {
		return vorderbillcode;
	}

	public void setVorderbillcode(String vorderbillcode) {
		this.vorderbillcode = vorderbillcode == null ? null : vorderbillcode.trim();
	}

	public String getVsrcid() {
		return vsrcid;
	}

	public void setVsrcid(String vsrcid) {
		this.vsrcid = vsrcid == null ? null : vsrcid.trim();
	}

	public String getVsrccode() {
		return vsrccode;
	}

	public void setVsrccode(String vsrccode) {
		this.vsrccode = vsrccode == null ? null : vsrccode.trim();
	}

	public String getEffectbillcode() {
		return effectbillcode;
	}

	public void setEffectbillcode(String effectbillcode) {
		this.effectbillcode = effectbillcode == null ? null : effectbillcode.trim();
	}

	/**
	 * @return the dbilldatestart
	 */
	public String getDbilldatestart() {
		return dbilldatestart;
	}

	/**
	 * @param dbilldatestart
	 *            the dbilldatestart to set
	 */
	public void setDbilldatestart(String dbilldatestart) {
		this.dbilldatestart = dbilldatestart;
	}

	/**
	 * @return the dbilldateend
	 */
	public String getDbilldateend() {
		return dbilldateend;
	}

	/**
	 * @param dbilldateend
	 *            the dbilldateend to set
	 */
	public void setDbilldateend(String dbilldateend) {
		this.dbilldateend = dbilldateend;
	}

	/**
	 * @return the effectbillcode_con
	 */
	public String getEffectbillcode_con() {
		return effectbillcode_con;
	}

	/**
	 * @param effectbillcode_con
	 *            the effectbillcode_con to set
	 */
	public void setEffectbillcode_con(String effectbillcode_con) {
		this.effectbillcode_con = effectbillcode_con;
	}

	/**
	 * @return the cmaterial
	 */
	public String getCmaterial() {
		return cmaterial;
	}

	/**
	 * @param cmaterial the cmaterial to set
	 */
	public void setCmaterial(String cmaterial) {
		this.cmaterial = cmaterial;
	}

}