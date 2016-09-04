package com.aoide.global.dataBaseManipulationObjects;

import java.sql.Connection;

import com.aoide.global.dataBaseManipulationObjects.album.AlbumDAO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberDAO;

public interface AbstractDaoFactory 
{
	public MemberDAO createMemberDAO( Connection con );
	public AlbumDAO createAlbumDAO( Connection con );
}
