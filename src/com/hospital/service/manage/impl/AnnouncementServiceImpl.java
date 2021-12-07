package com.hospital.service.manage.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dao.JDBCTools;
import com.hospital.entity.Announcement;
import com.hospital.service.manage.AnnouncementService;

public class AnnouncementServiceImpl implements AnnouncementService{

	@Override
	public List<Announcement> selectaAnnouncement(String keyword, int page, int count) {
		List<Announcement> list = new ArrayList<Announcement>();
		String sql = "";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			if (keyword == null || "".equals(keyword)) {
				sql = "SELECT announcement.id,announcement.title,announcement.author,"
						+ "announcement.releasedate,announcement.isdel" + 
						" FROM announcement ORDER BY announcement.id ASC LIMIT ?,?;";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, (page-1)*count);
				preparedStatement.setInt(2, count);
			}else {
				sql = "SELECT announcement.id,announcement.title,announcement.author,"
						+ "announcement.releasedate,announcement.isdel" + 
						" FROM announcement WHERE title LIKE ? ORDER BY announcement.id ASC LIMIT ?,?;";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, "%"+keyword+"%");
				preparedStatement.setInt(2, (page-1)*count);
				preparedStatement.setInt(3, count);
			}
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				list.add(new Announcement(resultSet.getInt("id"),
						resultSet.getString("title"),
						null,
						resultSet.getString("author"),
						resultSet.getString("releasedate"),
						resultSet.getInt("isdel")));
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
				sql = "SELECT COUNT(*) FROM announcement";
				preparedStatement = connection.prepareStatement(sql);
			}else {
				sql = "SELECT COUNT(*) FROM announcement WHERE title LIKE ?";
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
	public String getDescById(int id) {
		String sql = "SELECT description FROM announcement WHERE id=?";
		Connection connection = JDBCTools.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String desc = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				desc = resultSet.getString("description");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTools.release(resultSet, preparedStatement, connection);
		}
		return desc;
	}

	@Override
	public int updateAnnouncement(Announcement announcement) {
		String sql = "UPDATE announcement SET title=?,description=? WHERE id=?";
		Object[] o = {announcement.getTitle(),announcement.getDescription(),announcement.getId()};
 		return JDBCTools.exectuIUD(sql, o);
	}

	@Override
	public int shelvesAnnouncement(int id) {
		String sql = "UPDATE announcement SET isdel=1 WHERE id=?";
		Object[] o = {id};
		return JDBCTools.exectuIUD(sql, o);
	}

	@Override
	public int releaseAnnouncement(int id) {
		String sql = "UPDATE announcement SET isdel=0 WHERE id=?";
		Object[] o = {id};
		return JDBCTools.exectuIUD(sql, o);
	}

	@Override
	public int addAnnouncement(Announcement announcement) {
		String sql = "INSERT INTO announcement(title,description,author,releasedate) VALUES (?,?,?,?)";
		Object[] o = {announcement.getTitle(),announcement.getDescription(),announcement.getAuthor(),announcement.getReleasedate()};
		return JDBCTools.exectuIUD(sql, o);
	}
	
}
