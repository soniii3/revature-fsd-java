package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.app.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.model.Customer;

public class CustomerRegistrationForm extends Form{

	public CustomerRegistrationForm(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void captureData() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter First Name:");
		String firstName = scanner.nextLine();
		System.out.print("Enter LastName:");
		String lastName = scanner.nextLine();
		System.out.print("Enter emailId:");
		String email = scanner.nextLine();
		System.out.print("Setup password:");
		String password = scanner.nextLine();
	}
		
		
		

	@Override
	public void action() {
		success =true;
		
	}

}
