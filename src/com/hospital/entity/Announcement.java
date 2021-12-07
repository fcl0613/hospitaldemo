package com.hospital.entity;

public class Announcement {
	private Integer id;
	private String title;
	private String description;
	private String author;
	private String releasedate;
	private Integer isdel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	public Integer getIsdel() {
		return isdel;
	}
	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}
	public Announcement(Integer id, String title, String description, String author, String releasedate,
			Integer isdel) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
		this.releasedate = releasedate;
		this.isdel = isdel;
	}
	
	
}
