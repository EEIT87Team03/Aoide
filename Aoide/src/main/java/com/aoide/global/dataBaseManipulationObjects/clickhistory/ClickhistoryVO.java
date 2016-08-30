package com.aoide.global.dataBaseManipulationObjects.clickhistory;

import java.sql.Date;

public class ClickhistoryVO implements java.io.Serializable{
	
	private Integer chlickhistoryId;
	private Integer songId;
	private Date date;
	
	public ClickhistoryVO(int chlickhistoryId,int songId,Date date){
		
		this.chlickhistoryId = chlickhistoryId;
		
		this.songId = songId;
		
		this.date = date;
		
	}
	
    public ClickhistoryVO(){
		
		
	}
	
	public Integer getClickhistoryId() {
		return chlickhistoryId;
		
		
	}
	public void setClickhistoryId(Integer chlickhistoryId) {
		this.chlickhistoryId = chlickhistoryId;
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
	



}
