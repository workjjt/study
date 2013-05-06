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
		
		int currentPage = 1; //페이지 번호
		int totalCount = 0; //총 레코드 갯수
		int pageCount = 0; //총 페이지 수
		
		int pageGroupCount = 0;	//총 페이지 그룹 수
		int currentPageGroup = 0;	//현재 페이지 그룹 번호(1그룹{[1],[2]}, 2그룹{[3],[4]}, 3그룹{[5],[6]})
		int nextPageList = 0;	//[다음]에 대한 페이지 번호
		int prevPageList = 0;	// [이전]에 대한 페이지 번호
		int pageStartNo = 0;	//페이지 시작 번호
		int pageEndNo = 0;		//페이지 끝 번호
		
		int startRow = 0;		//시작 데이터 번호
		int endRow = 0;		//끝 데이터 번호
		
		String sidx = "employee_id";		//정렬 대상
		String sord = "asc";				//정렬 방법
		
		List<Employees> list;		//데이터 저장 리스트
		System.out.println(request.getParameter("sidx"));
		if (request.getParameter("sidx") != null) {
			sidx = request.getParameter("sidx");
		}
		if (request.getParameter("list_size") != null) {
			listSize = Integer.parseInt(request.getParameter("list_size"));
		}
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		//--------------페이징 처리 부분----------------------------------------
		//총 레코드(로우) 수
		totalCount = employeesService.getTotalCount();
		
		//총 페이지 수
		pageCount = totalCount / listSize + (totalCount % listSize > 0 ? 1 : 0);
		if(currentPage > pageCount){ //현재 페이지는 총 페이지 수보다 클수 없다.
			currentPage = pageCount;
		}
		
		//총 페이지 그룹 수
		pageGroupCount = pageCount / pageSize + (pageCount % pageSize > 0 ? 1 : 0);
		
		//현재 페이지 그룹 번호
		currentPageGroup = currentPage / pageSize + ( currentPage % pageSize > 0 ? 1 : 0);
	
		//페이지 출력 시작, 끝 번호
		pageEndNo = currentPageGroup * pageSize;	
		pageStartNo = pageEndNo-(pageSize-1);
		if (pageEndNo > pageCount) {
			pageEndNo = pageCount;
		}
		//[이전][다음]에 대한 페이지 번호
		prevPageList = pageStartNo - 1;
		nextPageList = pageStartNo + pageSize;
		if(prevPageList < 1){
			prevPageList=1;
		}
		if (nextPageList > pageCount) { // 다음 페이지보다 전체페이지 수가 클경우
			nextPageList = pageCount / pageSize * pageSize + 1;
		}
		//--------------페이징 처리 부분 끝--------------------------------------
		
		// 레코드(로우) 시작 번호와 끝 번호 설정
		startRow  = listSize * currentPage - listSize;
		endRow = startRow + listSize + 1;
		
		// 데이터 가져오기
		list = employeesService.getEmployeeList(startRow, endRow, sidx, sord);
		
		model.addAttribute("listSize", listSize);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPage", currentPage);
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageGroupCount", pageGroupCount);
		
		model.addAttribute("pageStartNo", pageStartNo);
		model.addAttribute("pageEndNo", pageEndNo);
		model.addAttribute("prevPageList", prevPageList);
		model.addAttribute("nextPageList", nextPageList);
		model.addAttribute("currentPageGroup", currentPageGroup);
		
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		
		model.addAttribute("sidx", sidx);
		
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
