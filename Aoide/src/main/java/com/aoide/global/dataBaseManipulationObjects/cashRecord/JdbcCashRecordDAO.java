package com.aoide.global.dataBaseManipulationObjects.cashRecord;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox.KeySelectionManager;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;

public class JdbcCashRecordDAO implements CashRecordDAO{
	
	private static final String INSERT_STMT = 
			"INSERT INTO cash_record (sponsor_id,recipient_id,cash_volume,token_volume,type) VALUES (?,?,?,?,?)";
	private static final String UPDATE_STMT = 
			"UPDATE cash_record SET cash_volume = ? WHERE cash_record_id = ?";
	private static final String DELETE_STMT = 
			"DELETE FROM cash_record WHERE cash_record_id = ?";
	private static final String GET_ONE_STMT =
			"SELECT cash_record_id,date,sponsor_id,recipient_id,cash_volume,token_volume,type FROM cash_record WHERE cash_record_id = ?";
	private static final String GET_BY_ID =
			"SELECT cash_record_id,date,sponsor_id,recipient_id,cash_volume,token_volume,type FROM cash_record WHERE sponsor_id = ? OR recipient_id = ?";	
	private static final String GET_ALL_STMT = 
			"SELECT cash_record_id,date,sponsor_id,recipient_id,cash_volume,token_volume,type FROM cash_record ORDER BY cash_record_id";
	@Override
	public Integer insert(CashRecordVO CashRecordVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		Integer id = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT,Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1, CashRecordVO.getSponsorId());
			pstmt.setInt(2, CashRecordVO.getRecipientId());
			pstmt.setInt(3, CashRecordVO.getCashVolume());
			pstmt.setInt(4, CashRecordVO.getTokenVolume());
			pstmt.setInt(5, CashRecordVO.getType());
			
			pstmt.executeUpdate();
			
			ResultSet keys = pstmt.getGeneratedKeys();
			if(keys.next()){
				id = (Integer) keys.getInt(1);	
			}
			return id;
			

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		
		

	}
	@Override
	public void update(CashRecordVO CashRecordVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, CashRecordVO.getCashVolume());
			pstmt.setInt(2, CashRecordVO.getCashRecordId());


			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	@Override
	public void delete(Integer cash_record_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, cash_record_id);
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	@Override
	public CashRecordVO findByPrimaryKey(Integer cash_record_id) {
		CashRecordVO cashRecordVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, cash_record_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				cashRecordVO = new CashRecordVO();
				cashRecordVO.setCashRecordId(rs.getInt("cash_record_id"));
				cashRecordVO.setDate(rs.getDate("date"));
				cashRecordVO.setSponsorId(rs.getInt("sponsor_id"));
				cashRecordVO.setRecipientId(rs.getInt("recipient_id"));
				cashRecordVO.setCashVolume(rs.getInt("cash_volume"));
				cashRecordVO.setTokenVolume(rs.getInt("token_volume"));
				cashRecordVO.setType(rs.getInt("type"));
								
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return cashRecordVO;

	}
	@Override
	public List<CashRecordVO> getAll() {
		List<CashRecordVO> list = new ArrayList<CashRecordVO>();
		CashRecordVO cashRecordVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ConnectionBean.getConnection();
			pstmt = conn.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				cashRecordVO = new CashRecordVO();
				cashRecordVO.setCashRecordId(rs.getInt("cash_record_id"));
				cashRecordVO.setDate(rs.getDate("date"));
				cashRecordVO.setSponsorId(rs.getInt("sponsor_id"));
				cashRecordVO.setRecipientId(rs.getInt("recipient_id"));
				cashRecordVO.setCashVolume(rs.getInt("cash_volume"));
				cashRecordVO.setTokenVolume(rs.getInt("token_volume"));
				cashRecordVO.setType(rs.getInt("type"));
				list.add(cashRecordVO); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;

	}
	
	@Override
	public List<CashRecordVO> findById(Integer id) {
		List<CashRecordVO> list = new ArrayList<CashRecordVO>();
		CashRecordVO cashRecordVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ConnectionBean.getConnection();
			pstmt = conn.prepareStatement(GET_BY_ID);
			pstmt.setInt(1, id);
			pstmt.setInt(2, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				cashRecordVO = new CashRecordVO();
				cashRecordVO.setCashRecordId(rs.getInt("cash_record_id"));
				cashRecordVO.setDate(rs.getDate("date"));
				cashRecordVO.setSponsorId(rs.getInt("sponsor_id"));
				cashRecordVO.setRecipientId(rs.getInt("recipient_id"));
				cashRecordVO.setCashVolume(rs.getInt("cash_volume"));
				cashRecordVO.setTokenVolume(rs.getInt("token_volume"));
				cashRecordVO.setType(rs.getInt("type"));
				list.add(cashRecordVO); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;

	}
	
	
}
