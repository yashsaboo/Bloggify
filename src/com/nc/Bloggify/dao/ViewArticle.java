package com.nc.Bloggify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nc.Bloggify.dto.User;
import com.nc.Bloggify.util.DBUtil;

public class ViewArticle implements IViewArticle {

	/* (non-Javadoc)
	 * @see com.nc.Bloggify.dao.IViewArticle#viewArticle(java.lang.String)
	 */
	@Override
	public User viewArticle(String title) {
		
		User user = new User();
		
		String query1 = "SELECT * FROM Article WHERE title=?";
		String query2 = "SELECT * FROM Users WHERE email=?";
		
		Connection connection = DBUtil.getConnection();
		
		try {
			PreparedStatement ps1 = connection.prepareStatement(query1);
			ps1.setString(1, title);
			
			ResultSet rs1 = ps1.executeQuery();
			
			if (rs1.next()) {
				user.setTitle(rs1.getString("title"));
				user.setData(rs1.getString("adata"));
				user.setEmail(rs1.getString("email"));
			}
			
			PreparedStatement ps2 = connection.prepareStatement(query2);
			ps2.setString(1, user.getEmail());
			
			ResultSet rs2 = ps2.executeQuery();
			
			if (rs2.next()) {
				user.setFirstName("fname");
				user.setLastName("lname");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}
}
