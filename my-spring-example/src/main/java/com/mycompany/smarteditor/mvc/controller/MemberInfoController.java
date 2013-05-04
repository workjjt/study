package com.mycompany.smarteditor.mvc.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.smarteditor.service.ContentsService;

@Controller
public class MemberInfoController {

	@Autowired
	private ContentsService contentsService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberInfoController.class);

		@RequestMapping(value = "/member/login", method = RequestMethod.GET)
		public String login(Locale locale, Model model) {
			
			logger.info("Login....", locale);
			
			return "login";
		}
		
		@RequestMapping(value = "member/login_check", method = RequestMethod.POST)
		public String memberLoginCheck(Locale locale, Model model){
			
			return "redirect:/";
		}
	
	
	
}
