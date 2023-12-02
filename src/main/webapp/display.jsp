<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="css/display.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" integrity="sha512-Avb2QiuDEEvB4bZJYdft2mNjVShBftLdPG8FJ0V7irTLQ8Uo0qcPxh4Plq7G5tGm0rU+1SPhVotteLpBERwTkw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    
</head>
<body>
 <nav class="navbar navbar-expand-lg navbar-dark bg-light">
   <div class="container-fluid">
         <h2 class="app-title">Employee Details Management Application</h2>
   </div>
 </nav>
 <div class="container custom-container">
  <a class="btn btn-danger reload-employee-btn" href="employeelist"><i class="fa-solid fa-rotate-right"></i></a>
  <div>
   <table id="emp_list"  class="table table-striped table-bordered">
      <thead class="thead-dark">
      <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Email</th>
        <th>Action</th>
      </tr>
      </thead>
      <c:forEach var="employee" items="${employees}">
      <tr>
       <td>${employee.getEmpId()}</td>
       <td>${employee.getEmpName()}</td>
       <td>${employee.getEmail()}</td>
       <td><a id="edit" class="btn btn-primary action-links" href="editemployee.jsp?empid=${employee.getEmpId()}&empname=${employee.getEmpName()}&email=${employee.getEmail()}">EDIT</a>
           <a id="delete" class="btn btn-danger action-links" href="deleteemp?empid=${employee.getEmpId()}">DELETE</a>
       </td>
      </tr> 
      </c:forEach>
   </table>
   </div>
   <form action="add_emp.jsp">
      <button onclick="submit" class="btn btn-success add-employee-btn">Add Employee</button>
      
   </form>
   
  </div>
   
   
</body>
</html>