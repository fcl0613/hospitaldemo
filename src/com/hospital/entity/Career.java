package com.hospital.entity;

public class Career {
	private Integer cid;
	private String cname;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Career(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Career(Integer cid) {
		super();
		this.cid = cid;
	}
	
}
