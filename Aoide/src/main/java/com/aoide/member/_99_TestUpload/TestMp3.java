package com.aoide.member._99_TestUpload;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

public class TestMp3 {
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
		int length = TestMp3.getMp3TrackLength("C:/Aoide/files/song_files/Songid5.mp3");
		System.out.println("length: " + length);
		
//		System.out.println("path: " + file.getAbsolutePath() );
//		
//		AudioFileFormat baseFileFormat = null;
//		try {
//			baseFileFormat = new MpegAudioFileReader().getAudioFileFormat(file);
//		} catch (UnsupportedAudioFileException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Map properties = baseFileFormat.properties();
//		Long duration = (Long) properties.get("duration");
//		
//		System.out.println("duration: " + duration);
//		
		
	}

}
