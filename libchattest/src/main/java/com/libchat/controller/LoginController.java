package com.libchat.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.libchat.services.LoginService;
import com.libchat.services.LoginServiceImpl;
 
@Controller
@RequestMapping("/login")
public class LoginController{
 
	@Autowired
	private LoginServiceImpl loginService;
	
	
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String ping(@RequestParam("username") String username, @RequestParam("pass") String pass
			, ModelMap model) {
		
		
		if(loginService.checkLogin(username, pass)) {
			Date date = new Date();
			model.addAttribute("message", date.toString());
			return "true";
		}
		else {
			return "false";
		}
 
	}
 
}