package com.revature.bankapp.dao;


import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;

public interface AccountDao {
	void create(Account account) throws AppException;
	public List<Account> showAccounts() throws AppException;
	
	

}
