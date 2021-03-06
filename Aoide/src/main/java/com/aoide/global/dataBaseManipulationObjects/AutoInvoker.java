package com.aoide.global.dataBaseManipulationObjects;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*	
 *  [column _name] => vo.getColumnName() => pstmt.setObject()
 */
public class AutoInvoker 
{
	public static String COLUMN_PATTERN = "\\[\\w+\\]";
	
	public static PreparedStatement invoke( Connection conn, String sql, Object vo) 
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException
	{
		Class< ? extends Object > voClass = vo.getClass();
		PreparedStatement pstmt = conn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
		
		ParameterMetaData sqlMetaData = pstmt.getParameterMetaData();
		List< String > propertyNames = analyze( sql );
		
		int parmCount = sqlMetaData.getParameterCount();
		System.out.println( "parmCount = " + parmCount );
		
		if ( ( propertyNames != null ) && ( propertyNames.size() == parmCount ) )
		{
			int propertyCount = propertyNames.size();
			System.out.println( "propertyCount = " + propertyCount );
			
			for( int i = 0; i < propertyCount; i++ )
			{	System.out.println("get" + propertyNames.get( i ));
				Method voGetter = voClass.getMethod( "get" + propertyNames.get( i ) );
				System.out.println( "vo." + voGetter.getName() + "() = " + voGetter.invoke( vo ) );
				
				if( ( voGetter.getReturnType() == byte[].class ) && ( voGetter.invoke( vo ) != null ) )
				{
					pstmt.setBinaryStream( i + 1, new ByteArrayInputStream( ( byte[] ) voGetter.invoke( vo ) ) );
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
			else if ( s.equals( "?" ) )
			{
				String top = stack.element();		//top = stack.peek()
				
				if ( top.equals( "=") )
				{
					stack.pop();
					if ( stack.element().matches( COLUMN_PATTERN ) )
					{
						String  last = stack.pop();
						propertyNames.add( ObjectPropertyBuilder.buildProperty( last.substring( 1, last.length() - 1 ).trim() ) );
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
				propertyNames.add( ObjectPropertyBuilder.buildProperty( last.substring( 1, last.length() - 1 ).trim() ) );
				unMatchedQuestionMark--;
			}
		}
		
//		System.out.println( "unMatchedQuestionMark = " + unMatchedQuestionMark );
			
		return propertyNames;
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
	
/*	
 *  rs.getObject( [column _name] ) => vo.setColumnName()
 */
	public static Object inject( ResultSet rs, Object vo ) 
			throws SQLException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		Class< ? extends Object > voClass = vo.getClass();
		
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		/*for ( int i = 1; i <= columnCount; i++ )
		{
			Object param = rs.getObject( i );
			System.out.println( "Property Name = " + ObjectPropertyBuilder.buildProperty( md.getColumnName( i ) )  );
			Method voSetter = voClass.getMethod( "set" + ObjectPropertyBuilder.buildProperty( md.getColumnName( i ) ), param.getClass() );
			
			System.out.println( "setter name = " + voSetter.getName()  );
			voSetter.invoke( vo, param );
		}*/
		Method[] methods = voClass.getMethods();
		Map< String, Class< ? >[] > map = new HashMap<>();
		
		for ( int j = 0; j < methods.length; j++ )
		{
			map.put( methods[ j ].getName(), methods[ j ].getParameterTypes() );
		}
			
		for ( int i = 1; i <= columnCount; i++ )
		{
			String setterName = "set" + ObjectPropertyBuilder.buildProperty( md.getColumnName( i ) ) ;
			Method voSetter = voClass.getMethod( setterName, map.get( setterName ) ); 
			
			voSetter.invoke( vo, rs.getObject( i ) );
			//System.out.println( "vo." + setterName + "( " + rs.getObject( i ) + " )" );
		}
		return vo;
	}
}
