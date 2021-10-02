package com.revature.bankapp.menu;

import java.util.List;
import java.sql.SQLException;

import com.revature.app.dao.EmployeeDao;
import com.revature.app.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.form.AccountRegistrationForm;
import com.revature.bankapp.form.CustomerRegistrationForm;
import com.revature.bankapp.form.LoginForm;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Transaction;

public class EmployeeMainMenu extends Menu{

	

	public EmployeeMainMenu(String name) {
		super(name);
		addMenuItem("Register for Customer account");
		addMenuItem("View Customers");
		addMenuItem("View Accounts");
		addMenuItem("View Transactions");
		//addMenuItem("Pending Accounts");
		addMenuItem("Logout");
	}

	
	@Override
	void handleAction() {
		EmployeeDao edao = new EmployeeDaoImpl();
		switch(selection) {
		
		case 1:
			CustomerRegistrationForm signUp = new CustomerRegistrationForm("Customer SignUp");
			signUp.captureDataAndPerformAction();
			
			LoginForm loginForm = new LoginForm("Customer Login");
			loginForm.captureDataAndPerformAction();
			
			AccountRegistrationForm createAcc = new AccountRegistrationForm("Account details");
			createAcc.captureDataAndPerformAction();
			
			
			
			break;
		case 2:
			try {
				List<Customer> list = edao.viewCustomer();
				for(int i =0; i <list.size(); i++) {
					System.out.println((i+1) + ") " + list.get(i));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayMenuAndCaptureSelection();
			break;
		case 3:
			try {
				List<Account> list = edao.showAccount();
				for(int i =0; i <list.size(); i++) {
					System.out.println((i+1) + ") " + list.get(i));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayMenuAndCaptureSelection();
			break;
		case 4:
			try {
				List<Transaction> list = edao.viewTransaction();
				for(int i =0; i <list.size(); i++) {
					System.out.println((i+1) + ") " + list.get(i));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayMenuAndCaptureSelection();
			break;
			
		/*case 5:
			PendingAccounts pa = new PendingAccounts();
			pa.viewPending();
			displayMenu();
			break;*/
			
		case 6:
			MainMenu mm = new MainMenu("Main Menu");
			mm.displayMenuAndCaptureSelection();
			break;
		}
		
	}


}
