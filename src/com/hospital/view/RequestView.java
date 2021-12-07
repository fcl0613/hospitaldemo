package com.hospital.view;

public class RequestView {
	private Integer id;
	private String dname;
	private String week;
	private String time;
	private String reason;
	private String state;
	private String subtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSubtime() {
		return subtime;
	}
	public void setSubtime(String subtime) {
		this.subtime = subtime;
	}
	public RequestView(Integer id, String dname, int week, int time, String reason, int state,String subtime) {
		super();
		this.id = id;
		this.dname = dname;
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
		this.reason = reason;
		switch(state) {
			case 0:
				this.state = "等待";
				break;
			case 1:
				this.state = "同意";
				break;
			case 2:
				this.state = "拒绝";
				break;
		}
		this.subtime = subtime;
	}
	
	
}
