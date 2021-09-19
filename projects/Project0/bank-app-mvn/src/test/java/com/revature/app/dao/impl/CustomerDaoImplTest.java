package com.revature.app.dao.impl;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.app.dao.CustomerDao;
import com.revature.bankapp.model.Customer;

public class CustomerDaoImplTest {

	@Test
	 public void testCreate_success() {
		Customer customer = new Customer("mars", "gd", "dgwqd", "dgw");
		CustomerDao dao = new CustomerDaoImpl();
		try {
			dao.create(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("creating employee failed");
		}
	}

}
