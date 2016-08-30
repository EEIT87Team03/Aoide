package com.aoide.global.dataBaseManipulationObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionBean {
	// Fields
	
	// JDBC infroms
	static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=AOIDE";
	static String userid = "sa";
	static String passwd = "P@ssw0rd";
	
	// JNDI infroms
	/*
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AOIDE");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	*/
	
	// Methods
	public static Connection getConnection(){
		Connection conn = null;		
		try {
			conn = getJdbcConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	public static Connection getJdbcConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		return DriverManager.getConnection(url, userid, passwd);
	}
	
	/*
	public static Connection getJndiConnection() throws ClassNotFoundException, SQLException{
		return ds.getConnection();
	}
	*/
}
