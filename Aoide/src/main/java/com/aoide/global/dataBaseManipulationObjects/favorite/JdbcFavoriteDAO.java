package com.aoide.global.dataBaseManipulationObjects.favorite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;



public class JdbcFavoriteDAO implements FavoriteDAO{
	
	
	private static final String INSERT_STMT = "INSERT INTO Favorite (member_id,song_id) VALUES(?,?)";
	private static final String UPDATE = "UPDATE Favorite set member_id=?,song_id=?";
	private static final String DELETE = "DELETE FROM Favorite where member_id = ? AND song_id = ? ";
	private static final String GET_ALL_STMT = "SELECT member_id,song_id FROM Favorite order by member_id";
	private static final String GET_ONE_STMT = "SELECT member_id,song_id FROM Favorite where member_id=? AND song_id = ?";
	private static final String GET_BY_MEMBER_ID = "SELECT member_id,song_id FROM Favorite where member_id=?";
	private static final String GET_FAVORITES_BY_MEMBERID = "SELECT * FROM favorite WHERE member_id=?";
	private static final String GET_FAVORITES_BY_SONGCOUNTS = "SELECT * FROM favorite WHERE song_id=?";
	
	private static final String GET_FAVORITE_SONGS_BY_MEMBERID = new StringBuffer().append("SELECT ")
			 .append("s.song_id,")
			 .append("s.song_file,")
			 .append("s.name,")
			 .append("s.song_type,")
			 .append("s.song_language,")
			 .append("s.member_id,")
			 .append("s.album_id,")
			 .append("s.introduction_file,")
			 .append("s.cover_file,")
			 .append("s.lyrics_file,")
			 .append("s.update_date,")
			 .append("s.lastclick_date,")
			 .append("s.clicks,")
			 .append("s.favorite_counts,")
			 .append("s.shares,")
			 .append("s.score,")
			 .append("s.length,")
			 .append("s.singer ")
			 .append("FROM song s ")
			 .append("JOIN favorite f ")
			 .append("ON s.song_id = f.song_id ")
			 .append("WHERE f.member_id = ?;")
			 .toString();
	
