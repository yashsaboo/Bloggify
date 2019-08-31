package com.nc.Bloggify.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection connection;
	
	private DBUtil() {}
	
	public static Connection getConnection() {	
		try {
			if (connection == null || connection.isClosed()) {
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				String url = "jdbc:oracle:thin:@localhost:1521:XE";
				String username = "SYSTEM";
				String password = "appledore";
				
				connection = DriverManager.getConnection(url, username, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
