<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
   String empid=request.getParameter("empid");
   String empname=request.getParameter("empname");
   String email=request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<link rel="stylesheet" href="css/editemployee.css">
</head>
<body>
   <h2>Update Employee</h2>
   
   <form action="editemp" method="post">
        <div class="form-group">
            <label for="empid">Employee ID:</label>
            <input type="text" class="form-control" name="empid" value="<%= empid %>" readonly>
        </div>
        <div class="form-group">
            <label for="empname">Employee Name:</label>
            <input type="text" class="form-control" name="empname" value="<%= empname %>">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" name="email" value="<%= email %>">
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
   </form>
   
</body>
</html>