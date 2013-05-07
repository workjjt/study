package com.mycompany.mvc.persistence;

import java.util.HashMap;
import java.util.List;

import com.mycompany.mvc.domain.Employees;

public interface EmployeesMapper {
	
	public int getTotalCount();
	
	public int getTotalCountAsSearch(HashMap<String, String> map);
	
	public List<Employees> findAll();
	
	public List<Employees> getEmployeeList(HashMap<String, String> map);
	
	public List<Employees> getEmployeeListAsSearch(HashMap<String, String> map);
	
	public Employees findById(int employeeId);
	
}
