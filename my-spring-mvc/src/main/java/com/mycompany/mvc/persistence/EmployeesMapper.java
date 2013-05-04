package com.mycompany.mvc.persistence;

import java.util.List;

import com.mycompany.mvc.domain.Employees;
import com.mycompany.mvc.domain.Member;

public interface EmployeesMapper {
	
	public List<Employees> findAll();
	public Employees findById(int employeeId);
	
}
