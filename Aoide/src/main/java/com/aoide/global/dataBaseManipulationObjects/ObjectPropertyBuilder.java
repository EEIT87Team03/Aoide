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
	
	public static List< String > buildProperties( Class< ? > voClass )
	{
		List< String > propertyNames= new ArrayList<>();
		
		Field[] fields = voClass.getDeclaredFields();
		for ( Field field : fields )
		{
			String propertyName = buildProperty( field.getName() );
			
			boolean isGetterExisting = methodExists( voClass, "get" + propertyName );
			boolean isSetterExisting = methodExists( voClass, "set" + propertyName, field.getType() );
			
			if ( isGetterExisting && isSetterExisting )
			{
				propertyNames.add( propertyName );
			}
			
		}
		return propertyNames;
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
		System.out.println( ObjectPropertyBuilder.buildProperties( TrackVO.class ) );
	}

}
