package com.cognizant.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.DAO.AdminDAO;
import com.cognizant.DAO.StaticDataDAO;
import com.cognizant.models.City;
import com.cognizant.models.Hotel;
import com.cognizant.models.Lists;
import com.cognizant.utils.Global;

@Controller
public class AdminController {
	@Autowired
	AdminDAO adminDAO;

	@Autowired
	StaticDataDAO staticDataDAO;

	@RequestMapping(value = "/addHotel", method = RequestMethod.GET)
	public String showAddHotelPage(ModelMap model) {
		Global.getInstance();
		if (Global.user == null) {
			return "redirect:/login";
		}
		if (!Global.user.getRole().equals("admin"))
			return "NotAuthorized";
		model.addAttribute("hotel", new Hotel());
		Lists list1 = new Lists(staticDataDAO.getCitiesList(), 1);
		model.addAttribute("citiesList", list1.cityList);
		model.addAttribute("countriesList", staticDataDAO.getCountriesList());
		return "admin/AddHotel";
	}

	@RequestMapping(value = "/cities", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ArrayList<City> citiesForCountry(
			@RequestParam(value = "countryId", required = true) int countryId) {
		System.out.println(countryId + ".....");

		Lists list1 = new Lists(staticDataDAO.getCitiesList(), countryId);
		// Set<City> set = new TreeSet<City>();
		// set.add(new City(1,1,"Pune"));
		// set.addAll(list1.cityList);
		return list1.cityList;
	}

	/*
	 * @RequestMapping(value = "/countries", method = RequestMethod.GET)
	 * public @ResponseBody Set<Country> findAllStates() { Set<Country> set =
	 * new TreeSet<Country>(); set.addAll(staticDataDAO.getCountriesList());
	 * return set; }
	 */

	@RequestMapping(value = "/processAddHotel", params = "submitButton", method = RequestMethod.POST)
	public String processAddHotel(@ModelAttribute("hotel") Hotel hotel, ModelMap model) {
		if (!hotel.getHotelId().substring(0, 3).matches("[a-zA-Z]+")
				|| !hotel.getHotelId().substring(3).matches("\\d+")) {
			model = addHotelScreenWithErrorMsg(
					"Hotel first 3 characters should be alphabets from hotel name and last 4 characters should be numbers",
					model, hotel);
			return "admin/AddHotel";
		}
		if (hotel.getAcRoomsCount() > 300 || hotel.getNonACRoomsCount() > 300) {
			model = addHotelScreenWithErrorMsg("No of rooms should be less than 300", model, hotel);
			return "admin/AddHotel";
		}
		if (hotel.getRateAdultAC() < 2500 || hotel.getRateAdultAC() > 4000) {
			model = addHotelScreenWithErrorMsg("Rate of AC Room for adults should be between Rs.2500 - Rs.4000 ", model,
					hotel);
			return "admin/AddHotel";
		}
		if (hotel.getRateAdultNonAC() < 2000 || hotel.getRateAdultNonAC() > 2500) {
			model = addHotelScreenWithErrorMsg("Rate of Non-AC Room for adults should be between Rs.2000 - Rs.2500",
					model, hotel);
			return "admin/AddHotel";
		}
		if (hotel.getRateChildAC() < 2000 || hotel.getRateChildAC() > 3000) {
			model = addHotelScreenWithErrorMsg("Rate of AC Room for child should be between Rs.2000 - Rs.3000", model,
					hotel);
			return "admin/AddHotel";
		}
		if (hotel.getRateChildNonAC() < 1000 || hotel.getRateChildNonAC() > 2000) {
			model = addHotelScreenWithErrorMsg("Rate of Non-AC Room for child should be between Rs.1000 - Rs.2000",
					model, hotel);
			return "admin/AddHotel";
		}
		int errorCode = adminDAO.addHotel(hotel);
		if (errorCode == 2) {
			JOptionPane.showMessageDialog(null, "Hotel with the hotel id:" + hotel.getHotelId() + " already exist.Please enter another hotel id");

			model = addHotelScreenWithErrorMsg(
					"",
					model, hotel);
			return "admin/AddHotel";
		}

		if (errorCode == 1) {
			JOptionPane.showMessageDialog(null, "Hotel successfully added.Hotel id: " + hotel.getHotelId());
			Global.getInstance();
			model.addAttribute("username", Global.user.getUsername());
			return "admin/WelcomeAdmin";
		} else {
			JOptionPane.showMessageDialog(null, "Error adding hotel.Please try again");
			return "redirect:/addHotel";
		}
	}

	@RequestMapping(value = "/editHotel", method = RequestMethod.GET)
	public String showEditHotelPage(ModelMap model) {
		Global.getInstance();
		if (Global.user == null) {
			return "redirect:/login";
		}

		if (!Global.user.getRole().equals("admin"))
			return "NotAuthorized";

		List<String> hotelIds = new ArrayList<String>();
		for (int i = 0; i < adminDAO.getAllHotels().size(); i++)
			hotelIds.add(adminDAO.getAllHotels().get(i).getIdentifyHotel());
		model.addAttribute("hotel", new Hotel());
		model.addAttribute("hotelIds", hotelIds);
		return "admin/EditHotel";
	}

	@RequestMapping(value = "/processEditHotel", method = RequestMethod.POST)
	public String processEditHotel(@ModelAttribute("hotel") Hotel hotel, ModelMap model) {
		hotel.setHotelId(hotel.getIdentifyHotel().split("\\..")[0]);
		int errorCode = adminDAO.editHotel(hotel);
		if (errorCode == 1) {
			Global.getInstance();
			model.addAttribute("username", Global.user.getUsername());
			return "admin/WelcomeAdmin";
		} else {
			return "redirect:/editHotel";
		}
	}

	@RequestMapping(value = "/deleteHotel", method = RequestMethod.GET)
	public String showDeleteHotelPage(ModelMap model) {
		Global.getInstance();
		if (Global.user == null) {
			return "redirect:/login";
		}

		if (!Global.user.getRole().equals("admin"))
			return "NotAuthorized";

		List<String> hotelIds = new ArrayList<String>();
		for (int i = 0; i < adminDAO.getAllHotels().size(); i++)
			hotelIds.add(adminDAO.getAllHotels().get(i).getIdentifyHotel());
		model.addAttribute("hotel", new Hotel());
		model.addAttribute("hotelIds", hotelIds);
		return "admin/DeleteHotel";
	}

	@RequestMapping(value = "/processDeleteHotel", method = RequestMethod.POST)
	public String processDeleteHotel(@ModelAttribute("hotel") Hotel hotel, ModelMap model) {
		hotel.setHotelId(hotel.getIdentifyHotel().split("\\..")[0]);
		int errorCode = adminDAO.deleteHotel(hotel);
		if (errorCode == 2) {
			JOptionPane.showMessageDialog(null,
					"This hotel have future booking so you can't delete it." + hotel.getHotelId());
			return "redirect:/deleteHotel";
		} else if (errorCode == 1) {
			Global.getInstance();
			model.addAttribute("username", Global.user.getUsername());
			return "admin/WelcomeAdmin";
		} else {
			return "redirect:/deleteHotel";
		}
	}

	public ModelMap addHotelScreenWithErrorMsg(String msg, ModelMap model, Hotel hotel) {
		model.addAttribute("hotel", hotel);
		model.addAttribute("message", msg);
		Lists list1 = new Lists(staticDataDAO.getCitiesList(), 1);
		model.addAttribute("citiesList", list1.cityList);
		model.addAttribute("countriesList", staticDataDAO.getCountriesList());
		return model;
	}
}
