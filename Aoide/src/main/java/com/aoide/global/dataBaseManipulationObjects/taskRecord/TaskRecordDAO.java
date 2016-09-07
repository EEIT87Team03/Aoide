package com.aoide.global.dataBaseManipulationObjects.taskRecord;


import java.util.*;

	public interface TaskRecordDAO {
		public Integer insert(TaskRecordVO taskrecordVO);
	    public void update(TaskRecordVO taskrecordVO1, TaskRecordVO taskrecordVO2);
	    public void delete(Integer task_id,Integer member_id);
	    public TaskRecordVO findByPrimaryKey(Integer task_id,Integer member_id);
	    public List<TaskRecordVO> getAll();
	}


