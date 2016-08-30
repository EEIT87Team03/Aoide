package com.aoide.global.dataBaseManipulationObjects.cashRecord;

import java.sql.Date;

public class CashRecordVO {
	public CashRecordVO() {
	}
	public CashRecordVO(int cashRecordId, Date date, int sponsorId,
			int recipientId, int cashVolume, int tokenVolume, int type) {
		super();
		this.cashRecordId = cashRecordId;
		this.date = date;
		this.sponsorId = sponsorId;
		this.recipientId = recipientId;
		this.cashVolume = cashVolume;
		this.tokenVolume = tokenVolume;
		this.type = type;
	}
	private int cashRecordId;
	private Date date;
	private int sponsorId;
	private int recipientId;
	private int cashVolume;
	private int tokenVolume;
	private int type;
	public int getCashRecordId() {
		return cashRecordId;
	}
	public void setCashRecordId(int cashRecordId) {
		this.cashRecordId = cashRecordId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(int sponsorId) {
		this.sponsorId = sponsorId;
	}
	public int getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}
	public int getCashVolume() {
		return cashVolume;
	}
	public void setCashVolume(int cashVolume) {
		this.cashVolume = cashVolume;
	}
	public int getTokenVolume() {
		return tokenVolume;
	}
	public void setTokenVolume(int tokenVolume) {
		this.tokenVolume = tokenVolume;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

}
