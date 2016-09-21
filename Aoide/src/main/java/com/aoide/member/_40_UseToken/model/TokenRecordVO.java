package com.aoide.member._40_UseToken.model;

import java.sql.Timestamp;

public class TokenRecordVO {
	// Fields
	private Integer tokenRecordId;
	private java.sql.Timestamp date;
	private Integer recipientId = 0;
	private Integer tokenVolume = 0;
	private Integer sponsorBalance = 0;
	private Integer recipienBalance = 0;
	private Integer sponsorId = 0;

	// Constructors
	public TokenRecordVO() {

	}
	public TokenRecordVO(Integer tokenRecordId, Timestamp date, Integer recipientId, Integer tokenVolume,
			Integer sponsorBalance, Integer recipienBalance, Integer sponsorId) {
		super();
		this.tokenRecordId = tokenRecordId;
		this.date = date;
		this.recipientId = recipientId;
		this.tokenVolume = tokenVolume;
		this.sponsorBalance = sponsorBalance;
		this.recipienBalance = recipienBalance;
		this.sponsorId = sponsorId;
	}
	
	// Methods
	public Integer getTokenRecordId() {
		return tokenRecordId;
	}
	public void setTokenRecordId(Integer tokenRecordId) {
		this.tokenRecordId = tokenRecordId;
	}
	public java.sql.Timestamp getDate() {
		return date;
	}
	public void setDate(java.sql.Timestamp date) {
		this.date = date;
	}
	public Integer getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(Integer recipientId) {
		this.recipientId = recipientId;
	}
	public Integer getTokenVolume() {
		return tokenVolume;
	}
	public void setTokenVolume(Integer tokenVolume) {
		this.tokenVolume = tokenVolume;
	}
	public Integer getSponsorBalance() {
		return sponsorBalance;
	}
	public void setSponsorBalance(Integer sponsorBalance) {
		this.sponsorBalance = sponsorBalance;
	}
	public Integer getRecipienBalance() {
		return recipienBalance;
	}
	public void setRecipienBalance(Integer recipienBalance) {
		this.recipienBalance = recipienBalance;
	}
	public Integer getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}
	
}
