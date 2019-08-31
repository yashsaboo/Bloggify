package com.nc.Bloggify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nc.Bloggify.dto.User;
import com.nc.Bloggify.util.DBUtil;

public class ArticleDB {
public String dbquery(User user) {

		
		String query;
		
		//ArticleDB arc= new ArticleDB();
		//1 getting connection
		String email=new String();
		//String fn;
		
		try(Connection conn = DBUtil.getConnection();
				Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)){//autoclose
			
			//article.setFirstName(session.getAttribute("uname"));
			
			//arc.getArticle().setFirstName("Neha");
			
			
			
			query = "SELECT email FROM users where fname='Neha'";
			
			PreparedStatement ps = conn.prepareStatement("SELECT email FROM users where fname=?");
			ps.setString(1, user.getFirstName());
			
			//2 form statement
			//3 fire statement
			
			ResultSet rs = st.executeQuery(query);
			//4 process result
			
			
			//while(rs.next())
			//{
				email=rs.getString("email");
			//}
			//rs.next();
			//rs.last(); //make type scrollable
			//rs.moveToCurrentRow();
			//int count = rs.getRow();
			//System.out.println("Number of rows : "+count);
			
			//5 close resources 
			rs.close();
			  /*st.close();
			conn.close();*/
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			/*e.printStackTrace();*/
			System.out.println(e.getMessage());
			if(e.getErrorCode()==942){
				return("Invalid Table Name!!");
			}
		}
		return email;
	}
}
