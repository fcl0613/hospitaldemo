package com.hospital.service.manage.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dao.JDBCTools;
import com.hospital.entity.User;
import com.hospital.service.manage.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public List<User> selectaUser(String keyword, int page, int count) {
		List<User> list = new ArrayList<User>();
		String sql = "";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			if (keyword == null || "".equals(keyword)) {
				sql = "SELECT user.id,user.account,user.tel,user.name,user.idcard,user.regtime" + 
						" FROM user ORDER BY user.id ASC LIMIT ?,?;";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, (page-1)*count);
				preparedStatement.setInt(2, count);
			}else {
				sql = "SELECT user.id,user.account,user.tel,user.name,user.idcard,user.regtime" + 
						" FROM user WHERE account LIKE ? ORDER BY user.id ASC LIMIT ?,?;";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, "%"+keyword+"%");
				preparedStatement.setInt(2, (page-1)*count);
				preparedStatement.setInt(3, count);
			}
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				list.add(new User(resultSet.getInt("id"),
						resultSet.getString("account"),
						null,
						resultSet.getString("tel"),
						resultSet.getString("name"),
						resultSet.getString("idcard"),
						resultSet.getString("regtime")));
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
				sql = "SELECT COUNT(*) FROM user";
				preparedStatement = connection.prepareStatement(sql);
			}else {
				sql = "SELECT COUNT(*) FROM user WHERE account LIKE ?";
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
	public int updateUser(User user) {
		String sql = "UPDATE user SET tel=?,name=?,idcard=? WHERE id=?";
		Object[] o = {user.getTel(),user.getName(),user.getIdcard(),user.getId()};
		return JDBCTools.exectuIUD(sql, o);
	}

	@Override
	public int resetPassword(int id) {
		String sql = "UPDATE user SET password=123456 WHERE id=?";
		Object[] o = {id};
		return JDBCTools.exectuIUD(sql, o);
	}
	
}
