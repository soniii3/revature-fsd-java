package com.revature.bankapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.dao.TransactionDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Transaction;

public class TransactionDaoImpl implements TransactionDao {

	public void performWithdrawl(long Id, long amount) throws AppException {
		try (Connection connection = Util.getConnection()) {

			String sql = "update bankapp.account set balance = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (int) amount);
			preparedStatement.setInt(2, (int) Id);
			preparedStatement.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void performDeposit(long Id, long amount) throws AppException {
		try (Connection connection = Util.getConnection()) {

			String sql = "update bankapp.account set balance = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (int) amount);
			preparedStatement.setInt(2, (int) Id);
			preparedStatement.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			throw new AppException(e);
		}

	}

	@Override
	public long showBalance(long Id) throws AppException {
		long balanceReturned = 0;
		try (Connection connection = Util.getConnection()) {

			String sql = "select balance from account where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (int) Id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				balanceReturned = (long) rs.getInt("balance");
			}

		} catch (SQLException e) {
			
			throw new AppException(e);
		}
		return balanceReturned;

	}

	@Override
	public void addTransaction(long accountId, String type, long money) {

		try (Connection connection = Util.getConnection()) {

			String sql = "INSERT INTO transaction (transaction_type, amount, account_id) VALUES (?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, type);
			preparedStatement.setInt(2, (int) money);
			preparedStatement.setInt(3, (int) accountId);

			preparedStatement.executeUpdate();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
		}
	}

	@Override
	public List<Transaction> showTransactions(long accountId) throws AppException {
		List<Transaction> transactionList = new ArrayList<>();

		try (Connection connection = Util.getConnection()) {

			String sql = "select  transaction_type, amount from transaction where account_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (int) accountId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Transaction transaction = new Transaction();
				transaction.setType(rs.getString("transaction_type").charAt(0));
				transaction.setMoney(rs.getInt("amount"));

				transactionList.add(transaction);
			}
		} catch (SQLException e) {
			throw new AppException(e);
		}

		return transactionList;
	}

}
