package com.hospital.service.manage.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.hospital.dao.JDBCTools;
import com.hospital.entity.Career;
import com.hospital.entity.Department;
import com.hospital.entity.Doctor;
import com.hospital.service.manage.DoctorService;
import com.hospital.view.DoctorView;

public class DoctorServiceImpl implements DoctorService{

	@Override
	public List<DoctorView> selectDoctor(String keyword, int page, int count) {
		List<DoctorView> list = new ArrayList<DoctorView>();
		String sql = "";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			if (keyword == null || "".equals(keyword)) {
				sql = "SELECT doctor.did,doctor.account,doctor.dname,doctor.gender,doctor.fee,doctor.age,doctor.description,doctor.imagepath," + 
						"career.cname,department.name,doctor.register FROM doctor,department,career WHERE doctor.career = career.cid AND " + 
						"doctor.department=department.id AND doctor.isdel=0 ORDER BY doctor.did ASC LIMIT ?,?;";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, (page-1)*count);
				preparedStatement.setInt(2, count);
			}else {
				sql = "SELECT doctor.did,doctor.account,doctor.dname,doctor.gender,doctor.fee,doctor.age,doctor.description,doctor.imagepath," + 
						"career.cname,department.name,doctor.register FROM doctor,department,career WHERE doctor.career = career.cid AND " + 
						"doctor.department=department.id AND doctor.isdel=0 AND doctor.dname LIKE ? ORDER BY doctor.did ASC LIMIT ?,?;";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, "%"+keyword+"%");
				preparedStatement.setInt(2, (page-1)*count);
				preparedStatement.setInt(3, count);
			}
			resultSet = preparedStatement.executeQuery();
//			while(resultSet.next()) {
//				list.add(new DoctorView(resultSet.getInt("did"),
//						resultSet.getString("account"),
//						resultSet.getString("dname"),
//						resultSet.getInt("gender"),
//						resultSet.getDouble("fee"),
//						resultSet.getInt("age"),
//						resultSet.getString("description"),
//						resultSet.getString("imagepath"),
//						resultSet.getString("cname"),
//						resultSet.getString("name"),
//						resultSet.getInt("register")));
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(resultSet, preparedStatement, connection);
		}
		return list;
	}

	@Override
	public int[] pageAndTotal(int count, String keyword) {
		int arr[] = new int[2];
		String sql = "";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			if (keyword == null || "".equals(keyword)) {
				sql = "SELECT COUNT(*) FROM doctor WHERE isdel=0";
				preparedStatement = connection.prepareStatement(sql);
			}else {
				sql = "SELECT COUNT(*) FROM doctor WHERE isdel=0 AND dname LIKE ?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, "%"+keyword+"%");
			}
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				arr[0] = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(resultSet, preparedStatement, connection);
		}
		if (arr[0] % count == 0) {
			arr[1] = arr[0]/count;
		}else {
			arr[1] = arr[0]/count+1;
		}
		return arr;
	}

	@Override
	public int updateDoctor(Doctor doctor) {
		String sql = "UPDATE doctor SET dname=?,gender=?,age=?,fee=?,"
				+ "description=?,imagepath=?,career=?,department=?,register=? WHERE did=?";
		Object[] o = {
				doctor.getName(),
				doctor.getGender(),
				doctor.getAge(),
				doctor.getFee(),
				doctor.getDescription(),
				doctor.getImagepath(),
				doctor.getCareer().getCid(),
				doctor.getDepartment().getId(),
				doctor.getRedister(),
				doctor.getId()
		};
		return JDBCTools.exectuIUD(sql, o);
	}

	@Override
	public List<Doctor> selectaDoctor(String keyword, int page, int count) {
		List<Doctor> list = new ArrayList<Doctor>();
		String sql = "";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			if (keyword == null || "".equals(keyword)) {
				sql = "SELECT doctor.did,doctor.account,doctor.dname,doctor.gender,doctor.fee,doctor.age,doctor.description,doctor.imagepath," + 
						"career.cid,career.cname,department.id,department.name,doctor.register FROM doctor,department,career WHERE doctor.career = career.cid AND " + 
						"doctor.department=department.id AND doctor.isdel=0 ORDER BY doctor.did ASC LIMIT ?,?;";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, (page-1)*count);
				preparedStatement.setInt(2, count);
			}else {
				sql = "SELECT doctor.did,doctor.account,doctor.dname,doctor.gender,doctor.fee,doctor.age,doctor.description,doctor.imagepath," + 
						"career.cid,career.cname,department.id,department.name,doctor.register FROM doctor,department,career WHERE doctor.career = career.cid AND " + 
						"doctor.department=department.id AND doctor.isdel=0 AND doctor.dname LIKE ? ORDER BY doctor.did ASC LIMIT ?,?;";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, "%"+keyword+"%");
				preparedStatement.setInt(2, (page-1)*count);
				preparedStatement.setInt(3, count);
			}
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				list.add(new Doctor(resultSet.getInt("did"),
						resultSet.getString("account"),
						null,
						resultSet.getString("dname"),
						resultSet.getInt("gender"),
						resultSet.getDouble("fee"),
						resultSet.getInt("age"),
						resultSet.getString("description"),
						resultSet.getString("imagepath"),
						new Career(resultSet.getInt("cid"), resultSet.getString("cname")),
						new Department(resultSet.getInt("id"), resultSet.getString("name"), null, null, null, null),
						resultSet.getInt("register"),0));
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
	public Doctor selectDoctorById(int id) {
		String sql = "SELECT did,account,dname,gender,age,fee,description,imagepath,career,department,register FROM doctor WHERE did=?"
				+ " AND isdel=0";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Doctor doctor = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				doctor = new Doctor(resultSet.getInt("did"),
						resultSet.getString("account"),
						null,
						resultSet.getString("dname"),
						resultSet.getInt("gender"),
						resultSet.getDouble("fee"),
						resultSet.getInt("age"),
						resultSet.getString("description"),
						resultSet.getString("imagepath"),
						new Career(resultSet.getInt("career"),null),
						new Department(resultSet.getInt("department"),null,null,null,null,null),
						resultSet.getInt("register"),
						null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(resultSet, preparedStatement, connection);
		}
		return doctor;
	}

	@Override
	public int addDoctor(Doctor doctor) {
		String sql = "INSERT INTO doctor(account,dname,gender,age,fee,description,imagepath,career,department,register)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?) ";
		Object[] o = {
				doctor.getAccount(),
				doctor.getName(),
				doctor.getGender(),
				doctor.getAge(),
				doctor.getFee(),
				doctor.getDescription(),
				doctor.getImagepath(),
				doctor.getCareer().getCid(),
				doctor.getDepartment().getId(),
				doctor.getRedister()
		};
		return JDBCTools.exectuIUD(sql, o);
	}

	@Override
	public int chickAccount(String account) {
		String sql = "SELECT did FROM doctor WHERE account=? AND isdel=0";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int res = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, account);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				res = resultSet.getInt("did");
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
	public int delectDoctor(int id) {
		String sql = "UPDATE doctor SET isdel=1 WHERE did=?";
		Object[] o = {id};
		return JDBCTools.exectuIUD(sql, o);
	}

}
