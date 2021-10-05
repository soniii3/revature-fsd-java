package com.revature.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learndb", "root", "17JD1a0595$");
			System.out.println("Connection successful");
			
			String sql = "insert into department(name) values ('Innovation')";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			
			String departmentName = "Statistics";
			sql = "insert into department (name) values ('" + departmentName + "')";
			statement.executeUpdate(sql);

			departmentName = "Research";
			sql = "insert into department (name) values ('" + departmentName + "')";
			statement.executeUpdate(sql);

			String email = "123@gmail.com' or 1 = 1";
			sql = "select * from user where email = '" + email + "'";

			sql = "select * from user where email = '123@gmail.com' or 1 = 1";

			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
