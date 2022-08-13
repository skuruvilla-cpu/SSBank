package com.ssbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {
	
	public Connection createConnection() {

		Connection con = null;

		String url = "jdbc:mysql://localhost:3306/ssbank";
		String user = "root";
		String pwd = "";

		try {
			// Loading JDBC Driver to work with MySQL database
			Class.forName("com.mysql.jdbc.Driver");
			// Establishing connection to the database
			con = DriverManager.getConnection(url, user, pwd);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;

	}

}
