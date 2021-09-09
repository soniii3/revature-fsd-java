package com.revature.bankapp.main;

import com.retvature.bankapp.menu.CustomerMainMenu;
import com.retvature.bankapp.menu.MainMenu;

public class BankApp {

	public static void main(String[] args) {
		MainMenu menu = new MainMenu("Main Menu");
		menu.displayMenuAndCaptureSelection();
		
		
		
		/*CustomerMainMenu customerMenu = new CustomerMainMenu("Customer Main Menu");
		customerMenu.addMenuItem("View Account");
		customerMenu.addMenuItem("Create new Account");
		customerMenu.addMenuItem("Logout");
		customerMenu.displayMenu();*/
		
	}

}
