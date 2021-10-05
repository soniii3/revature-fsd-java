package com.revature.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.app.model.Employee;

public class SelectDemo {
	public static void main(String[] args) {

		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learndb", "root", "17JD1a0595$");
			String sql = "select * from employee";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			List<Employee> employeeList = new ArrayList<>();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("name"));
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getDouble("salary"));
				employee.setGender(resultSet.getString("gender").charAt(0));
				employee.setDepartmentId(resultSet.getInt("department_id"));
				employeeList.add(employee);
			}
			employeeList.forEach(System.out::println);
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
