package com.revature.bankapp.dao;

import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Transaction;


public interface TransactionDao {

	
	void performWithdrawl(long accountId, long money) throws AppException;
	void performDeposit(long accountId, long money) throws AppException;
	long showBalance(long accounId) throws AppException;
	void addTransaction(long accountId, String type, long money);
	List<Transaction>showTransactions(long accountId) throws AppException;

}
