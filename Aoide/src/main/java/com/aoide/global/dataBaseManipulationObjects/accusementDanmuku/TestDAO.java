package com.aoide.global.dataBaseManipulationObjects.accusementDanmuku;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

public class TestDAO {

	public static void main(String[] args) {
		Connection conn = null;
		HibernateAccusementDanmukuDAO dao = null;
		List<HibernateAccusementDanmukuVO> voList = null;
		
		try{
			conn = ConnectionBean.getConnection();
			dao = new HibernateAccusementDanmukuDAO(conn);
			voList = dao.getAll();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		MemberVO accuse = null;
		MemberVO accused = null;
		String row = null;
		for (HibernateAccusementDanmukuVO vo :voList ){
			accuse = vo.getAccuse();
			accused = vo.getAccused();
			row = new StringBuffer().append("id: ").append(vo.getAccusementDanmukuId())
					                    .append("/ accuse name: ").append(accuse.getName())
					                    .append("/ accused name: ").append(accused.getName())
					                    .append("\n").toString();
			System.out.println(row);
		}
	
		
	}// end main

}
