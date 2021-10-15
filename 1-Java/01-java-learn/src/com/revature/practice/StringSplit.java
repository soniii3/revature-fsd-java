package com.revature.practice;

import java.util.Scanner;

public class StringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String[] arr = str.split(" ");
		for(int i=0;i<str.length();i++)
		{
			for(int j=arr[i].length()-1;j>=0;j--) {
				System.out.print(arr[i].charAt(j));
		}
			System.out.println();
		}
		

	}

}
