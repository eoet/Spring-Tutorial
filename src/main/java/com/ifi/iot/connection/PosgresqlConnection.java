package com.ifi.iot.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class PosgresqlConnection extends AbstractConnection{
	private static String DB_URL = "jdbc:postgresql://localhost:5432/iot";
    private static String USER_NAME = "postgres";
    private static String PASSWORD = "123456";
    
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
