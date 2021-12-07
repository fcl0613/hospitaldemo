package com.hospital.service.manage.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dao.JDBCTools;
import com.hospital.entity.Doctor;
import com.hospital.entity.Work;
import com.hospital.service.manage.WorkService;

public class WorkServiceImpl implements WorkService{

	@Override
	public List<Work> selectaRoaster(String keyword, int page, int count) {
		List<Work> list = new ArrayList<Work>();
		String sql = "";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			if (keyword == null || "".equals(keyword)) {
				sql = "SELECT `work`.id,doctor.did,doctor.dname,`work`.`week`,`work`.time,`work`.number,"
						+ "`work`.state FROM `work` RIGHT JOIN doctor ON "
						+ "`work`.did=doctor.did "
						+ "ORDER BY doctor.did LIMIT ?,?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, (page-1)*count);
				preparedStatement.setInt(2, count);
			}else {
				sql = "SELECT `work`.id,doctor.did,doctor.dname,`work`.`week`,`work`.time,`work`.number,"
						+ "`work`.state FROM `work` RIGHT JOIN doctor ON "
						+ "`work`.did=doctor.did WHERE dname LIKE ? "
						+ "ORDER BY doctor.did LIMIT ?,?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, "%"+keyword+"%");
				preparedStatement.setInt(2, (page-1)*count);
				preparedStatement.setInt(3, count);
			}
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				list.add(new Work(
						resultSet.getInt("id"),
						new Doctor(resultSet.getInt("did"),resultSet.getString("dname")),
						resultSet.getInt("week"),
						resultSet.getInt("time"),
						resultSet.getInt("number"),
						resultSet.getInt("state")
						));
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
	public int[] pageAndTotal(int count, String keyword) {
		int arr[] = new int[2];
		String sql = "";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			if (keyword == null || "".equals(keyword)) {
				sql = "SELECT COUNT(*) FROM `work` RIGHT JOIN doctor ON `work`.did=doctor.did";
				preparedStatement = connection.prepareStatement(sql);
			}else {
				sql = "SELECT COUNT(*) FROM `work` RIGHT JOIN doctor ON `work`.did=doctor.did WHERE dname LIKE ?";
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
	public int addRoaster(Work work) {
		String sql = "INSERT INTO work SET did=?,week=?,time=?,number=?,state=1";
		Object[] o = {
				work.getDoctor().getId(),
				work.getWeek(),
				work.getTime(),
				work.getNumber()
		};
		return JDBCTools.exectuIUD(sql, o);
	}

	@Override
	public Work selectRoasterByDoctorid(int id) {
		String sql = "SELECT `work`.did,doctor.dname,`work`.`week`,`work`.time,"
				+ "`work`.number,`work`.state FROM `work`,doctor "
				+ "WHERE `work`.did=doctor.did AND `work`.did=?";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Work work = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				work = new Work(null,
						new Doctor(resultSet.getInt("did"), resultSet.getString("dname")),
						resultSet.getInt("week"),
						resultSet.getInt("time"),
						resultSet.getInt("number"),
						resultSet.getInt("state"));
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
	public int updateRoaster(Work work) {
		String sql = "UPDATE work SET week=?,time=?,number=?,state=? WHERE did=?";
		Object[] o = {work.getWeek(),work.getTime(),work.getNumber(),work.getState(),work.getDoctor().getId()};
		return JDBCTools.exectuIUD(sql, o);
	}

	@Override
	public int deleteRoaster(int id) {
		String sql = "DELETE FROM work WHERE id=?";
		Object[] o = {id};
		return JDBCTools.exectuIUD(sql, o);
	}
	
}
