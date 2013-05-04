package com.mycompany.mvc;

import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.mvc.domain.Member;


@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String actionMember(Locale locale, Model model, HttpServletRequest request) {
		logger.info("The Request URI is \'{}\'.", request.getRequestURI()); // '/mvc/member/add'
		logger.info("The Request URI is \'{}\'.", request.getRequestURL()); // 'http://localhost:8088/mvc/member/add'
		logger.info("\'{}\'.", request.getServletPath()); 
		
		Enumeration<String> em = request.getHeaderNames();
		while (em.hasMoreElements()) {
			String string = (String) em.nextElement();
			System.out.println(string + " = " + request.getHeader(string));
		}
		
		return "member/member_add";
	}
	
	@RequestMapping(value = "/member/add", method = RequestMethod.POST)
	public String addMember(Member member, Model model, HttpServletRequest request) {
		logger.info("The Request URI is \'{}\'.", request.getRequestURI()); 

		//request 객체로 직접 받기
		System.out.println(request.getParameter("country"));
		
		//Check Box 처리
		if(member.getArrChk() != null){
			for(int i=0; i < member.getArrChk().length; i++){
				System.out.println(member.getArrChk()[i]);
			}
		}
		
		//Select Box 처리
		System.out.println(member.getCountry());
		
		if(member.getHobby() != null){
			for(int i=0; i < member.getHobby().length; i++){
				System.out.println(member.getHobby()[i]);
			}
		}
		
		return "redirect:/";
	}
	
	//Default Value Collection
	@ModelAttribute("contextRoot")
	public String getContxtRoot(HttpServletRequest request){
		
		String root = request.getContextPath();
		
		return root;
	}
}
