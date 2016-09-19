package com.aoide.global.dataBaseManipulationObjects.album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.AutoInvoker;

public class JdbcAlbumDAO implements AlbumDAO 
{
	private static final String INSERT_STMT = 
			"INSERT INTO album "
			+ "( [member_id], [name], [artist], [introduction_file_path], [cover_file_path] ) " 
			+ "VALUES ( ?, ?, ?, ?, ? )";
		
	private static final String UPDATE_STMT = 
			"UPDATE album SET "
			+ "[name] = ?, [artist] = ?, [introduction_file_path] = ?, [update_date] = ?, [cover_file_path] = ? "
			+ "WHERE [album_id] = ?";
		
	private static final String DELETE_STMT = 
			"DELETE FROM album WHERE [album_id] = ?";
	
	private static final String SEARCH_STMT = 
			"SELECT [album_id] ,[member_id], [name], [artist], "
			+ "[introduction_file_path], [update_date], [cover_file_path] "
			+ "FROM album WHERE [name] LIKE ?";
		
	private static final String GET_ONE_STMT = 
			"SELECT [album_id] ,[member_id], [name], [artist], "
			+ "[introduction_file_path], [update_date], [cover_file_path] "
			+ "FROM album WHERE [album_id] = ?";
		
	private static final String GET_ALL_STMT = 
			"SELECT [album_id] ,[member_id], [name], [artist], "
			+ "[introduction_file_path], [update_date], [cover_file_path] "
			+ "FROM album ORDER BY [album_id]";
	
	private Connection conn;
	
	public JdbcAlbumDAO( Connection con )
	{
		this.conn = con;
	}
	
	@Override
	public int insert( AlbumVO vo ) 
	{
		int insertionCount = 0, id = -1;
		try( PreparedStatement pstmt = AutoInvoker.invoke( conn, INSERT_STMT, vo ) )
		{
			insertionCount = pstmt.executeUpdate();
			ResultSet keys = pstmt.getGeneratedKeys();

			if ( keys.next() ) 
			{
				id = (Integer) keys.getInt(1);
				
				return id;
			}
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
		
		try( PreparedStatement pstmt = AutoInvoker.invoke( conn, UPDATE_STMT, vo ) )
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
		
		try( PreparedStatement pstmt = AutoInvoker.invokeByValues( conn, DELETE_STMT, albumId ) )
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
		try( PreparedStatement pstmt = AutoInvoker.invokeByValues( conn, GET_ONE_STMT, albumId );
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
	public List< AlbumVO > search( String keyword ) 
	{
		keyword = "%" + keyword + "%";
		List< AlbumVO > voList = new ArrayList<>();
		try( PreparedStatement pstmt = AutoInvoker.invokeByValues( conn, SEARCH_STMT, keyword );
			 ResultSet rs = pstmt.executeQuery() )
		{
					
			if ( rs.next() ) 
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
	
	@Override
	public List< AlbumVO > getAll() 
	{
		List< AlbumVO > voList = new ArrayList<>();
		try( PreparedStatement pstmt = conn.prepareStatement( GET_ALL_STMT );
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
	
}
