package com.aoide.global.websocket;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonString;
import javax.json.JsonValue;

import com.aoide.global.dataBaseManipulationObjects.ObjectPropertyBuilder;

public class JsonConverter 
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
			
			if ( result == null )
				builder.addNull( propertyName );
			else
			{
				String type = result.getClass().getName().split( "\\." )[ 2 ];
				
				switch( type )
				{
					case "Integer":
						builder.add( propertyName, ( Integer ) result );
						break;
					case "BigDecimal":
						builder.add( propertyName, ( BigDecimal ) result );
						break;
					case "Double":
						builder.add( propertyName, ( Double ) result );
						break;
					case "Boolean":
						builder.add( propertyName, ( Boolean ) result );
						break;
					default:
						builder.add( propertyName, result.toString() );
				}
			}
		}
		
		
		return builder.build();
	}
	
}
