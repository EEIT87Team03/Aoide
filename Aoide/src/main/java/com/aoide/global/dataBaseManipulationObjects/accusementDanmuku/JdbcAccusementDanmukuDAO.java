package com.aoide.global.dataBaseManipulationObjects.accusementDanmuku;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;

public class JdbcAccusementDanmukuDAO implements AccusementDanmukuDAO {
	// Fields
	private static final String INSERT_STMT = new StringBuffer()
			.append("INSERT INTO accusement_danmuku(")
			.append("[accuse_id],")
			.append("[accused_id],")
			.append("[content_file])")
			.append("VALUES(?,?,?)")
			.toString();

	private static final String UPDATE_STMT = new StringBuffer()
			.append("UPDATE accusement_danmuku ")
			.append("SET ")
			.append("[accuse_id] = ?,")
			.append("[accused_id] = ?,")
			.append("[content_file] = ? ")
			.append("WHERE [accusement_danmuku_id] = ?")
			.toString();

	private static final String DELETE_STMT = "DELETE FROM accusement_danmuku WHERE accusement_danmuku_id = ?";
	private static final String GET_ONE_STMT = new StringBuffer()
			.append("SELECT ") 
			.append("[accusement_danmuku_id],") 
			.append("[date],") 
			.append("[accuse_id],") 
			.append("[accused_id],") 
			.append("[content_file] ") 
			.append("FROM accusement_danmuku ") 
			.append("WHERE [accusement_danmuku_id] = ?")
			.toString();

	private static final String GET_ALL_STMT = new StringBuffer()
			.append("SELECT ") 
			.append("[accusement_danmuku_id],") 
			.append("[date],") 
			.append("[accuse_id],") 
			.append("[accused_id],") 
			.append("[content_file] ") 
			.append("FROM accusement_danmuku") 
			.toString();

	
	
	// Methods
	@Override
	public void insert(AccusementDanmukuVO accusementDanmukuVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, accusementDanmukuVO.getAccuseId());
			pstmt.setInt(2, accusementDanmukuVO.getAccusedId());
			pstmt.setString(3, accusementDanmukuVO.getContentFile());

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
	public void update(AccusementDanmukuVO accusementDanmukuVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, accusementDanmukuVO.getAccuseId());
			pstmt.setInt(2, accusementDanmukuVO.getAccusedId());
			pstmt.setString(3, accusementDanmukuVO.getContentFile());
			pstmt.setInt(4, accusementDanmukuVO.getAccusementDanmukuId());

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
	public void delete(Integer accusementDanmukuId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, accusementDanmukuId);
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
	public AccusementDanmukuVO findByPrimaryKey(Integer accusementDanmukuId) {
		AccusementDanmukuVO accusementDanmukuVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, accusementDanmukuId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				accusementDanmukuVO = new AccusementDanmukuVO();
				accusementDanmukuVO.setAccusementDanmukuId(rs.getInt("accusement_danmuku_id"));
				accusementDanmukuVO.setDate(rs.getTimestamp("date"));
				accusementDanmukuVO.setAccuseId(rs.getInt("accuse_id"));
				accusementDanmukuVO.setAccusedId(rs.getInt("accused_id"));
				accusementDanmukuVO.setContentFile(rs.getString("content_file"));
								
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			se.printStackTrace();
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
		return accusementDanmukuVO;
	}

	@Override
	public List<AccusementDanmukuVO> getAll() {
		List<AccusementDanmukuVO> list = new ArrayList<AccusementDanmukuVO>();
		AccusementDanmukuVO accusementDanmukuVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ConnectionBean.getConnection();
			pstmt = conn.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				accusementDanmukuVO = new AccusementDanmukuVO();
				accusementDanmukuVO.setAccusementDanmukuId(rs.getInt("accusement_danmuku_id"));
				accusementDanmukuVO.setDate(rs.getTimestamp("date"));
				accusementDanmukuVO.setAccuseId(rs.getInt("accuse_id"));
				accusementDanmukuVO.setAccusedId(rs.getInt("accused_id"));
				accusementDanmukuVO.setContentFile(rs.getString("content_file"));
				list.add(accusementDanmukuVO); // Store the row in the list
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

	public static void main(String[] args) {
		System.out.println(INSERT_STMT);
		System.out.println(UPDATE_STMT);
		System.out.println(DELETE_STMT);
		System.out.println(GET_ONE_STMT);
		System.out.println(GET_ALL_STMT);
	}

}
