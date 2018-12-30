package com.demo.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_connectivity {

	Connection conn;
	Statement statument;

	String url = "jdbc:oracle:thin:@javastation:1521:xe";
	String username = "env01";
	String password = "env01";

	public Statement do_db_connection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			statument = conn.createStatement();
			return statument;
		} catch (SQLException e) {
			System.err.println("Hi" +e.getErrorCode() + "\n" +e.getSQLState()+"\n" + e.getMessage());
			return null;			} 
		catch (Exception e) {
			return null;
		}
	}
}
