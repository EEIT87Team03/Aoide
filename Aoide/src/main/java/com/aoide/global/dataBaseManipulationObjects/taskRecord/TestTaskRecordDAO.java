package com.aoide.global.dataBaseManipulationObjects.taskRecord;

import java.util.List;

public class TestTaskRecordDAO {

	public static void main(String[] args) {
		TaskRecordDAO dao = new JdbcTaskRecordDAO();
		
     	// �s�W
//		TaskRecordVO taskrecordVO1 = new TaskRecordVO();
//		taskrecordVO1.setTaskId(11);
//		taskrecordVO1.setMemberId(11);
//		//taskrecordVO1.setCompleteDate();
//        dao.insert(taskrecordVO1);
//	
		
		
		// �ק�
//        TaskRecordVO taskrecordVO1 = new TaskRecordVO();
//        taskrecordVO1.setTaskId(1);
//        taskrecordVO1.setMemberId(1);
//        
//        TaskRecordVO taskrecordVO2 = new TaskRecordVO();
//        taskrecordVO2.setTaskId(2);
//        taskrecordVO2.setMemberId(2);
//		dao.update(taskrecordVO1, taskrecordVO2);
//		
		
		/*
        // �R��
		dao.delete(1,2);
		*/
		
		// �d��
//		TaskRecordVO taskrecordVO3 = dao.findByPrimaryKey(1,1);
//		System.out.print(taskrecordVO3.getTaskId() + ",");
//		System.out.print(taskrecordVO3.getMemberId() + ",");
//		System.out.print(taskrecordVO3.getCompleteDate() + ",\n");
//        System.out.println("---------------------");
//
//		// �d��
//		List<TaskRecordVO> list = dao.getAll();
//		for (TaskRecordVO aTaskrecordVO : list) {
//			System.out.print(aTaskrecordVO.getTaskId() + ",");
//			System.out.print(aTaskrecordVO.getMemberId() + ",");
//			System.out.print(aTaskrecordVO.getCompleteDate() + ",");
//            System.out.println();
//		}
    }
}


