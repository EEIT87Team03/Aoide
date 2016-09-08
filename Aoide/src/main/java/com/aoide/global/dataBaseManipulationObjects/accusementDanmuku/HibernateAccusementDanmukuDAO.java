package com.aoide.global.dataBaseManipulationObjects.accusementDanmuku;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.AutoInvoker;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

public class HibernateAccusementDanmukuDAO {
	// Fields
	private static final String INSERT_STMT = new StringBuffer()
			.append("INSERT INTO accusement_danmuku(")
			.append("[accuse_id],")
			.append("[accused_id],")
			.append("[content_file])")
			.append("VALUES(?,?,?)")
			.toString();

	private static final String UPDATE_STMT = new StringBuffer()
			.append("UPDATE accusement_danmuku ")
			.append("SET ")
			.append("[accuse_id] = ?,")
			.append("[accused_id] = ?,")
			.append("[content_file] = ? ")
			.append("WHERE accusement_danmuku_id = ?")
			.toString();

	private static final String DELETE_STMT = "DELETE FROM accusement_danmuku WHERE accusement_danmuku_id = ?";
	private static final String GET_ONE_STMT = new StringBuffer()
			.append("SELECT ") 
			.append("[accusement_danmuku_id],") 
			.append("[date],") 
			.append("[accuse_id],") 
			.append("[accused_id],") 
			.append("[content_file] ") 
			.append("FROM accusement_danmuku ") 
			.append("WHERE [accusement_danmuku_id] = ?")
			.toString();
	private static final String GET_ALL_STMT = new StringBuffer()
			.append("SELECT ") 
			.append("[accusement_danmuku_id],") 
			.append("[date],") 
			.append("[accuse_id],") 
			.append("[accused_id],") 
			.append("[content_file] ") 
			.append("FROM accusement_danmuku") 
			.toString();
	private static final String GET_MEMBER_STMT = 
			"SELECT [member_id] ,[account], [password], [name], [email], "
			+ "[register_state], [login_count], [last_login_date], [token_total],"
			+ "[picture], [introduction_file_path], [class_type], [ban_state] ,[bank_info] "
			+ "FROM member WHERE [member_id] = ?";
	
	Connection conn = null;
	
