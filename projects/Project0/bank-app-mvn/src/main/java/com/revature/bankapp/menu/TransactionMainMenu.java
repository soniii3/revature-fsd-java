package com.revature.bankapp.menu;


import java.sql.SQLException;
import java.util.Scanner;

import com.revature.app.dao.impl.AccountDaoImpl;
import com.revature.bankapp.model.ViewAccountsAndTransactions;



public class TransactionMainMenu extends Menu {
public static String transferAccNum;
public static String accNumber;
Scanner sc = new Scanner(System.in);
CustomerMainMenu cusMenu = new CustomerMainMenu("Customer Menu");

	public TransactionMainMenu(String name) {
		super(name);
		addMenuItem("Withdrwal");
		addMenuItem("Deposit");
		addMenuItem("View Balance");
		addMenuItem("View Transaction Log");
		addMenuItem("Back");
	}
	
	public String getAccount() {
		System.out.println("Enter Account number to make transaction: ");
		accNumber = sc.nextLine();
		System.out.println("Account Number: " + accNumber);
		return accNumber;
	}


	@Override
	void handleAction() {
		AccountDaoImpl accdao = new AccountDaoImpl();
		System.out.println("***********");
		switch (selection) {

		case 1:
			try {
				System.out.println("Enter amount to withdraw: ");
				double amount = sc.nextDouble();
				accdao.currentAccount().withdraw(amount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			cusMenu.displayMenuAndCaptureSelection();
			break;

		case 2:
			
			try {
				System.out.println("Enter amount to deposit: ");
				double amount = sc.nextDouble();
				accdao.currentAccount().deposit(amount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			cusMenu.displayMenuAndCaptureSelection();
			break;
			
		case 3:
			try {
				accdao.currentAccount();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ViewAccountsAndTransactions.transactionsList();
			cusMenu.displayMenuAndCaptureSelection();
			break;
			
		case 4:
			try {
				double balance = accdao.currentAccount().getBalance();
				System.out.println("Balance: " + balance);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			cusMenu.displayMenuAndCaptureSelection();
			break;
		
		case 5:
			System.out.println("Enter Account Number of receiver: ");
			transferAccNum = sc.nextLine();
			System.out.println("Enter amount to transfer: ");
			double amount = sc.nextDouble();
			try {
				accdao.currentAccount().withdraw(amount);
				System.out.println("Initiated");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("withdraw failed");
			}
			try {
				accdao.transferAccount().transfer(amount);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("deposit failed");
			}
			cusMenu.displayMenuAndCaptureSelection();
			break;
			
		case 6:
			cusMenu.displayMenuAndCaptureSelection();
			
		case 7:
			MainMenu mm = new MainMenu("Main Menu");
			mm.displayMenuAndCaptureSelection();
		}
		
	}

}

