package com.aoide.global.dataBaseManipulationObjects;

import java.sql.Connection;

import com.aoide.global.dataBaseManipulationObjects.album.AlbumDAO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberDAO;

public abstract class AbstractDaoFactory 
{
	protected Connection conn;
	
	public AbstractDaoFactory( Connection con)
	{
		this.conn = con;
	}
	public abstract MemberDAO createMemberDAO();
	public abstract AlbumDAO createAlbumDAO();
}
