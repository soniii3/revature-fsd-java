package com.revature.bankapp.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private static int choice;
	private ArrayList<Account> accountList;
	
	private static long counter = 0;
	
	private static Account currentAccount;
	
	public static Account getCurrentAccount1() {
		return currentAccount;
	}

	public static void setCurrentAccount(Account currentAccount) {
		Customer.currentAccount = currentAccount;
	}
	
	public Customer(String firstName, String lastName, String email, String password) {
		super();
		counter++;
		this.id = counter;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accountList = accountList;
	}
	

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public static void addAccount(Account account) {
		DataManager.getCurrentCustomer().getAccountList().add(account);
	}
	
	public static ArrayList<Account> getAccountList() {
		return DataManager.getCurrentCustomer().accountList;
	}
	
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}


	public static ArrayList<Account> createAccountList() {
		ArrayList<Account> list = new ArrayList<>();
		return list;
	
	}
	public static void withdrawl() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter amount to withdraw : ");
		long withdrwalAmount = scanner.nextLong();
		if (withdrwalAmount <= 0) {
			System.out.println("You cannot withdraw negative amount");
		} else if (DataManager.getCurrentCustomer().getAccountList().get(choice-1).getBalance() >= withdrwalAmount) {
			DataManager.getCurrentCustomer().getAccountList().get(choice-1).setBalance(
					DataManager.getCurrentCustomer().getAccountList().get(choice-1).getBalance() - withdrwalAmount);
			System.out.println(
					" Balance : " + DataManager.getCurrentCustomer().getAccountList().get(choice-1).getBalance());
			Account.addTransaction(withdrwalAmount+"  is debited from your account.");
		} else {
			System.out.println("Insuuficient Funds");
			System.out.println(
					" Balance : " + DataManager.getCurrentCustomer().getAccountList().get(choice-1).getBalance());
		}
	}
	
	public static void selectAccount() {
		System.out.print("Select account to perform transaction : ");
		Scanner scanner = new Scanner(System.in);
		choice = scanner.nextInt();
	    Customer.setCurrentAccount(DataManager.getCurrentCustomer().getAccountList().get(choice-1));
	    System.out.println(Customer.getCurrentAccount1());
		if (choice <= 0 && choice > DataManager.getCurrentCustomer().getAccountList().size()) {
			System.out.println("Choose valid Account");
			selectAccount();
		}

		// performTransaction();
	}

	public static void deposit() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter amount to deposit: ");
		long depositAmount = scanner.nextLong();
		DataManager.getCurrentCustomer().getAccountList().get(choice-1)
				.setBalance(DataManager.getCurrentCustomer().getAccountList().get(choice-1).getBalance() + depositAmount);
		System.out.println("Balance :" + DataManager.getCurrentCustomer().getAccountList().get(choice-1).getBalance());
		Account.addTransaction(depositAmount+"  is credited to your account");
	}
	
}
