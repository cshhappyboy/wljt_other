package com.fgc.pojo;

import java.math.BigDecimal;

public class MoneyVO {
    private String id;

    private String dbilldate;

    private String cdept;

    private String name;

    private BigDecimal zhipiao;

    private BigDecimal xianjin;

    private BigDecimal xiaoji;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDbilldate() {
        return dbilldate;
    }

    public void setDbilldate(String dbilldate) {
        this.dbilldate = dbilldate == null ? null : dbilldate.trim();
    }

    public String getCdept() {
        return cdept;
    }

    public void setCdept(String cdept) {
        this.cdept = cdept == null ? null : cdept.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getZhipiao() {
        return zhipiao;
    }

    public void setZhipiao(BigDecimal zhipiao) {
        this.zhipiao = zhipiao;
    }

    public BigDecimal getXianjin() {
        return xianjin;
    }

    public void setXianjin(BigDecimal xianjin) {
        this.xianjin = xianjin;
    }

    public BigDecimal getXiaoji() {
        return xiaoji;
    }

    public void setXiaoji(BigDecimal xiaoji) {
        this.xiaoji = xiaoji;
    }
}