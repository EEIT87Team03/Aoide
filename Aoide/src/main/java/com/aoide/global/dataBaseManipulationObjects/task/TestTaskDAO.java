package com.aoide.global.dataBaseManipulationObjects.task;

import java.sql.Date;
import java.util.List;

public class TestTaskDAO {

	public static void main(String[] args) {
		JdbcTaskDAO dao = new JdbcTaskDAO();
		
		
		// �s�W
		TaskVO testTaskVO1 = new TaskVO();
		//testTaskVO1.setTaskId(4);
		testTaskVO1.setName("你");
		testTaskVO1.setContentFile("你好");
		testTaskVO1.setReward(4.0);
		testTaskVO1.setPeriodHour(5);
		testTaskVO1.setBeginDate(new Date(79787788L));
		testTaskVO1.setCloseDate(new Date(88888222L));
		dao.insert(testTaskVO1);

//		// �ק�
		TaskVO testTaskVO2 = new TaskVO();
		testTaskVO2.setTaskId(8);
		testTaskVO2.setName("掰");
		testTaskVO2.setContentFile("掰掰掰");
		testTaskVO2.setReward(new Double(100.0d));
		testTaskVO2.setPeriodHour(10);
		testTaskVO2.setBeginDate(new Date(77772277L));
		testTaskVO2.setCloseDate(new Date(55552222L));
		dao.update(testTaskVO2);

		// �R��
		dao.delete(2);

		// �d��
		TaskVO testTaskVO3 = dao.findByPrimaryKey(1);
		System.out.print(testTaskVO3.getTaskId() + ",");
		System.out.print(testTaskVO3.getName() + ",");
		System.out.print(testTaskVO3.getContentFile() + ",");
		System.out.print(testTaskVO3.getReward() + ",");
		System.out.print(testTaskVO3.getPeriodHour() + ",");
		System.out.print(testTaskVO3.getBeginDate() + ",");
		System.out.println(testTaskVO3.getCloseDate() + ",");
		System.out.println("----------------------------");

		// �d��
		List<TaskVO> list = dao.getAll();
		for (TaskVO aTestTaskVO : list) {
			System.out.print(aTestTaskVO.getTaskId() + ",");
			System.out.print(aTestTaskVO.getName() + ",");
			System.out.print(aTestTaskVO.getContentFile() + ",");
			System.out.print(aTestTaskVO.getReward() + ",");
			System.out.print(aTestTaskVO.getPeriodHour() + ",");
			System.out.print(aTestTaskVO.getBeginDate() + ",");
			System.out.print(aTestTaskVO.getCloseDate() + ",");
			System.out.println();
		}

    }

}


