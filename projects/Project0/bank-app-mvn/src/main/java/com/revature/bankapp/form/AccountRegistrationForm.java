package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.app.dao.impl.AccountDaoImpl;
import com.revature.bankapp.model.Account;

public class AccountRegistrationForm extends Form {
	
	private String account_num;
	private long balance;

	public AccountRegistrationForm(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void captureData() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Account Number : ");
		account_num = scanner.nextLine();
		System.out.print("Enter starting balance : ");
		balance = scanner.nextLong();
	}
		
		

	@Override
	public void action() {
		success = true;
		AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
		try {
			accountDaoImpl.create(new Account(account_num,balance));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
