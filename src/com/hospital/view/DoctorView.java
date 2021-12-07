package com.hospital.view;

import com.hospital.entity.Doctor;

public class DoctorView {
	private Integer id;
	private String account;
	private String name;
	private Integer gender;
	private Integer age;
	private String description;
	private String imagepath;
	private String career;
	private String department;
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
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public DoctorView(Doctor doctor) {
		this.id = doctor.getId();
		this.account = doctor.getAccount();
		this.name = doctor.getName();
		this.gender = doctor.getGender();
		this.age = doctor.getAge();
		this.department = doctor.getDepartment().getName();
		this.description = doctor.getDescription();
		this.imagepath = doctor.getImagepath();
		this.career = doctor.getCareer().getCname();
	}
	public DoctorView(Integer id, String account, String name, Integer gender, Integer age, String description,
			String imagepath, String career, String department) {
		super();
		this.id = id;
		this.account = account;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.description = description;
		this.imagepath = imagepath;
		this.career = career;
		this.department = department;
	}
	
	
	
}
