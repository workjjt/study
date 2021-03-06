package com.mycompany.mvc.service;

import java.util.List;

import com.mycompany.mvc.domain.Employees;

public interface EmployeesService {
	
	public int getTotalCount();
	public int getTotalCountAsSearch(String searchTarget, String searchWord);
	public List<Employees> getEmployeeList(int startRow, int endRow, String sidx, String sord);
	public List<Employees> getEmployeeList(int startRow, int endRow, String sidx, String sord, String searchTarget, String searchWord);
	public List<Employees> findAll();
	public Employees findById(int employeeId);
	
}
