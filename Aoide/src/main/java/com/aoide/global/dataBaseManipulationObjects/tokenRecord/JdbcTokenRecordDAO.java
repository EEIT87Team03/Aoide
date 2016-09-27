package com.aoide.global.dataBaseManipulationObjects.tokenRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;

public class JdbcTokenRecordDAO implements TokenRecordDAO{
	
	private static final String INSERT_STMT = new StringBuffer()
													.append("INSERT INTO ")
													.append("token_record")
													.append("(")
													.append("recipient_id,")
													.append("token_volume,")
													.append("sponsor_balance,")
													.append("recipien_balance,")
													.append("sponsor_id")
													.append(") ")
													.append("VALUES(?,?,?,?,?)")
													.toString();
	
	
	private static final String UPDATE_STMT = new StringBuffer()
													.append("UPDATE ")
													.append("token_record ")
													.append("SET ")
													.append("token_volume = ? ")
													.append("WHERE ")
													.append("token_record_id = ?")
													.toString();
	
	
	private static final String DELETE_STMT = new StringBuffer()
													.append("DELETE FROM ")
													.append("token_record ")
													.append("WHERE ")
													.append("token_record_id = ?")
													.toString();
	
	private static final String GET_ONE_STMT = new StringBuffer()
													.append("SELECT")
													.append(" token_record_id,")
													.append("date,")
													.append("recipient_id,")
													.append("token_volume,")
													.append("sponsor_balance,")
													.append("recipien_balance ")
													.append("FROM ")
													.append("token_record ")
													.append("WHERE ")
													.append("token_record_id = ?")
													.toString();
	
	private static final String GET_ALL_BY_ID_STMT = new StringBuffer()
													.append("SELECT")
													.append(" token_record_id,")
													.append("date,")
													.append("recipient_id,")
													.append("token_volume,")
													.append("sponsor_balance,")
													.append("recipien_balance ")
													.append("FROM ")
													.append("token_record ")
													.append("WHERE ")
													.append("recipient_id = ? OR sponsor_id = ?")
													.toString();
	
	private static final String GET_ALL_STMT = new StringBuffer()
													.append("SELECT ")
													.append("token_record_id,")
													.append("date,")
													.append("recipient_id,")
													.append("token_volume,")
													.append("sponsor_balance,")
													.append("recipien_balance ")
													.append("FROM ")
													.append("token_record ")
													.append("ORDER BY ")
													.append("token_record_id")
													.toString();
													
	
	public JdbcTokenRecordDAO(){
		
	}
	
	@Override
	public void insert(TokenRecordVO TokenRecordVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, TokenRecordVO.getRecipientId());
			pstmt.setInt(2, TokenRecordVO.getTokenVolume());
			pstmt.setInt(3, TokenRecordVO.getSponsorBalance());
			pstmt.setInt(4, TokenRecordVO.getRecipienBalance());
			pstmt.setInt(5, TokenRecordVO.getSponsorId());

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
	public void update(TokenRecordVO TokenRecordVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, TokenRecordVO.getTokenVolume());
			pstmt.setInt(2, TokenRecordVO.getTokenRecordId());


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
	public void delete(Integer token_record_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, token_record_id);
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
	public TokenRecordVO findByPrimaryKey(Integer token_record_id) {
		TokenRecordVO tokenRecordVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, token_record_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				tokenRecordVO = new TokenRecordVO();
				tokenRecordVO.setTokenRecordId(rs.getInt("token_record_id"));
				tokenRecordVO.setDate(rs.getDate("date"));
				tokenRecordVO.setRecipientId(rs.getInt("recipient_id"));
				tokenRecordVO.setTokenVolume(rs.getInt("token_volume"));
				tokenRecordVO.setsponsorBalance(rs.getInt("sponsor_balance"));
				tokenRecordVO.setRecipienBalance(rs.getInt("recipien_balance"));
								
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
		return tokenRecordVO;

	}

	@Override
	public List<TokenRecordVO> getAll() {
		List<TokenRecordVO> list = new ArrayList<TokenRecordVO>();
		TokenRecordVO tokenRecordVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ConnectionBean.getConnection();
			pstmt = conn.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				tokenRecordVO = new TokenRecordVO();
				tokenRecordVO.setTokenRecordId(rs.getInt("token_record_id"));
				tokenRecordVO.setDate(rs.getDate("date"));
				tokenRecordVO.setRecipientId(rs.getInt("recipient_id"));
				tokenRecordVO.setTokenVolume(rs.getInt("token_volume"));
				tokenRecordVO.setsponsorBalance(rs.getInt("sponsor_balance"));
				tokenRecordVO.setRecipienBalance(rs.getInt("recipien_balance"));
				list.add(tokenRecordVO); // Store the row in the list
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
	public List<TokenRecordVO> findByRecipientId(Integer id) {
		List<TokenRecordVO> list = new ArrayList<TokenRecordVO>();
		TokenRecordVO tokenRecordVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ConnectionBean.getConnection();
			pstmt = conn.prepareStatement(GET_ALL_BY_ID_STMT);
			pstmt.setInt(1, id);
			pstmt.setInt(2, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				tokenRecordVO = new TokenRecordVO();
				tokenRecordVO.setTokenRecordId(rs.getInt("token_record_id"));
				tokenRecordVO.setDate(rs.getDate("date"));
				tokenRecordVO.setRecipientId(rs.getInt("recipient_id"));
				tokenRecordVO.setTokenVolume(rs.getInt("token_volume"));
				tokenRecordVO.setsponsorBalance(rs.getInt("sponsor_balance"));
				tokenRecordVO.setRecipienBalance(rs.getInt("recipien_balance"));
				list.add(tokenRecordVO); // Store the row in the list
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
