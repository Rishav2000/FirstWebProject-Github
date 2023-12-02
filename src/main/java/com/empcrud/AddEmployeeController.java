package com.empcrud;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addemp")
public class AddEmployeeController extends HttpServlet{
   Employee emp;
   DatabaseConnectionUtility dbUtility;
   public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   dbUtility = new DatabaseConnectionUtility();
	   int empid = Integer.parseInt(req.getParameter("empid"));
	   String empname= req.getParameter("empname");
	   String email = req.getParameter("email");
	   dbUtility.insertEmployee(new Employee(empid, empname, email));
//	   req.setAttribute("emp", new Employee(empid, empname, email));
	   res.sendRedirect(req.getContextPath() + "/employeelist");
   }
}
