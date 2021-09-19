package com.revature.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.app.dao.TransactionDao;
import com.revature.app.dao.Util;

public class TransactionDaoImpl implements TransactionDao {

	public void performWithdrawl(long Id, long amount) throws SQLException {
		try (Connection connection = Util.getConnection()) {

			String sql = "update bankapp.account set balance = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (int) amount);
			preparedStatement.setInt(2, (int) Id);
			preparedStatement.executeUpdate();
			
			connection.close();

		}

	}

	public void performDeposit(long Id, long amount) throws SQLException {
		try (Connection connection = Util.getConnection()) {

			String sql = "update bankapp.account set balance = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (int) amount);
			preparedStatement.setInt(2, (int) Id);
			preparedStatement.executeUpdate();
			
			connection.close();

		}

	}

	@Override
	public long showBalance(long Id) throws SQLException {
		long balanceReturned = 0;
		try (Connection connection = Util.getConnection()) {

			String sql = "select balance from account where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,(int)Id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				balanceReturned = (long) rs.getInt("balance");
			}

		}
		return balanceReturned;

	}


}
