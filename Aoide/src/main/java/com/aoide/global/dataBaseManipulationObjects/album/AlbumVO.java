package com.aoide.global.dataBaseManipulationObjects.album;

import java.io.Serializable;
import java.sql.Date;

public class AlbumVO implements Serializable 
{
	private int albumId;
	private int memberId;
	private String name;
	private String introductionFilePath;
	private Date updateDate;
	private String coverFilePath;
	
	public int getAlbumId() 
	{
		return albumId;
	}
	public void setAlbumId(int albumId) 
	{
		this.albumId = albumId;
	}
	
	public int getMemberId() 
	{
		return memberId;
	}
	public void setMemberId(int memberId) 
	{
		this.memberId = memberId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIntroductionFilePath() 
	{
		return introductionFilePath;
	}
	public void setIntroductionFilePath( String introductionFilePath) 
	{
		this.introductionFilePath = introductionFilePath;
	}
	
	public Date getUpdateDate() 
	{
		return updateDate;
	}
	public void setUpdateDate( Date updateDate) 
	{
		this.updateDate = updateDate;
	}
	
	public String getCoverFilePath() 
	{
		return coverFilePath;
	}
	public void setCoverFilePath( String coverFilePath ) 
	{
		this.coverFilePath = coverFilePath;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append( albumId ).append( "\t" ).append( memberId ).append( "\t" ).append( name ).append( "\t" )
		  .append( introductionFilePath ).append( "\t" ).append( updateDate ).append( "\t" ).append( coverFilePath );
		return sb.toString();
	}
}
