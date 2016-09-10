package com.aoide.global.dataBaseManipulationObjects.member;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.AbstractDaoFactory;
import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;
import com.aoide.global.dataBaseManipulationObjects.DataSourceProxy;
import com.aoide.global.dataBaseManipulationObjects.JdbcDaoFactory;

public class MemberService 
{
	private AbstractDaoFactory daoFactory;
	public MemberService()
	{
		daoFactory = new JdbcDaoFactory();
	}
	
	public int createMemberAccount( MemberVO vo )
	{
		int caeationCount = 0;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			MemberDAO mdao = daoFactory.createMemberDAO( conn );
			caeationCount = mdao.insert( vo );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return caeationCount;
	}
	
	public int updateMemberData( MemberVO vo )
	{
		int updateCount = 0;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			MemberDAO mdao = daoFactory.createMemberDAO( conn );
			updateCount = mdao.update( vo );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return updateCount;
	}
	
	public int deleteMemberAccount( String account )
	{
		int deletionCount = 0;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			MemberDAO mdao = daoFactory.createMemberDAO( conn );
			deletionCount = mdao.delete( account );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return deletionCount;
	}
	
	public MemberVO getMemberBean( String account )
	{
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			MemberDAO mdao = daoFactory.createMemberDAO( conn );
			return mdao.findByPrimaryKey( account );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List< MemberVO > getMembersList()
	{
		List< MemberVO > list = null;
		try ( Connection conn = DataSourceProxy.getConnection() )
		{
			MemberDAO mdao = daoFactory.createMemberDAO( conn );
			list =  mdao.getAll();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return list;
	}

	public static void main( String[] args ) 
	{
		MemberVO m = new MemberVO();
		m.setMemberId( 2 );
		m.setAccount( "smallBirdBeauty" );
		m.setPassword( "28825252" );
		m.setName( "小鳥美麗" );
		m.setEmail( "fattyCutty@outlook.com" );
		m.setRegisterState( 0 );
		m.setLoginCount( 50 );
		m.setLastLoginDate( Timestamp.valueOf( "2016-08-20 20:37:31.940" ) );
		m.setTokenTotal( new BigDecimal( 350 ) );
		m.setPicture( null );
		m.setIntroductionFilePath( "C:/introduction/file" );
		m.setClassType( 0 );
		m.setBanState( true );
		m.setBankInfo( "first bank" );
		
		MemberService ms = new MemberService();
		
		//System.out.println( ms.createMemberAccount( m ) );
		//System.out.println( ms.updateMemberData( m ) );
		//System.out.println( ms.deleteMemberAccount( "smallBirdBeauty" ) );
		//System.out.println( ms.getMemberBean( "whiteBirdBeauty" ) );
		//System.out.println( ms.getMembersList() );
		
	}

}
