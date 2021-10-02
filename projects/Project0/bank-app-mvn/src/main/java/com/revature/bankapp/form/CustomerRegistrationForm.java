package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.app.dao.CustomerDao;
import com.revature.app.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.model.Customer;

public class CustomerRegistrationForm extends Form{

	public CustomerRegistrationForm(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	
	@Override
	public void captureData() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter First Name:");
		firstName = scanner.nextLine();
		System.out.print("Enter LastName:");
		 lastName = scanner.nextLine();
		System.out.print("Enter emailId:");
		email = scanner.nextLine();
		System.out.print("Setup password:");
		password = scanner.nextLine();
	}
		
		
		

	@Override
	public void action() {
		success =true;
		CustomerDao dao=new CustomerDaoImpl();
        try {
        	dao.create(new Customer(firstName,lastName,email,password));
        }catch (SQLException e) {
	        System.out.println("unable to create customer");

        	
        }

		System.out.println("Customer added successfully.");
		
		
		
	}

}
