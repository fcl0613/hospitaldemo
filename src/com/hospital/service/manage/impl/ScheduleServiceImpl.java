package com.hospital.service.manage.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dao.JDBCTools;
import com.hospital.service.manage.ScheduleService;
import com.hospital.view.RequestView;

public class ScheduleServiceImpl implements ScheduleService{

	@Override
	public List<RequestView> selectaUser(int page, int count) {
		String sql = "SELECT request.id,doctor.dname,request.`week`,request.time,"
				+ "request.subtime,request.reason,request.state FROM doctor,request WHERE "
				+ "doctor.did=request.did ORDER BY request.id DESC LIMIT ?,?";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<RequestView> list = new ArrayList<RequestView>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (page-1)*count);
			preparedStatement.setInt(2, count);
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
	public int[] pageAndTotal(int count) {
		int arr[] = new int[2];
		String sql = "";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			
			sql = "SELECT COUNT(*) FROM request";
			preparedStatement = connection.prepareStatement(sql);
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
	public int agreeReq(int id) {
		String sql = "UPDATE request SET state=1 WHERE id=?";
		Object[] o = {id};
		return JDBCTools.exectuIUD(sql, o);
	}

	@Override
	public int disagreeReq(int id) {
		String sql = "UPDATE request SET state=2 WHERE id=?";
		Object[] o = {id};
		return JDBCTools.exectuIUD(sql, o);
	}

}
