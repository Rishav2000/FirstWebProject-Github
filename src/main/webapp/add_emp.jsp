<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<link rel="stylesheet" href="css/add_emp.css">
</head>
<body>
<div class="container">
       <h2>Add Employee</h2>
   
       <form action="addemp" method="post"  onsubmit="return validateForm()">
            <div class="form-group">
                <label for="empid">Employee ID:</label>
                <input type="text" class="form-control" id="empid" name="empid" required>
                <div id="empIdError" class="error-message"></div>
            </div>
            <div class="form-group">
                <label for="empname">Employee Name:</label>
                <input type="text" class="form-control" id="empname" name="empname" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="text" class="form-control" id="email" name="email" required>
            </div>
            <button type="submit" class="btn btn-success">Add Employee</button>
       </form>
   </div>
  <script>
        function validateForm() {
            var empIdInput = document.getElementById("empid");
            var empIdValue = empIdInput.value.trim();

            // Check if the value is a number
            if (isNaN(empIdValue)) {
                document.getElementById("empIdError").innerText = "Employee ID must be a number";
                return false;
            } else {
                document.getElementById("empIdError").innerText = "";
                return true;
            }
        }
    </script>
</body>

</html>