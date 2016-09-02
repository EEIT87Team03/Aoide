package com.aoide.global.dataBaseManipulationObjects.member;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.AutoInvoker;

public class JdbcMemberDAO implements MemberDAO 
{
	private static final String INSERT_STMT = 
			"INSERT INTO member "
			+ "( [account], [password], [name], [email], [picture], [introduction_file_path], [bank_info] ) " 
			+ "VALUES ( ?, ?, ?, ?, ?, ?, ? )";
		
	private static final String UPDATE_STMT = 
			"UPDATE member SET "
			+ "[password] = ?, [name] = ?, [email] = ?, [login_count] = ?, [last_login_date] = ?, "
			+ "[token_total] = ?, [picture] = ?, [introduction_file_path] = ?, [bank_info] = ? "
			+ "WHERE [account] = ?";
		
	private static final String DELETE_STMT = 
			"DELETE FROM member WHERE [account] = ?";
		
	private static final String GET_ONE_STMT = 
			"SELECT [member_id] ,[account], [password], [name], [email], "
			+ "[register_state], [login_count], [last_login_date], [token_total],"
			+ "[picture], [introduction_file_path], [class_type], [ban_state] ,[bank_info] "
			+ "FROM member WHERE [account] = ?";
		
	private static final String GET_ALL_STMT = 
			"SELECT [member_id] ,[account], [password], [name], [email], "
			+ "[register_state], [login_count], [last_login_date], [token_total], "
			+ "[picture], [introduction_file_path], [class_type], [ban_state] ,[bank_info] "
			+ "FROM member ORDER BY [member_id]";
	
	private Connection conn;
	
	public JdbcMemberDAO( Connection conn )
	{
		this.conn = conn;
	}
	
	@Override
	public int insert( MemberVO vo ) 
	{
		int insertionCount = 0;
		
		try( PreparedStatement pstmt = AutoInvoker.invoke( conn, INSERT_STMT, vo ) )
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
	public int update( MemberVO vo )
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
	public int delete( String account )
	{
		int deletionCount = 0;
		
		try( PreparedStatement pstmt = AutoInvoker.invokeByValues( conn, DELETE_STMT, account ) )
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
	public MemberVO findByPrimaryKey( String account )
	{
		try( PreparedStatement pstmt = AutoInvoker.invokeByValues( conn, GET_ONE_STMT, account );
			 ResultSet rs = pstmt.executeQuery()	)
		{
			if ( rs.next() ) 
			{
				return ( MemberVO ) AutoInvoker.inject( rs,  new MemberVO() );
			}
			
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List< MemberVO > getAll()
	{
		List< MemberVO > voList = new ArrayList<>();
		try( PreparedStatement pstmt = conn.prepareStatement( GET_ALL_STMT );
			 ResultSet rs = pstmt.executeQuery() )	 
		{
			while ( rs.next() ) 
			{
				voList.add( ( MemberVO ) AutoInvoker.inject( rs,  new MemberVO() ) );
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return voList;
	}
	
}
