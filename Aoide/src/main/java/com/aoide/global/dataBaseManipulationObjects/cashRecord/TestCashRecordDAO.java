package com.aoide.global.dataBaseManipulationObjects.cashRecord;

import java.util.List;

public class TestCashRecordDAO {

	public static void main(String[] args) {
		
		JdbcCashRecordDAO dao = new JdbcCashRecordDAO();
		
		// TODO Auto-generated method stub
		
		//新增
		/*CashRecordVO cashrecordVO1 = new CashRecordVO();
		cashrecordVO1.setSponsorId(1);
		cashrecordVO1.setRecipientId(2);
		cashrecordVO1.setCashVolume(9999);
		cashrecordVO1.setTokenVolume(9999);
		cashrecordVO1.setType(1);
		dao.insert(cashrecordVO1);*/
		
		//修改
		/*CashRecordVO cashrecordVO2 = new CashRecordVO();
		cashrecordVO2.setCashVolume(555);
		cashrecordVO2.setCashRecordId(10);
		dao.update(cashrecordVO2);*/
		
		//刪除
		/*dao.delete(10);*/
		
		
		
		
		//查詢一筆資料
		/*CashRecordVO cashrecordVO3 = dao.findByPrimaryKey(11); 
		System.out.println(cashrecordVO3.getCashRecordId());
		System.out.println(cashrecordVO3.getDate());
		System.out.println(cashrecordVO3.getSponsorId());
		System.out.println(cashrecordVO3.getRecipientId());
		System.out.println(cashrecordVO3.getCashVolume());
		System.out.println(cashrecordVO3.getTokenVolume());
		System.out.println(cashrecordVO3.getType());*/

		
		//查詢多筆資料
		List<CashRecordVO> list= dao.getAll(); 
		
		for (CashRecordVO cashrecordVO4 : list){
			System.out.println(cashrecordVO4.getCashRecordId());
			System.out.println(cashrecordVO4.getDate());
			System.out.println(cashrecordVO4.getSponsorId());
			System.out.println(cashrecordVO4.getRecipientId());
			System.out.println(cashrecordVO4.getCashVolume());
			System.out.println(cashrecordVO4.getTokenVolume());
			System.out.println(cashrecordVO4.getType());
		}
		

		
		
	}

}
