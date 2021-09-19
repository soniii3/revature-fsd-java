package com.revature.app.dao;

import java.sql.SQLException;


public interface TransactionDao {

	
	void performWithdrawl(long accountId, long money) throws SQLException;
	void performDeposit(long accountId, long money) throws SQLException;
	long showBalance(long accounId) throws SQLException;

}
