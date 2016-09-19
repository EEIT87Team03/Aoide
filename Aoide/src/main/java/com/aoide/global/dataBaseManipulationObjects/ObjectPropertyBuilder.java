package com.aoide.global.dataBaseManipulationObjects;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.websocket.track.TrackVO;

public class ObjectPropertyBuilder 
{
	public static String buildProperty( String parm )
	{
		return buildProperty( parm, true );
	}
	
	public static String buildProperty( String parm, boolean capitalize )
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
		
		if( !capitalize )
		{
			sb.setCharAt( 0, Character.toLowerCase( sb.charAt( 0 ) ) );
		}
		
		return sb.toString();
	}
	
	public static List< String > buildProperties( Class< ? > voClass )
	{
		return buildProperties( voClass, true );
	}
	
	public static List< String > buildProperties( Class< ? > voClass, boolean capitalize )
	{
		List< String > propertyNames= new ArrayList<>();
		
		Field[] fields = voClass.getDeclaredFields();
		for ( Field field : fields )
		{
			String propertyName = buildProperty( field.getName() );
			
			boolean getterExists = methodExists( voClass, "get" + propertyName );
			boolean setterExists = methodExists( voClass, "set" + propertyName, field.getType() );
			
			if ( getterExists && setterExists )
			{
				if ( !capitalize )
				{
					StringBuilder sb = new StringBuilder( propertyName );
					sb.setCharAt( 0, Character.toLowerCase( sb.charAt( 0 ) ) );
					propertyName = sb.toString();
				}
				
				propertyNames.add( propertyName );
			}
			
		}
		return propertyNames;
	}

	public static String capitalize( String s )
	{
		StringBuilder sb = new StringBuilder( s );
		sb.setCharAt( 0, Character.toUpperCase( sb.charAt( 0 ) ) );
		
		return sb.toString();
	}
	
	private static boolean methodExists( Class< ? > voClass, String methodName, Class< ? >... parameterTypes )
	{
		try
		{ 
			//System.out.println( methodName );
			Method method = voClass.getMethod( methodName, parameterTypes );
		}
		catch( Exception e )
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) 
	{
		System.out.println( ObjectPropertyBuilder.buildProperties( TrackVO.class, false ) );
	}

}
