package com.hospital.service.manage;

import java.util.List;

import com.hospital.entity.Doctor;
import com.hospital.view.DoctorView;

public interface DoctorService {
	public List<DoctorView> selectDoctor(String keyword,int page,int count);
	public List<Doctor> selectaDoctor(String keyword,int page,int count);
	public int[] pageAndTotal(int count, String keyword);
	public int updateDoctor(Doctor doctor);
	public Doctor selectDoctorById(int id);
	public int addDoctor(Doctor doctor);
	public int chickAccount(String account);
	public int delectDoctor(int id);
}
