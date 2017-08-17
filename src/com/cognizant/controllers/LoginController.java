package com.cognizant.controllers;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.DAO.UserDAO;
import com.cognizant.models.Login;
import com.cognizant.models.User;

@Controller
public class LoginController {
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String showLoginForm(ModelMap model) {
		model.addAttribute("login",new Login("",""));
		return "LoginForm";
	}
	
	@RequestMapping(value="/processLogin",method = RequestMethod.POST)
	public String processLogin(@Valid @ModelAttribute("login")Login login,BindingResult result,ModelMap model){
        User user = userDAO.validateUser(login);
        if(user==null){
        	return "LoginForm";
        }
        else{
        	model.addAttribute("username",user.getUsername());
    		return "WelcomeAdmin";
        }
		
	}
}