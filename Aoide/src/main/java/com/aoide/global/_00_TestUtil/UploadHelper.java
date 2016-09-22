package com.aoide.global._00_TestUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

public class UploadHelper {
	// Methods
	public static void savePartIntoPath(Part part, String path){
	    InputStream inputStream = null;
	    OutputStream outputStream = null;
		try {
			File file = new File(path);
			
			System.out.println("AbsolutePath: " + file.getAbsolutePath());
			
		    inputStream = part.getInputStream();// get file inputSteam
		    outputStream = new FileOutputStream(file); // get FileOutputStream to write inputStrem into the file
		    // write into file
		    byte[] bytes = new byte[1024];
		    int len;
		    while ( (len = inputStream.read(bytes))  != -1) {
		    	outputStream.write(bytes, 0, len);
		    }
		 } catch(IOException e){
			 e.printStackTrace();
		 } finally {
	         if (inputStream != null) {
	        	 try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	         }
	         if (outputStream != null) {
	        	 try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	         }
	     }
	}// end savePartIntoPath(Part part, String path)
	public static String getFileName(final Part part) {
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}// end getFileName(final Part part)
	public static String getFileExtention(Part part){
	    final String fileName = getFileName(part).trim();
	    int index = fileName.lastIndexOf('.');
	    String fileNameExtension = fileName.substring(index);
	    return fileNameExtension;
	}// end getFileExtention(Part part)
	public static int getMp3TrackLength(String path) {
		try {
			File file = new File(path);
			
			System.out.println("absPath: " + file.getAbsolutePath());
			
			MP3File f = (MP3File)AudioFileIO.read(file);
			MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
			return audioHeader.getTrackLength();	
		} catch(Exception e) {
			return -1;
		}
	}
	
	
	public static void main(String[] args) {
	}

}
