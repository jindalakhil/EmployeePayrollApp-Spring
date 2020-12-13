package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.model.EmpPayroll;

public interface EmpPayrollRepository extends JpaRepository<EmpPayroll, Long> {

}