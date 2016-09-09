package com.aoide.global.dataBaseManipulationObjects.song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;

public class JdbcSongDAO implements SongDAO {
	// Fields
	private static final String INSERT_STMT = "INSERT INTO song(song_file, name, song_type,	song_language, member_id, singer, album_id, introduction_file, cover_file, lyrics_file,	update_date, lastclick_date, clicks, favorite_counts, shares)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String UPDATE_STMT = new StringBuffer().append("UPDATE song ")
																.append("SET ")
																.append("song_file = ?,")
																.append("name = ?,")
																.append("song_type = ?,")
																.append("song_language = ?,")
																.append("member_id = ?,")
																.append("singer = ?,")
																.append("album_id = ?,")
																.append("introduction_file = ?,")
																.append("cover_file = ?,")
																.append("lyrics_file = ?,")
																.append("update_date = ?,")
																.append("lastclick_date = ?,")
																.append("clicks = ?,")
																.append("favorite_counts = ?,")
																.append("shares = ? ")
																.append("WHERE song_id = ?")
																.toString();

	private static final String DELETE_STMT = "DELETE FROM song WHERE song_id = ?";
	
	private static final String GET_ONE_STMT = new StringBuffer().append("SELECT ")
																 .append("song_id,")
																 .append("song_file,")
																 .append("name,")
																 .append("song_type,")
																 .append("song_language,")
																 .append("member_id,")
																 .append("singer,")
																 .append("album_id,")
																 .append("introduction_file,")
																 .append("cover_file,")
																 .append("lyrics_file,")
																 .append("update_date,")
																 .append("lastclick_date,")
																 .append("clicks,")
																 .append("favorite_counts,")
																 .append("shares ")
																 .append("FROM song ")
																 .append("WHERE song_id = ?")
																 .toString();
	
	private static final String GET_ALL_STMT = new StringBuffer().append("SELECT ")
																 .append("song_id,")
																 .append("song_file,")
																 .append("name,")
																 .append("song_type,")
																 .append("song_language,")
																 .append("member_id,")
																 .append("singer,")
																 .append("album_id,")
																 .append("introduction_file,")
																 .append("cover_file,")
																 .append("lyrics_file,")
																 .append("update_date,")
																 .append("lastclick_date,")
																 .append("clicks,")
																 .append("favorite_counts,")
																 .append("shares ")
																 .append("FROM song ")
																 .toString();
	
	private static final String GET_NAME_STMT = new StringBuffer().append("SELECT ")
																  .append("song_id,")
																  .append("song_file,")
																  .append("name,")
																  .append("song_type,")
																  .append("song_language,")
																  .append("member_id,")
																  .append("singer,")
																  .append("album_id,")
																  .append("introduction_file,")
																  .append("cover_file,")
																  .append("lyrics_file,")
																  .append("update_date,")
																  .append("lastclick_date,")
																  .append("clicks,")
																  .append("favorite_counts,")
																  .append("shares ")
																  .append("FROM song ")
																  .append("WHERE name like ?")
																  .toString();
	
	private static final String GET_SINGER_STMT = new StringBuffer().append("SELECT ")
			  														.append("song_id,")
			  														.append("song_file,")
			  														.append("name,")
			  														.append("song_type,")
			  														.append("song_language,")
			  														.append("member_id,")
			  														.append("singer,")
			  														.append("album_id,")
			  														.append("introduction_file,")
			  														.append("cover_file,")
			  														.append("lyrics_file,")
			  														.append("update_date,")
			  														.append("lastclick_date,")
			  														.append("clicks,")
			  														.append("favorite_counts,")
			  														.append("shares ")
			  														.append("FROM song ")
			  														.append("WHERE singer like ?")
			  														.toString();

	// Constructors
	public JdbcSongDAO() {

	}

	// Method
	@Override
	public Integer insert(SongVO songVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Integer id = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT, Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, songVO.getSongFile());
			pstmt.setString(2, songVO.getName());
			pstmt.setString(3, songVO.getSongType());
			pstmt.setString(4, songVO.getSongLanguage());
			pstmt.setInt(5, songVO.getMemberId());
			pstmt.setString(6, songVO.getSinger());
			pstmt.setInt(7, songVO.getAlbumId());
			pstmt.setString(8, songVO.getIntroductionFile());
			pstmt.setString(9, songVO.getCoverFile());
			pstmt.setString(10, songVO.getLyricsFile());
			pstmt.setDate(11, songVO.getUpdateDate());
			pstmt.setTimestamp(12, songVO.getLastclickDate());
			pstmt.setInt(13, songVO.getClicks());
			pstmt.setInt(14, songVO.getFavoriteCounts());
			pstmt.setInt(15, songVO.getShares());

			pstmt.executeUpdate();

			ResultSet keys = null;
			keys = pstmt.getGeneratedKeys();

			if (keys.next()) {
				id = (Integer) keys.getInt(1);
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return id;
	}

