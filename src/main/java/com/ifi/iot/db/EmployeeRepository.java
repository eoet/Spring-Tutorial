package com.ifi.iot.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ifi.iot.connection.AbstractConnection;
import com.ifi.iot.connection.MysqlConnection;
import com.ifi.iot.connection.PosgresqlConnection;
import com.ifi.iot.entities.Employee;

public class EmployeeRepository {
	private int ID_INDEX = 1;
	private int NAME_INDEX = 2;
	private int AGE_INDEX = 3;
	private AbstractConnection sqlConn;

	public EmployeeRepository() {
		this.sqlConn = new MysqlConnection();
		this.initTable();
	}
	
	public EmployeeRepository(AbstractConnection sqlConn) {
		this.sqlConn = sqlConn;
		if (sqlConn instanceof MysqlConnection) {
			this.initTable();
		} else if(sqlConn instanceof PosgresqlConnection) {
			this.initTablePosgreSQL();
		}
	}

	private void initTable() {
		Connection conn = sqlConn.getConnection();
		if (conn != null) {
			try {
				StringBuilder sb = new StringBuilder();
				sb.append("CREATE TABLE IF NOT EXISTS Employee(");
				sb.append("id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,");
				sb.append("name VARCHAR(50) NOT NULL,");
				sb.append("age INT(2)");
				sb.append(")");
				PreparedStatement stmt = conn.prepareStatement(sb.toString());
				stmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlConn.closeConnection(conn);
			}
		}
	}
	
	private void initTablePosgreSQL() {
		Connection conn = sqlConn.getConnection();
		if (conn != null) {
			try {
				StringBuilder sb = new StringBuilder();
				sb.append("CREATE SEQUENCE IF NOT EXISTS seq_emp;"); 
				sb.append("CREATE TABLE IF NOT EXISTS Employee(");
				sb.append("id integer PRIMARY KEY default nextval('seq_emp'),");
				sb.append("name VARCHAR(50) NOT NULL,");
				sb.append("age integer");
				sb.append(")");
				PreparedStatement stmt = conn.prepareStatement(sb.toString());
				stmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlConn.closeConnection(conn);
			}
		}
	}

	public List<Employee> fetchAll() {
		List<Employee> employees = null;
		Connection conn = sqlConn.getConnection();
		if (conn != null) {
			try {
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee");
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					if (employees == null) {
						employees = new ArrayList<Employee>();
					}
					Employee emp = new Employee();
					emp.setId(rs.getInt(ID_INDEX));
					emp.setName(rs.getString(NAME_INDEX));
					emp.setAge(rs.getInt(AGE_INDEX));

					employees.add(emp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlConn.closeConnection(conn);
			}
		}

		return employees;
	}

	public Employee create(Employee eIn) {
		Connection conn = sqlConn.getConnection();
		Employee employee = null;
		if (conn != null) {
			try {
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO Employee(name, age) VALUES(?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setString(1, eIn.getName());
				stmt.setInt(2, eIn.getAge());
				int affectedRows = stmt.executeUpdate();
				if (affectedRows > 0) {
					ResultSet generatedKeys = stmt.getGeneratedKeys();
					if (generatedKeys.next()) {
						employee = eIn.clone();
						employee.setId(generatedKeys.getInt(1));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlConn.closeConnection(conn);
			}
		}

		return employee;
	}

	public Employee update(Employee eIn) {
		Connection conn = sqlConn.getConnection();
		Employee employee = null;
		if (conn != null) {
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE Employee SET name=?,age=? WHERE id=?");
				stmt.setString(1, eIn.getName());
				stmt.setInt(2, eIn.getAge());
				stmt.setInt(3, eIn.getId());
				int affectedRows = stmt.executeUpdate();
				if (affectedRows > 0) {
					employee = eIn.clone();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlConn.closeConnection(conn);
			}
		}

		return employee;
	}

	public boolean delete(int eInId) {
		Connection conn = sqlConn.getConnection();
		boolean isDeleted = false;
		if (conn != null) {
			try {
				PreparedStatement stmt = conn.prepareStatement("DELETE FROM Employee WHERE id=?");
				stmt.setInt(1, eInId);
				int affectedRows = stmt.executeUpdate();
				if (affectedRows > 0) {
					isDeleted = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlConn.closeConnection(conn);
			}
		}

		return isDeleted;
	}
}
