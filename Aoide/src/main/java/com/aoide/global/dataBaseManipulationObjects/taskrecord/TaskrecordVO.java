package com.aoide.global.dataBaseManipulationObjects.taskrecord;

import java.sql.Date;

public class TaskrecordVO {
	private Integer taskId;
	private Integer memberId;
	private Date completeDate;
	
	public TaskrecordVO() {
	}
	public TaskrecordVO(Integer taskId, Integer memberId, Date completeDate ) {
		this.taskId = taskId;
		this.memberId = memberId;
		this.completeDate = completeDate;
		
	}
	
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Date getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

}
