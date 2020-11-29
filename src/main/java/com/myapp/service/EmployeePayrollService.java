package com.myapp.service;

import java.util.ArrayList;
import java.util.List;

import com.myapp.dto.EmployeePayrollDTO;
import com.myapp.model.EmployeePayrollData;

public class EmployeePayrollService implements IEmployeePayrollService {

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		List<EmployeePayrollData> empDataList =new ArrayList<>();
		empDataList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000)));
		return empDataList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		EmployeePayrollData empData =null;
		empData =new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000));
		return empData;
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData =null;
		empData =new EmployeePayrollData(1,empPayrollDTO);
		return empData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData =null;
		empData =new EmployeePayrollData(1,empPayrollDTO);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		// TODO Auto-generated method stub
		
	}

}