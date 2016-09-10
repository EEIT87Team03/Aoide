package com.aoide.global.dataBaseManipulationObjects.accusementDanmuku;

import java.io.Serializable;
import java.sql.Timestamp;

public class AccusementDanmukuVO implements Serializable{
	   
	// Fields
	private int accusementDanmukuId; 
	private Timestamp date;
	private int accuseId;      
	private int accusedId;     
	private String contentFile;
	private String danmukuContent;
	private Boolean state;
	
	// Constructors
	public AccusementDanmukuVO() {
	
	}
	
	public AccusementDanmukuVO(int accusementDanmukuId, Timestamp date, int accuseId, int accusedId,
			String contentFile) {
		super();
		this.accusementDanmukuId = accusementDanmukuId;
		this.date = date;
		this.accuseId = accuseId;
		this.accusedId = accusedId;
		this.contentFile = contentFile;
	}
	
	// Methods
	public int getAccusementDanmukuId() {
		return accusementDanmukuId;
	}

	public void setAccusementDanmukuId(int accusementDanmukuId) {
		this.accusementDanmukuId = accusementDanmukuId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getAccuseId() {
		return accuseId;
	}

	public void setAccuseId(int accuseId) {
		this.accuseId = accuseId;
	}

	public int getAccusedId() {
		return accusedId;
	}

	public void setAccusedId(int accusedId) {
		this.accusedId = accusedId;
	}

	public String getContentFile() {
		return contentFile;
	}

	public void setContentFile(String contentFile) {
		this.contentFile = contentFile;
	}

	public String getDanmukuContent() {
		return danmukuContent;
	}

	public void setDanmukuContent(String danmukuContent) {
		this.danmukuContent = danmukuContent;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	   
}
