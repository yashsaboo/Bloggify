package com.nc.Bloggify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nc.Bloggify.dto.User;
import com.nc.Bloggify.util.DBUtil;

public class SignUpValidate implements ISignUpValidate {

	@Override
	public boolean signUpValidate(User user) {
		
		boolean result = false;
		String query = "INSERT INTO Users VALUES(?, ?, ?, ?)";
		Connection connection = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getPassword());
			
			if (ps.executeUpdate() > 0)
				result = true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
}
