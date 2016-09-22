package com.aoide.manager._26_EditTask.model;

import java.util.ArrayList;
import java.util.List;


import com.aoide.global.dataBaseManipulationObjects.task.JdbcTaskDAO;
import com.aoide.global.dataBaseManipulationObjects.task.TaskDAO;
import com.aoide.global.dataBaseManipulationObjects.task.TaskVO;

public class TaskService {

	// Fields
	TaskDAO taskDAO = new JdbcTaskDAO();

	// Constructors
	public TaskService() {
	}
	
	// Methods
	public List<TaskVO> getUnreplyTaskVO() {
		List<TaskVO> taskList = new ArrayList();
		for (TaskVO aTask : taskDAO.getAll()) {
			taskList.add(aTask);

		}// end for
		return taskList;
	}// end getUnreplySuggestions()

	public void updateTask(TaskVO taskVO) {
		taskDAO.update(taskVO);
	}

	public TaskVO getTaskById(Integer taskId) {
		return taskDAO.findByPrimaryKey(taskId);
	}
	
}// end class