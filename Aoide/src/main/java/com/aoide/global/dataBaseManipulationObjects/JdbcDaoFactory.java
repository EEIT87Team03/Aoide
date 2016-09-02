package com.aoide.global.dataBaseManipulationObjects;

import java.sql.Connection;

import com.aoide.global.dataBaseManipulationObjects.member.JdbcMemberDAO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberDAO;

public class JdbcDaoFactory extends AbstractDaoFactory {

	public JdbcDaoFactory( Connection con ) 
	{
		super( con );
	}

	@Override
	public MemberDAO createMemberDAO() 
	{
		return new JdbcMemberDAO( conn );
	}

}
