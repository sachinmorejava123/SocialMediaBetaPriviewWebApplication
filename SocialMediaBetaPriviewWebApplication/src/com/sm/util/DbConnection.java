package com.sm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection=null;
		//Loading mysql driver class
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/polyglots_web_app","root","root");
		
		return connection;
		
	}

}
