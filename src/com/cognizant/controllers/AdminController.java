package com.cognizant.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.DAO.AdminDAO;
import com.cognizant.DAO.StaticDataDAO;
import com.cognizant.models.City;
import com.cognizant.models.Country;
import com.cognizant.models.Hotel;
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
		ArrayList<Country> countryList = staticDataDAO.getCountriesList();
		if(countryList.size()>0)
			model.addAttribute("startCountrycitiesList", staticDataDAO.getCitesOfCountry(countryList.get(0).getId()));
		else
			model.addAttribute("startCountrycitiesList",new ArrayList<City>());
		model.addAttribute("citiesList", staticDataDAO.getCitiesList());
		model.addAttribute("countriesList", countryList);
		return "admin/AddHotel";
	}

	@RequestMapping(value = "/processAddHotel", params = "submitButton", method = RequestMethod.POST)
	public String processAddHotel(@ModelAttribute("hotel") Hotel hotel, ModelMap model) {
		if (!hotel.getHotelId().substring(0, 3).matches("[a-zA-Z]+")
				|| !hotel.getHotelId().substring(3).matches("\\d+")) {
			model = addHotelScreenWithErrorMsg(
					"Hotel first 3 characters should be alphabets from hotel name and last 4 characters should be numbers",
					"", 0, model, hotel);
			return "admin/AddHotel";
		}
		if (hotel.getAcRoomsCount() > 300 || hotel.getNonACRoomsCount() > 300) {
			model = addHotelScreenWithErrorMsg("No of rooms should be less than 300", "", 0, model, hotel);
			return "admin/AddHotel";
		}
		if (hotel.getRateAdultAC() < 2500 || hotel.getRateAdultAC() > 4000) {
			model = addHotelScreenWithErrorMsg("Rate of AC Room for adults should be between Rs.2500 - Rs.4000 ", "", 0,
					model, hotel);
			return "admin/AddHotel";
		}
		if (hotel.getRateAdultNonAC() < 2000 || hotel.getRateAdultNonAC() > 2500) {
			model = addHotelScreenWithErrorMsg("Rate of Non-AC Room for adults should be between Rs.2000 - Rs.2500", "",
					0, model, hotel);
			return "admin/AddHotel";
		}
		if (hotel.getRateChildAC() < 2000 || hotel.getRateChildAC() > 3000) {
			model = addHotelScreenWithErrorMsg("Rate of AC Room for child should be between Rs.2000 - Rs.3000", "", 0,
					model, hotel);
			return "admin/AddHotel";
		}
		if (hotel.getRateChildNonAC() < 1000 || hotel.getRateChildNonAC() > 2000) {
			model = addHotelScreenWithErrorMsg("Rate of Non-AC Room for child should be between Rs.1000 - Rs.2000", "",
					0, model, hotel);
			return "admin/AddHotel";
		}
		int errorCode = adminDAO.addHotel(hotel);
		if (errorCode == 2) {
			model = addHotelScreenWithErrorMsg(
					"Hotel with the hotel id:" + hotel.getHotelId() + " already exist.Please enter another hotel id",
					"", 0, model, hotel);
			return "admin/AddHotel";
		}

		if (errorCode == 1) {
			model = addHotelScreenWithErrorMsg("", "Hotel successfully added.Hotel id: " + hotel.getHotelId(), 0, model, hotel);
			return "admin/AddHotel";
		} else {
			model = addHotelScreenWithErrorMsg("", "Error adding hotel.Please try again", 1, model, hotel);
			return "admin/AddHotel";
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

		if (adminDAO.getAllHotels().size() > 0)
			model.addAttribute("hotel", adminDAO.getAllHotels().get(0));
		else
			model.addAttribute("hotel", new Hotel());
		model.addAttribute("hotelsList", adminDAO.getAllHotels());
		return "admin/EditHotel";
	}

	@RequestMapping(value = "/processEditHotel", method = RequestMethod.POST)
	public String processEditHotel(@ModelAttribute("hotel") Hotel hotel, ModelMap model) {
		if (hotel.getAcRoomsCount() > 300 || hotel.getNonACRoomsCount() > 300) {
			model = editHotelScreenWithErrorMsg("No of rooms should be less than 300", "", 0, model, hotel);
			return "admin/EditHotel";
		}
		if (hotel.getRateAdultAC() < 2500 || hotel.getRateAdultAC() > 4000) {
			model = editHotelScreenWithErrorMsg("Rate of AC Room for adults should be between Rs.2500 - Rs.4000 ", "",
					0, model, hotel);
			return "admin/EditHotel";
		}
		if (hotel.getRateAdultNonAC() < 2000 || hotel.getRateAdultNonAC() > 2500) {
			model = editHotelScreenWithErrorMsg("Rate of Non-AC Room for adults should be between Rs.2000 - Rs.2500",
					"", 0, model, hotel);
			return "admin/EditHotel";
		}
		if (hotel.getRateChildAC() < 2000 || hotel.getRateChildAC() > 3000) {
			model = editHotelScreenWithErrorMsg("Rate of AC Room for child should be between Rs.2000 - Rs.3000", "", 0,
					model, hotel);
			return "admin/EditHotel";
		}
		if (hotel.getRateChildNonAC() < 1000 || hotel.getRateChildNonAC() > 2000) {
			model = editHotelScreenWithErrorMsg("Rate of Non-AC Room for child should be between Rs.1000 - Rs.2000", "",
					0, model, hotel);
			return "admin/EditHotel";
		}
		int errorCode = adminDAO.editHotel(hotel);
		if (errorCode == 1) {
			Global.getInstance();
			model = editHotelScreenWithErrorMsg("", "Hotel Successfully Edited", 0, model, hotel);
			return "admin/EditHotel";
		} else {
			model = editHotelScreenWithErrorMsg("", "Error editing hotel.Please try again", 1, model, hotel);
			return "admin/EditHotel";
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

		if (adminDAO.getAllHotels().size() > 0)
			model.addAttribute("hotel", adminDAO.getAllHotels().get(0));
		else
			model.addAttribute("hotel", new Hotel());
		model.addAttribute("hotelsList", adminDAO.getAllHotels());
		return "admin/DeleteHotel";
	}

	@RequestMapping(value = "/processDeleteHotel", method = RequestMethod.POST)
	public String processDeleteHotel(@ModelAttribute("hotel") Hotel hotel, ModelMap model) {
		/*int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this hotel", "Delete Hotel",
				JOptionPane.YES_NO_OPTION);*/
		/*if (reply == JOptionPane.YES_OPTION) {*/
			int errorCode = adminDAO.deleteHotel(hotel);
			if (errorCode == 2) {
				model = deleteHotelScreenWithErrorMsg("This hotel have future booking so you can't delete it.",1,model,hotel);
				return "admin/DeleteHotel";
			} else if (errorCode == 1) {
				model = deleteHotelScreenWithErrorMsg("Hotel Successfully Deleted",0,model,hotel);
				return "admin/DeleteHotel";
			} else {
				model = deleteHotelScreenWithErrorMsg("Error Deleting Hotel.Please try again",1,model,hotel);
				return "admin/DeleteHotel";
			}
		/*}*/ /*else {
			return "redirect:/deleteHotel";
		}*/

	}

	public ModelMap addHotelScreenWithErrorMsg(String msg, String alertMsg, int errorCode, ModelMap model,
			Hotel hotel) {
		model.addAttribute("hotel", hotel);
		model.addAttribute("message", msg);
		model.addAttribute("alertMessage", alertMsg);
		model.addAttribute("errorCode", errorCode);
		ArrayList<Country> countryList = staticDataDAO.getCountriesList();
		if(countryList.size()>0)
			model.addAttribute("1stCountrycitiesList", staticDataDAO.getCitesOfCountry(countryList.get(0).getId()));
		else
			model.addAttribute("1stCountrycitiesList","");
		model.addAttribute("citiesList", staticDataDAO.getCitiesList());
		model.addAttribute("countriesList", countryList);
		return model;
	}

	public ModelMap editHotelScreenWithErrorMsg(String msg, String alertMsg, int errorCode, ModelMap model,
			Hotel hotel) {
		model.addAttribute("hotelsList", adminDAO.getAllHotels());
		model.addAttribute("hotel", hotel);
		model.addAttribute("message", msg);
		model.addAttribute("alertMessage", alertMsg);
		model.addAttribute("errorCode", errorCode);
		return model;
	}
	
	public ModelMap deleteHotelScreenWithErrorMsg(String alertMsg, int errorCode, ModelMap model,
			Hotel hotel) {
		if (adminDAO.getAllHotels().size() > 0)
			model.addAttribute("hotel", adminDAO.getAllHotels().get(0));
		else
			model.addAttribute("hotel", new Hotel());
		model.addAttribute("hotelsList", adminDAO.getAllHotels());
		model.addAttribute("alertMessage", alertMsg);
		model.addAttribute("errorCode", errorCode);
		return model;
	}
}
