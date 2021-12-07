package com.hospital.entity;

public class Department {
	private Integer id;
	private String name;
	private Integer type;
	private String location;
	private String describe;
	private Integer isdelete;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	public Department(Integer id, String name, Integer type, String location, String describe, Integer isdelete) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.location = location;
		this.describe = describe;
		this.isdelete = isdelete;
	}
	public Department(Integer id) {
		super();
		this.id = id;
	}
	
}
