package com.revature.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Transaction;



public interface EmployeeDao {
	List<Customer> viewCustomer() throws SQLException;
	
	List<Transaction> viewTransaction() throws SQLException;

	List<Account> showAccount() throws SQLException;

}
