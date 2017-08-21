package com.cognizant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.utils.Global;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String showHomeScreen(ModelMap model){
		return "Home";
	}
	
	@RequestMapping(value="/welcomeAdmin",method=RequestMethod.GET)
	public String showWelcomeAdminPage(ModelMap model){
		Global.getInstance();
		if(Global.user==null){
			return "redirect:/login";
		}
		model.addAttribute("username",Global.user.getUsername());
		return "admin/WelcomeAdmin";
	}
}
