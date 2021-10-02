package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.app.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.menu.EmployeeMainMenu;
import com.revature.bankapp.menu.MainMenu;
import com.revature.bankapp.model.Employee;

public class EmployeeLoginForm extends Form {
	
	private String Id;
	private String password;

	public EmployeeLoginForm(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void captureData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Employee UserId: ");
		Id  = sc.nextLine();
		
		System.out.print("Password: ");
		password = sc.nextLine();
		
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		EmployeeDaoImpl edao = new EmployeeDaoImpl();
		//MainMenu mm =new MainMenu("Main Menu");
		try {
			Employee employee = edao.getEmployeeUserId(Id);
			if (employee == null) {
				System.out.println("Invalid Username or Passworrd");
			} 
			else if (employee.getPassword().equals(password)){
				success = true;
				System.out.println("Login Successfull\n");
				System.out.println("Welcome " + employee.getName());
				EmployeeMainMenu empMenu = new EmployeeMainMenu("Admin Options");
				empMenu.displayMenuAndCaptureSelection();
			} else {
				System.out.println("Invalid Username or Password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("FAILED");
			
			
		}
		
	}

}
