package com.empcrud;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/employeelist")
public class MainController extends HttpServlet{
	DatabaseConnectionUtility dbUtility;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    	dbUtility = new DatabaseConnectionUtility();
     	HashSet<Employee> employees = dbUtility.selectData();
     	req.setAttribute("employees", employees);
     	RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
     	rd.forward(req,res);
    	
    	
    }
   
}
