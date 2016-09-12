package com.aoide.global.dataBaseManipulationObjects.bullet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;



public class JdbcBulletDAO implements BulletDAO {
	// Fields
	private static final String INSERT_STMT = new StringBuffer()
													.append("INSERT INTO bullet(")
													.append("date,")
													.append("title,")
													.append("content_file) ")
													.append("VALUES(?,?,?)")
													.toString();
			
	private static final String UPDATE_STMT = new StringBuffer()
													.append("UPDATE bullet ")
													.append("SET ")
													.append("date = ?,")
													.append("title = ?,")
													.append("content_file = ? ")
													.append("WHERE bullet_id = ?")
													.toString();

	private static final String DELETE_STMT = "DELETE FROM bullet WHERE bullet_id = ?";
	
	private static final String GET_ONE_STMT = new StringBuffer()
													.append("SELECT ") 
													.append("bullet_id,") 
													.append("date,") 
													.append("title,") 
													.append("content_file ") 
													.append("FROM bullet ") 
													.append("WHERE bullet_id = ?")
													.toString();
	
	private static final String GET_ALL_STMT = new StringBuffer()
	.append("SELECT ") 
	.append("bullet_id,") 
	.append("date,") 
	.append("title,") 
	.append("content_file ") 
	.append("FROM bullet ") 
	.toString();
	
	// Constructors
	public JdbcBulletDAO() {
		
	}

	// Method
	
	@Override
	public Integer insert(BulletVO bulletVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet keys = null;
		Integer id = null;

		try {
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setDate(1,bulletVO.getDate());
			pstmt.setString(2,bulletVO.getTitle());
			pstmt.setString(3,bulletVO.getContentFile());
			pstmt.executeUpdate();
			// get generated key
			keys = pstmt.getGeneratedKeys();
			if(keys.next()){
				id = (Integer)keys.getInt(1);
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
			if (keys != null){
				try{
					keys.close();
				}catch(Exception e){
					e.printStackTrace(System.err);
				}
			}
			
		}
		return id;
	}

	@Override
	public void update(BulletVO bulletVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setDate(1, bulletVO.getDate());
			pstmt.setString(2, bulletVO.getTitle());
			pstmt.setString(3, bulletVO.getContentFile());
			pstmt.setInt(4, bulletVO.getBulletId ());
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
	public void delete(Integer bullet_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, bullet_id);
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
	public BulletVO findByPrimaryKey(Integer bulletId) {
		BulletVO bulletVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, bulletId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				bulletVO = new BulletVO();
				bulletVO.setBulletId(rs.getInt("bullet_id"));
				bulletVO.setDate(rs.getDate("date"));
				bulletVO.setTitle(rs.getString("title"));
				bulletVO.setContentFile(rs.getString("content_file"));
											
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
		return bulletVO;

	}

	@Override
	public List<BulletVO> getAll() {
		List<BulletVO> list = new ArrayList<BulletVO>();
		BulletVO bulletVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ConnectionBean.getConnection();
			pstmt = conn.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				bulletVO = new BulletVO();
				bulletVO.setBulletId(rs.getInt("bullet_id"));
				bulletVO.setDate(rs.getDate("date"));
				bulletVO.setTitle(rs.getString("title"));
				bulletVO.setContentFile(rs.getString("content_file"));
				list.add(bulletVO); // Store the row in the list
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

