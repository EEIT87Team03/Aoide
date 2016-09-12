package com.aoide.global.dataBaseManipulationObjects.ad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;
import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionVO;

public class JdbcAdDAO implements AdDAO {
	// String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// String url = "jdbc:sqlserver://localhost:????;DatabaseName=AOIDE";
	// String userid = "sa";
	// String passwd = "sa123456";

	private static final String INSERT_STMT = new StringBuffer()
			                                 .append("INSERT INTO ad(")
			                                 .append("ad_img) ")
			                                 .append("VALUES(?)")
			                                 .toString();

	private static final String UPDATE_STMT = new StringBuffer()
			                                 .append("UPDATE ad ")
			                                 .append("SET ")
			                                 .append("ad_img = ? ") 
			                                 .append("WHERE song_id = ?")
			                                 .toString();

	private static final String DELETE_STMT = "DELETE FROM ad WHERE song_id = ?";
	
	private static final String GET_ONE_STMT = new StringBuffer()
			                                 .append("SELECT ")
			                                 .append("song_id,")
			                                 .append("ad_img ")
			                                 .append("FROM ad ")
			                                 .append("WHERE song_id = ?")
			                                 .toString();
	
	private static final String GET_ALL_STMT = new StringBuffer()
			                                 .append("SELECT ")
			                                 .append("song_id,")
			                                 .append("ad_img ")
			                                 .append("FROM ad")
			                                 .toString();

	// Constructors
	public JdbcAdDAO() {

	}

	// Method
	@Override
	public Integer insert(AdVO adVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet keys = null;
		Integer id = null;

		try {
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, adVO.getAdImg());
			pstmt.executeUpdate();
			// get generated key
			keys = pstmt.getGeneratedKeys();
			if (keys.next()) {
				id = (Integer) keys.getInt(1);
			}

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
			if (keys != null) {
				try {
					keys.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}

		}
		return id;
	}

	@Override
	public void update(AdVO adVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setString(1, adVO.getAdImg());
			pstmt.setInt(2, adVO.getSongId());
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
	public void delete(Integer songId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, songId);
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
	public AdVO findByPrimaryKey(Integer songId) {
		AdVO adVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, songId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				adVO = new AdVO();
				adVO.setSongId(rs.getInt("song_id"));
				adVO.setAdImg(rs.getString("ad_img"));
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
		return adVO;

	}

	@Override
	public List<AdVO> getAll() {
		List<AdVO> list = new ArrayList<AdVO>();
		AdVO adVO = null;
        Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ConnectionBean.getConnection();
			pstmt = conn.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				adVO = new AdVO();
				adVO.setSongId(rs.getInt("song_id"));
				adVO.setAdImg(rs.getString("ad_img"));
				list.add(adVO); // Store the row in the list
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
