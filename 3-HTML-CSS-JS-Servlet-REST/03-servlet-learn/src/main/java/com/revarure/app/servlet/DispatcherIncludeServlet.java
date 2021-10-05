package com.revarure.app.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")

public class DispatcherIncludeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.getWriter().write("<h1>Dispatcher Demo Servlet content</h1>");
		RequestDispatcher rd = req.getRequestDispatcher("content-type");
		rd.include(req, resp);
	}
}
