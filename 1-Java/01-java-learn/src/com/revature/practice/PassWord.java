package com.revature.practice;

import java.util.Scanner;

public class PassWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
		String str = sc.next();
		int len = str.length();
		boolean lower = false;
		boolean upper = false;
		boolean digit = false;
		boolean special = false;

		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			if (Character.isLowerCase(ch))
				lower = true;
			if (Character.isUpperCase(ch))
				upper = true;
			if (Character.isDigit(ch))
				digit = true;
			if ((!Character.isLowerCase(ch)) && (!Character.isUpperCase(ch)) && (!Character.isDigit(ch))) 
				special = true;
			
		}
		
		if(lower && upper && digit && special && len>=8) {
			System.out.println("Password is Strong");
		}
		else {
			//System.out.println("password is not Strong");
			if(len<8)
				System.out.println("password should have minimum 8 characters");
			if(upper == false) {
				System.out.println("Upper Case is required");
			}
			
			if(lower == false) {
				System.out.println("Lower Case is required");
			}
			
			if(digit == false) {
				System.out.println("digit Case is required");
			}
			
			if(special == false) {
				System.out.println("Special character is required");
			}
		}
		
		

	}
}
