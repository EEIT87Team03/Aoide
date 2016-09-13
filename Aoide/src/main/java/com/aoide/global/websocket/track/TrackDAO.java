package com.aoide.global.websocket.track;

import java.util.List;



public interface TrackDAO 
{
	public Integer insert(TrackVO songVO );
	public int update( TrackVO songVO );
	public int delete( Integer songId );
	public TrackVO findByPrimaryKey( Integer songId );
	public List<TrackVO> getAll();
	public List<TrackVO> getName(String search);
	public List<TrackVO> getSinger(String search);
	
	
	
	
}
