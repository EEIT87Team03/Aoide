package com.aoide.global.dataBaseManipulationObjects.bullet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;

public class JdbcBulletDAO implements BulletDAO {
//	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	String url = "jdbc:sqlserver://localhost:????;DatabaseName=AOIDE";
//	String userid = "sa";
//	String passwd = "sa123456";
	
	private static final String INSERT_STMT = "INSERT INTO bullet VALUES(?,?,?,?)";
	private static final String UPDATE_STMT = new StringBuffer()
	.append("UPDATE bullet").append(" SET ").append("date = ?, ")
	                                        .append("tiltle = ?, ")
	                                        .append("content_file = ? ")
	                                        .append("WHERE bullet_id = ?").toString();
			                                  
			                          
	private static final String GET_ONE_STMT = new StringBuffer()
			       .append("SELECT ").append("bullet_id , ")
                                     .append("date , ")
                                     .append("tiltle , ")
                                     .append("content_file  ")
                                     .append("FROM bullet ") 
                                     .append("WHERE bullet_id = ?").toString();
	
    			
	private static final String GET_ALL_STMT = " SELECT * FROM bullet ";
			     
    private static final String DELETE_STMT = " DELETE FROM bullet WHERE bullet_id = ? ";
	
	@Override
	public void insert(BulletVO bulletVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, bulletVO.getBulletId ());
			pstmt.setDate(2, bulletVO.getDate());
			pstmt.setString(3, bulletVO.getTiltle());
			pstmt.setString(4, bulletVO.getContentFile());
			pstmt.executeUpdate();
			
		}catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
//				// Handle any SQL errors
//			} catch (SQLException se) {
//				throw new RuntimeException("A database error occured. "
//						+ se.getMessage());
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
	public void update(BulletVO bulletVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			
			pstmt.setDate(1,bulletVO.getDate());
			pstmt.setString(2,bulletVO.getTiltle());
			pstmt.setString(3,bulletVO.getContentFile());
			pstmt.setInt(4,bulletVO.getBulletId ());
			pstmt.executeUpdate();
		
		
		}catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
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
	public void delete(Integer bulletId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
            pstmt.setInt(1, bulletId);
            pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " 
					+ se.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
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
	public BulletVO findByPrimaryKey(Integer bulletId) {

		BulletVO bulletVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
            pstmt.setInt(1, bulletId);
            rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				bulletVO = new BulletVO();
				bulletVO.setBulletId(rs.getInt("bullet_id"));
				bulletVO.setDate(rs.getDate("date"));
				bulletVO.setTiltle(rs.getString("tiltle"));
				bulletVO.setContentFile(rs.getString("content_file"));
					
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
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
		return bulletVO;
	}

	@Override
	public List<BulletVO> getAll() {
		List<BulletVO> list = new ArrayList<BulletVO>();
		BulletVO bulletVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				bulletVO = new BulletVO();
				bulletVO.setBulletId(rs.getInt("bullet_id"));
				bulletVO.setDate(rs.getDate("date"));
				bulletVO.setTiltle(rs.getString("tiltle"));
				bulletVO.setContentFile(rs.getString("content_file"));
				list.add(bulletVO); 
				// Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("Couldn't load database driver. "
					+ se.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
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
		return list;
	}

	public static void main(String[] args) {
		System.out.println(UPDATE_STMT);
	}
}


