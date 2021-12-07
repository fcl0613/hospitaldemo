package com.hospital.service.manage;

import java.util.List;

import com.hospital.entity.Department;

public interface DepartmentService {
	public List<Department> selectAll();
	public int selectDepByDepname(String name);
	public int addDepartment(Department department);
	public int updateDepartment(Department department);
	public int deleteDepartment(int id);
}
