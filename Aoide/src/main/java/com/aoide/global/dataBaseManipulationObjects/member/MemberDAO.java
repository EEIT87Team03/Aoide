package com.aoide.global.dataBaseManipulationObjects.member;

import java.util.List;

public interface MemberDAO 
{
	public int insert( MemberVO valueObject );
	public int update( MemberVO newValueObject );
	public int delete( String account );
	public MemberVO findByPrimaryKey( String account );
	public List< MemberVO > getAll();
}
