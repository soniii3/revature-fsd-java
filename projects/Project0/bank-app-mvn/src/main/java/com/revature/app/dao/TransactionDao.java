package com.revature.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.model.Transaction;


public interface TransactionDao {

	
	void performWithdrawl(long accountId, long money) throws SQLException;
	void performDeposit(long accountId, long money) throws SQLException;
	long showBalance(long accounId) throws SQLException;
	void addTransaction(long accountId, String type, long money);
	List<Transaction>showTransactions(long accountId) throws SQLException;

}
