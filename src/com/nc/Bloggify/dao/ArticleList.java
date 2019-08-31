package com.nc.Bloggify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nc.Bloggify.dto.User;
import com.nc.Bloggify.util.DBUtil;

public class ArticleList implements IArticleList {

	@Override
	public List<User> getArticleTitle() {
		
		List<User> articleTitles = new ArrayList<User>();
		String query = "SELECT Title FROM Article";
		int count = 1;
		
		Connection connection = DBUtil.getConnection();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				User current = new User();
				current.setTitle(rs.getString("Title"));
				articleTitles.add(current);
				count++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return articleTitles;
	}
	
	@Override
	public List<User> getArticleTitle1(String username) {
			
			List<User> articleTitles = new ArrayList<User>();
			String query = "SELECT Title FROM Article WHERE email=?";
			int count = 1;
			
			Connection connection = DBUtil.getConnection();
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					User current = new User();
					current.setTitle(rs.getString("Title"));
					articleTitles.add(current);
					count++;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return articleTitles;
		}
}
