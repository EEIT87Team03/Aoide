package com.aoide.global.websocket.track;

import java.io.Serializable; 
import java.sql.Date;
import java.sql.Timestamp;

public class TrackVO implements Serializable
{
	
	// Fields
	private Integer songId; 
	private String songFile;
	private String name;
	private String songType;
	private String songLanguage;
	private Integer memberId;
	private Integer albumId;
	private String introductionFile;
	private String coverFile;
	private String lyricsFile;
	private Date updateDate;
	private Timestamp lastclickDate;   
	private Integer clicks;
	private Integer favoriteCounts;
	private Integer shares;
	private Double score;
	private Integer length;
	private String singer;
	
	// Methods
	public Integer getSongId() 
	{
		return songId;
	}
	public void setSongId( Integer songId ) 
	{
		this.songId = songId;
	}

	public String getSongFile() 
	{
		return songFile;
	}
	public void setSongFile( String songFile ) 
	{
		this.songFile = songFile;
	}

	public String getName() 
	{
		return name;
	}
	public void setName( String name ) 
	{
		this.name = name;
	}

	public String getSongType() 
	{
		return songType;
	}
	public void setSongType( String songType ) 
	{
		this.songType = songType;
	}

	public String getSongLanguage() 
	{
		return songLanguage;
	}

	public void setSongLanguage( String songLanguage ) 
	{
		this.songLanguage = songLanguage;
	}

	public int getMemberId()
	{
		return memberId;
	}
	public void setMemberId( Integer memberId) 
	{
		this.memberId = memberId;
	}

	public int getAlbumId() 
	{
		return albumId;
	}
	public void setAlbumId( Integer albumId) 
	{
		this.albumId = albumId;
	}

	public String getIntroductionFile() 
	{
		return introductionFile;
	}
	public void setIntroductionFile( String introductionFile ) 
	{
		this.introductionFile = introductionFile;
	}

	public String getCoverFile() 
	{
		return coverFile;
	}
	public void setCoverFile( String coverFile ) 
	{
		this.coverFile = coverFile;
	}

	public String getLyricsFile() {
		return lyricsFile;
	}
	public void setLyricsFile( String lyricsFile ) 
	{
		this.lyricsFile = lyricsFile;
	}

	public Date getUpdateDate() 
	{
		return updateDate;
	}
	public void setUpdateDate( Date updateDate )
	{
		this.updateDate = updateDate;
	}

	public Timestamp getLastclickDate() 
	{
		return lastclickDate;
	}
	public void setLastclickDate( Timestamp lastclickDate ) 
	{
		this.lastclickDate = lastclickDate;
	}

	public int getClicks() 
	{
		return clicks;
	}
	public void setClicks( Integer clicks) 
	{
		this.clicks = clicks;
	}

	public int getFavoriteCounts()
	{
		return favoriteCounts;
	}
	public void setFavoriteCounts( Integer favoriteCounts ) 
	{
		this.favoriteCounts = favoriteCounts;
	}

	public Integer getShares() 
	{
		return shares;
	}
	public void setShares( Integer shares) 
	{
		this.shares = shares;
	}

	public Double getScore() 
	{
		return score;
	}
	public void setScore( Double score) {
		this.score = score;
	}

	public Integer getLength() 
	{
		return length;
	}
	public void setLength( Integer length ) 
	{
		this.length = length;
	}
	
	public String getSinger() 
	{
		return singer;
	}
	public void setSinger( String singer ) 
	{
		this.singer = singer;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append( songId + "\t" ).append( name + "\t" ).append( length + "\t" ).append( singer + "\t" );
		
		return sb.toString();
	}
	
}
