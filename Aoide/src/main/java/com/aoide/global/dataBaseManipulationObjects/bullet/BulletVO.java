package com.aoide.global.dataBaseManipulationObjects.bullet;

import java.sql.Date;

	public class BulletVO {
		private Integer bulletId;
		private Date date;
		private String title;
		private String contentFile;
		
		
		public BulletVO() {
		}
		public BulletVO(Integer bulletId, Date date, String title , String contentFile) {
			this.bulletId = bulletId;
			this.date = date;
			this.title = title;
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
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getContentFile() {
				return contentFile;
			}
			public void setContentFile(String contentFile) {
				this.contentFile = contentFile;
			}

    }