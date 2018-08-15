package com.fgc.pojo;

import java.math.BigDecimal;

public class InvoiceHVO {
	
	private String cmaterial;

	private String delwarehouse;

	private String effectbillcode_con;

	private String dbilldatestart;

	private String dbilldateend;
	
    private String id;

    private String pkGroup;

    private String pkOrg;

    private String cbilltype;

    private String vbilltype;

    private String dbilldate;

    private String vbillcode;

    private String customer;

    private String currency;

    private String salesman;

    private BigDecimal ntotalmny;

    private String cdept;

    private BigDecimal norigtaxmny;

    private String cbalatype;

    private BigDecimal nexchangerate;

    private String memo;

    private Long vbillstatus;

    private String client;

    private String vdef1;

    private String address;

    private String vdef2;

    private String vdef3;

    private String tel;

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

    private String vorderbillcode;

    private String modifiedtime;

    private String approver;

    private String approvetime;

    private String ts;

    private BigDecimal dr;

    private Short issync;

    private String vsrcid;

    private String vsrccode;

    private String vsrcbilltype;

    private String effectbillcode;

    private BigDecimal nsalemny;

    private BigDecimal ntotalrecemny;

    private BigDecimal retainage;

    private Long isdebt;

    private Long returnsale;

    private BigDecimal ntotalinvoicemny;

    private Long alreadyout;

    private BigDecimal ntotaloutnum;

    private BigDecimal ntotalnum;

    private String vsrcbilltypecode;

    private String cashaccount;

    private String cbankid;

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

    public String getCbilltype() {
        return cbilltype;
    }

    public void setCbilltype(String cbilltype) {
        this.cbilltype = cbilltype == null ? null : cbilltype.trim();
    }

    public String getVbilltype() {
        return vbilltype;
    }

    public void setVbilltype(String vbilltype) {
        this.vbilltype = vbilltype == null ? null : vbilltype.trim();
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman == null ? null : salesman.trim();
    }

    public BigDecimal getNtotalmny() {
        return ntotalmny;
    }

    public void setNtotalmny(BigDecimal ntotalmny) {
        this.ntotalmny = ntotalmny;
    }

    public String getCdept() {
        return cdept;
    }

    public void setCdept(String cdept) {
        this.cdept = cdept == null ? null : cdept.trim();
    }

    public BigDecimal getNorigtaxmny() {
        return norigtaxmny;
    }

    public void setNorigtaxmny(BigDecimal norigtaxmny) {
        this.norigtaxmny = norigtaxmny;
    }

    public String getCbalatype() {
        return cbalatype;
    }

    public void setCbalatype(String cbalatype) {
        this.cbalatype = cbalatype == null ? null : cbalatype.trim();
    }

    public BigDecimal getNexchangerate() {
        return nexchangerate;
    }

    public void setNexchangerate(BigDecimal nexchangerate) {
        this.nexchangerate = nexchangerate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Long getVbillstatus() {
        return vbillstatus;
    }

    public void setVbillstatus(Long vbillstatus) {
        this.vbillstatus = vbillstatus;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client == null ? null : client.trim();
    }

    public String getVdef1() {
        return vdef1;
    }

    public void setVdef1(String vdef1) {
        this.vdef1 = vdef1 == null ? null : vdef1.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
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

    public String getVorderbillcode() {
        return vorderbillcode;
    }

    public void setVorderbillcode(String vorderbillcode) {
        this.vorderbillcode = vorderbillcode == null ? null : vorderbillcode.trim();
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

    public String getVsrcbilltype() {
        return vsrcbilltype;
    }

    public void setVsrcbilltype(String vsrcbilltype) {
        this.vsrcbilltype = vsrcbilltype == null ? null : vsrcbilltype.trim();
    }

    public String getEffectbillcode() {
        return effectbillcode;
    }

    public void setEffectbillcode(String effectbillcode) {
        this.effectbillcode = effectbillcode == null ? null : effectbillcode.trim();
    }

    public BigDecimal getNsalemny() {
        return nsalemny;
    }

    public void setNsalemny(BigDecimal nsalemny) {
        this.nsalemny = nsalemny;
    }

    public BigDecimal getNtotalrecemny() {
        return ntotalrecemny;
    }

    public void setNtotalrecemny(BigDecimal ntotalrecemny) {
        this.ntotalrecemny = ntotalrecemny;
    }

    public BigDecimal getRetainage() {
        return retainage;
    }

    public void setRetainage(BigDecimal retainage) {
        this.retainage = retainage;
    }

    public Long getIsdebt() {
        return isdebt;
    }

    public void setIsdebt(Long isdebt) {
        this.isdebt = isdebt;
    }

    public Long getReturnsale() {
        return returnsale;
    }

    public void setReturnsale(Long returnsale) {
        this.returnsale = returnsale;
    }

    public BigDecimal getNtotalinvoicemny() {
        return ntotalinvoicemny;
    }

    public void setNtotalinvoicemny(BigDecimal ntotalinvoicemny) {
        this.ntotalinvoicemny = ntotalinvoicemny;
    }

    public Long getAlreadyout() {
        return alreadyout;
    }

    public void setAlreadyout(Long alreadyout) {
        this.alreadyout = alreadyout;
    }

    public BigDecimal getNtotaloutnum() {
        return ntotaloutnum;
    }

    public void setNtotaloutnum(BigDecimal ntotaloutnum) {
        this.ntotaloutnum = ntotaloutnum;
    }

    public BigDecimal getNtotalnum() {
        return ntotalnum;
    }

    public void setNtotalnum(BigDecimal ntotalnum) {
        this.ntotalnum = ntotalnum;
    }

    public String getVsrcbilltypecode() {
        return vsrcbilltypecode;
    }

    public void setVsrcbilltypecode(String vsrcbilltypecode) {
        this.vsrcbilltypecode = vsrcbilltypecode == null ? null : vsrcbilltypecode.trim();
    }

    public String getCashaccount() {
        return cashaccount;
    }

    public void setCashaccount(String cashaccount) {
        this.cashaccount = cashaccount == null ? null : cashaccount.trim();
    }

    public String getCbankid() {
        return cbankid;
    }

    public void setCbankid(String cbankid) {
        this.cbankid = cbankid == null ? null : cbankid.trim();
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

	/**
	 * @return the delwarehouse
	 */
	public String getDelwarehouse() {
		return delwarehouse;
	}

	/**
	 * @param delwarehouse the delwarehouse to set
	 */
	public void setDelwarehouse(String delwarehouse) {
		this.delwarehouse = delwarehouse;
	}

	/**
	 * @return the effectbillcode_con
	 */
	public String getEffectbillcode_con() {
		return effectbillcode_con;
	}

	/**
	 * @param effectbillcode_con the effectbillcode_con to set
	 */
	public void setEffectbillcode_con(String effectbillcode_con) {
		this.effectbillcode_con = effectbillcode_con;
	}

	/**
	 * @return the dbilldatestart
	 */
	public String getDbilldatestart() {
		return dbilldatestart;
	}

	/**
	 * @param dbilldatestart the dbilldatestart to set
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
	 * @param dbilldateend the dbilldateend to set
	 */
	public void setDbilldateend(String dbilldateend) {
		this.dbilldateend = dbilldateend;
	}
    
}