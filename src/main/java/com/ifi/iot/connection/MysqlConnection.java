package com.ifi.iot.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection extends AbstractConnection{
	private static String DB_URL = "jdbc:mysql://localhost:3306/iot";
    private static String USER_NAME = "admin";
    private static String PASSWORD = "123456";
    
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
