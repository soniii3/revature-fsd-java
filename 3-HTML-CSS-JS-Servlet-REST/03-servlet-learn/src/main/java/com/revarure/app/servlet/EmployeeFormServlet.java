package com.revarure.app.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/emp-form")
public class EmployeeFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String[] languages = req.getParameterValues("languages");
        
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html>");
        buffer.append("<body>");
        buffer.append("<h1>Employee Form Data</h1>");
        buffer.append("<table>");
        buffer.append("<tr><td>Name</td><td>").append(name).append("</td></tr>");
        buffer.append("<tr><td>Gender</td><td>").append(gender).append("</td></tr>");
        buffer.append("<tr><td>Languages</td><td>").append(Arrays.toString(languages)).append("</td></tr>");
        buffer.append("</table>");
        buffer.append("</body>");
        buffer.append("</html>");
        resp.getWriter().write(buffer.toString());

    }
}