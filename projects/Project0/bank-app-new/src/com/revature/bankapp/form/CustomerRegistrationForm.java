package com.revature.bankapp.form;
import java.util.Scanner;
import com.revature.bankapp.menu.MainMenu;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;

  public class CustomerRegistrationForm extends Form{

	public CustomerRegistrationForm(String name) {
		super(name);
		
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
		
		
		
		DataManager.addCustomer(new Customer(firstName, lastName, email, password));
		
	}

	@Override
	public void action() {
		success =true;
		
	}

}
