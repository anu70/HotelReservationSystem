package com.cognizant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.models.Login;
import com.cognizant.utils.Global;

@Controller
public class LogoutController {
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logout(ModelMap model){
		Global.getInstance().setUser(null);
		model.addAttribute("login", new Login());
		return "LoginForm";
	}
}
