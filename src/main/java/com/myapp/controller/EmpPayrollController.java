package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.dto.EmployeePayrollDTO;
import com.myapp.dto.ResponseDTO;
import com.myapp.dto.User;
import com.myapp.exception.EmpPayrollException;
import com.myapp.model.EmpPayroll;
import com.myapp.service.IEmpPayrollService;

@RestController
public class EmpPayrollController {

	@Autowired
	private IEmpPayrollService empPayrollService;

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(empPayrollService.CreateUser(user));
		} catch (EmpPayrollException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(empPayrollService.UpdateUser(user));
		} catch (EmpPayrollException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(empPayrollService.deleteUser(id));
		} catch (EmpPayrollException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/get")
	public ResponseEntity<List<User>> getAllUser() {
		try {
		return ResponseEntity.status(HttpStatus.OK).body(empPayrollService.getAllUser());
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(empPayrollService.getUserById(id));
			}catch(Exception e) {
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
	}

}