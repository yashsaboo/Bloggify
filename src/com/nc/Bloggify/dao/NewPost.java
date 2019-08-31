package com.nc.Bloggify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nc.Bloggify.dto.User;
import com.nc.Bloggify.util.DBUtil;

public class NewPost implements INewPost {

/* (non-Javadoc)
 * @see com.nc.Bloggify.dao.INewPost#newPost(com.nc.Bloggify.dto.User)
 */
@Override
public boolean newPost(User user){
		
		String postdata = user.getData();
		int count = 1;
		
		try
		{
			
		Connection connection = DBUtil.getConnection(); //establishing connection
		
		String query1 = "SELECT MAX(artid) FROM article";
		String query2 = "INSERT INTO article(artid,title,adata,claps,email) VALUES(?,?,?,?,?)";
		
		Statement st = connection.createStatement();
		ResultSet rs1 = st.executeQuery(query1);
		if (rs1.next()) {
			count = rs1.getInt("MAX(artid)") + 1;
		}

	    PreparedStatement ps = connection.prepareStatement(query2);
	    ps.setInt(1, count);
	    ps.setString(2, user.getTitle());
	    ps.setString(3, user.getData());
	    ps.setInt(4, 5);
	    ps.setString(5, user.getEmail());
	    
	    int result = ps.executeUpdate();
	    
	    if (result > 0)
	    	return true;
	    else 
	    	return false;
	    }catch(SQLException e){
			e.printStackTrace();
			}
		
		return false;
	}
}
