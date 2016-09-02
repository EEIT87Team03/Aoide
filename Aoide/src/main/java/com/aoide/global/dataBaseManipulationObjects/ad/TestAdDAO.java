package com.aoide.global.dataBaseManipulationObjects.ad;

import java.util.List;

public class TestAdDAO {

	public static void main(String[] args) {
		JdbcAdDAO dao = new JdbcAdDAO();
		
		
//		// �s�W
		AdVO adVO1 = new AdVO ();
		adVO1.setSongId(2);
		adVO1.setAdImg("七八九");
		dao.insert(adVO1);
//
////		// �ק�
		AdVO adVO2 = new AdVO();
		adVO2.setSongId(3);
		adVO2.setAdImg("十");
		dao.update(adVO2);
//
//		// �R��
//		dao.delete(2);

		// �d��
		
		AdVO adVO3 = dao.findByPrimaryKey(3);
		System.out.print(adVO3.getSongId() + ",");
		System.out.println(adVO3.getAdImg() + ",");
		System.out.println("---------------------");

		// �d��
		List<AdVO> list = dao.getAll();
		for (AdVO aAdVO : list) {
			System.out.print(aAdVO.getSongId() + ",");
			System.out.print(aAdVO.getAdImg() + ",");
			System.out.println();
		}
    }
}


