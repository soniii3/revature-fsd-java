package com.revature.bankapp.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.app.dao.impl.AccountDaoImpl;
import com.revature.bankapp.form.AccountRegistrationForm;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;

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
			System.out.println("Your Accounts are");
			AccountDaoImpl accdao = new AccountDaoImpl();
			try {
				List<Account> account_list=accdao.showAccounts();
				for(int i = 0; i<account_list.size();i++) {
					System.out.println(account_list.get(i));
					//displayMenuAndCaptureSelection();
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			TransactionMainMenu tranMenu = new TransactionMainMenu("Transaction Menu");
			tranMenu.getAccount();
			tranMenu.displayMenuAndCaptureSelection();
			break;
			
		case 2:
			AccountRegistrationForm accountRegistrationForm = new AccountRegistrationForm("New Account registartion form");
			accountRegistrationForm.captureDataAndPerformAction();
			displayMenuAndCaptureSelection();
			break;
		
			
			
			
		/*case 3:
			System.out.println("..........");
			TransactionMainMenu tranMenu = new TransactionMainMenu("Transaction Menu");
			System.out.println("+++++");
			tranMenu.getAccount();
			tranMenu.displayMenuAndCaptureSelection();
			break;*/
			
		case 3:
			System.out.println("Logout");
			MainMenu mm = new MainMenu("Main Menu");
			mm.displayMenuAndCaptureSelection();
			break;
		}
		
	}
	
	

}
