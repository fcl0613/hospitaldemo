package com.hospital.service.manage.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dao.JDBCTools;
import com.hospital.entity.Department;
import com.hospital.service.manage.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{

	@Override
	public List<Department> selectAll() {
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Department> list = new ArrayList<Department>();
		String sql = "SELECT * FROM department WHERE isdel=0 ORDER BY type ASC";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				list.add(new Department(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getInt("type"),
						resultSet.getString("location"),
						resultSet.getString("des"),
						resultSet.getInt("isdel"))
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(resultSet, preparedStatement, connection);
		}
		return list;
	}

	@Override
	public int selectDepByDepname(String name) {
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int res = 0;
		String sql = "SELECT * FROM department WHERE name=? AND isdel=0";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				res = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(resultSet, preparedStatement, connection);
		}
		
		return res;
	}

	@Override
	public int addDepartment(Department department) {
		String sql = "INSERT INTO department(name,type,location,des,isdel) VALUES(?,?,?,?,?)";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		int res = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, department.getName());
			preparedStatement.setInt(2, department.getType());
			preparedStatement.setString(3, department.getLocation());
			preparedStatement.setString(4, department.getDescribe());
			preparedStatement.setInt(5, department.getIsdelete());
			res = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(null, preparedStatement, connection);
		}
		
//		Object[] o = {
//			department.getName(),
//			department.getType(),
//			department.getLocation(),
//			department.getDescribe(),
//			department.getIsdelete()
//		};
//		System.out.println(o[4].toString());
		return res;
	}

	@Override
	public int updateDepartment(Department department) {
		String sql = "UPDATE department SET location=?,des=? WHERE id=?";
		Object[] o = {
				department.getLocation(),
				department.getDescribe(),
				department.getId()
		};
		return JDBCTools.exectuIUD(sql, o);
	}

	@Override
	public int deleteDepartment(int id) {
		String sql = "UPDATE department SET isdel=1 WHERE id=?";
		Object[] o = {id};
		return JDBCTools.exectuIUD(sql, o);
	}

}
