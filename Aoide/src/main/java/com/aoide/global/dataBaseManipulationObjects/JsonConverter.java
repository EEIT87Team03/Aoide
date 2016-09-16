package com.aoide.global.dataBaseManipulationObjects;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import com.aoide.global.dataBaseManipulationObjects.ObjectPropertyBuilder;

public class JsonConverter //no support array type
{

	public static JsonObject convertToJsonObject( Object vo ) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		Class< ? extends Object > voClass = vo.getClass();
		List< String > properties = ObjectPropertyBuilder.buildProperties( voClass );
		
		JsonBuilderFactory factory = Json.createBuilderFactory( null );
		JsonObjectBuilder builder = factory.createObjectBuilder();
		
		for ( String propertyName : properties )
		{
			Method voGetter = voClass.getMethod( "get" + propertyName );
			Object result = voGetter.invoke( vo );
			
			builderHelper( builder, propertyName, result );
		}
		
		
		return builder.build();
	}
	
	private static void builderHelper( JsonObjectBuilder builder, String name, Object value )
	{
		if ( value == null )
			builder.addNull( name );
		else if ( value.getClass().isArray() )
		{
//			JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
//			Object[] values = ( Object[] ) value;
//			for ( int i = 0; i < values.length; i++ )
//			{
//				builderHelper( arrayBuilder, i + "", values[ i ]  );
//			}
//			builder.add( name, arrayBuilder );
		}
		else
		{
			String type = value.getClass().getName().split( "\\." )[ 2 ];
			
			switch( type )
			{
				case "Integer":
					builder.add( name, ( Integer ) value );
					break;
				case "BigDecimal":
					builder.add( name, ( BigDecimal ) value );
					break;
				case "Double":
					builder.add( name, ( Double ) value );
					break;
				case "Boolean":
					builder.add( name, ( Boolean ) value );
					break;
				default:
					builder.add( name, value.toString() );
			}
		}
	}
	
}
