package com.empcrud;


import java.util.HashSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionUtility {
	
	 private String SEARCH_QUERY="select * from empdetails";
	 private String INSERT_QUERY="insert into empdetails(empid, empname, email) values(?,?,?)";
     private String UPDATE_QUERY="update empdetails set empname=?, email=? where empid=?";
	 private String DELETE_QUERY="delete from empdetails where empid=?";
	 
	 private String url = "jdbc:postgresql://localhost:5432/EmployeeDB";
	 private String dbuser="postgres";
	 private String dbpassword="admin";
	 
	 
	 
	 HashSet <Employee> emps = new HashSet<>();
	 
     public Connection createDBConnection() {
    	 Connection con=null;
    	 try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,dbuser,dbpassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Eshtablishing Connection with the database");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Eshtablishing Connection with the database");
			e.printStackTrace();
		}
		return con; 
     }
	 
	 public HashSet<Employee> selectData() {
		 int id;
		 String name;
		 String email;
		 try (Statement stm= createDBConnection().createStatement();){
			 ResultSet resultset = stm.executeQuery(SEARCH_QUERY);
			 while(resultset.next()) {
				 id= Integer.parseInt(resultset.getString("empid"));
				 name=resultset.getString("empname");
				 email=resultset.getString("email");
				 emps.add(new Employee(id, name, email));
			 }
			 createDBConnection().close();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return emps;
	 }

	public void insertEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try (PreparedStatement preparedStatement = createDBConnection().prepareStatement(INSERT_QUERY)){
			 preparedStatement.setInt(1, emp.getEmpId());
			 preparedStatement.setString(2, emp.getEmpName());
			 preparedStatement.setString(3, emp.getEmail());
			 preparedStatement.executeUpdate();
			 createDBConnection().close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteEmployee(int empid) {
		try (PreparedStatement preparedStatement = createDBConnection().prepareStatement(DELETE_QUERY)){
			 preparedStatement.setInt(1, empid);
			 preparedStatement.executeUpdate();
			 createDBConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateEmployee(Employee emp) {
		try (PreparedStatement preparedStatement = createDBConnection().prepareStatement(UPDATE_QUERY)){
			 preparedStatement.setString(1, emp.getEmpName());
			 preparedStatement.setString(2, emp.getEmail());
			 preparedStatement.setInt(3, emp.getEmpId());
			 preparedStatement.executeUpdate();
			 createDBConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	 
}