	@Override
	public void update(SongVO songVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setString(1, songVO.getSongFile());
			pstmt.setString(2, songVO.getName());
			pstmt.setString(3, songVO.getSongType());
			pstmt.setString(4, songVO.getSongLanguage());
			pstmt.setInt(5, songVO.getMemberId());
			pstmt.setString(6, songVO.getSinger());
			pstmt.setInt(7, songVO.getAlbumId());
			pstmt.setString(8, songVO.getIntroductionFile());
			pstmt.setString(9, songVO.getCoverFile());
			pstmt.setString(10, songVO.getLyricsFile());
			pstmt.setDate(11, songVO.getUpdateDate());
			pstmt.setTimestamp(12, songVO.getLastclickDate());
			pstmt.setInt(13, songVO.getClicks());
			pstmt.setInt(14, songVO.getFavoriteCounts());
			pstmt.setInt(15, songVO.getShares());
			pstmt.setInt(16, songVO.getSongId());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public SongVO findByPrimaryKey(Integer songId) {
		SongVO songVO = null;
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
				songVO = new SongVO();
				songVO.setSongId(rs.getInt("song_id"));
				songVO.setSongFile(rs.getString("song_file"));
				songVO.setName(rs.getString("name"));
				songVO.setSongType(rs.getString("song_type"));
				songVO.setSongLanguage(rs.getString("song_language"));
				songVO.setMemberId(rs.getInt("member_id"));
				songVO.setSinger(rs.getString("singer"));
				songVO.setAlbumId(rs.getInt("album_id"));
				songVO.setIntroductionFile(rs.getString("introduction_file"));
				songVO.setCoverFile(rs.getString("cover_file"));
				songVO.setLyricsFile(rs.getString("lyrics_file"));
				songVO.setUpdateDate(rs.getDate("update_date"));
				songVO.setLastclickDate(rs.getTimestamp("lastclick_date"));
				songVO.setClicks(rs.getInt("clicks"));
				songVO.setFavoriteCounts(rs.getInt("favorite_counts"));
				songVO.setShares(rs.getInt("shares"));
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return songVO;

	}

	@Override
	public List<SongVO> getAll() {
		List<SongVO> list = new ArrayList<SongVO>();
		SongVO songVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ConnectionBean.getConnection();
			pstmt = conn.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				songVO = new SongVO();
				songVO.setSongId(rs.getInt("song_id"));
				songVO.setSongFile(rs.getString("song_file"));
				songVO.setName(rs.getString("name"));
				songVO.setSongType(rs.getString("song_type"));
				songVO.setSongLanguage(rs.getString("song_language"));
				songVO.setMemberId(rs.getInt("member_id"));
				songVO.setSinger(rs.getString("singer"));
				songVO.setAlbumId(rs.getInt("album_id"));
				songVO.setIntroductionFile(rs.getString("introduction_file"));
				songVO.setCoverFile(rs.getString("cover_file"));
				songVO.setLyricsFile(rs.getString("lyrics_file"));
				songVO.setUpdateDate(rs.getDate("update_date"));
				songVO.setLastclickDate(rs.getTimestamp("lastclick_date"));
				songVO.setClicks(rs.getInt("clicks"));
				songVO.setFavoriteCounts(rs.getInt("favorite_counts"));
				songVO.setShares(rs.getInt("shares"));
				list.add(songVO); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

	public List<SongVO> getName(String search) {
		List<SongVO> list = new ArrayList<SongVO>();
		SongVO songVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ConnectionBean.getConnection();
			pstmt = conn.prepareStatement(GET_NAME_STMT);
			search = '%' + search + '%';
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				songVO = new SongVO();
				songVO.setSongId(rs.getInt("song_id"));
				songVO.setSongFile(rs.getString("song_file"));
				songVO.setName(rs.getString("name"));
				songVO.setSongType(rs.getString("song_type"));
				songVO.setSongLanguage(rs.getString("song_language"));
				songVO.setMemberId(rs.getInt("member_id"));
				songVO.setSinger(rs.getString("singer"));
				songVO.setAlbumId(rs.getInt("album_id"));
				songVO.setIntroductionFile(rs.getString("introduction_file"));
				songVO.setCoverFile(rs.getString("cover_file"));
				songVO.setLyricsFile(rs.getString("lyrics_file"));
				songVO.setUpdateDate(rs.getDate("update_date"));
				songVO.setLastclickDate(rs.getTimestamp("lastclick_date"));
				songVO.setClicks(rs.getInt("clicks"));
				songVO.setFavoriteCounts(rs.getInt("favorite_counts"));
				songVO.setShares(rs.getInt("shares"));
				list.add(songVO); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	
	public List<SongVO> getSinger(String search) {
		List<SongVO> list = new ArrayList<SongVO>();
		SongVO songVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ConnectionBean.getConnection();
			pstmt = conn.prepareStatement(GET_SINGER_STMT);
			search = '%' + search + '%';
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				songVO = new SongVO();
				songVO.setSongId(rs.getInt("song_id"));
				songVO.setSongFile(rs.getString("song_file"));
				songVO.setName(rs.getString("name"));
				songVO.setSongType(rs.getString("song_type"));
				songVO.setSongLanguage(rs.getString("song_language"));
				songVO.setMemberId(rs.getInt("member_id"));
				songVO.setSinger(rs.getString("singer"));
				songVO.setAlbumId(rs.getInt("album_id"));
				songVO.setIntroductionFile(rs.getString("introduction_file"));
				songVO.setCoverFile(rs.getString("cover_file"));
				songVO.setLyricsFile(rs.getString("lyrics_file"));
				songVO.setUpdateDate(rs.getDate("update_date"));
				songVO.setLastclickDate(rs.getTimestamp("lastclick_date"));
				songVO.setClicks(rs.getInt("clicks"));
				songVO.setFavoriteCounts(rs.getInt("favorite_counts"));
				songVO.setShares(rs.getInt("shares"));
				list.add(songVO); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		System.out.println(GET_NAME_STMT);
	}



}
