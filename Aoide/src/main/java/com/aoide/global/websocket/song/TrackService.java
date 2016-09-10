package com.aoide.global.websocket.song;

import java.sql.Connection;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.DataSourceProxy;


public class TrackService 
{
	public TrackService()
	{
		
	}
	
	public int createNewTrack( SongVO vo )
	{
		int id = 0;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			SongDAO sdao = new JdbcSongDAO();
			id = sdao.insert( vo );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return id;
	}
	
	public int updateTrackInfo( SongVO vo )
	{
		int updateCount = 0;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			SongDAO sdao = new JdbcSongDAO();
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
			SongDAO sdao = new JdbcSongDAO();
			deletionCount = sdao.delete( id );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return deletionCount;
	}
	
	public SongVO getTrackBean( int id )
	{
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			SongDAO sdao = new JdbcSongDAO();
			return sdao.findByPrimaryKey( id );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List< SongVO > getAllTrackBeans()
	{
		List< SongVO > list = null;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			SongDAO sdao = new JdbcSongDAO();
			list =  sdao.getAll();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return list;
	}
}
