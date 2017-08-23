package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.DAO.CustomerDAO;
import com.cognizant.models.Hotel;
import com.cognizant.models.Trip;
import com.cognizant.utils.Global;

@Controller
public class CustomerController {
	@Autowired
	CustomerDAO customerDAO;
	@RequestMapping(value="/welcomeCustomer",method = RequestMethod.GET)
	public String showSearchPage(ModelMap model){
		Global.getInstance();
		if(Global.user==null){
			return "redirect:/login";
		}		
		model.addAttribute("trip",new Trip());
		model.addAttribute("username",Global.user.getUsername());
		model.addAttribute("citiesList",Global.citiesList);
		model.addAttribute("countriesList", Global.countriesList);
		return "customer/WelcomeCustomer";
	}
	
	@RequestMapping(value="/availableHotels",method = RequestMethod.POST)
	public String processSearch(@ModelAttribute("trip")Trip trip,ModelMap model){
		System.out.println(trip.getStartDate());
		List<Hotel> hotels = customerDAO.getAllAvailableHotels(trip);
		model.addAttribute("lists",hotels);
		return "customer/AvailableHotels";
	}
}
