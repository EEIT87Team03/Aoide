package com.aoide.global.dataBaseManipulationObjects.taskRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;
import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionVO;

public class JdbcTaskRecordDAO implements TaskRecordDAO {
	// String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// String url = "jdbc:sqlserver://localhost:????;DatabaseName=AOIDE";
	// String userid = "sa";
	// String passwd = "sa123456";

	private static final String INSERT_STMT = new StringBuffer()
			                                 .append("INSERT INTO taskrecord(")
			                                 .append("task_id,")
			                                 .append("member_id) ")
			                                 .append("VALUES(?,?)")
			                                 .toString();

	private static final String UPDATE_STMT = new StringBuffer()
	                                         .append("UPDATE taskrecord ")
                                             .append("SET ")
                                             .append("task_id = ?,")
                                             .append("member_id = ? ") 
                                             .append("WHERE task_id = ? AND member_id = ?")
                                             .toString();

	private static final String DELETE_STMT = "DELETE FROM taskrecord WHERE task_id = ? AND member_id = ?";
	
	private static final String GET_ONE_STMT = new StringBuffer()
	                                         .append("SELECT ")
                                             .append("task_id,")
                                             .append("member_id,")
                                             .append("complete_date ")
                                             .append("FROM taskrecord ")
                                             .append("WHERE task_id = ? AND member_id = ?")
                                             .toString();
	
	private static final String GET_ALL_STMT = new StringBuffer()
	                                         .append("SELECT ")
                                             .append("task_id,")
                                             .append("member_id,")
                                             .append("complete_date ")
                                             .append("FROM taskrecord ")
                                             .toString();
	// Constructors
	public JdbcTaskRecordDAO() {

	}

	// Method
	@Override
	public Integer insert(TaskRecordVO taskrecordVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet keys = null;
		Integer id = null;

		try {
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, taskrecordVO.getTaskId());
			pstmt.setInt(2, taskrecordVO.getMemberId());
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
	public void update(TaskRecordVO taskrecordVO1, TaskRecordVO taskrecordVO2) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, taskrecordVO1.getTaskId());
			pstmt.setInt(2, taskrecordVO1.getMemberId());
			pstmt.setInt(1, taskrecordVO2.getTaskId());
			pstmt.setInt(2, taskrecordVO2.getMemberId());
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
	public void delete(Integer taskId,Integer memberId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
			 
			pstmt.setInt(1, taskId);
	        pstmt.setInt(2, memberId);
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
	public TaskRecordVO findByPrimaryKey(Integer taskId,Integer memberId) {
		TaskRecordVO taskrecordVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, taskId);
	        pstmt.setInt(2, memberId);
	        rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				taskrecordVO = new TaskRecordVO();
				taskrecordVO.setTaskId(rs.getInt("task_id"));
				taskrecordVO.setMemberId(rs.getInt("member_id"));			
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
		return taskrecordVO;

	}

	@Override
	public List<TaskRecordVO> getAll() {
		List<TaskRecordVO> list = new ArrayList<TaskRecordVO>();
		TaskRecordVO taskrecordVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ConnectionBean.getConnection();
			pstmt = conn.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				taskrecordVO = new TaskRecordVO();
				taskrecordVO.setTaskId(rs.getInt("task_id"));
				taskrecordVO.setMemberId(rs.getInt("member_id"));
				list.add(taskrecordVO); // Store the row in the list
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