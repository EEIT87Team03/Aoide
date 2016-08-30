package com.aoide.global.dataBaseManipulationObjects.task;

import java.sql.Date;

//public class TaskVO implements java.io.Serializable{
public class TaskVO {
	
	private Integer taskId;
	private String name;
	private String contentFile;
	private Double reward;
	private Integer periodHour;
	private Date beginDate;
	private Date closeDate;
	

	// Constructors
	public TaskVO() {
	}
	public TaskVO(Integer taskId, String name, String contentFile, Double reward,
			Integer periodHour, Date beginDate, Date closeDate) {
		this.taskId = taskId;
		this.name = name;
		this.contentFile = contentFile;
		this.reward = reward;
		this.periodHour = periodHour;
		this.beginDate = beginDate;
		this.closeDate = closeDate;
	}
	
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContentFile() {
		return contentFile;
	}
	public void setContentFile(String contentFile) {
		this.contentFile = contentFile;
	}
	public Double getReward() {
		return reward;
	}
	public void setReward(Double reward) {
		this.reward = reward;
	}
	public Integer getPeriodHour() {
		return periodHour;
	}
	public void setPeriodHour(Integer periodHour) {
		this.periodHour = periodHour;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
}


	