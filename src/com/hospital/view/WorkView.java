package com.hospital.view;

import com.hospital.entity.Work;

public class WorkView {
	private Integer id;
	private Integer doctorid;
	private String doctorname;
	private Integer iswork;
	private String week;
	private String time;
	private Integer number;
	private String state;
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIswork() {
		return iswork;
	}
	public void setIswork(Integer iswork) {
		this.iswork = iswork;
	}
	
	public Integer getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(Integer doctorid) {
		this.doctorid = doctorid;
	}
	public WorkView(Work work) {
		this.id = work.getId();
		this.doctorid = work.getDoctor().getId();
		this.doctorname = work.getDoctor().getName();
		this.iswork = work.getWeek();
		switch(work.getWeek()) {
			case 0:
				this.week = "未排班";
				break;
			case 1:
				this.week = "星期一";
				break;
			case 2:
				this.week = "星期二";
				break;
			case 3:
				this.week = "星期三";
				break;
			case 4:
				this.week = "星期四";
				break;
			case 5:
				this.week = "星期五";
				break;
			case 6:
				this.week = "星期六";
				break;
			case 7:
				this.week = "星期日";
				break;
			case 8:
				this.week = "1-5";
				break;
		}
		switch(work.getTime()) {
			case 0:
				this.time = "未排班";
				break;
			case 1:
				this.time = "上午";
				break;
			case 2:
				this.time = "下午";
				break;
			case 3:
				this.time = "全天";
				break;
		}
		this.number = work.getNumber();
		switch(work.getState()) {
		case 0:
			this.state = "停诊";
			break;
		case 1:
			this.state = "可预约";
			break;
		case 2:
			this.state = "预约已满";
			break;
		}
	}
	
	public WorkView(int week, int time) {
		switch(week) {
		case 0:
			this.week = "未排班";
			break;
		case 1:
			this.week = "星期一";
			break;
		case 2:
			this.week = "星期二";
			break;
		case 3:
			this.week = "星期三";
			break;
		case 4:
			this.week = "星期四";
			break;
		case 5:
			this.week = "星期五";
			break;
		case 6:
			this.week = "星期六";
			break;
		case 7:
			this.week = "星期日";
			break;
		case 8:
			this.week = "1-5";
			break;
	}
	switch(time) {
		case 0:
			this.time = "未排班";
			break;
		case 1:
			this.time = "上午";
			break;
		case 2:
			this.time = "下午";
			break;
		case 3:
			this.time = "全天";
			break;
	}
	}
}
