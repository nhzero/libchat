package com.libchat.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
@RequestMapping("/index")
public class MainController{
 
	@RequestMapping(method = RequestMethod.GET)
	public String ping(ModelMap model) {
		
		Date date = new Date();
		model.addAttribute("message", date.toString());
		return "index";
 
	}
 
}