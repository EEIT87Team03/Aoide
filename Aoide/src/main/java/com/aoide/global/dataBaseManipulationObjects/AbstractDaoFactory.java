package com.aoide.global.dataBaseManipulationObjects;

import java.sql.Connection;

import com.aoide.global.dataBaseManipulationObjects.member.MemberDAO;

public abstract class AbstractDaoFactory 
{
	protected Connection conn;
	
	public abstract MemberDAO createMemberDAO();
	
}
