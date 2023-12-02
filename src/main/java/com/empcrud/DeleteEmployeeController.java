package com.empcrud;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteemp")
public class DeleteEmployeeController extends HttpServlet{
	DatabaseConnectionUtility dbUtility;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    	dbUtility = new DatabaseConnectionUtility();
    	int empid = Integer.parseInt(req.getParameter("empid"));
    	dbUtility.deleteEmployee(empid);
    	res.sendRedirect(req.getContextPath() + "/employeelist");
    }
}
