package com.aoide.global.dataBaseManipulationObjects.album;

import java.sql.Connection;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.AbstractDaoFactory;
import com.aoide.global.dataBaseManipulationObjects.DataSourceProxy;
import com.aoide.global.dataBaseManipulationObjects.JdbcDaoFactory;

public class AlbumService 
{
	private AbstractDaoFactory daoFactory;
	
	public AlbumService()
	{
		daoFactory = new JdbcDaoFactory();
	}
	
	public int createNewAlbum( AlbumVO vo )
	{
		int caeationCount = 0;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			AlbumDAO adao = daoFactory.createAlbumDAO( conn );
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
			AlbumDAO adao = daoFactory.createAlbumDAO( conn );
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
			AlbumDAO adao = daoFactory.createAlbumDAO( conn );
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
			AlbumDAO adao = daoFactory.createAlbumDAO( conn );
			return adao.findByPrimaryKey( id );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List< AlbumVO > searchAlbum( String keyword )
	{
		List< AlbumVO > list = null;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			AlbumDAO adao = daoFactory.createAlbumDAO( conn );
			list =  adao.search( keyword );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public List< AlbumVO > getAllAlbumBeans()
	{
		List< AlbumVO > list = null;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			AlbumDAO adao = daoFactory.createAlbumDAO( conn );
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
