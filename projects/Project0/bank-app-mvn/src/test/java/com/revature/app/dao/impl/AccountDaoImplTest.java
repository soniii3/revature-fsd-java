package com.revature.app.dao.impl;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.bankapp.model.Account;

public class AccountDaoImplTest {
	@Test
	public void test() {
		AccountDaoImpl adao = new AccountDaoImpl();
		Account account = new Account();
		account.setBalance(6000);
		account.setName("venkat");
		try {
			adao.create(account);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test_Success() {
		AccountDaoImpl adao = new AccountDaoImpl();
		try {
			adao.showAccounts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("failed getting account Details");
		}
	}

	
}
