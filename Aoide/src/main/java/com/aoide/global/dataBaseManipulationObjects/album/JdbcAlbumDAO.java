package com.aoide.global.dataBaseManipulationObjects.album;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcAlbumDAO implements AlbumDAO 
{
	private static final String INSERT_STMT = 
			"INSERT INTO album "
			+ "( [member_id], [name], [introduction_file_path], [cover_file_path] ) " 
			+ "VALUES ( ?, ?, ?, ? )";
		
	private static final String UPDATE_STMT = 
			"UPDATE album SET "
			+ "[name] = ?, [introduction_file_path] = ?, [update_date] = ?, [cover_file_path] = ? "
			+ "WHERE [album_id] = ?";
		
	private static final String DELETE_STMT = 
			"DELETE FROM album WHERE [album_id] = ?";
		
	private static final String GET_ONE_STMT = 
			"SELECT [album_id] ,[member_id], [name], "
			+ "[introduction_file_path], [update_date], [cover_file_path] "
			+ "FROM album WHERE [album_id] = ?";
		
	private static final String GET_ALL_STMT = 
			"SELECT [album_id] ,[member_id], [name], "
			+ "[introduction_file_path], [update_date], [cover_file_path] "
			+ "FROM album ORDER BY [album_id]";
	
	@Override
	public int insert( AlbumVO vo ) 
	{
		int insertionCount = 0;
		
		try( Connection conn = DataSourceProxy.getConnection(); 
			 PreparedStatement pstmt = AutoInvoker.invoke( conn, INSERT_STMT, vo ) )
		{
			insertionCount = pstmt.executeUpdate();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return insertionCount;
	}

	@Override
	public int update( AlbumVO vo ) 
	{
		int updateCount = 0;
		
		try( Connection conn = DataSourceProxy.getConnection(); 
			 PreparedStatement pstmt = AutoInvoker.invoke( conn, UPDATE_STMT, vo ) )
		{
			updateCount = pstmt.executeUpdate();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return updateCount;
	}

	@Override
	public int delete( int albumId )
	{
		int deletionCount = 0;
		
		try( Connection conn = DataSourceProxy.getConnection(); 
			 PreparedStatement pstmt = AutoInvoker.invokeByValues( conn, DELETE_STMT, albumId ) )
		{
			deletionCount = pstmt.executeUpdate();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return deletionCount;
	}

	@Override
	public AlbumVO findByPrimaryKey( int albumId ) 
	{
		try( Connection conn = DataSourceProxy.getConnection(); 
			 PreparedStatement pstmt = AutoInvoker.invokeByValues( conn, GET_ONE_STMT, albumId );
			 ResultSet rs = pstmt.executeQuery() )
		{
			
			if ( rs.next() ) 
			{
				return (AlbumVO) AutoInvoker.inject( rs, new AlbumVO() );
			}
			
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
			
		return null;
	}

	@Override
	public List< AlbumVO > getAll() 
	{
		List< AlbumVO > voList = new ArrayList<>();
		try( Connection conn = DataSourceProxy.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement( GET_ALL_STMT );
			 ResultSet rs = pstmt.executeQuery() )
		{	
			while ( rs.next() ) 
			{
				voList.add( (AlbumVO) AutoInvoker.inject( rs, new AlbumVO() ) );
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return voList;
	}
	
	public static void main( String[] args )
	{
		AlbumVO vo = new AlbumVO();
		vo.setAlbumId( 12 );
		vo.setMemberId( 4 );
		vo.setName( "TTTTT" );
		vo.setIntroductionFilePath( "專輯介紹" );
		vo.setUpdateDate( Date.valueOf( "2016-08-30" ) );
		vo.setCoverFilePath( "/contextPath/img/cover/" );
		
		JdbcAlbumDAO dao = new JdbcAlbumDAO();
		
		//System.out.println( dao.insert( vo ) );
		//System.out.println( dao.update( vo ) );
		//System.out.println( dao.delete( 13 ) );
		System.out.println( dao.findByPrimaryKey( 9 ) );
		List< AlbumVO > voList = dao.getAll();
		for( AlbumVO avo : voList )
		{
			System.out.println( avo );
		}
	}
}
