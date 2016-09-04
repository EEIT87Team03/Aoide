package com.aoide.global.dataBaseManipulationObjects;

import java.sql.Connection;

import com.aoide.global.dataBaseManipulationObjects.album.AlbumDAO;
import com.aoide.global.dataBaseManipulationObjects.album.JdbcAlbumDAO;
import com.aoide.global.dataBaseManipulationObjects.member.JdbcMemberDAO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberDAO;

public class JdbcDaoFactory implements AbstractDaoFactory 
{

	@Override
	public MemberDAO createMemberDAO( Connection con ) 
	{
		return new JdbcMemberDAO( con );
	}

	@Override
	public AlbumDAO createAlbumDAO( Connection con) 
	{
		return new JdbcAlbumDAO( con );
	}

}
