package com.fgc.pojo;

import java.math.BigDecimal;

public class MoneyDetailVO {
    private String dbilldate;

    private String ddh;

    private String bah;

    private BigDecimal fpzje;

    private BigDecimal skje;

    private BigDecimal wk;

    private BigDecimal rnreceivedmny;

    private BigDecimal inreceivedmny;

    private String fph;

    private String cdept;

    private String billmaker;

    private String sohbillmaker;

    public String getDbilldate() {
        return dbilldate;
    }

    public void setDbilldate(String dbilldate) {
        this.dbilldate = dbilldate == null ? null : dbilldate.trim();
    }

    public String getDdh() {
        return ddh;
    }

    public void setDdh(String ddh) {
        this.ddh = ddh == null ? null : ddh.trim();
    }

    public String getBah() {
        return bah;
    }

    public void setBah(String bah) {
        this.bah = bah == null ? null : bah.trim();
    }

    public BigDecimal getFpzje() {
        return fpzje;
    }

    public void setFpzje(BigDecimal fpzje) {
        this.fpzje = fpzje;
    }

    public BigDecimal getSkje() {
        return skje;
    }

    public void setSkje(BigDecimal skje) {
        this.skje = skje;
    }

    public BigDecimal getWk() {
        return wk;
    }

    public void setWk(BigDecimal wk) {
        this.wk = wk;
    }

    public BigDecimal getRnreceivedmny() {
        return rnreceivedmny;
    }

    public void setRnreceivedmny(BigDecimal rnreceivedmny) {
        this.rnreceivedmny = rnreceivedmny;
    }

    public BigDecimal getInreceivedmny() {
        return inreceivedmny;
    }

    public void setInreceivedmny(BigDecimal inreceivedmny) {
        this.inreceivedmny = inreceivedmny;
    }

    public String getFph() {
        return fph;
    }

    public void setFph(String fph) {
        this.fph = fph == null ? null : fph.trim();
    }

    public String getCdept() {
        return cdept;
    }

    public void setCdept(String cdept) {
        this.cdept = cdept == null ? null : cdept.trim();
    }

    public String getBillmaker() {
        return billmaker;
    }

    public void setBillmaker(String billmaker) {
        this.billmaker = billmaker == null ? null : billmaker.trim();
    }

    public String getSohbillmaker() {
        return sohbillmaker;
    }

    public void setSohbillmaker(String sohbillmaker) {
        this.sohbillmaker = sohbillmaker == null ? null : sohbillmaker.trim();
    }
}