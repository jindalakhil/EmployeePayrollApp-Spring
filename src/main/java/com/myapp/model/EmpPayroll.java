package com.myapp.model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_payroll")
public class EmpPayroll implements Serializable{
	
	  
	private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    public Long id;
        private String name;
//        private String profile;
        private String gender;
        private String department;
        private double basic_pay;
        private String start;
//        private String notes;
        
        public EmpPayroll() {}
        
        public EmpPayroll(String name, String gender, String department, double salary, String startDate) {
        	this.name = name;
//        	this.profile = profile;
        	this.gender = gender;
        	this.department = department;
        	this.basic_pay = salary;
        	this.start = startDate;
        	//this.notes = notes;
        }
        
}