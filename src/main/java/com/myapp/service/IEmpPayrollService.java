package com.myapp.service;

import java.util.List;

import com.myapp.dto.EmployeePayrollDTO;
import com.myapp.dto.User;
import com.myapp.exception.EmpPayrollException;
import com.myapp.model.EmpPayroll;

public interface IEmpPayrollService {

	User CreateUser(User user) throws EmpPayrollException;

	User UpdateUser(User user) throws EmpPayrollException;

	User deleteUser(Long id) throws EmpPayrollException;

	List<User> getAllUser();
	
	User getUserById(Long id) throws EmpPayrollException;

}