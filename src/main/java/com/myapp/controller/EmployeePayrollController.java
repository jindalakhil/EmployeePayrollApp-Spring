package com.myapp.controller;

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
import com.myapp.model.EmployeePayrollData;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",300000));
		ResponseDTO respDTO = new ResponseDTO("Get call for Success ",empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",300000));
		ResponseDTO respDTO = new ResponseDTO("Get Call success for ID  ",empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1,empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Created EmployeePayroll Data Success",empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1,empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated EmployeePayroll Data Success  ",empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	//nothing is done here!!
	@DeleteMapping
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id "+empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

}