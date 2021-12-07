package com.hospital.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hospital.dao.JDBCTools;
import com.hospital.entity.Admin;
import com.hospital.service.LoginService;

public class LoginServiceImpl implements LoginService{

	@Override
	public Admin adminLogin(Admin admin) {
		String sql = "SELECT * FROM admin WHERE account=? AND password=?";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Admin a = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, admin.getAccount());
			preparedStatement.setString(2, admin.getPassword());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				a = new Admin(resultSet.getString("account"),resultSet.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(resultSet, preparedStatement, connection);
		}
		return a;
	}

	@Override
	public int AdminchangePwd(Admin admin) {
		String sql = "UPDATE admin SET password=? WHERE account=?";
		Object[] o = {admin.getPassword(),admin.getAccount()};
		return JDBCTools.exectuIUD(sql, o);
	}

}
