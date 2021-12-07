package com.hospital.entity;

public class User {
	private Integer id;
	private String account;
	private String password;
	private String tel;
	private String name;
	private String idcard;
	private String regtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public User(Integer id, String account, String password, String tel, String name, String idcard, String regtime) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.tel = tel;
		this.name = name;
		this.idcard = idcard;
		this.regtime = regtime;
	}
	
}
