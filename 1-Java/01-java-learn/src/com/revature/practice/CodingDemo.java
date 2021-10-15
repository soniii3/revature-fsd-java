package com.revature.practice;

import java.util.Scanner;

public class CodingDemo {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = sc.nextInt();
		for (int i=1;i<=10;i++)
		{
			System.out.print(String.format("%d X %2d = %2d",num,i,num*i));
			System.out.println(' ');
		}
	}

}
