package com.revature.bankapp.model;

public class Transaction {

	private int customerId;
	private String name;
	private String accountNumber;
	private double initialAmount;
	private int accountId;
	private String type;
	private double amount;

	public Transaction(String c, double amount) {
		this.type = c;
		this.amount = amount;
	}
	
	public Transaction() {
		
	}
	

	public Transaction(char c, double amount2) {
		// TODO Auto-generated constructor stub
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
		return initialAmount;
	}

	public void setInitialAmount(double initialAmount) {
		this.initialAmount = initialAmount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getType() {
		return type;
	}

	public void setType(String c) {
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

	@Override
	public String toString() {
		return "CustomerId: " + customerId + "  Name: " + name + "  Account Number: " + accountNumber
				+ "  Balance: " + initialAmount + "  Account Id: " + accountId + "  Type: " + type + "  Amount: "
				+ amount;
	}

	public void setMoney(int int1) {
		// TODO Auto-generated method stub
		
	}

	public void setType(char charAt) {
		// TODO Auto-generated method stub
		
	}


	
	



}