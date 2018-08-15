package com.fgc.pojo;

import java.math.BigDecimal;

public class CustsaleVO {
    private String pkcustsale;

    private String vdef1;

    private String pkcustomer;

    private String vdef2;

    private String vdef3;

    private String vdef4;

    private String vdef5;

    private String vdef6;

    private String vdef7;

    private String vdef8;

    private String vdef9;

    private String vdef10;

    private Long dr;

    private String pkorg;

    private BigDecimal stockpriceratio;

    public String getPkcustsale() {
        return pkcustsale;
    }

    public void setPkcustsale(String pkcustsale) {
        this.pkcustsale = pkcustsale == null ? null : pkcustsale.trim();
    }

    public String getVdef1() {
        return vdef1;
    }

    public void setVdef1(String vdef1) {
        this.vdef1 = vdef1 == null ? null : vdef1.trim();
    }

    public String getPkcustomer() {
        return pkcustomer;
    }

    public void setPkcustomer(String pkcustomer) {
        this.pkcustomer = pkcustomer == null ? null : pkcustomer.trim();
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

    public Long getDr() {
        return dr;
    }

    public void setDr(Long dr) {
        this.dr = dr;
    }

    public String getPkorg() {
        return pkorg;
    }

    public void setPkorg(String pkorg) {
        this.pkorg = pkorg == null ? null : pkorg.trim();
    }

    public BigDecimal getStockpriceratio() {
        return stockpriceratio;
    }

    public void setStockpriceratio(BigDecimal stockpriceratio) {
        this.stockpriceratio = stockpriceratio;
    }
}