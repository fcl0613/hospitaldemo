package com.hospital.service.manage;

import java.util.List;

import com.hospital.entity.Work;



public interface WorkService {
	public List<Work> selectaRoaster(String keyword,int page,int count);
	public int[] pageAndTotal(int count, String keyword);
	public int addRoaster(Work work);
	public Work selectRoasterByDoctorid(int id);
	public int updateRoaster(Work work);
	public int deleteRoaster(int id);
}
