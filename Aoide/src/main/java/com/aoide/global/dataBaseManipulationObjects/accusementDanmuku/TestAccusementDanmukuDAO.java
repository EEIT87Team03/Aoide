package com.aoide.global.dataBaseManipulationObjects.accusementDanmuku;

import java.util.List;

public class TestAccusementDanmukuDAO {

	public static void main(String[] args) {
		JdbcAccusementDanmukuDAO dao = new JdbcAccusementDanmukuDAO();
		
/*	
		// �s�W
		AccusementDanmukuVO accusementDanmukuVO1 = new AccusementDanmukuVO();
		accusementDanmukuVO1.setAccuseId(4);
		accusementDanmukuVO1.setAccusedId(4);
		accusementDanmukuVO1.setContentFile("test insert path");
		accusementDanmukuVO1.setDanmukuContent("0910 test");
		accusementDanmukuVO1.setState(false);
		dao.insert(accusementDanmukuVO1);
			
		// �ק�
		AccusementDanmukuVO accusementDanmukuVO2 = new AccusementDanmukuVO();
		accusementDanmukuVO2.setAccuseId(2);
		accusementDanmukuVO2.setAccusedId(1);
		accusementDanmukuVO2.setContentFile("0910 test update");
		accusementDanmukuVO2.setAccusementDanmukuId(11);
		accusementDanmukuVO2.setDanmukuContent("0910 test update");
		accusementDanmukuVO2.setState(false);
		dao.update(accusementDanmukuVO2);
*/		
		// �R��
		dao.delete(11);
		
	
/*
		// �d��
		AccusementDanmukuVO accusementDanmukuVO3 = dao.findByPrimaryKey(4);
		System.out.print(accusementDanmukuVO3.getAccusementDanmukuId() + ",");
		System.out.print(accusementDanmukuVO3.getDate() + ",");
		System.out.print(accusementDanmukuVO3.getAccuseId() + ",");
		System.out.print(accusementDanmukuVO3.getAccusedId() + ",");
		System.out.print(accusementDanmukuVO3.getContentFile() + ",\n");
		System.out.print(accusementDanmukuVO3.getDanmukuContent() + ",\n");
		System.out.print(accusementDanmukuVO3.getState() + ",\n");
		System.out.println("---------------------");

		
		// �d��
		List<AccusementDanmukuVO> list = dao.getAll();
		for (AccusementDanmukuVO aAccusementDanmukuVO : list) {
			System.out.print(aAccusementDanmukuVO.getAccusementDanmukuId() + ",");
			System.out.print(aAccusementDanmukuVO.getDate() + ",");
			System.out.print(aAccusementDanmukuVO.getAccuseId() + ",");
			System.out.print(aAccusementDanmukuVO.getAccusedId() + ",");
			System.out.print(aAccusementDanmukuVO.getContentFile() + ",");
			System.out.print(aAccusementDanmukuVO.getDanmukuContent() + ",");
			System.out.print(aAccusementDanmukuVO.getState());
			System.out.println();
		}
*/	
	}

}
