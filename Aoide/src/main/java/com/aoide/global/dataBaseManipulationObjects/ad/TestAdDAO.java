package com.aoide.global.dataBaseManipulationObjects.ad;

import java.util.List;

public class TestAdDAO {

	public static void main(String[] args) {
		AdDAO dao = new JdbcAdDAO();
		
		
//		// �s�W
//		AdVO adVO1 = new AdVO ();
//		adVO1.setAdImg("七八九");
//		dao.insert(adVO1);
     
		// �ק�
//		AdVO adVO2 = new AdVO();
//		adVO2.setAdImg("掰掰");
//		adVO2.setSongId(0);
//		dao.update(adVO2);

//		// �R��
		dao.delete(2);
		
//		// �d��
//		
//		AdVO adVO3 = dao.findByPrimaryKey(0);
//		System.out.print(adVO3.getSongId() + ",");
//		System.out.println(adVO3.getAdImg() + ",");
//		System.out.println("---------------------");
////
////		// �d��
//		List<AdVO> list = dao.getAll();
//		for (AdVO aAdVO : list) {
//			System.out.print(aAdVO.getSongId() + ",");
//			System.out.print(aAdVO.getAdImg() + ",");
//			System.out.println();
//		}
    }
}


