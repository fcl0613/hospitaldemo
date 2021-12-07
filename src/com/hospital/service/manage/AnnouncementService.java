package com.hospital.service.manage;

import java.util.List;

import com.hospital.entity.Announcement;


public interface AnnouncementService {
	public List<Announcement> selectaAnnouncement(String keyword,int page,int count);
	public int[] pageAndTotal(int count, String keyword);
	public String getDescById(int id);
	public int updateAnnouncement(Announcement announcement);
	public int shelvesAnnouncement(int id);
	public int releaseAnnouncement(int id);
	public int addAnnouncement(Announcement announcement);
}
