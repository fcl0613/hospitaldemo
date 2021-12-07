package com.hospital.service.manage;

import java.util.List;

import com.hospital.view.RequestView;


public interface ScheduleService {
	public List<RequestView> selectaUser(int page,int count);
	public int[] pageAndTotal(int count);
	public int agreeReq(int id);
	public int disagreeReq(int id);
}
