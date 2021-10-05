package com.revature.app;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.app.model.Employee;

public class GetAllEmployeesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        
        
        
        List<Employee> employeeList = session.createQuery("from Employee", Employee.class).getResultList();
		for (Employee employee : employeeList) {
			System.out.println(employee.getName());
			System.out.println(employee.getDepartment());
			System.out.println(employee.getSkillList());
		}

	}

}
