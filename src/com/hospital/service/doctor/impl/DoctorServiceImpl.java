package com.hospital.service.doctor.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dao.JDBCTools;
import com.hospital.entity.Doctor;
import com.hospital.entity.Work;
import com.hospital.service.doctor.DoctorService;
import com.hospital.view.DoctorView;
import com.hospital.view.RequestView;

public class DoctorServiceImpl implements DoctorService{

	@Override
	public Work selectSchedule(int did) {
		String sql = "SELECT `work`.`week`,`work`.time FROM `work` WHERE did=?";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Work work = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, did);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				work = new Work(null, null, resultSet.getInt("week"), resultSet.getInt("time"), null, null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(resultSet, preparedStatement, connection);
		}
		return work;
	}

	@Override
	public Doctor login(String account, String password) {
		String sql = "SELECT did,account,password,dname FROM doctor WHERE account=? AND password=? AND isdel=0";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Doctor doctor = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, account);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				doctor = new Doctor(resultSet.getInt("did"), resultSet.getString("account"),
						resultSet.getString("password"), resultSet.getString("dname"));
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
	public int requestDay(int did, int week, int time, String reason, String subtime) {
		String sql = "INSERT INTO request SET did=?,week=?,time=?,reason=?,subtime=?";
		Object[] o = {did,week,time,reason,subtime};
		return JDBCTools.exectuIUD(sql, o);
	}

	@Override
	public List<RequestView> selectRequest(int did) {
		String sql = "SELECT request.id,doctor.dname,request.`week`,request.time,"
				+ "request.reason,request.state,request.subtime FROM request,doctor WHERE doctor.did=request.did "
				+ "AND request.did=?";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<RequestView> list = new ArrayList<RequestView>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, did);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				list.add(new RequestView(resultSet.getInt("id"),
						resultSet.getString("dname"),
						resultSet.getInt("week"),
						resultSet.getInt("time"),
						resultSet.getString("reason"), 
						resultSet.getInt("state"),
						resultSet.getString("subtime")));
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
	public DoctorView selectgrxx(int id) {
		String sql = "SELECT doctor.account,doctor.dname,doctor.gender,doctor.age,"
				+ "doctor.description,doctor.imagepath,career.cname,department.`name` "
				+ "FROM doctor,career,department WHERE doctor.career=career.cid AND "
				+ "doctor.department=department.id AND doctor.did=?";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DoctorView doctorView = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				doctorView = new DoctorView(null, 
						resultSet.getString("account"),
						resultSet.getString("dname"),
						resultSet.getInt("gender"),
						resultSet.getInt("age"),
						resultSet.getString("description"),
						resultSet.getString("imagepath"),
						resultSet.getString("cname"),
						resultSet.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(resultSet, preparedStatement, connection);
		}
		return doctorView;
	}

	@Override
	public int updateGrxx(Doctor doctor) {
		String sql = "UPDATE doctor SET dname=?,gender=?,age=?,description=?,imagepath=? WHERE did=?";
		Object[] o = {doctor.getName(),doctor.getGender(),doctor.getAge(),doctor.getDescription(),
				doctor.getImagepath(),doctor.getId()};
		return JDBCTools.exectuIUD(sql, o);
	}

	@Override
	public int changePwd(int id, String password) {
		String sql = "UPDATE doctor SET password=? WHERE did=?";
		Object[] o = {password,id};
		return JDBCTools.exectuIUD(sql, o);
	}
	
}
