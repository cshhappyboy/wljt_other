package com.fgc.pojo.util;

import java.math.BigDecimal;

/**
 * 销售订单导入中间VO
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月22日
 *
 *     未来离线需求
 */
public class OrderImportVO {

	private String materialcode;

	private String materialspec;

	private String materialtype;

	private Long services;

	private String cunitid;

	private String measrate;

	private String vbilltype;

	private String cbilltype;

	private String vbillcode;

	private String dbilldate;

	private String customer;

	private String currency;

	private String salesman;

	private String cdept;

	private String client;

	private String address;

	private String tel;

	private String memo;

	private String cmaterial;

	private BigDecimal salenum;

	private BigDecimal nsaleprice;

	private BigDecimal nmny;

	private String effectbillcode;

	private String delwarehouse;

	private String castunitid;

	private String csaleunitid;

	private String vunitratio;

	private BigDecimal nexchangerate;

	private String delwarehousecode;

	/**
	 * @return the vunitratio
	 */
	public String getVunitratio() {
		return vunitratio;
	}

	/**
	 * @param vunitratio
	 *            the vunitratio to set
	 */
	public void setVunitratio(String vunitratio) {
		this.vunitratio = vunitratio;
	}

	/**
	 * @return the vbilltype
	 */
	public String getVbilltype() {
		return vbilltype;
	}

	/**
	 * @param vbilltype
	 *            the vbilltype to set
	 */
	public void setVbilltype(String vbilltype) {
		this.vbilltype = vbilltype;
	}

	/**
	 * @return the cbilltype
	 */
	public String getCbilltype() {
		return cbilltype;
	}

	/**
	 * @param cbilltype
	 *            the cbilltype to set
	 */
	public void setCbilltype(String cbilltype) {
		this.cbilltype = cbilltype;
	}

	/**
	 * @return the vbillcode
	 */
	public String getVbillcode() {
		return vbillcode;
	}

	/**
	 * @param vbillcode
	 *            the vbillcode to set
	 */
	public void setVbillcode(String vbillcode) {
		this.vbillcode = vbillcode;
	}

	/**
	 * @return the dbilldate
	 */
	public String getDbilldate() {
		return dbilldate;
	}

	/**
	 * @param dbilldate
	 *            the dbilldate to set
	 */
	public void setDbilldate(String dbilldate) {
		this.dbilldate = dbilldate;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the salesman
	 */
	public String getSalesman() {
		return salesman;
	}

	/**
	 * @param salesman
	 *            the salesman to set
	 */
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}

	/**
	 * @return the cdept
	 */
	public String getCdept() {
		return cdept;
	}

	/**
	 * @param cdept
	 *            the cdept to set
	 */
	public void setCdept(String cdept) {
		this.cdept = cdept;
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return the cmaterial
	 */
	public String getCmaterial() {
		return cmaterial;
	}

	/**
	 * @param cmaterial
	 *            the cmaterial to set
	 */
	public void setCmaterial(String cmaterial) {
		this.cmaterial = cmaterial;
	}


	/**
	 * @return the nmny
	 */
	public BigDecimal getNmny() {
		return nmny;
	}

	/**
	 * @param nmny
	 *            the nmny to set
	 */
	public void setNmny(BigDecimal nmny) {
		this.nmny = nmny;
	}

	/**
	 * @return the effectbillcode
	 */
	public String getEffectbillcode() {
		return effectbillcode;
	}

	/**
	 * @param effectbillcode the effectbillcode to set
	 */
	public void setEffectbillcode(String effectbillcode) {
		this.effectbillcode = effectbillcode;
	}

	/**
	 * @return the delwarehouse
	 */
	public String getDelwarehouse() {
		return delwarehouse;
	}

	/**
	 * @param delwarehouse
	 *            the delwarehouse to set
	 */
	public void setDelwarehouse(String delwarehouse) {
		this.delwarehouse = delwarehouse;
	}

	/**
	 * @return the castunitid
	 */
	public String getCastunitid() {
		return castunitid;
	}

	/**
	 * @param castunitid
	 *            the castunitid to set
	 */
	public void setCastunitid(String castunitid) {
		this.castunitid = castunitid;
	}

	/**
	 * @return the csaleunitid
	 */
	public String getCsaleunitid() {
		return csaleunitid;
	}

	/**
	 * @param csaleunitid
	 *            the csaleunitid to set
	 */
	public void setCsaleunitid(String csaleunitid) {
		this.csaleunitid = csaleunitid;
	}

	/**
	 * @return the nexchangerate
	 */
	public BigDecimal getNexchangerate() {
		return nexchangerate;
	}

	/**
	 * @param nexchangerate
	 *            the nexchangerate to set
	 */
	public void setNexchangerate(BigDecimal nexchangerate) {
		this.nexchangerate = nexchangerate;
	}

	/**
	 * @return the materialcode
	 */
	public String getMaterialcode() {
		return materialcode;
	}

	/**
	 * @param materialcode
	 *            the materialcode to set
	 */
	public void setMaterialcode(String materialcode) {
		this.materialcode = materialcode;
	}

	/**
	 * @return the materialspec
	 */
	public String getMaterialspec() {
		return materialspec;
	}

	/**
	 * @param materialspec
	 *            the materialspec to set
	 */
	public void setMaterialspec(String materialspec) {
		this.materialspec = materialspec;
	}

	/**
	 * @return the materialtype
	 */
	public String getMaterialtype() {
		return materialtype;
	}

	/**
	 * @param materialtype
	 *            the materialtype to set
	 */
	public void setMaterialtype(String materialtype) {
		this.materialtype = materialtype;
	}

	/**
	 * @return the services
	 */
	public Long getServices() {
		return services;
	}

	/**
	 * @param services
	 *            the services to set
	 */
	public void setServices(Long services) {
		this.services = services;
	}

	/**
	 * @return the cunitid
	 */
	public String getCunitid() {
		return cunitid;
	}

	/**
	 * @param cunitid
	 *            the cunitid to set
	 */
	public void setCunitid(String cunitid) {
		this.cunitid = cunitid;
	}

	/**
	 * @return the measrate
	 */
	public String getMeasrate() {
		return measrate;
	}

	/**
	 * @param measrate
	 *            the measrate to set
	 */
	public void setMeasrate(String measrate) {
		this.measrate = measrate;
	}

	/**
	 * @return the delwarehousecode
	 */
	public String getDelwarehousecode() {
		return delwarehousecode;
	}

	/**
	 * @param delwarehousecode
	 *            the delwarehousecode to set
	 */
	public void setDelwarehousecode(String delwarehousecode) {
		this.delwarehousecode = delwarehousecode;
	}

	/**
	 * @return the salenum
	 */
	public BigDecimal getSalenum() {
		return salenum;
	}

	/**
	 * @param salenum the salenum to set
	 */
	public void setSalenum(BigDecimal salenum) {
		this.salenum = salenum;
	}

	/**
	 * @return the nsaleprice
	 */
	public BigDecimal getNsaleprice() {
		return nsaleprice;
	}

	/**
	 * @param nsaleprice the nsaleprice to set
	 */
	public void setNsaleprice(BigDecimal nsaleprice) {
		this.nsaleprice = nsaleprice;
	}

}
