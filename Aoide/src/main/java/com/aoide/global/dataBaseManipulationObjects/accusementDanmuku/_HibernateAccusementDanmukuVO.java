package com.aoide.global.dataBaseManipulationObjects.accusementDanmuku;

import java.sql.Timestamp;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

public class _HibernateAccusementDanmukuVO {
	// Fields
	private int accusementDanmukuId; 
	private Timestamp date;
	private MemberVO accuse;      
	private MemberVO accused;     
	private String contentFile;
	
	// Constructors
	public _HibernateAccusementDanmukuVO() {
	
	}

	public _HibernateAccusementDanmukuVO(int accusementDanmukuId, Timestamp date, MemberVO accuse, MemberVO accused,
			String contentFile) {
		super();
		this.accusementDanmukuId = accusementDanmukuId;
		this.date = date;
		this.accuse = accuse;
		this.accused = accused;
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

	public MemberVO getAccuse() {
		return accuse;
	}

	public void setAccuse(MemberVO accuse) {
		this.accuse = accuse;
	}

	public MemberVO getAccused() {
		return accused;
	}

	public void setAccused(MemberVO accused) {
		this.accused = accused;
	}

	public String getContentFile() {
		return contentFile;
	}

	public void setContentFile(String contentFile) {
		this.contentFile = contentFile;
	}

}
