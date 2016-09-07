package com.aoide.global.dataBaseManipulationObjects.suggestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;


public class JdbcSuggestionDAO implements SuggestionDAO {
	// Fields
	private static final String INSERT_STMT = new StringBuffer()
													.append("INSERT INTO suggestion(")
													.append("suggestion_content_file,")
													.append("title) ")
													.append("VALUES(?,?)")
													.toString();
			
	private static final String UPDATE_STMT = new StringBuffer()
													.append("UPDATE suggestion ")
													.append("SET ")
													.append("suggestion_content_file = ?,")
													.append("reply_content_file = ?,")
													.append("reply_state = ? ")
													.append("WHERE suggestion_id = ?")
													.toString();

	private static final String DELETE_STMT = "DELETE FROM suggestion WHERE suggestion_id = ?";
	private static final String GET_ONE_STMT = new StringBuffer()
													.append("SELECT ") 
													.append("suggestion_id,") 
													.append("suggest_date,") 
													.append("title,") 
													.append("suggestion_content_file,") 
													.append("reply_content_file,") 
													.append("reply_state,") 
													.append("reply_date ") 
													.append("FROM suggestion ") 
													.append("WHERE suggestion_id = ?")
													.toString();
	private static final String GET_ALL_STMT = new StringBuffer()
			.append("SELECT ") 
			.append("suggestion_id,") 
			.append("suggest_date,") 
			.append("title,") 
			.append("suggestion_content_file,") 
			.append("reply_content_file,") 
			.append("reply_state,") 
			.append("reply_date ") 
			.append("FROM suggestion") 
			.toString();
	
	// Constructors
	public JdbcSuggestionDAO() {
		
	}

	// Method
	@Override
	public Integer insert(SuggestionVO suggestionVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet keys = null;
		Integer id = null;

		try {
			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, suggestionVO.getSuggestionContentFile());
			pstmt.setString(2, suggestionVO.getTitle());
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
	public void update(SuggestionVO suggestionVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setString(1, suggestionVO.getSuggestionContentFile());
			pstmt.setString(2, suggestionVO.getReplyContentFile());
			pstmt.setInt(3, suggestionVO.getReplyState());
			pstmt.setInt(4, suggestionVO.getSuggestionId());


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
	public void delete(Integer suggestionId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, suggestionId);
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
	public SuggestionVO findByPrimaryKey(Integer suggestionId) {
		SuggestionVO suggestionVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, suggestionId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				suggestionVO = new SuggestionVO();
				suggestionVO.setSuggestionId(rs.getInt("suggestion_id"));
				suggestionVO.setSuggestDate(rs.getDate("suggest_date"));
				suggestionVO.setTitle(rs.getString("title"));
				suggestionVO.setSuggestionContentFile(rs.getString("suggestion_content_file"));
				suggestionVO.setReplyContentFile(rs.getString("reply_content_file"));
				suggestionVO.setReplyState(rs.getInt("reply_state"));
				suggestionVO.setReplyDate(rs.getDate("reply_date"));
								
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
		return suggestionVO;

	}

	@Override
	public List<SuggestionVO> getAll() {
		List<SuggestionVO> list = new ArrayList<SuggestionVO>();
		SuggestionVO suggestionVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ConnectionBean.getConnection();
			pstmt = conn.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				suggestionVO = new SuggestionVO();
				suggestionVO.setSuggestionId(rs.getInt("suggestion_id"));
				suggestionVO.setSuggestDate(rs.getDate("suggest_date"));
				suggestionVO.setTitle(rs.getString("title"));
				suggestionVO.setSuggestionContentFile(rs.getString("suggestion_content_file"));
				suggestionVO.setReplyContentFile(rs.getString("reply_content_file"));
				suggestionVO.setReplyState(rs.getInt("reply_state"));
				suggestionVO.setReplyDate(rs.getDate("reply_date"));
				list.add(suggestionVO); // Store the row in the list
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
