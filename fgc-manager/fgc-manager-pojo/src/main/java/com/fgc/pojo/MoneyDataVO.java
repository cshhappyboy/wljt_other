package com.fgc.pojo;

import java.math.BigDecimal;

public class MoneyDataVO {
    private String pid;

    private String dbilldate;

    private BigDecimal xianjin;

    private BigDecimal zhipiao;

    private BigDecimal xiaoji;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getDbilldate() {
        return dbilldate;
    }

    public void setDbilldate(String dbilldate) {
        this.dbilldate = dbilldate == null ? null : dbilldate.trim();
    }

    public BigDecimal getXianjin() {
        return xianjin;
    }

    public void setXianjin(BigDecimal xianjin) {
        this.xianjin = xianjin;
    }

    public BigDecimal getZhipiao() {
        return zhipiao;
    }

    public void setZhipiao(BigDecimal zhipiao) {
        this.zhipiao = zhipiao;
    }

    public BigDecimal getXiaoji() {
        return xiaoji;
    }

    public void setXiaoji(BigDecimal xiaoji) {
        this.xiaoji = xiaoji;
    }
}