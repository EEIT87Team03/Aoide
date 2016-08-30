package com.aoide.global.dataBaseManipulationObjects.tokenRecord;

import java.util.List;

public class TestTokenRecordDAO {

	public static void main(String[] args) {
		
		TokenRecordDAOInstance dao = new TokenRecordDAOInstance();
		
		// TODO Auto-generated method stub
		
		//新增
		/*TokenRecordVO tokenrecordVO1 = new TokenRecordVO();
		tokenrecordVO1.setRecipientId(1);
		tokenrecordVO1.setTokenVolume(123);
		tokenrecordVO1.setsponsorBalance(123);
		tokenrecordVO1.setRecipienBalance(123);
		dao.insert(tokenrecordVO1);*/
		
		//修改
		/*TokenRecordVO tokenrecordVO2 = new TokenRecordVO();
		tokenrecordVO2.setTokenVolume(555);
		tokenrecordVO2.setTokenRecordId(10);
		dao.update(tokenrecordVO2);*/
		
		//刪除
		//dao.delete(10);
		
		
		
		
		//查詢一筆資料
		/*TokenRecordVO tokenrecordVO3 = dao.findByPrimaryKey(10); 
		System.out.println(tokenrecordVO3.getTokenRecordId());
		System.out.println(tokenrecordVO3.getDate());
		System.out.println(tokenrecordVO3.getRecipientId());
		System.out.println(tokenrecordVO3.getTokenVolume());
		System.out.println(tokenrecordVO3.getSponsorBalance());
		System.out.println(tokenrecordVO3.getRecipienBalance());*/

		
		//查詢多筆資料
		List<TokenRecordVO> list= dao.getAll(); 
		
		for (TokenRecordVO tokenrecordVO4 : list){
			System.out.println(tokenrecordVO4.getTokenRecordId());
			System.out.println(tokenrecordVO4.getDate());
			System.out.println(tokenrecordVO4.getRecipientId());
			System.out.println(tokenrecordVO4.getTokenVolume());
			System.out.println(tokenrecordVO4.getSponsorBalance());
			System.out.println(tokenrecordVO4.getRecipienBalance());
		}
		

		
		
	}

}
