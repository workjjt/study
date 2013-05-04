package com.mycompany.smarteditor.mvc.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.smarteditor.domain.Contents;
import com.mycompany.smarteditor.mvc.ContentModel;
import com.mycompany.smarteditor.service.ContentsService;

@Controller
public class SmartEditorController {

	private static final Logger logger = LoggerFactory.getLogger(SmartEditorController.class);
		
	@Autowired
	private ContentsService contentsService;
	
	@RequestMapping(value = "smarteditor/set", method = RequestMethod.POST)
	public String setContent(@RequestParam(value = "ir1") String ir1, @ModelAttribute ContentModel bean, Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		//form 다운 받는 방법
		logger.info(request.getParameter("ir1"), locale);
		logger.info(bean.getIr1(), locale);
		logger.info(ir1, locale);
		
		Contents contents = new Contents();
		contents.setContent(ir1);
		
		contentsService.insertContents(contents);
		
		return "redirect:/";
	}
	
}
