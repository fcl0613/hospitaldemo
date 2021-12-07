package com.hospital.service;

import com.hospital.entity.Admin;

public interface LoginService {
	public Admin adminLogin(Admin admin);
	public int AdminchangePwd(Admin admin);
}
