package com.aoide.global.dataBaseManipulationObjects.accusementDanmuku;

import java.util.List;

public class TestAccusementDanmukuDAO {

	public static void main(String[] args) {
		AccusementDanmukuDAOInstance dao = new AccusementDanmukuDAOInstance();
		
		
		// �s�W
		AccusementDanmukuVO accusementDanmukuVO1 = new AccusementDanmukuVO();
		accusementDanmukuVO1.setAccuseId(4);
		accusementDanmukuVO1.setAccusedId(4);
		accusementDanmukuVO1.setContentFile("test insert path");
		dao.insert(accusementDanmukuVO1);

		// �ק�
		AccusementDanmukuVO accusementDanmukuVO2 = new AccusementDanmukuVO();
		accusementDanmukuVO2.setAccuseId(2);
		accusementDanmukuVO2.setAccusedId(1);
		accusementDanmukuVO2.setContentFile("test update path");
		accusementDanmukuVO2.setAccusementDanmukuId(3);
		dao.update(accusementDanmukuVO2);
		
		// �R��
		dao.delete(3);
		
	
		// �d��
		AccusementDanmukuVO accusementDanmukuVO3 = dao.findByPrimaryKey(4);
		System.out.print(accusementDanmukuVO3.getAccusementDanmukuId() + ",");
		System.out.print(accusementDanmukuVO3.getDate() + ",");
		System.out.print(accusementDanmukuVO3.getAccuseId() + ",");
		System.out.print(accusementDanmukuVO3.getAccusedId() + ",");
		System.out.print(accusementDanmukuVO3.getContentFile() + ",\n");
		System.out.println("---------------------");
	
		
		// �d��
		List<AccusementDanmukuVO> list = dao.getAll();
		for (AccusementDanmukuVO aAccusementDanmukuVO : list) {
			System.out.print(aAccusementDanmukuVO.getAccusementDanmukuId() + ",");
			System.out.print(aAccusementDanmukuVO.getDate() + ",");
			System.out.print(aAccusementDanmukuVO.getAccuseId() + ",");
			System.out.print(aAccusementDanmukuVO.getAccusedId() + ",");
			System.out.print(aAccusementDanmukuVO.getContentFile() + ",");
			System.out.println();
		}

	}

}
