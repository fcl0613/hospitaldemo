package com.hospital.service.doctor;

import java.util.List;

import com.hospital.entity.Doctor;
import com.hospital.entity.Work;
import com.hospital.view.DoctorView;
import com.hospital.view.RequestView;

public interface DoctorService {
	public Work selectSchedule(int did);
	public Doctor login(String account,String password);
	public int requestDay(int did,int week,int time,String reason,String subtime);
	public List<RequestView> selectRequest(int did);
	public DoctorView selectgrxx(int id);
	public int updateGrxx(Doctor doctor);
	public int changePwd(int id,String password);
}
