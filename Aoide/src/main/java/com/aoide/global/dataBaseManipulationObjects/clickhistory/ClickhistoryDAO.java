package com.aoide.global.dataBaseManipulationObjects.clickhistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;

public class ClickhistoryDAO implements ClickhistoryDAO_interface {

	private static final String INSERT_STMT = "INSERT INTO Clickhistory (song_Id,date) VALUES(?,?)";
	private static final String UPDATE = "UPDATE Clickhistory set chlickhistory_Id=?,song_Id=? date=? ";
	private static final String DELETE = "DELETE FROM Chlickhistory where chlickhistory_Id=?";
	private static final String GET_ALL_STMT = "SELECT clickhistory_id,song_id,date FROM Clickhistory ORDER BY clickhistory_id";
	private static final String GET_ONE_STMT = "SELECT clickhistory_id,song_id,date FROM Clickhistory where clickhistory_id=? ";

	@Override
	public void insert(ClickhistoryVO clickhistoryVO) {

		Connection conn = null;
		PreparedStatement ptmt = null;

		try {
			conn = ConnectionBean.getConnection();
			ptmt = conn.prepareStatement(INSERT_STMT);

//			ptmt.setInt(1, clickhistoryVO.getClickhistoryId());
			ptmt.setInt(1, clickhistoryVO.getSongId());
			ptmt.setDate(2,clickhistoryVO.getDate());

			ptmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. "
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
	public void update(ClickhistoryVO clickhistoryVO) {
		
		Connection conn = null;
		PreparedStatement ptmt = null;

		try {
			conn = ConnectionBean.getConnection();
			ptmt = conn.prepareStatement(UPDATE);

			ptmt.setInt(1, clickhistoryVO.getClickhistoryId());
			ptmt.setInt(2, clickhistoryVO.getSongId());
			ptmt.setDate(3,clickhistoryVO.getDate());

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
	public void delete(Integer chickhistoryId) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		
	    try {
	    	conn = ConnectionBean.getConnection();
	    	ptmt = conn.prepareStatement(DELETE);
	    	ptmt.setInt(1, chickhistoryId);
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
	public ClickhistoryVO findByPrimaryKey(Integer clickhistoryId) {
		
		ClickhistoryVO clickhistoryVO = null;
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
		try{
			conn = ConnectionBean.getConnection();
			
			ptmt = conn.prepareStatement(GET_ONE_STMT);
			ptmt.setInt(1, clickhistoryId);
			ptmt.setInt(1, clickhistoryId);
			rs = ptmt.executeQuery();
			
			while (rs.next()){
				clickhistoryVO = new ClickhistoryVO();
				clickhistoryVO.setClickhistoryId(rs.getInt("clickhistory_id"));
				clickhistoryVO.setSongId(rs.getInt("song_id"));
				clickhistoryVO.setDate(rs.getDate("date"));
				
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

		
		
		return clickhistoryVO;
	}

	
	
	
	@Override
	public List<ClickhistoryVO> getAll() {
		List<ClickhistoryVO>list = new ArrayList<ClickhistoryVO>();
		
		ClickhistoryVO clickhistoryVO = null;
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		
	    try{
	    	conn = ConnectionBean.getConnection();
	    	ptmt = conn.prepareStatement(GET_ALL_STMT);
	    	rs = ptmt.executeQuery();
	    	
	    	while(rs.next()){
	    		clickhistoryVO = new ClickhistoryVO();
				clickhistoryVO.setClickhistoryId(rs.getInt("clickhistory_id"));
				clickhistoryVO.setSongId(rs.getInt("song_id"));
				clickhistoryVO.setDate(rs.getDate("date"));
				list.add(clickhistoryVO);
				
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
					if (ptmt != null) {
						try {
							ptmt.close();
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
			}

	
		return list;	
		
	}
	public static void main(String[]args){
		
		ClickhistoryDAO dao = new ClickhistoryDAO();
		
		//insert
		
//		ClickhistoryVO clickhistoryVO1 = new ClickhistoryVO();
//		clickhistoryVO1.setClickhistoryId(1);
//		clickhistoryVO1.setSongId(1);
//		clickhistoryVO1.setDate(java.sql.Date.valueOf("2016-01-01"));
//		dao.insert(clickhistoryVO1);

		
		//modify
		
//		ClickhistoryVO clickhistoryVO2 = new ClickhistoryVO();
//		clickhistoryVO2.setClickhistoryId(2);
//		clickhistoryVO2.setSongId(2);
//		clickhistoryVO2.setDate(java.sql.Date.valueOf("2016-02-02"));
//		dao.update(clickhistoryVO2);

		
		//delete
		
//		ClickhistoryVO clickhistoryVO3 = new ClickhistoryVO();
//		clickhistoryVO3.setClickhistoryId(3);
//		clickhistoryVO3.setSongId(3);
//		clickhistoryVO3.setDate(java.sql.Date.valueOf("2016-03-03"));
//		dao.delete(1);
		
		
		
		//check
		    List<ClickhistoryVO>list = dao.getAll();
		    for(ClickhistoryVO chlick : list){
	        System.out.println(chlick.getClickhistoryId());
			System.out.println(chlick.getSongId());
			System.out.println(chlick.getDate());			
						
			

		}
		
		
	}
	
}
	
	
	
	
	
	




	
	
	
	
	
	
	
	
	
	
	












