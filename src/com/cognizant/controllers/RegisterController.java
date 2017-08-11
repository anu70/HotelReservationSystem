package com.cognizant.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.models.User;
import com.cognizant.utils.Global;

@Controller
public class RegisterController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(ModelMap model) {
		model.addAttribute("user", new User(" ", " ", " ", " ", " ", " ", " ", " ", " "));		
		model.addAttribute("rolesList",Global.getInstance().rolesList);
		model.addAttribute("citiesList",Global.getInstance().citiesList);
		model.addAttribute("countriesList", Global.getInstance().countriesList);
		return "RegistrationForm";                                                                                                                                                                                                                    
	}
	
	@RequestMapping(value = "/processRegistration", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("user")User user,ModelMap model){
		model.addAttribute("username",user.getUsername());
		return "RegistrationSuccessful";
	}
}
