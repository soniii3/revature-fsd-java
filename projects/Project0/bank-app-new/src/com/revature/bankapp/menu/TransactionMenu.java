package com.revature.bankapp.menu;

import com.revature.bankapp.model.Customer;

public class TransactionMenu extends Menu {

	public TransactionMenu(String name) {
		super(name);
		addMenuItem("Withdrwal");
		addMenuItem("Deposit");
		addMenuItem("View Balance");
		addMenuItem("View Transaction Log");
		addMenuItem("Back");
	}

	@Override
	void handleAction() {
		switch (selection) {
		case 1:
			System.out.println("withDrawal granted");
			Customer.withdrawl();
			displayMenuAndCaptureSelection();
			break;
		case 2:
			System.out.println("Deposit Granted");
			Customer.deposit();
			displayMenuAndCaptureSelection();
			break;
		case 3:
			System.out.println("View Balance");
			Customer.getAccountList();
			displayMenuAndCaptureSelection();
			break;
		case 4:
			System.out.println("View Treansaction Log");
			System.out.println(Customer.getCurrentAccount1().getTransactionList());
			displayMenuAndCaptureSelection();
			break;
		case 5:
			break;
		}
	}

}
