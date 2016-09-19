package com.aoide.global.dataBaseManipulationObjects.score;

import java.sql.Date;

public class ScoreVO {
	
	private Integer memberId;

	private Integer songId;
	
	private Date date;
	
	private Integer scoreValue;
	
	private String  comment;
	
	
	public ScoreVO (int memberId,int songId,Date date,String comment)
	
	{ this.memberId = memberId;
	
	  this.songId = songId ;
	  
	  this.date = date ;
      
	 
	  
	  this.comment = comment ;
		

		
	};
	
	
	public ScoreVO(){};
	
	

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getScoreValue() {
		return scoreValue;
	}

	public void setScoreValue(Integer scoreValue){
		
	     this.scoreValue =scoreValue;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}



	

}
