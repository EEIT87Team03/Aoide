package com.aoide.global.dataBaseManipulationObjects;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

import com.aoide.global.dataBaseManipulationObjects.ObjectPropertyBuilder;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

public class JsonConverter //no support array type
{

	public static JsonObject convertToJsonObject( Object vo ) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		Class< ? extends Object > voClass = vo.getClass();
		
		List< String > properties = ObjectPropertyBuilder.buildProperties( voClass, false );
		
		JsonBuilderFactory factory = Json.createBuilderFactory( null );
		JsonObjectBuilder builder = factory.createObjectBuilder();
		
		for ( String propertyName : properties )
		{
			Method voGetter = voClass.getMethod( "get" + ObjectPropertyBuilder.capitalize( propertyName ) );
			Object result = voGetter.invoke( vo );
			
			builderHelper( builder, propertyName, result );
		}
		
		
		return builder.build();
	}
	
	private static void builderHelper( JsonObjectBuilder builder, String name, Object value ) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		if ( value == null )
			builder.addNull( name );
		else if ( value.getClass().isArray() || ( value instanceof Iterable ) )
		{
			builder.add( name, convertToJsonArray( value) );
		}
		else if ( value instanceof ValueObject )
		{
			builder.add( name, convertToJsonObject( value ) );
		}
		else
		{
			String type = value.getClass().getName().split( "\\." )[ 2 ];
			
			switch( type )
			{
				case "Integer":
					builder.add( name, ( Integer ) value );
					return;
				case "BigDecimal":
					builder.add( name, ( BigDecimal ) value );
					return;
				case "BigInteger":
					builder.add( name, ( BigInteger ) value );
					return;
				case "Double":
					builder.add( name, ( Double ) value );
					return;
				case "Boolean":
					builder.add( name, ( Boolean ) value );
					return;
				default:
					builder.add( name, value.toString() );
			}
		}
	}
	
	public static JsonArray convertToJsonArray( Object vo ) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		Iterator< Object > iterator = null;
		
		if ( ( vo.getClass().isArray() ) )
		{
			List< Object > temp = Arrays.asList( ( Object[] ) vo );
			iterator = temp.iterator();
		}
		else if ( vo instanceof Iterable )
		{
			iterator = ( ( Iterable< Object > ) vo ).iterator();
		}
		
		while ( iterator.hasNext() )
		{
			arrayBuilderHelper( arrayBuilder, iterator.next() );
		}
		
		
		return arrayBuilder.build();
	}
	
	private static void arrayBuilderHelper( JsonArrayBuilder arrayBuilder, Object value ) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		if ( value == null )
			arrayBuilder.addNull();
		else if ( value.getClass().isArray() || ( value instanceof Iterable ) )
		{
			arrayBuilder.add( convertToJsonArray( value) );
		}
		else if ( value instanceof ValueObject )
		{
			arrayBuilder.add( convertToJsonObject( value ) );
		}
		else
		{
			String type = value.getClass().getName().split( "\\." )[ 2 ];
			
			switch( type )
			{
				case "Integer":
					arrayBuilder.add( ( Integer ) value );
					return;
				case "BigDecimal":
					arrayBuilder.add( ( BigDecimal ) value );
					return;
				case "BigInteger":
					arrayBuilder.add( ( BigInteger ) value );
					return;
				case "Double":
					arrayBuilder.add( ( Double ) value );
					return;
				case "Boolean":
					arrayBuilder.add( ( Boolean ) value );
					return;
				default:
					arrayBuilder.add( value.toString() );
			}
		}
	}
	
	public static void main( String[] args ) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		MemberVO m = new MemberVO();
		
		m.setAccount( "AAAsmallBirdBeauty" );
		m.setPassword( "28825252" );
		m.setName( "小鳥美麗" );
		m.setEmail( "fattyCutty@outlook.com" );
		m.setRegisterState( 0 );
		m.setLoginCount( 50 );
		m.setLastLoginDate( Timestamp.valueOf( "2016-08-20 20:37:31.940" ) );
		m.setTokenTotal( new BigDecimal( 350 ) );
		m.setPicture( null );
		m.setIntroductionFilePath( "C:/introduction/file" );
		m.setClassType( 0 );
		m.setBanState( true );
		m.setBankInfo( "first bank" );
		
		JsonWriter jw = Json.createWriter( System.out );
		
//		System.out.println( JsonConverter.convertToJsonObject( m ) );
//		jw.writeObject( JsonConverter.convertToJsonObject( m ) );
		
		MemberVO[] a = { m, m };
		
		List< MemberVO > b = new ArrayList<>();
		b.add( m );
		b.add( m );
		
		System.out.println( JsonConverter.convertToJsonArray( a ) );
		jw.writeArray( JsonConverter.convertToJsonArray( b ) );
	}
}
