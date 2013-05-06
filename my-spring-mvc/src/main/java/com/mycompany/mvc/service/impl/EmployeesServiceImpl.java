package com.mycompany.mvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.mvc.domain.Employees;
import com.mycompany.mvc.persistence.EmployeesMapper;
import com.mycompany.mvc.service.EmployeesService;

@Service("employeesService")
@Repository
@Transactional
public class EmployeesServiceImpl implements EmployeesService {

	private Log log = LogFactory.getLog(EmployeesServiceImpl.class);	
	
	@Autowired
	private EmployeesMapper employeesMapper;
	
	@Override
	public int getTotalCount() {
		
		int totalCount = employeesMapper.getTotalCount();
		
		return totalCount;
	}
	
	@Override
	public List<Employees> getEmployeeList(int startRow, int endRow, String sidx, String sord) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("startRow", String.valueOf(startRow));
		map.put("endRow", String.valueOf(endRow));
		map.put("sidx", sidx);
		map.put("sord", sord);
		
		System.out.println(map);
		
		List<Employees> list = employeesMapper.getEmployeeList(map);
		
		return list;
	}

	
	@Transactional(readOnly=true)
	@Override
	public List<Employees> findAll() {
		
		List<Employees> list = employeesMapper.findAll();
		
		return list;
	}

	@Transactional(readOnly=true)
	@Override
	public Employees findById(int employeeId) {

		Employees employees = employeesMapper.findById(employeeId);
		
		return employees;
	}
}
