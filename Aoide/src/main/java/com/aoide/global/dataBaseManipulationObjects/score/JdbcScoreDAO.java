package com.aoide.global.dataBaseManipulationObjects.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;



public class JdbcScoreDAO implements ScoreDAO {
	
	
	private static final String INSERT_STMT = "INSERT INTO Score (member_id,song_id,date,score_value,comment_file) VALUES(?,?,?,?,?)";
	private static final String UPDATE = "UPDATE Score set member_id=?,song_id=?, date=?,score_value=?,comment_file=? ";
	private static final String DELETE = "DELETE FROM Score where (member_id=?,song_id=?)";
	private static final String GET_ALL_STMT = "SELECT member_id,song_id,date,score_value,comment_file FROM Score order by member_id";
	private static final String GET_ONE_STMT = "SELECT member_id,song_id,date,score_value,comment_file FROM Score where member_id=? and song_id=?";
	private static final String GET_AVG_STMT = "SELECT AVG(score_value) FROM score WHERE song_id = ?";

	


	@Override
	public void insert(ScoreVO scoreVO) {
		
		Connection conn = null;
		PreparedStatement ptmt = null;

		try {
			conn = ConnectionBean.getConnection();
			ptmt = conn.prepareStatement(INSERT_STMT);

			ptmt.setInt(1, scoreVO.getMemberId());
			ptmt.setInt(2, scoreVO.getSongId());
			ptmt.setDate(3,scoreVO.getDate());
			ptmt.setInt(4, scoreVO.getScoreValue());
			ptmt.setString(5, scoreVO.getComment());

			ptmt.executeUpdate();

		} catch (Exception e) {
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
	public void update(ScoreVO scoreVO) {
		
		Connection conn = null;
		PreparedStatement ptmt = null;

		try {
			conn = ConnectionBean.getConnection();
			ptmt = conn.prepareStatement(UPDATE);

			ptmt.setInt(1, scoreVO.getMemberId());
			ptmt.setInt(2, scoreVO.getSongId());
			ptmt.setDate(3,scoreVO.getDate());
			ptmt.setInt(4, scoreVO.getScoreValue());
			ptmt.setString(5, scoreVO.getComment());


			ptmt.executeUpdate();

		} catch (Exception e) {
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
	public void delete(Integer memberId, Integer songId) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		
	    try {
	    	conn = ConnectionBean.getConnection();
	    	ptmt = conn.prepareStatement(DELETE);
	    	ptmt.setInt(1, memberId);
	    	ptmt.setInt(2, songId);
	    	ptmt.executeUpdate();
    		      	    	
	    	
	    } catch (Exception e) {
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
	public void calculatorAVG(ScoreVO scoreValue) {
		
		ScoreVO scoreVO = null;
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		try{
			
			conn = ConnectionBean.getConnection();
			ptmt = conn.prepareStatement(GET_AVG_STMT);
			ptmt.setDouble(1, 1);
	    	
			rs = ptmt.executeQuery();
			
			while (rs.next()){
				scoreVO = new ScoreVO();
	    		scoreVO.setMemberId(rs.getInt("member_id"));
	    		scoreVO.setSongId(rs.getInt("song_id"));
	    		scoreVO.setDate(rs.getDate("date"));
	    		scoreVO.setScoreValue(rs.getInt("score_value"));
	    		scoreVO.setComment(rs.getString("comment_file"));
				
			       }
				
			  } catch (Exception e) {
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
	public List<ScoreVO> getAll() {
		
        List<ScoreVO>list = new ArrayList<ScoreVO>();
        ScoreVO scoreVO = null;
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
	    try{
	    	conn = ConnectionBean.getConnection();
	    	ptmt = conn.prepareStatement(GET_ALL_STMT);
	    	rs = ptmt.executeQuery();
	    	
	    	while(rs.next()){
	    		scoreVO = new ScoreVO();
	    		scoreVO.setMemberId(rs.getInt("member_id"));
	    		scoreVO.setSongId(rs.getInt("song_id"));
	    		scoreVO.setDate(rs.getDate("date"));
	    		scoreVO.setScoreValue(rs.getInt("score_value"));
	    		scoreVO.setComment(rs.getString("comment_file"));
	    		
	    		
	    		
				list.add(scoreVO);
				
	        }
			
		  } catch (Exception e) {
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
	
	@Override
	public ScoreVO findByPrimaryKey(Integer memberId, Integer songId) {
		
		ScoreVO scoreVO = null;
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
				scoreVO = new ScoreVO();
	    		scoreVO.setMemberId(rs.getInt("member_id"));
	    		scoreVO.setSongId(rs.getInt("song_id"));
	    		scoreVO.setDate(rs.getDate("date"));
	    		scoreVO.setScoreValue(rs.getInt("score_value"));
	    		scoreVO.setComment(rs.getString("comment_file"));
				
			       }
				
			  } catch (Exception e) {
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

		
		
		return scoreVO;
	}
	

	
	
    public static void main(String[]args){
	
	JdbcScoreDAO dao = new JdbcScoreDAO();
	
	//insert
	
	ScoreVO scoreVO1 = new ScoreVO();
	scoreVO1.setMemberId(1);
	scoreVO1.setSongId(1);
	scoreVO1.setDate(java.sql.Date.valueOf("2016-01-01"));
	scoreVO1.setScoreValue(1);
	scoreVO1.getComment();

	
	//modify
	
	ScoreVO scoreVO2 = new ScoreVO();
	scoreVO2.setMemberId(2);
	scoreVO2.setSongId(2);
	scoreVO2.setDate(java.sql.Date.valueOf("2016-02-02"));
	scoreVO2.setScoreValue(2);
	scoreVO2.getComment();
	
	
	//delete
	
	
	ScoreVO scoreVO3 = new ScoreVO();
	scoreVO3.setMemberId(2);
	scoreVO3.setSongId(2);
	scoreVO3.setDate(java.sql.Date.valueOf("2016-02-02"));
	scoreVO3.setScoreValue(2);
	scoreVO3.getComment();
	
	
	//check
	List<ScoreVO>list = dao.getAll();
	for(ScoreVO aChi : list){
		System.out.println(aChi.getMemberId());
		System.out.println(aChi.getSongId());
		System.out.println(aChi.getDate());
		System.out.println(aChi.getScoreValue());
		System.out.println(aChi.getComment());


				
		
		
		
	}
	
	
}







	@Override
	public ScoreVO calculatorAVG(int scoreValue) {
		// TODO Auto-generated method stub
		return null;
	}







}





