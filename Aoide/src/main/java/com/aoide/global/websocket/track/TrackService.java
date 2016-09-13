package com.aoide.global.websocket.track;

import java.sql.Connection;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.DataSourceProxy;


public class TrackService 
{
	public TrackService()
	{
		
	}
	
	public int createNewTrack( TrackVO vo )
	{
		int id = 0;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			TrackDAO sdao = new JdbcTrackDAO();
			id = sdao.insert( vo );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return id;
	}
	
	public int updateTrackInfo( TrackVO vo )
	{
		int updateCount = 0;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			TrackDAO sdao = new JdbcTrackDAO();
			updateCount = sdao.update( vo );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return updateCount;
	}
	
	public int deleteTrackRecord( int id )
	{
		int deletionCount = 0;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			TrackDAO sdao = new JdbcTrackDAO();
			deletionCount = sdao.delete( id );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return deletionCount;
	}
	
	public TrackVO getTrackBean( int id )
	{
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			TrackDAO sdao = new JdbcTrackDAO();
			return sdao.findByPrimaryKey( id );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List< TrackVO > getAllTrackBeans()
	{
		List< TrackVO > list = null;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			TrackDAO sdao = new JdbcTrackDAO();
			list =  sdao.getAll();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return list;
	}
}
