package com.revature.bankapp.model;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.app.dao.impl.AccountDaoImpl;
import com.revature.bankapp.menu.CustomerMainMenu;

public class ViewAccountsAndTransactions {
	

		public static ArrayList<Account> accountsList() {

			AccountDaoImpl accdao = new AccountDaoImpl();
			try {
				List<Account> accounts = accdao.accountList();
				for (int i = 0; i < accounts.size(); i++) {
					System.out.println((i + 1) + ") " + accounts.get(i));
				}
				CustomerMainMenu cm = new CustomerMainMenu("Customer Menu");
				cm.displayMenuAndCaptureSelection();;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Cannot display accounts");
			}
			return null;
		}

		public static ArrayList<Transaction> transactionsList() {

			AccountDaoImpl accdao = new AccountDaoImpl();
			try {
				List<Transaction> transaction = accdao.transactionList();
				for (int i = 0; i < transaction.size(); i++) {
					System.out.println((i + 1) + ") " + transaction.get(i).print());
				}
				CustomerMainMenu cm = new CustomerMainMenu("Customer Menu");
				
				cm.displayMenuAndCaptureSelection();;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Cannot display accounts");
			}
			return null;
		}
	}
