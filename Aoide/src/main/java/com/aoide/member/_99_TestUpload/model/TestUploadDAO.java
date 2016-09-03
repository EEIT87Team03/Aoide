package com.aoide.member._99_TestUpload.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

public class TestUploadDAO {
	// Fields
	private static final String INSERT_STMT = "INSERT INTO song (song_file, name, member_id) VALUES (?,?,?)";
	
	// Constructors
	public TestUploadDAO() {
		
	}
	
	// Methods
	public Integer insert(SongVO songVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet keys = null;
		Integer id = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, songVO.getSongFile());
			pstmt.setString(2, songVO.getName());
			pstmt.setInt(3, songVO.getMemberId());

			pstmt.executeUpdate();
			
			// Get id of song just inserted. 
			keys = pstmt.getGeneratedKeys();
			if(keys.next()){
				id = keys.getInt(1);
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (keys != null){
				try {
					keys.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
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
		return id;
	}// end insert()
	
	
	
}
