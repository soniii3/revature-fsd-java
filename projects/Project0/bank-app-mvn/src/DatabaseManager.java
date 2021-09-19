package com.revature.bankapp.model;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.app.dao.impl.TransactionDaoImpl;

public class DatabaseManager {
	private static Customer currentCustomer;
	private static long currentAccountId;

	public static Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public static void setCurrentCustomer(Customer currentCustomer) {
		DatabaseManager.currentCustomer = currentCustomer;
	}

	public static long selectAccount() {
		System.out.print("Select account to perform transaction : ");
		Scanner scanner = new Scanner(System.in);
		long choice = scanner.nextInt();
//	    Customer.setCurrentAccount(DataManager.getCurrentCustomer().getAccountList().get(choice-1));
//	    System.out.println(Customer.getCurrentAccount());
//		if (choice <= 0 && choice > DataManager.getCurrentCustomer().getAccountList().size()) {
//			System.out.println("Choose valid Account");
//			selectAccount();
//		}
		// performTransaction();
		return choice;

	}

	public static long getCurrentAccountId() {
		return currentAccountId;
	}

	public static void setCurrentAccountId(long currentAccountId) {
		DatabaseManager.currentAccountId = currentAccountId;
	}

	public static void withdrwal() {
		System.out.println("Enter amount to withdraw");
		Scanner sc = new Scanner(System.in);
		long amount = sc.nextLong();
		long accountNo = DatabaseManager.getCurrentAccountId();
		TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
		long currentBalance = 0;
		try {
			currentBalance = transactionDaoImpl.showBalance(accountNo);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (currentBalance >= amount) {
			try {
				transactionDaoImpl.performWithdrawl(accountNo, currentBalance - amount);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(amount < 0){
			System.out.println("Enter Valid Amount");
		}
		else {
			System.out.println("Insufficient Funds");
		}

	}
	
	public static void deposit() {
		System.out.print("Enter amount to deposit : ");
		Scanner sc = new Scanner(System.in);
		long amount = sc.nextLong();
		long accountNo = DatabaseManager.getCurrentAccountId();
		TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
		long currentBalance= 0;
		
			try {
				currentBalance = transactionDaoImpl.showBalance(accountNo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(amount > 0) {
				try {
					transactionDaoImpl.performDeposit(accountNo, currentBalance+amount);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("Enter valid amount");
			}
	}

}
