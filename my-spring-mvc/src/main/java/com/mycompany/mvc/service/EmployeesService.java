package com.mycompany.mvc.service;

import java.util.List;

import com.mycompany.mvc.domain.Employees;

public interface EmployeesService {
	
	public List<Employees> findAll();
	public Employees findById(int employeeId);
	
}
