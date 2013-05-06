package com.mycompany.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.mvc.domain.Employees;
import com.mycompany.mvc.service.EmployeesService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private EmployeesService employeesService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String actionBoard(Model model, HttpServletRequest request) {
		logger.info("The Request URI is \'{}\'.", request.getRequestURI());
	
		int listSize = 10; //리스트 사이즈 설정
		int pageSize = 5; ///페이지 당 보여줄 번호 수[1],[2],[3],[4],[5]
		
		int totalCount = 0; //총 레코드 갯수
		int pageCount = 0; //총 페이지 수
		int currentPage = 1; //페이지 번호
		int currentPageList = 0;	//페이지 순서
		int nextPageList = 0;
		int prevPageList = 0;
		int pageStartNo = 0;
		int pageEndNo = 0;
		
		int startRow = 0;
		int endRow = 11;
		String sidx = "employee_id";		//정렬 대상
		String sord = "asc";				//정렬 방법
		
		//페이징 처리
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		totalCount = employeesService.getTotalCount();	//전체 테이블 갯수
		
		pageCount = totalCount / listSize + (totalCount % listSize>0 ? 1 : 0);
		
		if(currentPage > pageCount){
			currentPage = pageCount;
		}
		
		startRow  = listSize * currentPage - listSize;
		endRow = startRow + listSize + 1;
		
		currentPageList = currentPage/pageSize+( currentPage%pageSize>0 ? 1:0);
		pageEndNo = currentPageList * pageSize;	
		pageStartNo = pageEndNo-(pageSize-1);
		if (pageEndNo > pageCount) {
			pageEndNo = pageCount;
		}
		
		prevPageList = pageStartNo - 1;
		nextPageList = pageStartNo + pageSize;
		if(prevPageList < 1){
			prevPageList=1;
		}
		if (nextPageList > pageCount) {
			// 다음 페이지보다 전체페이지 수보가 클경우
			nextPageList = pageCount / pageSize * pageSize + 1;
			// next_pageno=total_page
			// 다음 페이지 = 전체페이지수 / 페이지당 보여줄 번호수 * 페이지당 보여줄 번호수 + 1
			// ex) = 76 / 5 * 5 + 1 ????????
		}
		
		System.out.println("totalCount:" + totalCount);
		System.out.println("pageCount:" + pageCount);
		System.out.println("currentPage:" + currentPage);
		System.out.println("currentPageList:" + currentPageList);
		System.out.println("prevPageList:" + prevPageList);
		System.out.println("nextPageList:" + nextPageList);
		System.out.println("pageStartNo:" + pageStartNo);
		System.out.println("pageEndNo:" + pageEndNo);
		
		List<Employees> list = employeesService.getEmployeeList(startRow, endRow, sidx, sord);
		
		model.addAttribute("pageStartNo", pageStartNo);
		model.addAttribute("pageEndNo", pageEndNo);
		model.addAttribute("prevPageList", prevPageList);
		model.addAttribute("nextPageList", nextPageList);
		model.addAttribute("listSize", listSize);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("list", list);
		
		return "board/board_list";
	}
	
	@RequestMapping(value = "/daum/jsonp", method = RequestMethod.GET)
	public String actionDaumApi(HttpServletRequest request) {
		logger.info("The Request URI is \'{}\'.", request.getRequestURI());
		
		return "jqgrid/jqgrid_daum_api";
	}
	
	@RequestMapping(value = "/daum/paging", method = RequestMethod.GET)
	public String actionDaumBookApi(HttpServletRequest request) {
		logger.info("The Request URI is \'{}\'.", request.getRequestURI());
		
		return "jqgrid/jqgrid_paging";
	}
	
	//Default Value Collection
	@ModelAttribute("contextRoot")
	public String getContxtRoot(HttpServletRequest request){
		
		String root = request.getContextPath();
		
		return root;
	}
	
}
