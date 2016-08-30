package com.aoide.global.dataBaseManipulationObjects.favorite;

import java.sql.Date;

public class FavoriteVO {
	
	private Integer memberId;

	private Integer songId;
	
	
	
	public FavoriteVO(int memberId, int songId){
		
		 this.memberId = memberId;
		 
		 this.songId = songId ;
		
		
		
	}
	
	public FavoriteVO(){};
	
	

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}
	
	
	
	
	
}
