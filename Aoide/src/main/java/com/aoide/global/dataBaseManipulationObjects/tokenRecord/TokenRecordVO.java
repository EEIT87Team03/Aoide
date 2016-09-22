package com.aoide.global.dataBaseManipulationObjects.tokenRecord;

public class TokenRecordVO {
	
	public TokenRecordVO(){
		
	}
	
	public TokenRecordVO(int recipientId, int tokenVolume, int sponsorBalance,
			int recipienBalance, int type) {
		super();
		this.recipientId = recipientId;
		this.tokenVolume = tokenVolume;
		this.sponsorBalance = sponsorBalance;
		this.recipienBalance = recipienBalance;
		this.type = type;
	}
	private int tokenRecordId;
	private java.sql.Date date;
	private int recipientId;
	private int tokenVolume;
	private int sponsorBalance;
	private int recipienBalance;
	private int type;
	private int sponsorId;
	
	public int getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(int sponsorId) {
		this.sponsorId = sponsorId;
	}

	public void setSponsorBalance(int sponsorBalance) {
		this.sponsorBalance = sponsorBalance;
	}

	public int getTokenRecordId() {
		return tokenRecordId;
	}
	public void setTokenRecordId(int tokenRecordId) {
		this.tokenRecordId = tokenRecordId;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public int getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}
	public int getTokenVolume() {
		return tokenVolume;
	}
	public void setTokenVolume(int tokenVolume) {
		this.tokenVolume = tokenVolume;
	}
	public int getSponsorBalance() {
		return sponsorBalance;
	}
	public void setsponsorBalance(int sponsorBalance) {
		this.sponsorBalance = sponsorBalance;
	}
	public int getRecipienBalance() {
		return recipienBalance;
	}
	public void setRecipienBalance(int recipienBalance) {
		this.recipienBalance = recipienBalance;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
