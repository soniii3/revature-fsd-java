package com.revature.bankapp.form;


import java.sql.SQLException;
import java.util.Scanner;

import com.revature.app.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.menu.CustomerMainMenu;
import com.revature.bankapp.menu.MainMenu;
import com.revature.bankapp.model.Customer;


public class LoginForm extends Form {
	private String email_id;
	private String password;

	public LoginForm(String name) {
		super(name);
	}

	@Override
	public void captureData() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Email: ");
		email_id = scanner.nextLine();
		
		System.out.print("Password: ");
		password = scanner.nextLine();
	} 

	@Override
	public void action() {
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		Customer customer = null;
		try {
			customer = customerDaoImpl.getCustomerByEmail(email_id);
			if (customer == null) {
				System.out.println("Invalid Password or Email");
			} else if (customer.getPassword().equals(password)) {
				success = true;
				
				System.out.println("Successfully Login");
				System.out.println();
				System.out.println("Welcome " + customer.getFirstName());
				CustomerMainMenu customerMenu = new CustomerMainMenu("Customer Menu");
				customerMenu.displayMenuAndCaptureSelection();

			} else {
				System.out.println("Invalid Password or Email");
				System.out.println("Please try again...");
				MainMenu mm= new MainMenu("Main Menu");
				mm.displayMenuAndCaptureSelection();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

