package com.aoide.global.dataBaseManipulationObjects;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;
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
	
	//private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url;
	private static String account;
	private static String password ;
	private static String lookUpName;			//java:comp/env/jdbc/AOIDE
	private static DataSource ds;
	private static Properties props;
	
	
	public static Connection getConnection() 
	{
		Connection conn = null;		
		Throwable exceptions = new Throwable();
		
		try
		{
			conn = getJndiConnection();
			
		} 
		catch ( Exception e) 
		{
			exceptions.addSuppressed( e );
			try
			{
				conn = getJdbcConnection();
			}
			catch( Exception ex )
			{
				exceptions.addSuppressed( ex );
			}
			
			for ( Throwable t : exceptions.getSuppressed() )
			{
				t.printStackTrace();
			}
		}
		
		return conn;
	}
	
	
	public static Connection getJdbcConnection() 
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException
	{
		props = new Properties();
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		props.load( classLoader.getResourceAsStream( "com/aoide/global/dataBaseManipulationObjects/jdbc.properties" ) );
		
		Class.forName( props.getProperty( "driverName" ) );
		url = props.getProperty( "connUrl" );
		account = props.getProperty( "dbAccount" );
		password = props.getProperty( "dbPassword" );
		return DriverManager.getConnection( url, account, password );
	}
	
	public static Connection getJndiConnection() throws ClassNotFoundException, SQLException, NamingException
	{
		Context ctx = new InitialContext();
		ds = ( DataSource ) ctx.lookup( lookUpName );	
		
		return ds.getConnection();
	}
	
	public static void setJndiLookUpName( String name )
	{
		lookUpName = name;
	}
}
