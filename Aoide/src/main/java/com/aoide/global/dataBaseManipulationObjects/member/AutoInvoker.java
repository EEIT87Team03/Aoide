package com.aoide.global.dataBaseManipulationObjects.member;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


/*	
 *  [column _name] => vo.getColumnName()
 */
public class AutoInvoker 
{
	public static String COLUMN_PATTERN = "\\[\\w+\\]";
	
	public static PreparedStatement invoke( Connection conn, String sql, Object vo) 
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException
	{
		Class voClass = vo.getClass();
		PreparedStatement pstmt = conn.prepareStatement( sql );
		
		ParameterMetaData sqlMetaData = pstmt.getParameterMetaData();
		List< String > propertyNames = analyze( sql );
		
		int parmCount = sqlMetaData.getParameterCount();
		int propertyCount = propertyNames.size();
		
		System.out.println( "parmCount = " + parmCount );
		System.out.println( "propertyCount = " + propertyCount );
		
		if ( ( propertyNames != null ) && ( propertyCount == parmCount ) )
		{
			for( int i = 0; i < propertyCount; i++ )
			{
				Method voGetter = voClass.getMethod( "get" + propertyNames.get( i ) );
				System.out.println( voGetter.getName() + "\t" + voGetter.invoke( vo ) );
				//System.out.println( voGetter.getReturnType() );
				//System.out.println( voGetter.getReturnType().getName() );
				
				if( voGetter.getReturnType() == byte[].class )
				{
					if( voGetter.invoke( vo ) != null )
					{	
						pstmt.setBytes( i + 1,  ( byte[] ) voGetter.invoke( vo ) );
					}
					else
					{	
						pstmt.setBytes( i + 1, null );
					}
				}
				else
				{
					pstmt.setObject( i + 1, voGetter.invoke( vo ) );
				}
			}
			
		}
		else
		{
			throw new SQLException( "SQL Syntax Error" );
		}
		return pstmt;
	}
	
	public static PreparedStatement invokeByValues( Connection conn, String sql, Object... pks ) throws SQLException 
	{
		PreparedStatement pstmt = conn.prepareStatement( sql );
		
		for ( int i = 0; i < pks.length; i++ )
		{
			pstmt.setObject( i + 1 , pks[ i ] );
		}
		
		return pstmt;
	}
	private static List< String > analyze( String statement )
	{
		int unMatchedQuestionMark = 0;
		String sql = preProcess( statement );
		List< String > propertyNames = new ArrayList<>();
		ArrayDeque< String > stack = new ArrayDeque<>();
		Scanner scanner = new Scanner( sql ).useDelimiter( "[\\s,()]+" );
		
		while( scanner.hasNext() )
		{
			String s = scanner.next();
			
			if ( s.matches( COLUMN_PATTERN ) || s.equals( "=" ) )
			{
				stack.push( s );
			}
			else if( s.equals( "?" ) )
			{
				String top = stack.element();		//top = stack.peek()
				
				if ( top.equals( "=") )
				{
					stack.pop();
					if ( stack.element().matches( COLUMN_PATTERN ) )
					{
						String  last = stack.pop();
						propertyNames.add( buildProperty( last.substring( 1, last.length() - 1 ).trim() ) );
					}
					else
					{
						return null;
					}
				}
				else if ( top.matches( COLUMN_PATTERN ) )
				{
					unMatchedQuestionMark++;
				}
			}
			
		}
		scanner.close();
		
		int length = stack.size();
		if ( length == unMatchedQuestionMark )
		{
			
			for( int i = 0; i < length; i++ )
			{
				String  last = stack.pollLast();
				propertyNames.add( buildProperty( last.substring( 1, last.length() - 1 ).trim() ) );
				unMatchedQuestionMark--;
			}
		}
		
		System.out.println( "unMatchedQuestionMark = " + unMatchedQuestionMark );
		
		if ( unMatchedQuestionMark == 0 )
			return propertyNames;
		
		return null;
	}
	
	private static String buildProperty( String parm )
	{
		StringBuilder sb = new StringBuilder( parm );
		
		if( Character.isLetter( sb.charAt( 0 ) ) )
			sb.setCharAt( 0, Character.toUpperCase( sb.charAt( 0 ) ) );
		
		for( int i = 0; i < sb.length(); i++ )
		{	
			switch( sb.charAt( i ) )
			{
				case '_':
				case '%':
				case '&':
					sb.deleteCharAt( i );
					if( Character.isLetter( sb.charAt( i ) ) )
						sb.setCharAt( i, Character.toUpperCase( sb.charAt( i ) ) );
					break;
				default:
			}
		}
		
		return sb.toString();
	}
	