	// Constructors
	public HibernateAccusementDanmukuDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	// Methods
	public void insert(HibernateAccusementDanmukuVO accusementDanmukuVO) {
		
		try( PreparedStatement pstmt = AutoInvoker.invoke( conn, INSERT_STMT, accusementDanmukuVO ) )
		{
			pstmt.executeUpdate();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
	}
	
	public int update(HibernateAccusementDanmukuVO accusementDanmukuVO) {
		int updateCount = 0;
		
		try( PreparedStatement pstmt = AutoInvoker.invoke( conn, UPDATE_STMT, accusementDanmukuVO ) )
		{
			updateCount = pstmt.executeUpdate();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return updateCount;
		
	}
	
	public int delete(Integer accusementDanmukuId) {
		
		int deletionCount = 0;
		
		try( PreparedStatement pstmt = AutoInvoker.invokeByValues( conn, DELETE_STMT, accusementDanmukuId ) )
		{
			deletionCount = pstmt.executeUpdate();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return deletionCount;
	}
	
	public HibernateAccusementDanmukuVO findByPrimaryKey(Integer accusementDanmukuId) {
		
		AccusementDanmukuVO accusementDanmukuVO = null;
		HibernateAccusementDanmukuVO hibernateVO = new HibernateAccusementDanmukuVO();
		
		try( PreparedStatement pstmt = AutoInvoker.invokeByValues( conn, GET_ONE_STMT, accusementDanmukuId );
				ResultSet rs = pstmt.executeQuery()  )
			{
				if ( rs.next() ) 
				{
					accusementDanmukuVO = ( AccusementDanmukuVO ) AutoInvoker.inject( rs,  new AccusementDanmukuVO() );
				}
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}
		Integer accuseId = accusementDanmukuVO.getAccuseId();
		Integer accusedId = accusementDanmukuVO.getAccusedId();
		
		// get accuse by memberId
		MemberVO accuse = null;
		try( PreparedStatement pstmt = AutoInvoker.invokeByValues( conn, GET_MEMBER_STMT, accuseId );
				 ResultSet rs1 = pstmt.executeQuery()	)
			{
				if ( rs1.next() ) 
				{
					accuse =  ( MemberVO ) AutoInvoker.inject( rs1,  new MemberVO() );
				}
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}
		
		// get accused by memberId			
		MemberVO accused = null;
		try( PreparedStatement pstmt = AutoInvoker.invokeByValues( conn, GET_MEMBER_STMT, accusedId );
				 ResultSet rs2 = pstmt.executeQuery()	)
			{
				if ( rs2.next() ) 
				{
					accused =  ( MemberVO ) AutoInvoker.inject( rs2,  new MemberVO() );
				}
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}	
		// set accuse and accused 
		hibernateVO.setAccuse(accuse);
		hibernateVO.setAccused(accused);
		// set other properties
		hibernateVO.setAccusementDanmukuId(accusementDanmukuVO.getAccusementDanmukuId());
		hibernateVO.setDate(accusementDanmukuVO.getDate());
		hibernateVO.setContentFile(accusementDanmukuVO.getContentFile());
		
		return hibernateVO;
	}
	
	public List<HibernateAccusementDanmukuVO> getAll() {
		List< HibernateAccusementDanmukuVO > voList = new ArrayList<>();
		AccusementDanmukuVO accusementDanmukuVO = null;
		HibernateAccusementDanmukuVO hibernateVO = null;
		
		
		try( PreparedStatement pstmt = conn.prepareStatement( GET_ALL_STMT );
			 ResultSet rs = pstmt.executeQuery() )	 
		{
			while ( rs.next() ) 
			{	
				// get AccusementDanmukuVO 
				accusementDanmukuVO = ( AccusementDanmukuVO ) AutoInvoker.inject( rs,  new AccusementDanmukuVO() );
				Integer accuseId = accusementDanmukuVO.getAccuseId();
				Integer accusedId = accusementDanmukuVO.getAccusedId();
				System.out.println("accuseId: " + accuseId);
				System.out.println("accusedId: " + accusedId);
				
				// get accuse by memberId
				MemberVO accuse = null;
				try( PreparedStatement pstmt2 = AutoInvoker.invokeByValues( conn, GET_MEMBER_STMT, accuseId );
						 ResultSet rs1 = pstmt2.executeQuery()	)
					{
						if ( rs1.next() ) 
						{
							accuse =  ( MemberVO ) AutoInvoker.inject( rs1,  new MemberVO() );
						}
					}
					catch( Exception e )
					{
						e.printStackTrace();
					}
				// get accused by memberId			
				MemberVO accused = null;
				try( PreparedStatement pstmt3 = AutoInvoker.invokeByValues( conn, GET_MEMBER_STMT, accusedId );
						 ResultSet rs3 = pstmt3.executeQuery()	)
					{
						if ( rs3.next() ) 
						{
							accused =  ( MemberVO ) AutoInvoker.inject( rs3,  new MemberVO() );
						}
					}
					catch( Exception e )
					{
						e.printStackTrace();
					}	
				
				// set accuse and accused
				hibernateVO = new HibernateAccusementDanmukuVO();
				hibernateVO.setAccuse(accuse);
				hibernateVO.setAccused(accused);
				// set other properties
				hibernateVO.setAccusementDanmukuId(accusementDanmukuVO.getAccusementDanmukuId());
				hibernateVO.setDate(accusementDanmukuVO.getDate());
				hibernateVO.setContentFile(accusementDanmukuVO.getContentFile());
				
				voList.add( hibernateVO );
				
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return voList;
	}
	
}
