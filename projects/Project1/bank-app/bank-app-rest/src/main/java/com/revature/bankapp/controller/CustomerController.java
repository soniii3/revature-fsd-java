package com.revature.bankapp.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.revature.bankapp.daoimpl.CustomerDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;

@Path("/customers")
public class CustomerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	private CustomerDaoImpl dao = new CustomerDaoImpl();
	
	@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Customer customer) {
		LOGGER.info("Start");
		LOGGER.debug("{}", customer);
		try {
			dao.create(customer);
			LOGGER.info("End");
			return Response.ok().build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		LOGGER.info("Controller Start");
		Customer customer;
		try {
			customer = dao.getCustomerByEmail("bhaskar@gmail.com");
			return Response.ok().entity(customer).build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
	}
	
	
	
//	@GET
//	@Path("/{email}/{password}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response get(@PathParam("email") String email, @PathParam("password")  String password) {
//		System.out.println("Customer email: " + email);
//		try {
//			Customer customer = dao.getCustomerByEmail(email);
//			if (customer == null) {
//				return Response.status(401).build();
//			}
//			else if (customer.getPassword().equals(password)) {
//				System.out.println("Success");
//				return Response
//						.ok()
//						.entity(customer)
//						.build();
//			} else {
//				System.out.println("failed");
//				return Response.status(401).build();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return Response.status(500).build();
//		}
//
//		
//
//	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response get() {
//		try {
//			Customer customer = dao.getCurrentCustomer();
//			System.out.println(CustomerDaoImpl.currentCustomerId);
//			return Response
//					.ok()
//					.entity(customer)
//					.build();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return Response.status(500).build();
//		}
//
//	}

}
	
	