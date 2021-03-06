package com.aoide.global.dataBaseManipulationObjects.song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.AutoInvoker;
import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;
import com.aoide.global.dataBaseManipulationObjects.DataSourceProxy;
import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;

public class JdbcSongDAO implements SongDAO {
	// Fields
	private static final String INSERT_STMT = 
			"INSERT INTO song ( [song_file], [name], [song_type], [song_language], [member_id], [album_id], [introduction_file], [lyrics_file], [length], [singer] ) "
			+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
	
	private static final String UPDATE_STMT = new StringBuffer().append("UPDATE song ")
																.append("SET ")
																.append("[song_file] = ?, ")
																.append("[name] = ?, ")
																.append("[song_type] = ?, ")
																.append("[song_language] = ?, ")
																.append("[member_id] = ?, ")
																.append("[album_id] = ?, ")
																.append("[introduction_file] = ?, ")
																.append("[cover_file] = ?, ")
																.append("[lyrics_file] = ?, ")
																.append("[update_date] = ?, ")
																.append("[lastclick_date] = ?, ")
																.append("[clicks] = ?, ")
																.append("[favorite_counts] = ?, ")
																.append("[shares] = ?, ")
																.append("[score] = ?, ")
																.append("[length] = ?, ")
																.append("[singer] = ? ")
																.append("WHERE [song_id] = ?")
																.toString();

	private static final String DELETE_STMT = "DELETE FROM song WHERE song_id = ?";
	
	private static final String GET_ONE_STMT = new StringBuffer().append("SELECT ")
																 .append("song_id,")
																 .append("song_file,")
																 .append("name,")
																 .append("song_type,")
																 .append("song_language,")
																 .append("member_id,")
																 .append("album_id,")
																 .append("introduction_file,")
																 .append("cover_file,")
																 .append("lyrics_file,")
																 .append("update_date,")
																 .append("lastclick_date,")
																 .append("clicks,")
																 .append("favorite_counts,")
																 .append("shares,")
																 .append("score,")
																 .append("length,")
																 .append("singer ")
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
																 .append("album_id,")
																 .append("introduction_file,")
																 .append("cover_file,")
																 .append("lyrics_file,")
																 .append("update_date,")
																 .append("lastclick_date,")
																 .append("clicks,")
																 .append("favorite_counts,")
																 .append("shares,")
																 .append("score,")
																 .append("length,")
																 .append("singer ")
																 .append("FROM song ")
																 .toString();
	
	private static final String GET_NAME_STMT = new StringBuffer().append("SELECT ")
																  .append("song_id,")
																  .append("song_file,")
																  .append("name,")
																  .append("song_type,")
																  .append("song_language,")
																  .append("member_id,")
																  .append("album_id,")
																  .append("introduction_file,")
																  .append("cover_file,")
																  .append("lyrics_file,")
																  .append("update_date,")
																  .append("lastclick_date,")
																  .append("clicks,")
																  .append("favorite_counts,")
																  .append("shares,")
																  .append("score,")
																  .append("length,")
																  .append("singer ")
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
			  														.append("album_id,")
			  														.append("introduction_file,")
			  														.append("cover_file,")
			  														.append("lyrics_file,")
			  														.append("update_date,")
			  														.append("lastclick_date,")
			  														.append("clicks,")
			  														.append("favorite_counts,")
			  														.append("shares,")
																	.append("score,")
																	.append("length,")
			  														.append("singer ")
			  														.append("FROM song ")
			  														.append("WHERE singer like ?")
			  														.toString();
	
	
	
	private static final String GET_FAVORITES_BY_MEMBERID = new StringBuffer().append("SELECT ")
			 .append("song_id,")
			 .append("song_file,")
			 .append("name,")
			 .append("song_type,")
			 .append("song_language,")
			 .append("member_id,")
			 .append("album_id,")
			 .append("introduction_file,")
			 .append("cover_file,")
			 .append("lyrics_file,")
			 .append("update_date,")
			 .append("lastclick_date,")
			 .append("clicks,")
			 .append("favorite_counts,")
			 .append("shares,")
			 .append("score,")
			 .append("length,")
			 .append("singer ")
			 .append("FROM song ")
			 .append("WHERE song_id = ?")
			 .toString();
	
	
	
	private static final String GET_ONE_SONG = new StringBuffer().append("SELECT ")
			 .append("song_id,")
			 .append("song_file,")
			 .append("name,")
			 .append("song_type,")
			 .append("song_language,")
			 .append("member_id,")
			 .append("album_id,")
			 .append("introduction_file,")
			 .append("cover_file,")
			 .append("lyrics_file,")
			 .append("update_date,")
			 .append("lastclick_date,")
			 .append("clicks,")
			 .append("favorite_counts,")
			 .append("shares,")
			 .append("score,")
			 .append("length,")
			 .append("singer ")
			 .append("FROM song ")
			 .append("WHERE song_id = ?")
			 .toString();
	
	
	private static final String GET_BY_AlBUM = new StringBuffer().append("SELECT ")
			 .append("song_id,")
			 .append("song_file,")
			 .append("name,")
			 .append("song_type,")
			 .append("song_language,")
			 .append("member_id,")
			 .append("album_id,")
			 .append("introduction_file,")
			 .append("cover_file,")
			 .append("lyrics_file,")
			 .append("update_date,")
			 .append("lastclick_date,")
			 .append("clicks,")
			 .append("favorite_counts,")
			 .append("shares,")
			 .append("score,")
			 .append("length,")
			 .append("singer ")
			 .append("FROM song ")
			 .append("WHERE album_id = ?")
			 .toString();




