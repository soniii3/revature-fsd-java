package com.revature.app.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int age = sc.nextInt();
			System.out.println(age);
		} catch (InputMismatchException e) {
			System.out.println("Enter valid number. ");
		}
		System.out.println("After catch block.");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println(sdf.parse("01/01/2021"));
		} catch (ParseException e) {
			System.out.println("Enter date in dd/mm/yyyy format");
		}
		
	}

}
