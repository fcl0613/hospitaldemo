package com.hospital.service.manage;

import java.util.List;

import com.hospital.entity.User;


public interface UserService {
	public List<User> selectaUser(String keyword,int page,int count);
	public int[] pageAndTotal(int count, String keyword);
	public int updateUser(User user);
	public int resetPassword(int id);
}
