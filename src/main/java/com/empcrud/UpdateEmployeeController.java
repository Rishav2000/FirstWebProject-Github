package com.empcrud;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editemp")
public class UpdateEmployeeController extends HttpServlet{
	Employee emp;
	DatabaseConnectionUtility dbUtility;
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        dbUtility = new DatabaseConnectionUtility();
    	int empid = Integer.parseInt(req.getParameter("empid"));
 	    String empname= req.getParameter("empname");
 	    String email = req.getParameter("email");
 	    dbUtility.updateEmployee(new Employee(empid, empname, email));
 	    res.sendRedirect(req.getContextPath() + "/employeelist");
 	   
    }
}
