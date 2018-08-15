package com.fgc.pojo;

public class BillCodeVO {
    private String id;

    private String billflag;

    private String dt;

    private Long flow;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBillflag() {
        return billflag;
    }

    public void setBillflag(String billflag) {
        this.billflag = billflag == null ? null : billflag.trim();
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt == null ? null : dt.trim();
    }

    public Long getFlow() {
        return flow;
    }

    public void setFlow(Long flow) {
        this.flow = flow;
    }
}