package com.aoide.global.dataBaseManipulationObjects.song;

import java.sql.Date;
import java.sql.Timestamp;

public class SongVO {
	
	// Fields
	private Integer songId; 
	private String songFile;
	private String name;
	private String songType;
	private String songLanguage;
	private Integer memberId;
	private Integer albumId = 1;
	private String introductionFile;
	private String coverFile;
	private String lyricsFile;
	private Date updateDate;
	private Timestamp lastclickDate = new Timestamp(0);   
	private Integer clicks;
	private Integer favoriteCounts;
	private Integer shares;
	private Double score;
	private Integer length;
	private String singer;
	
	// Constructors
	public SongVO() {

	}
	public SongVO(int songId, String songFile, String name, String songType, String songLanguage, int memberId,
			int albumId, String introductionFile, String coverFile, String lyricsFile, Date updateDate,
			Timestamp lastclickDate, int clicks, int favoriteCounts, int shares, double score, int length,
			String singer) {
		super();
		this.songId = songId;
		this.songFile = songFile;
		this.name = name;
		this.songType = songType;
		this.songLanguage = songLanguage;
		this.memberId = memberId;
		this.albumId = albumId;
		this.introductionFile = introductionFile;
		this.coverFile = coverFile;
		this.lyricsFile = lyricsFile;
		this.updateDate = updateDate;
		this.lastclickDate = lastclickDate;
		this.clicks = clicks;
		this.favoriteCounts = favoriteCounts;
		this.shares = shares;
		this.score = score;
		this.length = length;
		this.singer = singer;
	}
	
	// Methods
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getSongFile() {
		return songFile;
	}
	public void setSongFile(String songFile) {
		this.songFile = songFile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSongType() {
		return songType;
	}
	public void setSongType(String songType) {
		this.songType = songType;
	}
	public String getSongLanguage() {
		return songLanguage;
	}
	public void setSongLanguage(String songLanguage) {
		this.songLanguage = songLanguage;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public String getIntroductionFile() {
		return introductionFile;
	}
	public void setIntroductionFile(String introductionFile) {
		this.introductionFile = introductionFile;
	}
	public String getCoverFile() {
		return coverFile;
	}
	public void setCoverFile(String coverFile) {
		this.coverFile = coverFile;
	}
	public String getLyricsFile() {
		return lyricsFile;
	}
	public void setLyricsFile(String lyricsFile) {
		this.lyricsFile = lyricsFile;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Timestamp getLastclickDate() {
		return lastclickDate;
	}
	public void setLastclickDate(Timestamp lastclickDate) {
		this.lastclickDate = lastclickDate;
	}
	public Integer getClicks() {
		return clicks;
	}
	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}		   
	public Integer getFavoriteCounts() {
		return favoriteCounts;
	}
	public void setFavoriteCounts(Integer favoriteCounts) {
		this.favoriteCounts = favoriteCounts;
	}
	public Integer getShares() {
		return shares;
	}
	public void setShares(Integer shares) {
		this.shares = shares;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	
	
	
	
}