	@Override
	public void insert(FavoriteVO favoriteVO) {

		Connection conn = null;
		PreparedStatement ptmt = null;

		try {
			conn = ConnectionBean.getConnection();
			ptmt = conn.prepareStatement(INSERT_STMT);

		    ptmt.setInt(1, favoriteVO.getMemberId());
		    ptmt.setInt(2, favoriteVO.getSongId());
			
		

			ptmt.executeUpdate();

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

	}

		
	

	@Override
	public void update(FavoriteVO favoriteVO) {
		Connection conn = null;
		PreparedStatement ptmt = null;

		try {
			conn = ConnectionBean.getConnection();
			ptmt = conn.prepareStatement(UPDATE);

			ptmt.setInt(1, favoriteVO.getMemberId());
			ptmt.setInt(2, favoriteVO.getSongId());

			ptmt.executeUpdate();

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

	}
				
	

	@Override
	public void delete(Integer memberId, Integer songId) {Connection conn = null;
	PreparedStatement ptmt = null;
	
    try {
    	conn = ConnectionBean.getConnection();
    	ptmt = conn.prepareStatement(DELETE);
    	ptmt.setInt(1, memberId);
    	ptmt.setInt(2, songId);
    	ptmt.executeUpdate();
		      	    	
    	
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

}

	@Override
	public FavoriteVO findByPrimaryKey(Integer memberId, Integer songId) {
		FavoriteVO favoriteVO = null;
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		try{
			conn = ConnectionBean.getConnection();
			ptmt = conn.prepareStatement(GET_ONE_STMT);
			ptmt.setInt(1, memberId);
			ptmt.setInt(2, songId);
			rs = ptmt.executeQuery();
			
			while (rs.next()){
				favoriteVO = new FavoriteVO();
				favoriteVO.setMemberId(rs.getInt("member_id"));
				favoriteVO.setSongId(rs.getInt("song_id"));
			
				
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
		
		
		return favoriteVO;
	}

	
	
	
	
	@Override
	public List<FavoriteVO> getAll() {
    List<FavoriteVO>list = new ArrayList<FavoriteVO>();
		
        FavoriteVO favoriteVO = null;
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
	    try{
	    	conn = ConnectionBean.getConnection();
	    	ptmt = conn.prepareStatement(GET_ALL_STMT);
	    	rs = ptmt.executeQuery();
	    	
	    	while(rs.next()){
	    		favoriteVO = new FavoriteVO();
	    		favoriteVO.setMemberId(rs.getInt("member_id"));
	    		favoriteVO.setSongId(rs.getInt("song_id"));
	   
				list.add(favoriteVO);
				
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
		

	
        public static void main(String[]args){
		
        System.out.println(GET_FAVORITE_SONGS_BY_MEMBERID);	
        	
		JdbcFavoriteDAO dao = new JdbcFavoriteDAO();
		
//		//insert
//		
//		FavoriteVO favoriteVO1 = new FavoriteVO();
//		favoriteVO1.setMemberId(1);
//		favoriteVO1.setSongId(1);
//		dao.insert(favoriteVO1);
//	
//		
//		//modify
//		
//		FavoriteVO favoriteVO2 = new FavoriteVO();
//		favoriteVO2.setMemberId(2);
//		favoriteVO2.setSongId(2);
//		dao.update(favoriteVO2);
//		
//		//delete
//		
//		FavoriteVO favoriteVO3 = new FavoriteVO();
//		favoriteVO3.setMemberId(3);
//		favoriteVO3.setSongId(3);
//		dao.delete(1, 3);
//		
//		
//		//check
//		List<FavoriteVO>list = dao.getAll();
//		for(FavoriteVO aChi : list){
//			System.out.println(aChi.getMemberId());
//			System.out.println(aChi.getSongId());
//		}
//		
		
	}




        @Override
    	public List<FavoriteVO> finByMemberId(Integer memberId){
        List<FavoriteVO>list = new ArrayList<FavoriteVO>();
    		
            FavoriteVO favoriteVO = null;
    		Connection conn = null;
    		PreparedStatement ptmt = null;
    		ResultSet rs = null;
    		SongVO songVO = null;
    		
    	    try{
    	    	conn = ConnectionBean.getConnection();
    	    	ptmt = conn.prepareStatement(GET_BY_MEMBER_ID);
    	    	ptmt.setInt(1, memberId);
    	    	rs = ptmt.executeQuery();
    	    	
    	    	while(rs.next()){
    	    		favoriteVO = new FavoriteVO();
    	    		favoriteVO.setMemberId(rs.getInt("member_id"));
    	    		favoriteVO.setSongId(rs.getInt("song_id"));
    	    	   
    	    	
    	    		
    	    		
    	    		
    	    		
    				list.add(favoriteVO);
    				
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
	
    	public List<FavoriteVO> getFavoritesById(Integer memberId) {
    		List<FavoriteVO>list = new ArrayList<FavoriteVO>();
    			
    	        FavoriteVO favoriteVO = null;
    			Connection conn = null;
    			PreparedStatement ptmt = null;
    			ResultSet rs = null;
    			
    		    try{
    		    	conn = ConnectionBean.getConnection();
    		    	ptmt = conn.prepareStatement(GET_FAVORITES_BY_MEMBERID);
    		    	ptmt.setInt(1, memberId);
    		    	rs = ptmt.executeQuery();
    		    	
    		    	while(rs.next()){
    		    		favoriteVO = new FavoriteVO();
    		    		favoriteVO.setMemberId(rs.getInt("member_id"));
    		    		favoriteVO.setSongId(rs.getInt("song_id"));
    		   
    					list.add(favoriteVO);
    					
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
	
	
    	public FavoriteVO getFavoritesBySong(Integer songId) {
    	 
    			
    	        FavoriteVO favoriteVO = null;
    			Connection conn = null;
    			PreparedStatement ptmt = null;
    			ResultSet rs = null;
    			
    		    try{
    		    	conn = ConnectionBean.getConnection();
    		    	ptmt = conn.prepareStatement(GET_FAVORITES_BY_SONGCOUNTS);
    		    	ptmt.setInt(1, songId);
    		    	rs = ptmt.executeQuery();
    		    	
    		    	while(rs.next()){
    		    		favoriteVO = new FavoriteVO();
    		     		favoriteVO.setSongId(rs.getInt("song_id"));
    		   
    				
    					
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
				return favoriteVO;
    				
    		} // getFavoritesBySong()
    	
    	@Override
    	public List<SongVO> getFavoriteSongs(Integer memberId) {
    		List<SongVO> list = new ArrayList<SongVO>();
    		SongVO songVO = null;

    		Connection conn = null;
    		PreparedStatement pstmt = null;
    		ResultSet rs = null;

    		try {

    			conn = ConnectionBean.getConnection();
    			pstmt = conn.prepareStatement(GET_FAVORITE_SONGS_BY_MEMBERID);
    			pstmt.setInt(1, memberId);
    			rs = pstmt.executeQuery();

    			while (rs.next()) {
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
    
    	
	
	

}


	
	
	
	
	
	
	
	
	
	
	









