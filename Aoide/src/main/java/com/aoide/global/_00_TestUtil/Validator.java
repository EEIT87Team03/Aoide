package com.aoide.global._00_TestUtil;

import javax.servlet.http.Part;

public class Validator {
	// Methods
	public static boolean isValidString(String str){
		return ((str != null) && (str.trim().length() != 0));
	}
	public static boolean isValidEmail(String str){
		// ref http://regexlib.com/REDetails.aspx?regexp_id=16
		return isValidString(str) && str.matches("^(\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3})$");
	}
	public static boolean isValidAccount(String str){
		return ((str != null) && (str.trim().length() != 0));
	}
	public static boolean isValidPassword(String str){
		// ref http://regexlib.com/REDetails.aspx?regexp_id=2112
		// ^([a-zA-Z0-9]{6,18}?)$
		return isValidString(str) && str.matches("^([a-zA-Z0-9]{6,18}?)$");
	}
	public static boolean isImage(Part part){
		return part.getContentType().trim().split("/")[0].equals("image");
	}
	public static boolean isAudio(Part part){
		return part.getContentType().trim().split("/")[0].equals("audio");
	}
	public static boolean isEmptyPart(Part part){
		return part.getSize() == 0L;
	}
	
	
	
	public static void main(String[] args) {
//		System.out.println("Validator.isValidString(\"\"): " + Validator.isValidString(""));
//		System.out.println("Validator.isValidString(null): " + Validator.isValidString(null));
//		System.out.println("Validator.isValidString(\" \"): " + Validator.isValidString(" "));
//		System.out.println("Validator.isValidString(\"we \"): " + Validator.isValidString("we "));
//----------------------------------------------------------------------------------------
//		System.out.println("Validator.isValidPassword(\"asd123123\"): " + Validator.isValidPassword("asd123123"));
//		System.out.println("Validator.isValidPassword(\"asdasdfasf\"): " + Validator.isValidPassword("asdasdfasf"));
//		System.out.println("Validator.isValidPassword(\"asd1\"): " + Validator.isValidPassword("asd1"));
//		System.out.println("Validator.isValidPassword(\"12334514515qwe\"): " + Validator.isValidPassword("12334514515qwe"));
//----------------------------------------------------------------------------------------
		System.out.println("Validator.isValidEmail(\"12334514515qwe\"): " + Validator.isValidEmail("12334514515qwe"));		
		System.out.println("Validator.isValidEmail(\"asdqw334@gmail.com\"): " + Validator.isValidEmail("asdqw334@gmail.com"));		
	}

}
