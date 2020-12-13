package com.myapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.dto.EmployeePayrollDTO;
import com.myapp.dto.User;
import com.myapp.exception.EmpPayrollException;
import com.myapp.model.EmpPayroll;
import com.myapp.repository.EmpPayrollRepository;


@Service
public class EmpPayrollService implements IEmpPayrollService {

	@Autowired
	private EmpPayrollRepository empPayrollRepository;

	@Override
	public User CreateUser(User user) throws EmpPayrollException {
		if (Objects.nonNull(user.getName()) && Objects.nonNull(user.getSalary())) {
			EmpPayroll empPayroll = new EmpPayroll(user.getName(),
					user.getGender(), user.getDepartment(), user.getSalary(), user.getStartDate());
			return new User(empPayrollRepository.save(empPayroll));
		} else {
			throw new EmpPayrollException("Invalid Entry");
		}
	}

	@Override
	public User UpdateUser(User user) throws EmpPayrollException {

		return empPayrollRepository.findById(user.getId()).map(employee -> {
			if (Objects.nonNull(user.getName())) {
				employee.setName(user.getName());
			}
			if (Objects.nonNull(user.getSalary())) {
				employee.setBasic_pay(user.getSalary());
			}
			return new User(empPayrollRepository.save(employee));
		}).orElseThrow(() -> new EmpPayrollException("Employee match not found"));
	}

	@Override
	public User deleteUser(Long id) throws EmpPayrollException {
		return empPayrollRepository.findById(id).map(employee -> {
			empPayrollRepository.deleteById(employee.getId());
			return new User(employee);
		}).orElseThrow(() -> new EmpPayrollException("Employee match not found"));
	}

	@Override
	public List<User> getAllUser() {
		return empPayrollRepository.findAll().stream().map(employee -> new User(employee)).collect(Collectors.toList());
	}

	@Override
	public User getUserById(Long id) throws EmpPayrollException {
		EmpPayroll emp = empPayrollRepository.findById(id).orElse(null);
		if (Objects.nonNull(emp)) {
			return new User(emp);
		} else {
			throw new EmpPayrollException("Employee match not found");
		}
	}
}