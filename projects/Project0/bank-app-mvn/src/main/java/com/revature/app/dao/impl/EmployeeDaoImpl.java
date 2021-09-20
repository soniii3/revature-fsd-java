package com.revature.app.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.app.dao.EmployeeDao;
import com.revature.app.dao.Util;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Employee;
import com.revature.bankapp.model.Transaction;


public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Customer> viewCustomer() throws SQLException {
		List<Customer> customerList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from customer";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Customer customerTemp = new Customer();
				customerTemp.setId(resultSet.getInt("id"));
				customerTemp.setName(resultSet.getString("name"));
				customerTemp.setUserId(resultSet.getString("user_id"));
				customerList.add(customerTemp);
			}
		return customerList;
		}
	}

	@Override
	public List<Account> showAccount() throws SQLException {
		List<Account> accountList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select c.id, c.name, account_number, initial_amount from account\r\n" + 
					"inner join customer c on customer_id = c.id";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Account accountTemp = new Account();
				accountTemp.setCustomerId(resultSet.getInt("id"));
				accountTemp.setName(resultSet.getString("name"));
				accountTemp.setAccountNumber(resultSet.getString("account_number"));
				accountTemp.setBalance(resultSet.getDouble("balance"));
				accountList.add(accountTemp);

			}
		}
		return accountList;
	}

	public List<Transaction> viewTransaction() throws SQLException {
		List<Transaction> transactionList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select c.id, c.name, a.account_number, a.initial_amount, t.type, t.amount from transaction t\r\n" + 
					"inner join account a on account_id = a.id\r\n" + 
					"inner join customer c on customer_id = c.id";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Transaction transactionTemp = new Transaction();
				transactionTemp.setCustomerId(resultSet.getInt("id"));
				transactionTemp.setName(resultSet.getString("name"));
				transactionTemp.setAccountNumber(resultSet.getString("account_number"));
				transactionTemp.setBalance(resultSet.getDouble("balance"));
				transactionTemp.setType(resultSet.getString("type").charAt(0));
				transactionTemp.setAmount(resultSet.getDouble("amount"));
				transactionList.add(transactionTemp);

			}
		}
		return transactionList;
	}
	
	public Employee getEmployeeUserId(String userId) throws SQLException {
		Employee employee = null;
		
		try (Connection connection = Util.getConnection()){
			String sql = "select * from admin where user_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String userid = resultSet.getString("user_id");
				String password = resultSet.getString("password");
				
				employee = new Employee(name, userid, password);
			}
		}
		return employee;
	}


}
