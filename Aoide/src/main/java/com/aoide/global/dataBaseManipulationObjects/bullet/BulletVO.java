package com.aoide.global.dataBaseManipulationObjects.bullet;

import java.sql.Date;

	public class BulletVO {
		private Integer bulletId;
		private Date date;
		private String tiltle;
		private String contentFile;
		
		public BulletVO() {
		}
		public BulletVO(Integer bulletId, Date date, String tiltle , String contentFile) {
			this.bulletId = bulletId;
			this.date = date;
			this.tiltle = tiltle;
			this.contentFile = contentFile;
		}

			public Integer getBulletId() {
				return bulletId;
			}
			public void setBulletId(Integer bulletId) {
				this.bulletId = bulletId;
			}
			public Date getDate() {
				return date;
			}
			public void setDate(Date date) {
				this.date = date;
			}
			public String getTiltle() {
				return tiltle;
			}
			public void setTiltle(String tiltle) {
				this.tiltle = tiltle;
			}
			public String getContentFile() {
				return contentFile;
			}
			public void setContentFile(String contentFile) {
				this.contentFile = contentFile;
			}
    }