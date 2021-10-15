//package com.revature.bankapp.controller;
//
//import java.util.List;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.revature.bankapp.dao.EmployeeDao;
//import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
//import com.revature.bankapp.exception.AppException;
//import com.revature.bankapp.model.Customer;
//import com.revature.bankapp.model.Employee;
//import com.revature.bankapp.model.Transaction;
//
//@Path("/employees")
//
//public class EmployeeController {
//	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
//	private EmployeeDao dao = new EmployeeDaoImpl();
//	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response create(Employee employee) {
//		LOGGER.info("Start");
//		LOGGER.debug("{}",employee);
//		try {
//			dao.create(employee);
//			LOGGER.info("End");
//			return Response.ok().build();
//		} catch (AppException e) {
//			return Response.status(500).build();
//		}
//	}
//	
//	//For employee login
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response list() {
//		LOGGER.info("Controller Start");
//		Employee employee;
//		try {
//			employee = dao.getEmployeeByEmail("john@gmail.com");
//			return Response
//					.ok()
//					.entity(employee)
//					.build();
//		} catch (AppException e) {
//			return Response.status(500).build();
//		}
//	}
//	
//	//Getting Customer-details
//	@GET
//	@Path("/{customers}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response customerList() {
//		LOGGER.info("Customer list Start");
//		List<Customer> customerList;
//		try {
//			customerList = dao.viewCustomer();
//			return Response.ok().entity(customerList).build();
//		} catch (AppException e) {
//			return Response.status(500).build();
//		}
//	}
//	
//	//Getting Transaction List
//	@GET
//	@Path("/transactions")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response transactionList() {
//		LOGGER.info("Transaction List Start");
//		List<Transaction> transactionList;
//		try {
//			transactionList = dao.viewTransaction();
//			return Response.ok().entity(transactionList).build();
//		} catch(AppException e) {
//			return Response.status(500).build();
//		}
//	}
//
//}










package com.revature.bankapp.controller;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.bankapp.daoimpl.EmployeeDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Employee;

@Path("/employees")
public class EmployeeController {
	@GET
	@Path("/{email}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("email") String email, @PathParam("password")  String password) {
		System.out.println("Employee userName: " + email);
		try {
		EmployeeDaoImpl empl = new EmployeeDaoImpl();
			Employee employee = empl.getEmployeeUserId(email);
			if (employee == null) {
				System.out.println("Error");
				return Response.status(401).build();
			}
			else if (employee.getPassword().equals(password)) {
				System.out.println("Success");
				return Response
						.ok()
						.entity(employee)
						.build();
			} else {
				

				System.out.println("failed");
				return Response.status(401).build();
			}
			
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
  
  }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		try {
			List<Customer> viewCustomer;
			 EmployeeDaoImpl empl = new EmployeeDaoImpl();
			 viewCustomer = empl.viewCustomer();
			
			System.out.println(viewCustomer);
			return Response
					.ok()
					.entity(viewCustomer)
					.build();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	
	
	
	
	
	
}