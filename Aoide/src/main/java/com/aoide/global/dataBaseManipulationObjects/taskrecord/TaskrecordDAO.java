package com.aoide.global.dataBaseManipulationObjects.taskrecord;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;

public class TaskrecordDAO implements TaskrecordDAO_Inteface {
//	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	String url = "jdbc:sqlserver://localhost:????;DatabaseName=AOIDE";
//	String userid = "sa";
//	String passwd = "sa123456";
	
	private static final String INSERT_STMT = "INSERT INTO taskrecord(task_id, member_id) VALUES(?,?)";
	private static final String UPDATE_STMT = new StringBuffer().append("UPDATE taskrecord ")
			                                                    .append("SET ")
			                                                    .append("task_id = ?, ")
			                                                    .append("member_id = ? ") 
	                                                            .append("WHERE task_id = ? AND member_id = ?")
	                                                            .toString();
			                                  
			                          
	private static final String GET_ONE_STMT = new StringBuffer().append("SELECT ")
                                                                 .append("task_id, ")
                                                                 .append("member_id, ")
                                                                 .append("complete_date ")
                                                                 .append("FROM taskrecord ")
                                                                 .append("WHERE task_id = ? AND member_id = ?")
                                                                 .toString();
    			
			
	private static final String GET_ALL_STMT = new StringBuffer().append("SELECT ")
            													 .append("task_id, ")
                                                                 .append("member_id, ")
                                                                 .append("complete_date ")
                                                                 .append("FROM taskrecord")
                                                                 .toString();
				
	private static final String DELETE_STMT = "DELETE FROM taskrecord WHERE task_id = ? AND member_id = ?";
	
	@Override
	public void insert(TaskrecordVO taskrecordVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, taskrecordVO.getTaskId());
			pstmt.setInt(2, taskrecordVO.getMemberId());
		
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
	public void update(TaskrecordVO taskrecordVO1, TaskrecordVO taskrecordVO2) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, taskrecordVO1.getTaskId());
			pstmt.setInt(2, taskrecordVO1.getMemberId());
			pstmt.setInt(1, taskrecordVO2.getTaskId());
			pstmt.setInt(2, taskrecordVO2.getMemberId());
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
	public void delete(Integer task_id,Integer member_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
            pstmt.setInt(1, task_id);
            pstmt.setInt(2, member_id);
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
	public TaskrecordVO findByPrimaryKey(Integer taskId,Integer memberId) {

		TaskrecordVO taskrecordVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
            pstmt.setInt(1, taskId);
            pstmt.setInt(2, memberId);
            rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				taskrecordVO = new TaskrecordVO();
				taskrecordVO.setTaskId(rs.getInt("task_id"));
				taskrecordVO.setMemberId(rs.getInt("member_id"));
				
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
		return taskrecordVO;
	}

	@Override
	public List<TaskrecordVO> getAll() {
		List<TaskrecordVO> list = new ArrayList<TaskrecordVO>();
		TaskrecordVO taskrecordVO = null;

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
				taskrecordVO = new TaskrecordVO();
				taskrecordVO.setTaskId(rs.getInt("task_id"));
				taskrecordVO.setMemberId(rs.getInt("member_id"));
				
				list.add(taskrecordVO); // Store the row in the list
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
