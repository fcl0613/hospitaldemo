package com.hospital.entity;

public class Doctor {
	private Integer id;
	private String account;
	private String password;
	private String name;
	private Integer gender;
	private Double fee;
	private Integer age;
	private String description;
	private String imagepath;
	private Career career;
	private Department department;
	private Integer redister;
	private Integer isdelete;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public Career getCareer() {
		return career;
	}
	public void setCareer(Career career) {
		this.career = career;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Integer getRedister() {
		return redister;
	}
	public void setRedister(Integer redister) {
		this.redister = redister;
	}
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	public Doctor(Integer id, String account, String password, String name, Integer gender, Double fee, Integer age,
			String description, String imagepath, Career career, Department department, Integer redister,
			Integer isdelete) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.fee = fee;
		this.age = age;
		this.description = description;
		this.imagepath = imagepath;
		this.career = career;
		this.department = department;
		this.redister = redister;
		this.isdelete = isdelete;
	}
	public Doctor(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Doctor(Integer id, String account, String password, String name) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.name = name;
	}
	public Doctor(Integer id, String name, Integer gender, Integer age, String description, String imagepath) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.description = description;
		this.imagepath = imagepath;
	}
	
	
}
