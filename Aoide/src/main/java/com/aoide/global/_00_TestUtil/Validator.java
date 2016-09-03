package com.aoide.global._00_TestUtil;

public class Validator {
	// Methods
	public static boolean isValidString(String str){
		return ((str != null) && (str.trim().length() != 0));
	}
	
	
	public static void main(String[] args) {
		System.out.println("Validator.isValidString(\"\"): " + Validator.isValidString(""));
		System.out.println("Validator.isValidString(null): " + Validator.isValidString(null));
		System.out.println("Validator.isValidString(\" \"): " + Validator.isValidString(" "));
		System.out.println("Validator.isValidString(\"we \"): " + Validator.isValidString("we "));
	}

}
