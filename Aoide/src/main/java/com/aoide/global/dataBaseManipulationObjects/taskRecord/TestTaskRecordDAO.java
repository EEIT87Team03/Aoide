package com.aoide.global.dataBaseManipulationObjects.taskRecord;

import java.util.List;

public class TestTaskRecordDAO {

	public static void main(String[] args) {
		JdbcTaskRecordDAO dao = new JdbcTaskRecordDAO();
		
     	// �s�W
//		TaskrecordVO taskrecordVO1 = new TaskrecordVO();
//		taskrecordVO1.setTaskId(1);
//		taskrecordVO1.setMemberId(2);
////		taskrecordVO1.setCompleteDate();
//        dao.insert(taskrecordVO1);
	
		
		/*
		// �ק�
        TaskrecordVO taskrecordVO1 = new TaskrecordVO();
        taskrecordVO1.setTaskId(2);
        taskrecordVO1.setMemberId(1);
        TaskrecordVO taskrecordVO2 = new TaskrecordVO();
        taskrecordVO2.setTaskId(1);
        taskrecordVO2.setMemberId(3);
		dao.update(taskrecordVO1, taskrecordVO2);
		*/
		
		/*
        // �R��
		dao.delete(1,2);
		*/
		
		// �d��
//		TaskrecordVO taskrecordVO3 = dao.findByPrimaryKey(1,null);
//		System.out.print(taskrecordVO3.getTaskId() + ",");
//		System.out.print(taskrecordVO3.getMemberId() + ",");
//		System.out.print(taskrecordVO3.getCompleteDate() + ",\n");
//        System.out.println("---------------------");

		// �d��
		List<TaskRecordVO> list = dao.getAll();
		for (TaskRecordVO aTaskrecordVO : list) {
			System.out.print(aTaskrecordVO.getTaskId() + ",");
			System.out.print(aTaskrecordVO.getMemberId() + ",");
			System.out.print(aTaskrecordVO.getCompleteDate() + ",");
            System.out.println();
		}
    }
}


