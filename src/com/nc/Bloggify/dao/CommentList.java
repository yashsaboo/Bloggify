package com.nc.Bloggify.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nc.Bloggify.dto.User;
import com.nc.Bloggify.util.DBUtil;

public class CommentList {

	public List<User> getCommentList(){
		
		List<User> comments = new ArrayList<User>();
		
		Connection con = null;
		
		try{
		
	    con = DBUtil.getConnection(); //establishing connection
			
	    Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery("SELECT cdata from comments");
	    
	    while(rs.next()){
	    	User c = new User();
	    	c.setCommentdata(rs.getString("cdata"));
	    	comments.add(c);
	    }
		
		}catch(SQLException e){
			e.printStackTrace();
			}
		return comments;
	}
}

