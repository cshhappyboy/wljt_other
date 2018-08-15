package com.fgc.pojo;

public class TempEffectBillcodeVO {
    private String id;

    private String effectbillcode;

    private String ts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEffectbillcode() {
        return effectbillcode;
    }

    public void setEffectbillcode(String effectbillcode) {
        this.effectbillcode = effectbillcode == null ? null : effectbillcode.trim();
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts == null ? null : ts.trim();
    }
}