package com.aoide.global.dataBaseManipulationObjects.suggestion;

import java.io.Serializable;
import java.sql.Date;

public class SuggestionVO implements Serializable {
	
	// Fields
	private int suggestionId;
	private Date suggestDate;
	private String title;
	private String suggestionContentFile;
	private String replyContentFile;
	private int replyState;
	private Date replyDate;
	
	// Constructors
	public SuggestionVO() {
	}
	
	public SuggestionVO(int suggestionId, Date suggestDate, String suggestionContentFile, String replyContentFile,
			int replyState, Date replyDate) {
		this.suggestionId = suggestionId;
		this.suggestDate = suggestDate;
		this.suggestionContentFile = suggestionContentFile;
		this.replyContentFile = replyContentFile;
		this.replyState = replyState;
		this.replyDate = replyDate;
	}
	
	// Methods
	public int getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(int suggestionId) {
		this.suggestionId = suggestionId;
	}

	public Date getSuggestDate() {
		return suggestDate;
	}

	public void setSuggestDate(Date suggestDate) {
		this.suggestDate = suggestDate;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getSuggestionContentFile() {
		return suggestionContentFile;
	}

	public void setSuggestionContentFile(String suggestionContentFile) {
		this.suggestionContentFile = suggestionContentFile;
	}

	public String getReplyContentFile() {
		return replyContentFile;
	}

	public void setReplyContentFile(String replyContentFile) {
		this.replyContentFile = replyContentFile;
	}

	public int getReplyState() {
		return replyState;
	}

	public void setReplyState(int replyState) {
		this.replyState = replyState;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	

	
}
