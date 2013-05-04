package com.mycompany.mvc;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.mvc.domain.Employees;
import com.mycompany.mvc.service.EmployeesService;

@Controller
public class HrController {

	private static final Logger logger = LoggerFactory
			.getLogger(JspController.class);

	@Autowired
	private EmployeesService employeesService;

	@RequestMapping(value = "/hr/list", method = RequestMethod.GET)
	public String getHrList(Locale locale, Model model, HttpServletRequest request) {
		logger.info("The Request URI is \'{}\'.", request.getRequestURI());

		List<Employees> list =  employeesService.findAll();
		
		for (Employees employees : list) {
			System.out.println(employees);
		}
		
		model.addAttribute("employees", list);
		
		return "hr/hr_list";
	}
	
	@RequestMapping(value = "/hr/list/json", method = RequestMethod.GET)
	public @ResponseBody List<Employees> getHrListAsJson(HttpServletRequest request) {
		logger.info("The Request URI is \'{}\'.", request.getRequestURI());

		List<Employees> list =  employeesService.findAll();
		
		return list;
	}

}
