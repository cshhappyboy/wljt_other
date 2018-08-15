package com.fgc.pojo;

public class TempBillcodeVO {
    private String id;

    private String vbillcode;

    private String ts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getVbillcode() {
        return vbillcode;
    }

    public void setVbillcode(String vbillcode) {
        this.vbillcode = vbillcode == null ? null : vbillcode.trim();
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts == null ? null : ts.trim();
    }
}