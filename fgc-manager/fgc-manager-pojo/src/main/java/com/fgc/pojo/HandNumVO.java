package com.fgc.pojo;

import java.math.BigDecimal;

public class HandNumVO {
    private String cmaterial;

    private String cwarehouseid;

    private String vbatchcode;

    private BigDecimal nastnum;

    public String getCmaterial() {
        return cmaterial;
    }

    public void setCmaterial(String cmaterial) {
        this.cmaterial = cmaterial == null ? null : cmaterial.trim();
    }

    public String getCwarehouseid() {
        return cwarehouseid;
    }

    public void setCwarehouseid(String cwarehouseid) {
        this.cwarehouseid = cwarehouseid == null ? null : cwarehouseid.trim();
    }

    public String getVbatchcode() {
        return vbatchcode;
    }

    public void setVbatchcode(String vbatchcode) {
        this.vbatchcode = vbatchcode == null ? null : vbatchcode.trim();
    }

    public BigDecimal getNastnum() {
        return nastnum;
    }

    public void setNastnum(BigDecimal nastnum) {
        this.nastnum = nastnum;
    }
}