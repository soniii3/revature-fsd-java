package com.revature.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.menu.TransactionMainMenu;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transaction;
import com.revature.app.dao.AccountDao;
import com.revature.app.dao.Util;

public class AccountDaoImpl implements AccountDao {

	public static int currentAccountId;
	public static int transferAccountId;

	@Override
	public void create(Account account) throws SQLException {

		try (Connection connection = Util.getConnection()) {
			String sql = "INSERT INTO `account` (`account_num`, `balance`,cus_id) VALUES (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, account.getAccountNumber());
			preparedStatement.setInt(2, (int) account.getBalance());
			preparedStatement.setInt(3, CustomerDaoImpl.current_id);

			preparedStatement.executeUpdate();

		}

	}

	@Override
	public List<Account> showAccounts() throws SQLException {
		List<Account> accountList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where cus_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, CustomerDaoImpl.current_id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				account.setAccountNumber(rs.getString("account_num"));
				account.setBalance(rs.getDouble("balance"));

				accountList.add(account);
			}
		}
		return accountList;

	}

	public Account currentAccount() throws SQLException {
		Account account = null;
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where account_num = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, TransactionMainMenu.accNumber);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				currentAccountId = resultSet.getInt("id");
				String accNumber = resultSet.getString("account_num");
				Double balance = resultSet.getDouble("balance");

				account = new Account(accNumber, balance);
			}
		}
		return account;
	}

	public void insert(Transaction transaction) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into transaction (type, amount, account_id) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, String.valueOf(transaction.getType()));
			statement.setDouble(2, transaction.getAmount());
			statement.setInt(3, currentAccountId);
			//statement.executeUpdate();

		}

	}

	public void insertTransfer(Transaction transaction) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into transaction (type, amount, account_id) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, String.valueOf(transaction.getType()));
			statement.setDouble(2, transaction.getAmount());
			statement.setInt(3, transferAccountId);
			statement.executeUpdate();
		}
	}

	public void update(Account account) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update account set balance = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, account.getBalance());
			statement.setInt(2, currentAccountId);
			statement.executeUpdate();
		}
	}

	public List<Transaction> transactionList() throws SQLException {
		List<Transaction> transactionList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from transaction where account_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, currentAccountId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Transaction transaction = new Transaction();
				transaction.setType(resultSet.getString("type").charAt(0));
				transaction.setAmount(resultSet.getDouble("amount"));
				transactionList.add(transaction);

			}
		}

		return transactionList;

	}

	public void updateTransfer(Account account) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update account set balance = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, account.getBalance());
			statement.setInt(2, transferAccountId);
			statement.executeUpdate();
		}
	}

	public Account transferAccount() throws SQLException {
		Account account = null;
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where account_num = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, TransactionMainMenu.transferAccNum);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				transferAccountId = resultSet.getInt("id");
				String accNumber = resultSet.getString("account_num");
				Double balance = resultSet.getDouble("balance");

				account = new Account(accNumber, balance);
				
			}
			
		}
		return account;
	}
	
	public List<Account> accountList() throws SQLException {
		List<Account> accountList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where cus_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, CustomerDaoImpl.current_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Account account = new Account();
				account.setAccountNumber(resultSet.getString("account_num"));
				account.setBalance(resultSet.getDouble("balance"));
				accountList.add(account);

			}
		}

		return accountList;

	}
	
}
