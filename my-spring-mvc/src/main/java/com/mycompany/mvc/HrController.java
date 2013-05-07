package com.mycompany.mvc;

import java.util.Enumeration;
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
import com.mycompany.mvc.domain.JsonModel;
import com.mycompany.mvc.service.EmployeesService;

@Controller
public class HrController {

	private static final Logger logger = LoggerFactory
			.getLogger(JspController.class);

	@Autowired
	private EmployeesService employeesService;
	
	@RequestMapping(value = "/jqgrid/list", method = RequestMethod.GET)
	public String actionHrListPaging(Locale locale, Model model, HttpServletRequest request) {
		logger.info("The Request URI is \'{}\'.", request.getRequestURI());
				
		return "jqgrid/jqgrid_list_paging";
	}
	
	@RequestMapping(value = "/jqgrid/list/json", method = RequestMethod.GET)
	public @ResponseBody JsonModel getHrListAsJsonTest(Model model, HttpServletRequest request) throws Exception {
		
		logger.info("The Request URI is \'{}\'.", request.getRequestURI());
		
		int totalCount = 0; //총 레코드 갯수
		int listSize = 10; //리스트 표시 사이즈 
		int pageCount = 0; //총 페이지 수
		int currentPage = 1; //페이지 번호
		int startRow = 0; //페이지의 시작글 번호
		int endRow = 0; //페이지의 마지막 글 번호
		
		String sidx = "employee_id";		//정렬 대상
		String sord = "asc";				//정렬 방법
		
		Enumeration<String> em = request.getParameterNames();
		
		while (em.hasMoreElements()) {
			String string = (String) em.nextElement();
			System.out.println(string + " = " + request.getParameter(string));
		}
		
		if (request.getParameter("sidx") != null) {
			sidx = request.getParameter("sidx");
		}
		if (request.getParameter("sord") != null) {
			sord = request.getParameter("sord");
		}
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		totalCount = employeesService.getTotalCount();
		pageCount = (int) ((double) totalCount / listSize + 0.95); // 0.95를 더해서 올림

		startRow  = listSize * currentPage - listSize; 
		endRow = startRow + listSize + 1;
		
		System.out.println("---------------------------");
		System.out.println("pageCount = " + pageCount);
		System.out.println("currentPage = " + currentPage);
		System.out.println(startRow + " : " + endRow );
		
		List<Employees> list =  employeesService.getEmployeeList(startRow, endRow, sidx, sord);
		
		JsonModel jm = new JsonModel();
		
		jm.setPage(currentPage);
		jm.setTotal(pageCount);
		jm.setRecords(totalCount);
		jm.setRows(list);
		
		model.addAttribute("real_page", currentPage);
		
		return jm;
	}

}
