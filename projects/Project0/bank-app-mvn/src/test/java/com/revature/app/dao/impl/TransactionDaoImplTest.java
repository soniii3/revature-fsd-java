package com.revature.app.dao.impl;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class TransactionDaoImplTest {
	@Test
	public void test1() {
		TransactionDaoImpl dao= new TransactionDaoImpl();
		try {
			dao.showBalance(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}
	@Test
	public void test_success() {
		TransactionDaoImpl dao = new TransactionDaoImpl();
		
		try {
			dao.performWithdrawl(4, 6500);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_DepositSuccess() {
		TransactionDaoImpl dao  = new TransactionDaoImpl();
		
		try {
			dao.performDeposit(5, 650);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
