package com.revature.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.app.dao.CustomerDao;
import com.revature.app.dao.Util;
import com.revature.bankapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	public static int current_id;
	public void create(Customer customer) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			
			String sql = "INSERT INTO customer (firstName, lastName, email_id, password) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.executeUpdate();

			connection.close();
		}
	}

	@Override
	public Customer getCustomerByEmail(String email) throws SQLException {
		Customer customer = null;
		try (Connection connection = Util.getConnection()) {
			String sql = "SELECT * FROM bankapp.customer where email_id= ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String fs_nm = resultSet.getString("firstName");
				String ls_nm = resultSet.getString("lastName");
				String em_id = resultSet.getString("email_id");
				String ps_wd = resultSet.getString("password");
				current_id = resultSet.getInt("id");
				customer = new Customer(fs_nm, ls_nm, em_id, ps_wd);

			}
		}
		return customer;
	}
}
