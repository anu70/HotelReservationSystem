package com.cognizant.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.DAO.AdminDAO;
import com.cognizant.models.Hotel;
import com.cognizant.utils.Global;

@Controller
public class AdminController {
	@Autowired
	AdminDAO adminDAO;
	@RequestMapping(value="/addHotel",method=RequestMethod.GET)
	public String showAddHotelPage(ModelMap model){
		model.addAttribute("hotel",new Hotel());
		Global.getInstance();
		model.addAttribute("citiesList",Global.citiesList);
		model.addAttribute("countriesList", Global.countriesList);
		return "admin/AddHotel";
	}
	
	@RequestMapping(value="/processAddHotel",method = RequestMethod.POST)
	public String processAddHotel(@ModelAttribute("hotel")Hotel hotel ,ModelMap model){
		 int errorCode = adminDAO.addHotel(hotel);
	        if(errorCode==1){
	        	Global.getInstance();
				model.addAttribute("username",Global.user.getUsername());
	    		return "admin/WelcomeAdmin";
	        }
	        else{
	        	return "redirect:/admin/AddHotel";
	        }
	}
	
	@RequestMapping(value="/editHotel",method=RequestMethod.GET)
	public String showEditHotelPage(ModelMap model){
		List<String> hotelIds = new ArrayList<String>();
		for(int i=0;i<adminDAO.getAllHotels().size();i++)
			hotelIds.add(adminDAO.getAllHotels().get(i).getIdentifyHotel());
		model.addAttribute("hotel",new Hotel());
		model.addAttribute("hotelIds",hotelIds);
		return "admin/EditHotel";
	}
	
	@RequestMapping(value="/processEditHotel",method = RequestMethod.POST)
	public String processEditHotel(@ModelAttribute("hotel")Hotel hotel ,ModelMap model){
		hotel.setHotelId(hotel.getIdentifyHotel().split("\\..")[0]);
		 int errorCode = adminDAO.editHotel(hotel);
	        if(errorCode==1){
	        	Global.getInstance();
				model.addAttribute("username",Global.user.getUsername());
	    		return "admin/WelcomeAdmin";
	        }
	        else{
	        	return "redirect:/admin/EditHotel";
	        }
	}
}
