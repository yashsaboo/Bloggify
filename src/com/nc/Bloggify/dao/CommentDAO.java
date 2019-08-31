package com.nc.Bloggify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nc.Bloggify.dto.User;
import com.nc.Bloggify.util.DBUtil;

public class CommentDAO {

	public void addComment(User commentbean){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try
		{
			
		con = DBUtil.getConnection(); //establishing connection
		
		//entering data into database
		String sql = "INSERT INTO comments VALUES(?,?,?,?)";
		String query = "SELECT MAX(cid) FROM comments";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {
			count = rs.getInt("MAX(cid)") + 1;
		}
		
		pstmt = con.prepareStatement(sql);
	    pstmt.setInt(1, count);
	    pstmt.setInt(2, 101);
	    pstmt.setString(3, commentbean.getEmail());
	    pstmt.setString(4, commentbean.getCommentdata());
	    
	    if (pstmt.executeUpdate() > 0)
	    	System.out.println("Data inserted");
	    else
	    	System.out.println("Data not inserted");
	    
		}catch(SQLException e){
			e.printStackTrace();
			}
		
	}
}
