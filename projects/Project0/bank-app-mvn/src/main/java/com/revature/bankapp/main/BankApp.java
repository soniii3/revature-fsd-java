package com.revature.bankapp.main;

import com.revature.bankapp.menu.CustomerMainMenu;
import com.revature.bankapp.menu.MainMenu;

public class BankApp {

	public static void main(String[] args) {
		MainMenu menu = new MainMenu("Main Menu");
		menu.displayMenuAndCaptureSelection();
		
		
		
		/*CustomerMainMenu custo1merMenu = new CustomerMainMenu("Customer Main Menu");
		customerMenu.addMenuItem("View Account");
		customerMenu.addMenuItem("Create new Account");
		customerMenu.addMenuItem("Logout");
		customerMenu.displayMenu();*/
		
	}

}
