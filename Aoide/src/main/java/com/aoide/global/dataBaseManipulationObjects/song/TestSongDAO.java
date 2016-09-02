package com.aoide.global.dataBaseManipulationObjects.song;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public class TestSongDAO {

	public static void main(String[] args) {
			JdbcSongDAO dao = new JdbcSongDAO();
			
			
			// �s�W
			SongVO songVO1 = new SongVO();
			
			songVO1.setSongFile("1");
			songVO1.setName("111");
			songVO1.setSongType("1");
			songVO1.setSongLanguage("1");
			songVO1.setMemberId(1);
			songVO1.setAlbumId(1);
			songVO1.setIntroductionFile("1");
			songVO1.setCoverFile("1");
			songVO1.setLyricsFile("1");
			songVO1.setUpdateDate(new Date(16543684L));
			songVO1.setLastclickDate(new Timestamp(16543684L));
			songVO1.setClicks(1);
			songVO1.setFavoriteCounts(1);
			songVO1.setShares(1);
			dao.insert(songVO1);

			// �ק�
			SongVO songVO2 = new SongVO();
			
			songVO2.setSongFile("1");
			songVO2.setName("111");
			songVO2.setSongType("1");
			songVO2.setSongLanguage("1");
			songVO2.setMemberId(1);
			songVO2.setAlbumId(1);
			songVO2.setIntroductionFile("1");
			songVO2.setCoverFile("1");
			songVO2.setLyricsFile("1");
			songVO2.setUpdateDate(new Date(16543684L));
			songVO2.setLastclickDate(new Timestamp(16543684L));
			songVO2.setClicks(1);
			songVO2.setFavoriteCounts(1);
			songVO2.setShares(1);
			dao.update(songVO2);

			// �R��
			dao.delete(10);

			// �d��
			SongVO songVO3 = dao.findByPrimaryKey(4);
			System.out.print(songVO3.getSongId() + ",");
			System.out.print(songVO3.getSongFile() + ",");
			System.out.print(songVO3.getName() + ",");
			System.out.print(songVO3.getSongType() + ",");
			System.out.print(songVO3.getSongLanguage() + ",");
			System.out.print(songVO3.getMemberId() + ",");
			System.out.print(songVO3.getAlbumId() + ",");
			System.out.print(songVO3.getIntroductionFile() + ",");
			System.out.print(songVO3.getCoverFile() + ",");
			System.out.print(songVO3.getLyricsFile() + ",");
			System.out.print(songVO3.getUpdateDate() + ",");
			System.out.print(songVO3.getLastclickDate() + ",");
			System.out.print(songVO3.getClicks() + ",");
			System.out.print(songVO3.getFavoriteCounts() + ",");
			System.out.print(songVO3.getShares() + ",");
			System.out.println("---------------------");

			// �d��
			List<SongVO> list = dao.getAll();
			for (SongVO aSongVO : list) {
				System.out.print(aSongVO.getSongId() + ",");
				System.out.print(aSongVO.getSongFile() + ",");
				System.out.print(aSongVO.getName() + ",");
				System.out.print(aSongVO.getSongType() + ",");
				System.out.print(aSongVO.getSongLanguage() + ",");
				System.out.print(aSongVO.getMemberId() + ",");
				System.out.print(aSongVO.getAlbumId() + ",");
				System.out.print(aSongVO.getIntroductionFile() + ",");
				System.out.print(aSongVO.getCoverFile() + ",");
				System.out.print(aSongVO.getLyricsFile() + ",");
				System.out.print(aSongVO.getUpdateDate() + ",");
				System.out.print(aSongVO.getLastclickDate() + ",");
				System.out.print(aSongVO.getClicks() + ",");
				System.out.print(aSongVO.getFavoriteCounts() + ",");
				System.out.print(aSongVO.getShares() + ",");
				System.out.println();
			}

	}

}
