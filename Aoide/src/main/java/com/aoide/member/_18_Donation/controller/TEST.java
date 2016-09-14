package com.aoide.member._18_Donation.controller;

public class TEST {

	public static void main(String[] args) {
		
		String cash_volume = "123";
		
		String re = "/^[0-9]+$/";
		if (cash_volume.matches(re)){
			System.out.println("符合驗證");
		}else{
			System.out.println("符合失敗");
		}
		// TODO Auto-generated method stub

	}

}
