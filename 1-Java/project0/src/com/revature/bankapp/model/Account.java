package com.revature.bankapp.model;

public class Account {
	
	private long id;
	private long accNumber;
	private int balance;
	private String branch;
	private String name;
	
	

	public Account(long id, long accNumber, int balance, String branch, String name) {
		super();
		this.id = id;
		this.accNumber = accNumber;
		this.balance = balance;
		this.branch = branch;
		this.name = name;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getAccNumber() {
		return accNumber;
	}



	public void setAccountNumber(long accNumber) {
		this.accNumber = accNumber;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public static void main(String[] args) {
		

	}

}
