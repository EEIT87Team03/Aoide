package com.aoide.global.dataBaseManipulationObjects.album;

import java.util.List;

public interface AlbumDAO
{
	public int insert( AlbumVO valueObject );
	public int update( AlbumVO newValueObject );
	public int delete( int albumId );
	public AlbumVO findByPrimaryKey( int albumId );
	public List< AlbumVO > getAll();
}