	private static String preProcess( String sql )
	{
		StringBuilder sb = new StringBuilder( sql );
		
		for ( int i = 0; i < sb.length(); i ++ )
		{
			if ( sb.charAt( i ) == '=' )
			{
				if ( sb.charAt( i - 1) != ' ' )
				{
					sb.insert( i, ' ' );
				}
				else if ( sb.charAt( i + 1) != ' ')
				{
					sb.insert( i + 1, ' ' );
				}
			}
		}
		
		return sb.toString();
	}
	
	public static Object inject( ResultSet rs, Object vo ) 
			throws SQLException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		Class voClass = vo.getClass();
		
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		/*for ( int i = 1; i <= columnCount; i++ )
		{
			Object param = rs.getObject( i );
			System.out.println( "Property Name = " + buildProperty( md.getColumnName( i ) )  );
			Method voSetter = voClass.getMethod( "set" + buildProperty( md.getColumnName( i ) ), param.getClass() );
			
			System.out.println( "setter name = " + voSetter.getName()  );
			voSetter.invoke( vo, param );
		}*/
		Method[] methods = voClass.getMethods();
		Map< String, Class[] > map = new HashMap<>();
		
		for ( int j = 0; j < methods.length; j++ )
		{
			map.put( methods[ j ].getName(), methods[ j ].getParameterTypes() );
		}
		
		for ( Entry<String, Class[] > e : map.entrySet())
		{
			if( e.getValue().length == 1)
				System.out.println( e.getKey() + "\t" + e.getValue()[0].getName() );
		}
		
		for ( int i = 1; i <= columnCount; i++ )
		{
			Method voSetter;
			String setterName = "set" + buildProperty( md.getColumnName( i ) ) ;
			
			voSetter = voClass.getMethod( setterName, map.get( setterName ) ); 
			voSetter.invoke( vo, rs.getObject( i ) );
			System.out.println( "set value : " + rs.getObject( i ) );
		
		}
		return vo;
	}
	
	public static void main( String[] args )
	{
//		final String INSERT_STMT = 
//				"INSERT INTO member "
//				+ "( [account], [password], [name], [email], [picture], [introduction_file_path], [bank_info] ) " 
//				+ "VALUES ( ?, ?, ?, ?, ?, ?, ? )";
//			
//		final String UPDATE_STMT = 
//				"UPDATE member SET "
//				+ "[password] = ?, [name] = ?, [email] = ?, [login_count] = ?, [last_login_date] = ?, "
//				+ "[token_total] = ?, [picture] = ?, [introduction_file_path] = ?, [bank_info] = ? "
//				+ "WHERE [account] = ?";
//			
//		final String DELETE_STMT = 
//				"DELETE FROM member WHERE [account] = ?";
//			
//		final String GET_ONE_STMT = 
//				"SELECT [member_id] ,[account], [password], [name], [email],"
//				+ "[register_state], [login_count], [last_login_date], [token_total],"
//				+ "[picture], [introduction_file_path], [class_type], [ban_state] ,[bank_info] "
//				+ "FROM member WHERE [account] = ?";
//			
//		final String GET_ALL_STMT = 
//				"SELECT [member_id] ,[account], [password], [name], [email],"
//				+ "[register_state], [login_count], [last_login_date], [token_total],"
//				+ "[picture], [introduction_file_path], [class_type], [ban_state] ,[bank_info] "
//				+ "FROM member ORDER BY [member_id]";
//		
//		MemberVO m = new MemberVO();
//		m.setMemberId( 2 );
//		m.setAccount( "CCCQwhiteBirdBeauty" );
//		m.setPassword( "28825252" );
//		m.setName( "白鳥美麗" );
//		m.setEmail( "fattyCutty@outlook.com" );
//		m.setRegisterState( 0 );
//		m.setLoginCount( 50 );
//		m.setLastLoginDate( Timestamp.valueOf( "2016-08-20 20:37:31.940" ) );
//		m.setTokenTotal( 350 );
//		m.setPicture( null );
//		m.setIntroductionFilePath( "C:/introduction/file" );
//		m.setClassType( 0 );
//		m.setBanState( false );
//		m.setBankInfo( "NNNNN bank" );
//		try( Connection conn = DataSourceProxy.getConnection();
//			 PreparedStatement pstmt = AutoInvoker.invoke( conn, UPDATE_STMT, m ) )
//		{
//			
//			pstmt.executeUpdate();
//			
//		}
//		catch( Exception e )
//		{
//			e.printStackTrace();
//		}	
		
	}
}
