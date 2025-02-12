package com.revature.bankapp.model;

import java.sql.SQLException;


public class Account {

	private String accountNumber;
	private String name;
	private String branch;
	private double balance;
	private boolean success = true;
	private int cus_id;
	

	public int getCus_id() {
		return cus_id;
	}



	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}



	public Account(String name, String branch, double balance) {
		super();
		this.name = name;
		this.branch = branch;
		this.balance = balance;

	}
	
	

	public Account() {
		
	}
	
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getBalance() {
		return balance;
	}

	public Account(String accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public void setBalance(double d) {
		this.balance = d;
	}

//	public double withdraw(double withdrawAmount) {
//		while (success) {
//			if (withdrawAmount < 0) {
//				System.out.println("Enter Amount greater than 0");
//			} else if (withdrawAmount <= balance) {
//				balance -= withdrawAmount;
//				success = false;
//				try {
//					//accdao.insert(new Transaction('D', withdrawAmount));
//					accdao.update(this);
//					System.out.println("Successfull");
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			} 
//				else {
//					System.out.println("Insufficient funds");
//					break;
//				}
//
//			}
//			return balance;
//		}
//
//		public double deposit(double depositAmount) {
//			while (success) {
//				if (depositAmount < 0) {
//					System.out.println("Enter Amount greater than 0");
//					break;
//				} else {
//					balance += depositAmount;
//					success = false;
//					try {
//						accdao.insert(new Transaction('C', depositAmount));
//						accdao.update(this);
//						System.out.println("Successfull");
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//
//			return balance;
//		}
//
//		
//		public void transfer(double amount) {
//			balance += amount;
//			try {
//				accdao.insertTransfer(new Transaction('C', amount));
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				accdao.updateTransfer(this);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

	@Override
	public String toString() {
		return "acc_num=" + accountNumber + "  balance=" + balance;
	}



	public void setId(int int1) {
		// TODO Auto-generated method stub
		
	}

}
