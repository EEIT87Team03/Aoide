package com.aoide.manager._28_ManageAccusement.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;
import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.HibernateAccusementDanmukuDAO;
import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.HibernateAccusementDanmukuVO;

public class ManageAccusementService {
	// Fields
	Connection conn = null;
	HibernateAccusementDanmukuDAO dao = null;
	// Constructors
	public ManageAccusementService() {
		conn = ConnectionBean.getConnection();
		dao = new HibernateAccusementDanmukuDAO(conn);
	}
	// Methods
	public List<HibernateAccusementDanmukuVO> getAllAccusement() {
		List<HibernateAccusementDanmukuVO> accusements = null;
		try{
			accusements = dao.getAll();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return accusements;
	}
	public void removeAccusement(Integer accusementDanmukuId) {
		try{
			dao.delete(accusementDanmukuId);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