	// Method
	public Integer insert( SongVO vo ) 
	{
		int insertionCount = 0, id = -1;
		
		try( Connection conn = DataSourceProxy.getConnection();
			 PreparedStatement pstmt = AutoInvoker.invoke( conn, INSERT_STMT, vo ) )
		{
			insertionCount = pstmt.executeUpdate();
			ResultSet keys = pstmt.getGeneratedKeys();

			if ( keys.next() ) 
			{
				id = (Integer) keys.getInt(1);
				return id;
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return insertionCount;
	}

	@Override
	public int update( SongVO vo ) 
	{
		int updateCount = 0;
		
		try( Connection conn = DataSourceProxy.getConnection();
			 PreparedStatement pstmt = AutoInvoker.invoke( conn, UPDATE_STMT, vo ) )
		{
			updateCount = pstmt.executeUpdate();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return updateCount;
	}

	@Override
	public int delete( Integer songId )
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		int deletionCount = 0;
		try 
		{

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, songId);
			deletionCount = pstmt.executeUpdate();

			// Handle any SQL errors
		} 
		catch (SQLException se) 
		{
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} 
		finally 
		{
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) 
			{
				try 
				{
					con.close();
				} 
				catch (Exception e) 
				{
					e.printStackTrace(System.err);
				}
			}
		}
		return deletionCount;
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
				songVO.setAlbumId(rs.getInt("album_id"));
				songVO.setIntroductionFile(rs.getString("introduction_file"));
				songVO.setCoverFile(rs.getString("cover_file"));
				songVO.setLyricsFile(rs.getString("lyrics_file"));
				songVO.setUpdateDate(rs.getDate("update_date"));
				songVO.setLastclickDate(rs.getTimestamp("lastclick_date"));
				songVO.setClicks(rs.getInt("clicks"));
				songVO.setFavoriteCounts(rs.getInt("favorite_counts"));
				songVO.setShares(rs.getInt("shares"));
				songVO.setScore(rs.getDouble("score"));
				songVO.setLength(rs.getInt("length"));
				songVO.setSinger(rs.getString("singer"));
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
	public List<SongVO> findByOther(Integer songId) {
		List<SongVO> list = new ArrayList<SongVO>();
		SongVO songVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ConnectionBean.getConnection();
			pstmt = con.prepareStatement(GET_ONE_SONG);
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
				songVO.setAlbumId(rs.getInt("album_id"));
				songVO.setIntroductionFile(rs.getString("introduction_file"));
				songVO.setCoverFile(rs.getString("cover_file"));
				songVO.setLyricsFile(rs.getString("lyrics_file"));
				songVO.setUpdateDate(rs.getDate("update_date"));
				songVO.setLastclickDate(rs.getTimestamp("lastclick_date"));
				songVO.setClicks(rs.getInt("clicks"));
				songVO.setFavoriteCounts(rs.getInt("favorite_counts"));
				songVO.setShares(rs.getInt("shares"));
				songVO.setScore(rs.getDouble("score"));
				songVO.setLength(rs.getInt("length"));
				songVO.setSinger(rs.getString("singer"));
				list.add(songVO);
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
		return list;
		
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
				songVO.setAlbumId(rs.getInt("album_id"));
				songVO.setIntroductionFile(rs.getString("introduction_file"));
				songVO.setCoverFile(rs.getString("cover_file"));
				songVO.setLyricsFile(rs.getString("lyrics_file"));
				songVO.setUpdateDate(rs.getDate("update_date"));
				songVO.setLastclickDate(rs.getTimestamp("lastclick_date"));
				songVO.setClicks(rs.getInt("clicks"));
				songVO.setFavoriteCounts(rs.getInt("favorite_counts"));
				songVO.setShares(rs.getInt("shares"));
				songVO.setScore(rs.getDouble("score"));
				songVO.setLength(rs.getInt("length"));
				songVO.setSinger(rs.getString("singer"));
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
				songVO.setAlbumId(rs.getInt("album_id"));
				songVO.setIntroductionFile(rs.getString("introduction_file"));
				songVO.setCoverFile(rs.getString("cover_file"));
				songVO.setLyricsFile(rs.getString("lyrics_file"));
				songVO.setUpdateDate(rs.getDate("update_date"));
				songVO.setLastclickDate(rs.getTimestamp("lastclick_date"));
				songVO.setClicks(rs.getInt("clicks"));
				songVO.setFavoriteCounts(rs.getInt("favorite_counts"));
				songVO.setShares(rs.getInt("shares"));
				songVO.setScore(rs.getDouble("score"));
				songVO.setLength(rs.getInt("length"));
				songVO.setSinger(rs.getString("singer"));
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
				songVO.setAlbumId(rs.getInt("album_id"));
				songVO.setIntroductionFile(rs.getString("introduction_file"));
				songVO.setCoverFile(rs.getString("cover_file"));
				songVO.setLyricsFile(rs.getString("lyrics_file"));
				songVO.setUpdateDate(rs.getDate("update_date"));
				songVO.setLastclickDate(rs.getTimestamp("lastclick_date"));
				songVO.setClicks(rs.getInt("clicks"));
				songVO.setFavoriteCounts(rs.getInt("favorite_counts"));
				songVO.setShares(rs.getInt("shares"));
				songVO.setScore(rs.getDouble("score"));
				songVO.setLength(rs.getInt("length"));
				songVO.setSinger(rs.getString("singer"));
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
	
	public List<SongVO> getFavoritesSongById(Integer memberId) {
		List<SongVO>list = new ArrayList<SongVO>();
			
		    SongVO songVO = null;
			Connection conn = null;
			PreparedStatement ptmt = null;
			ResultSet rs = null;
			
		    try{
		    	conn = ConnectionBean.getConnection();
		    	ptmt = conn.prepareStatement(GET_FAVORITES_BY_MEMBERID);
		    	ptmt.setInt(1, memberId);
		    	
		    	
		    	
		    	rs = ptmt.executeQuery();
		    	
		    	while(rs.next()){
		    		songVO = new SongVO();
		    		songVO.setMemberId(rs.getInt("member_id"));
		    		songVO.setSongId(rs.getInt("song_id"));
		    		songVO.setAlbumId(rs.getInt("album_id"));
		    		
		    		
		    		
		    		
					list.add(songVO);
					
		        }
				
		    } catch (SQLException e) {
				throw new RuntimeException("Can't Use this Database."
						+ e.getMessage());


				} finally {
					if (ptmt != null) {
						try {
							ptmt.close();
						} catch (SQLException e1) {
							e1.printStackTrace(System.err);

						}

						if (conn != null) {
							try {
								conn.close();

							} catch (Exception e) {
								e.printStackTrace(System.err);

							}

						}

					}
				}
			return list;	
		}		

	
	public List<SongVO> getSongsByAlbum(Integer albumId) {
		List<SongVO>list = new ArrayList<SongVO>();
			
		    SongVO songVO = null;
			Connection conn = null;
			PreparedStatement ptmt = null;
			ResultSet rs = null;
			
		    try{
		    	conn = ConnectionBean.getConnection();
		    	ptmt = conn.prepareStatement(GET_BY_AlBUM);
		    	ptmt.setInt(1, albumId);
		    	
		    	rs = ptmt.executeQuery();
		    	
		    	while(rs.next()){
					songVO = new SongVO();
					songVO.setSongId(rs.getInt("song_id"));
					songVO.setSongFile(rs.getString("song_file"));
					songVO.setName(rs.getString("name"));
					songVO.setSongType(rs.getString("song_type"));
					songVO.setSongLanguage(rs.getString("song_language"));
					songVO.setMemberId(rs.getInt("member_id"));
					songVO.setAlbumId(rs.getInt("album_id"));
					songVO.setIntroductionFile(rs.getString("introduction_file"));
					songVO.setCoverFile(rs.getString("cover_file"));
					songVO.setLyricsFile(rs.getString("lyrics_file"));
					songVO.setUpdateDate(rs.getDate("update_date"));
					songVO.setLastclickDate(rs.getTimestamp("lastclick_date"));
					songVO.setClicks(rs.getInt("clicks"));
					songVO.setFavoriteCounts(rs.getInt("favorite_counts"));
					songVO.setShares(rs.getInt("shares"));
					songVO.setScore(rs.getDouble("score"));
					songVO.setLength(rs.getInt("length"));
					songVO.setSinger(rs.getString("singer"));
					list.add(songVO);
		        }
				
		    } catch (SQLException e) {
				throw new RuntimeException("Can't Use this Database."
						+ e.getMessage());

				} finally {
					if (ptmt != null) {
						try {
							ptmt.close();
						} catch (SQLException e1) {
							e1.printStackTrace(System.err);

						}

						if (conn != null) {
							try {
								conn.close();

							} catch (Exception e) {
								e.printStackTrace(System.err);

							}

						}

					}
				}
			return list;	
		}		

	
	
	
	
	

	public static void main(String[] args) 
	{
		SongVO songVO = new SongVO();
		songVO.setSongId( 50 );
		songVO.setSongFile( "E:////" );
		songVO.setName("ABCDE");
		
		songVO.setMemberId( 1 );
		songVO.setAlbumId(1);
		songVO.setClicks( 20 );
		songVO.setLength(240);
		songVO.setSinger("12345");
		SongDAO dao = new JdbcSongDAO();
		System.out.println(dao.insert(songVO));
		System.out.println(dao.update(songVO));
		
		System.out.println(UPDATE_STMT);
	}

}
