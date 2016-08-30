package com.aoide.global.dataBaseManipulationObjects.member;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceProxy
{
	
	//static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url;
	private static String account;
	private static String password ;
	private static DataSource ds = null;
	private static Properties props = null;
	
	static 
	{
		try 
		{
//			Context ctx = new InitialContext();
//			ds = ( DataSource ) ctx.lookup("java:comp/env/jdbc/AoideDB");
			
			props = new Properties();
			props.load( new FileInputStream( "src/com/aoide/util/jdbc.properties" ) );
		
			url = props.getProperty( "connUrl" );
			account = props.getProperty( "dbAccount" );
			password = props.getProperty( "dbPassword" );
		} 
		catch ( Exception e ) 
		{
			e.printStackTrace();
		}
	}
	
//	public DataSourceProxy()
//	{
//		 this( "jdbc.properties" );
//	}
//	
//	public DataSourceProxy( String configFile )
//	{
//		try
//		{
//			props = new Properties();
//			props.load( new FileInputStream( configFile ) );
//		
//			url = props.getProperty( "connUrl" );
//			account = props.getProperty( "dbAccount" );
//			password = props.getProperty( "dbPassword" );
//			
//		}
//		catch( IOException e )
//		{
//			e.printStackTrace();
//		}
//	}
	
	public static Connection getConnection()
	{
		Connection conn = null;		
		try {
			conn = getJdbcConnection();
		} catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	public static Connection getJdbcConnection() throws ClassNotFoundException, SQLException
	{
		//Class.forName(driver);
		//System.out.println( url + "\t" + account + "\t" + password );
		return DriverManager.getConnection( url, account, password );
	}
	
	public static Connection getJndiConnection() throws ClassNotFoundException, SQLException
	{
		return ds.getConnection();
	}
}
