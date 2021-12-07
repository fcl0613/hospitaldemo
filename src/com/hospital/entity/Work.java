package com.hospital.entity;

public class Work {
	private Integer id;
	private Doctor doctor;
	private Integer week;
	private Integer time;
	private Integer number;
	private Integer state;
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Work(Integer id, Doctor doctor, Integer week, Integer time, Integer number, Integer state) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.week = week;
		this.time = time;
		this.number = number;
		this.state = state;
	}
	
	
}
