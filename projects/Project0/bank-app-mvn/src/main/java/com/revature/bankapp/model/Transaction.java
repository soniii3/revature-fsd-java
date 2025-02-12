
package com.revature.bankapp.model;

public class Transaction {

	private int customerId;
	private String name;
	private String accountNumber;
	private double balance;
	private int accountId;
	private char type;
	private double amount;

	public Transaction(char c, double amount) {
		this.type = c;
		this.amount = amount;
	}
	
	

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getInitialAmount() {
		return balance;
	}

	public void setInitialAmount(double balance) {
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public char getType() {
		return type;
	}

	public void setType(char c) {
		this.type = c;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String print() {
		return "Type: " + type + "  Amount: "+ amount;
	}
	
	public Transaction() {
		
	}

	@Override
	public String toString() {
		return "CustomerId: " + customerId + "  Account Number: " + accountNumber
				+ "  Balance: " + balance + "  Account Id: " + accountId + "  Type: " + type + "  Amount: "
				+ amount;
	}

	public void setMoney(int int1) {
		// TODO Auto-generated method stub
		
	}



	public void setBalance(double balance) {
		// TODO Auto-generated method stub
		this.balance=balance;
	}

	


	
	



}