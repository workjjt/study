package com.mycompany.mvc;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.mvc.domain.Member;

@Controller
public class JspController {
	
private static final Logger logger = LoggerFactory.getLogger(JspController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/jsp/el", method = RequestMethod.GET)
	public String jsp(Locale locale, Model model, HttpServletRequest request) {
		logger.info("The Request URI is \'{}\'.", request.getRequestURI());
		
		model.addAttribute("code", "안녕");
		Member member = new Member();
		member.setUsername("전준태");
		model.addAttribute("member", member);
		
		return "jsp/el";
	}
	
	@RequestMapping(value = "/jsp/jstl", method = RequestMethod.GET)
	public String jstl(Locale locale, Model model, HttpServletRequest request) {
		logger.info("The Request URI is \'{}\'.", request.getRequestURI());
		
		model.addAttribute("code", "안녕");
		Member member = new Member();
		member.setUsername("전준태");
		model.addAttribute("member", member);
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int i=0; i < 10; i++){
			arrayList.add(i + 1);
			map.put(i, "값" + i);
		}
		model.addAttribute("arrayList", arrayList);
		model.addAttribute("hashMap", map);
		
		return "jsp/jstl";
	}
}
