package com.cognizant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.DAO.UserDAO;
import com.cognizant.models.User;
import com.cognizant.utils.Global;

@Controller
public class RegisterController {
	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(ModelMap model) {
		model.addAttribute("user", new User());	
		Global.getInstance();
		model.addAttribute("rolesList",Global.rolesList);
		model.addAttribute("citiesList",Global.citiesList);
		model.addAttribute("countriesList", Global.countriesList);
		return "RegistrationForm";                                                                                                                                                                                                                    
	}
	
	@RequestMapping(value = "/processRegistration", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("user")User user,BindingResult bindingResult,ModelMap model){
        
        int errorCode = userDAO.register(user);
        if(errorCode==1){
        	model.addAttribute("username",user.getUsername());
    		return "RegistrationSuccessful";
        }
        else{
        	return "redirect:/register";
        }
		
	}
}
