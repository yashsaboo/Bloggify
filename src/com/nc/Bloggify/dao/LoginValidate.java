package com.nc.Bloggify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nc.Bloggify.util.DBUtil;

public class LoginValidate {
	
	private static boolean status = false;
	
	
	public static boolean loginValidate(String username, String password) {
		
		
		Connection connection = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT email, password FROM users WHERE email=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
}
