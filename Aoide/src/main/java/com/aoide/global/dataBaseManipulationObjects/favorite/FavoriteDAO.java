package com.aoide.global.dataBaseManipulationObjects.favorite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;



public class FavoriteDAO implements FavoriteDAO_interface{
	
	
	private static final String INSERT_STMT = "INSERT INTO Favorite(member_id,song_id) VALUES(?,?)";
	private static final String UPDATE = "UPDATE Favorite set member_id=?,song_id=?";
	private static final String DELETE = "DELETE FROM Favorite where (member_id=?,song_id=?)";
	private static final String GET_ALL_STMT = "SELECT member_id,song_id FROM Favorite order by member_id";
	private static final String GET_ONE_STMT = "SELECT member_id,song_id FROM Favorite where member_id=?";

	

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
		
		FavoriteDAO dao = new FavoriteDAO();
		
		//insert
		
		FavoriteVO favoriteVO1 = new FavoriteVO();
		favoriteVO1.setMemberId(1);
		favoriteVO1.setSongId(1);
		dao.insert(favoriteVO1);
	
		
		//modify
		
		FavoriteVO favoriteVO2 = new FavoriteVO();
		favoriteVO2.setMemberId(2);
		favoriteVO2.setSongId(2);
		dao.update(favoriteVO2);
		
		//delete
		
		FavoriteVO favoriteVO3 = new FavoriteVO();
		favoriteVO3.setMemberId(3);
		favoriteVO3.setSongId(3);
		dao.delete(1, 3);
		
		
		//check
		List<FavoriteVO>list = dao.getAll();
		for(FavoriteVO aChi : list){
			System.out.println(aChi.getMemberId());
			System.out.println(aChi.getSongId());
					
			
			
			
		}
		
		
	}
	
	
	
	
	
	

}


	
	
	
	
	
	
	
	
	
	
	









