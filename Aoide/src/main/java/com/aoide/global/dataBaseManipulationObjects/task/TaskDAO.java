package com.aoide.global.dataBaseManipulationObjects.task;



import java.util.*;

public interface TaskDAO {
	public void insert(TaskVO taskVO);
    public void update(TaskVO taskVO);
    public void delete(Integer task_id);
    public TaskVO findByPrimaryKey(Integer task_id);
    public List<TaskVO> getAll();
}

