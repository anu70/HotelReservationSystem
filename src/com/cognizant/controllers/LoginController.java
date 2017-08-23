package com.cognizant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.DAO.UserDAO;
import com.cognizant.models.Login;
import com.cognizant.models.User;
import com.cognizant.utils.Global;

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
	public String processLogin(@ModelAttribute("login")Login login,ModelMap model){
        User user = userDAO.validateUser(login);
        if(user==null){
        	model.addAttribute("message", "The username or password is incorrect.");
        	model.addAttribute("login",new Login("",""));
        	return "LoginForm";
        }
        else{
        	Global.getInstance().setUser(user);
        	Global.getInstance();
			model.addAttribute("username",Global.user.getUsername());
        	if(user.getRole().equals("admin"))
        		return "admin/WelcomeAdmin";
        	else
        		return "redirect:/welcomeCustomer";
        }
		
	}
	
}