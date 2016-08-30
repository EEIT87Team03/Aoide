package com.aoide.global.dataBaseManipulationObjects.taskrecord;


import java.util.*;

	public interface TaskrecordDAO_Inteface {
		public void insert(TaskrecordVO taskrecordVO);
	    public void update(TaskrecordVO taskrecordVO1, TaskrecordVO taskrecordVO2);
	    public void delete(Integer task_id,Integer member_id);
	    public TaskrecordVO findByPrimaryKey(Integer task_id,Integer member_id);
	    public List<TaskrecordVO> getAll();
	}


