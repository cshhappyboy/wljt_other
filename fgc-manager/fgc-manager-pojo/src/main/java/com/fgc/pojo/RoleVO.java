package com.fgc.pojo;

public class RoleVO {
    private String id;

    private String name;

    private String remark;

    private Integer seq;

    private String pid;

    private String dr;

    private String ts;
    
    private String resIds;

    /**
	 * @return the resIds
	 */
	public String getResIds() {
		return resIds;
	}

	/**
	 * @param resIds the resIds to set
	 */
	public void setResIds(String resIds) {
		this.resIds = resIds;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr == null ? null : dr.trim();
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts == null ? null : ts.trim();
    }
}