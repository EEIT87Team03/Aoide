package com.aoide.global.dataBaseManipulationObjects.task;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;

public class JdbcTaskDAO implements TaskDAO {
//	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	String url = "jdbc:sqlserver://localhost:????;DatabaseName=AOIDE";
//	String userid = "sa";
//	String passwd = "sa123456";
	
	private static final String INSERT_STMT = "INSERT INTO task VALUES(?,?,?,?,?,?)";
	private static final String UPDATE_STMT = new StringBuffer().append("UPDATE task")
			                                                    .append(" SET ")
			                                                    .append("name =?, ")
			                                                    .append("content_file =?, ")
			                                                    .append("reward =?, ")
	                                                            .append("period_hour =?, ")
	                                                            .append("begin_date =?, ")
	                                                            .append("close_date =?  ")
	                                                            .append("WHERE task_id =?").toString();
			                                  
			                          
	private static final String GET_ONE_STMT = new StringBuffer().append("SELECT ")			                                                     
			                                                     .append("task_id, ") 
			                                                     .append("name , ")
			                                                     .append("content_file , ")
			                                                     .append("reward , ")
	                                                             .append("period_hour , ")
	                                                             .append("begin_date , ")
	                                                             .append("close_date  ")
	                                                             .append("FROM task ") 
	                                                             .append("WHERE task_id = ?").toString();
			
			
	private static final String GET_ALL_STMT = " SELECT * FROM task ";
			
	
	private static final String DELETE_STMT = "DELETE FROM task WHERE task_id = ?";
	
	@Override
	public void insert(TaskVO taskVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			//pstmt.setInt(1, taskVO.getTaskId());
			pstmt.setString(1, taskVO.getName());
			pstmt.setString(2, taskVO.getContentFile());
			pstmt.setDouble(3, taskVO.getReward());
			pstmt.setInt(4, taskVO.getPeriodHour());
			pstmt.setDate(5, taskVO.getBeginDate());
			pstmt.setDate(6, taskVO.getCloseDate());

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
	public void update(TaskVO taskVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setString(1, taskVO.getName());
			pstmt.setString(2, taskVO.getContentFile());
			
			System.out.println("aaa" + taskVO.getContentFile());
			
			pstmt.setDouble(3, taskVO.getReward());
			
			pstmt.setInt(4, taskVO.getPeriodHour());
			pstmt.setDate(5, taskVO.getBeginDate());
			pstmt.setDate(6, taskVO.getCloseDate());
			pstmt.setInt(7, taskVO.getTaskId());
			
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
	public void delete(Integer taskId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
            pstmt.setInt(1, taskId);
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
	public TaskVO findByPrimaryKey(Integer taskId) {

		TaskVO taskVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
            pstmt.setInt(1, taskId);
            rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				taskVO = new TaskVO();
				taskVO.setTaskId(rs.getInt("task_id"));
				taskVO.setName(rs.getString("name"));
				taskVO.setContentFile(rs.getString("content_file"));
				taskVO.setReward(rs.getDouble("reward"));
				taskVO.setPeriodHour(rs.getInt("period_hour"));
				taskVO.setBeginDate(rs.getDate("begin_date"));
				taskVO.setCloseDate(rs.getDate("close_date"));
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
		return taskVO;
	}

	@Override
	public List<TaskVO> getAll() {
		List<TaskVO> list = new ArrayList<TaskVO>();
		TaskVO taskVO = null;

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
				taskVO = new TaskVO();
				taskVO.setTaskId(rs.getInt("task_id"));
				taskVO.setName(rs.getString("name"));
				taskVO.setContentFile(rs.getString("content_file"));
				taskVO.setReward(rs.getDouble("reward"));
				taskVO.setPeriodHour(rs.getInt("period_hour"));
				taskVO.setBeginDate(rs.getDate("begin_date"));
				taskVO.setCloseDate(rs.getDate("close_date"));
				list.add(taskVO); 
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



   
