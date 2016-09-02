package com.aoide.global.dataBaseManipulationObjects.album;

import java.sql.Connection;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.DataSourceProxy;

public class AlbumService 
{
	public int createNewAlbum( AlbumVO vo )
	{
		int caeationCount = 0;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			AlbumDAO adao = new JdbcAlbumDAO( conn );
			caeationCount = adao.insert( vo );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return caeationCount;
	}
	
	public int updateAlbumContent( AlbumVO vo )
	{
		int updateCount = 0;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			AlbumDAO adao = new JdbcAlbumDAO( conn );
			updateCount = adao.update( vo );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return updateCount;
	}
	
	public int deleteAlbum( Integer albumId )
	{
		int deletionCount = 0;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			AlbumDAO adao = new JdbcAlbumDAO( conn );
			deletionCount = adao.delete( albumId );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return deletionCount;
	}
	
	public AlbumVO getAlbumBean( int id )
	{
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			AlbumDAO adao = new JdbcAlbumDAO( conn );
			return adao.findByPrimaryKey( id );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List< AlbumVO > getMembersList()
	{
		List< AlbumVO > list = null;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			AlbumDAO adao = new JdbcAlbumDAO( conn );
			list =  adao.getAll();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
