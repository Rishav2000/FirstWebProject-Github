package com.empcrud;

public class Employee {
	  private int empId;
	  private String empName;
	  private String email;
	  public Employee(int empId, String empName, String email) {
			super();
			setEmpId(empId);
			setEmpName(empName);
			setEmail(email);
	 }
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empname) {
		this.empName = empname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	  
  
  
}
