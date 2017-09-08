package com.cognizant.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.DAO.StaticDataDAO;
import com.cognizant.DAO.UserDAO;
import com.cognizant.models.City;
import com.cognizant.models.Country;
import com.cognizant.models.User;
import com.cognizant.utils.Global;

@Controller
public class RegisterController {
	@Autowired
	UserDAO userDAO;
	@Autowired
	StaticDataDAO staticDataDAO;
	


	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(ModelMap model) {
		Global.getInstance();
		model.addAttribute("user", new User());	
		model.addAttribute("rolesList",Global.rolesList);
		ArrayList<Country> countryList = staticDataDAO.getCountriesList();
		if(countryList.size()>0)
			model.addAttribute("startCountrycitiesList", staticDataDAO.getCitesOfCountry(countryList.get(0).getId()));
		else
			model.addAttribute("startCountrycitiesList",new ArrayList<City>());
		model.addAttribute("citiesList", staticDataDAO.getCitiesList());
		model.addAttribute("countriesList", countryList);
		return "RegistrationForm";                                                                                                                                                                                                                    
	}
	
	@RequestMapping(value = "/processRegistration", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("user")User user,BindingResult bindingResult,ModelMap model){
        if(user.getRole().equals("admin") && userDAO.adminAlreadyExist()){
        	model = registrationScreenWithErrorMsg(model,user,"Admin already exist.Please change your role to customer");
        	return "RegistrationForm";
        }
        int errorCode = userDAO.register(user);
        if(errorCode==1){
        	model.addAttribute("username",user.getUsername());
    		return "RegistrationSuccessful";
        }
        else{
    		model = registrationScreenWithErrorMsg(model,user,"Email id you have entered already exist.Please enter a new email id.");
        	return "RegistrationForm";
        }
	}
	
	public ModelMap registrationScreenWithErrorMsg(ModelMap model,User user,String msg){
		model.addAttribute("user", user);	
		model.addAttribute("rolesList",Global.rolesList);
		ArrayList<Country> countryList = staticDataDAO.getCountriesList();
		if(countryList.size()>0)
			model.addAttribute("startCountrycitiesList", staticDataDAO.getCitesOfCountry(countryList.get(0).getId()));
		else
			model.addAttribute("startCountrycitiesList",new ArrayList<City>());
		model.addAttribute("citiesList", staticDataDAO.getCitiesList());
		model.addAttribute("countriesList", countryList);
    	model.addAttribute("message",msg);
    	return model;
	}
	
}
