package com.cognizant.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.DAO.UserDAO;
import com.cognizant.DAOImplementation.UserDAOImpl;
import com.cognizant.models.User;
import com.cognizant.utils.Global;

@Controller
public class RegisterController {
	
	private ApplicationContext applicationContext;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(ModelMap model) {
		model.addAttribute("user", new User(" ", " ", " ", " ", " ", " ", " ", " ", " "));	
		Global.getInstance();
		model.addAttribute("rolesList",Global.rolesList);
		model.addAttribute("citiesList",Global.citiesList);
		model.addAttribute("countriesList", Global.countriesList);
		return "RegistrationForm";                                                                                                                                                                                                                    
	}
	
	@RequestMapping(value = "/processRegistration", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("user")User user,ModelMap model){
		applicationContext = new ClassPathXmlApplicationContext("spring-dispatcher-servlet.xml");
        UserDAO userDAO = (UserDAO) applicationContext.getBean("userDAO");
        
        userDAO.register(user);
		model.addAttribute("username",user.getUsername());
		return "RegistrationSuccessful";
	}
}
