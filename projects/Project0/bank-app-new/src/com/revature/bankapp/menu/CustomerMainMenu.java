package com.revature.bankapp.menu;

import java.util.Scanner;

import com.revature.bankapp.form.AccountRegistrationForm;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;

public class CustomerMainMenu extends Menu{

	public CustomerMainMenu(String name) {
		super(name);
		addMenuItem("View Accounts");
		addMenuItem("Create Account");
		addMenuItem("Logout");

		displayMenuAndCaptureSelection();
			}

	@Override
	void handleAction() {
		Scanner scanner = new Scanner(System.in);
		switch (selection) {
		case 1:
			AccountRegistrationForm accountRegistrationForm = new AccountRegistrationForm("New Account registartion form");
			accountRegistrationForm.captureDataAndPerformAction();
			displayMenuAndCaptureSelection();
			break;
		case 2:
			System.out.println("These are Your Accounts");
			System.out.println(DataManager.getCurrentCustomer().getAccountList());
			Customer.selectAccount();
			TransactionMenu transactionMenu = new TransactionMenu("Transactrion Menu");
			transactionMenu.displayMenuAndCaptureSelection();
			break;
		case 3:
			System.out.println("Logout");
			break;
		}
		
	}
	
	

}
