package com.nc.Bloggify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nc.Bloggify.util.DBUtil;

public class UserData implements IUserData {

	@Override
	public String userInfo(String username) {
		
		String firstName = "";
		String lastName = "";
		String query = "SELECT fname, lname FROM Users WHERE email=?";
		
		Connection connection = DBUtil.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				firstName = rs.getString("fname");
				lastName = rs.getString("lname");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return (new String(firstName + " " + lastName));
	}
	
	public String totalClaps(String username) {
		
		String claps = "";
		String query = "SELECT SUM(claps) FROM Article WHERE email=?";
		
		Connection connection = DBUtil.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				claps = Integer.toString(rs.getInt("SUM(claps)"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return (claps);
	}
}
