package com.revature.bankapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
//import com.revature.bankapp.menu.TransactionMainMenu;
import com.revature.bankapp.model.Account;

public class AccountDaoImpl implements AccountDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountDaoImpl.class);
	
	CustomerDaoImpl customer = new CustomerDaoImpl();
	public static int currentAccountId;
	public static int transferAccountId;

	@Override
	public void create(Account account) throws AppException {
		LOGGER.info("Accounts start");
		LOGGER.debug("{}",account);
		try (Connection connection = Util.getConnection()) {
			String sql = "INSERT INTO `account` (`account_num`, `balance`,cus_id) VALUES (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, account.getAccountNumber());
			preparedStatement.setInt(2, (int) account.getBalance());
			preparedStatement.setInt(3, account.getCus_id());

			preparedStatement.executeUpdate();
			LOGGER.info("End");

		} catch (SQLException e) {
			LOGGER.error("Error inserting account", e);
			throw new AppException(e);
		}

	}

	@Override
	public List<Account> showAccounts(int id) throws AppException {
		List<Account> accountList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where cus_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				account.setAccountNumber(rs.getString("account_num"));
				account.setBalance(rs.getDouble("balance"));
				account.setCus_id(rs.getInt("cus_id"));
				

				accountList.add(account);
			}
		} catch (SQLException e) {
			throw new AppException(e);
		}
		return accountList;

	}

	public Account currentAccount() throws AppException {
		Account account = null;
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where account_num = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			//statement.setString(1, TransactionMainMenu.accNumber);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				currentAccountId = resultSet.getInt("id");
				String accNumber = resultSet.getString("account_num");
				Double balance = resultSet.getDouble("balance");
				String name = resultSet.getString("name");
				String branch = resultSet.getString("branch");
				

				account = new Account(accNumber, balance);
			}
		} catch (SQLException e) {
			throw new AppException(e);
		}
		return account;
	}

	//
	
}
