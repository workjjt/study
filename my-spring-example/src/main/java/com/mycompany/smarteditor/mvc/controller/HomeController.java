package com.mycompany.smarteditor.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.smarteditor.domain.Contents;
import com.mycompany.smarteditor.service.ContentsService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ContentsService contentsService;
	
	
	//Default Value Collection
	@ModelAttribute("contextRoot")
	public String getContxtRoot(HttpServletRequest request){
		
		String root = request.getContextPath();
		
		return root;
	}
	
	
	//Action 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home!", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("menuName", "home");
		
		return "home";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Locale locale, Model model) {
		logger.info("Welcome about!", locale);
		
		model.addAttribute("menuName", "about");
		
		return "about";
	}
	
	@RequestMapping(value = "/programming", method = RequestMethod.GET)
	public String programming(Locale locale, Model model) {
		logger.info("Welcome programming!", locale);
		
		model.addAttribute("menuName", "programming");
		
		return "programming_bootstrap_01";
	}
	
	@RequestMapping(value = "/programming/bootstrap/01", method = RequestMethod.GET)
	public String programmingBootstrapA(Locale locale, Model model) {
		logger.info("Welcome programming!", locale);
		
		model.addAttribute("menuName", "programming");
		
		return "programming_bootstrap_01";
	}
	

	@RequestMapping(value = "/programming/plugin/01", method = RequestMethod.GET)
	public String programmingPluginA(Locale locale, Model model) {
		logger.info("Welcome programming!", locale);
		
		model.addAttribute("menuName", "programming_plugin_01");
		
		return "programming_plugin_01";
	}
	
	@RequestMapping(value = "/programming/javascript/01", method = RequestMethod.GET)
	public String programmingJavascriptA(Locale locale, Model model) {
		logger.info("Welcome programming!", locale);
		
		model.addAttribute("menuName", "programming_javascript_01");
		
		return "programming_javascript_01";
	}
	

}
