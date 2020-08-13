package com.ifi.iot.connection;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractConnection {
	public abstract Connection getConnection();

	public void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
