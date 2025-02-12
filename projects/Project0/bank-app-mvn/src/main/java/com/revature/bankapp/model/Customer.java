package com.revature.bankapp.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private ArrayList<Account> accountList;
	private static Account currentAccount;
	
	private static long counter = 0;
	
	public static Account getCurrentAccount() {
		return currentAccount;
	}

	public static void setCurrentAccount(Account currentAccount) {
		Customer.currentAccount = currentAccount;
	}

	
	public Customer(String firstName, String lastName, String email, String password) {
		super();
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
	public void setPassowrd(String passowrd) {
		this.password = passowrd;
	}
	
	
	
	public static long selectAccount() {
		System.out.print("Select account to perform transaction : ");
		Scanner scanner = new Scanner(System.in);
		long choice = scanner.nextInt();
		return choice;
	}

	public Customer() {
		
	}
	
	public void setId(long id) {
		this.id = id;
		
	}

	

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}

	public static void setCounter(long counter) {
		Customer.counter = counter;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	

}
