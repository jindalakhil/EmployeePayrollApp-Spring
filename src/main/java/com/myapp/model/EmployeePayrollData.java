package com.myapp.model;

import com.myapp.dto.EmployeePayrollDTO;

public class EmployeePayrollData {
	private int empId;
	private String name;
	private long salary;
	
	public EmployeePayrollData() {
		
	}
	
	public EmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		this.empId=empId;
		this.name=empPayrollDTO.name;
		this.salary=empPayrollDTO.salary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
}