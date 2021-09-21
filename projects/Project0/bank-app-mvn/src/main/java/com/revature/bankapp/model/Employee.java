package com.revature.bankapp.model;

public class Employee {
	
	private String name;
	private String Id;
	private String password;
	
	
	public Employee(String name, String Id, String password) {
		super();
		this.name = name;
		this.Id = Id;
		this.password = password;
	}
	
	public Employee() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return Id;
	}

	public void setId(String userId) {
		this.Id = Id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
