package com.cognizant.controllers;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.DAO.AdminDAO;
import com.cognizant.DAO.StaticDataDAO;
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
		model.addAttribute("citiesList", staticDataDAO.getCitiesList());
		model.addAttribute("countriesList", staticDataDAO.getCountriesList());
		return "admin/AddHotel";
	}

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
			JOptionPane.showMessageDialog(null,
					"Hotel with the hotel id:" + hotel.getHotelId() + " already exist.Please enter another hotel id");

			model = addHotelScreenWithErrorMsg("", model, hotel);
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
		
		if(adminDAO.getAllHotels().size()>0)
			model.addAttribute("hotel",adminDAO.getAllHotels().get(0));
		else
			model.addAttribute("hotel", new Hotel());
		model.addAttribute("hotelsList", adminDAO.getAllHotels());
		return "admin/EditHotel";
	}

	@RequestMapping(value = "/processEditHotel", method = RequestMethod.POST)
	public String processEditHotel(@ModelAttribute("hotel") Hotel hotel, ModelMap model) {
		if (hotel.getAcRoomsCount() > 300 || hotel.getNonACRoomsCount() > 300) {
			model = editHotelScreenWithErrorMsg("No of rooms should be less than 300", model, hotel);
			return "admin/EditHotel";
		}
		if (hotel.getRateAdultAC() < 2500 || hotel.getRateAdultAC() > 4000) {
			model = editHotelScreenWithErrorMsg("Rate of AC Room for adults should be between Rs.2500 - Rs.4000 ", model,
					hotel);
			return "admin/EditHotel";
		}
		if (hotel.getRateAdultNonAC() < 2000 || hotel.getRateAdultNonAC() > 2500) {
			model = editHotelScreenWithErrorMsg("Rate of Non-AC Room for adults should be between Rs.2000 - Rs.2500",
					model, hotel);
			return "admin/EditHotel";
		}
		if (hotel.getRateChildAC() < 2000 || hotel.getRateChildAC() > 3000) {
			model = editHotelScreenWithErrorMsg("Rate of AC Room for child should be between Rs.2000 - Rs.3000", model,
					hotel);
			return "admin/EditHotel";
		}
		if (hotel.getRateChildNonAC() < 1000 || hotel.getRateChildNonAC() > 2000) {
			model = editHotelScreenWithErrorMsg("Rate of Non-AC Room for child should be between Rs.1000 - Rs.2000",
					model, hotel);
			return "admin/EditHotel";
		}
		int errorCode = adminDAO.editHotel(hotel);
		if (errorCode == 1) {
			Global.getInstance();
			JOptionPane.showMessageDialog(null, "Hotel successfully edited");
			model.addAttribute("username", Global.user.getUsername());
			return "admin/WelcomeAdmin";
		} else {
			JOptionPane.showMessageDialog(null, "Error editing hotel.Please try again");
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

		if(adminDAO.getAllHotels().size()>0)
			model.addAttribute("hotel",adminDAO.getAllHotels().get(0));
		else
			model.addAttribute("hotel", new Hotel());
		model.addAttribute("hotelsList", adminDAO.getAllHotels());
		return "admin/DeleteHotel";
	}

	@RequestMapping(value = "/processDeleteHotel", method = RequestMethod.POST)
	public String processDeleteHotel(@ModelAttribute("hotel") Hotel hotel, ModelMap model) {
		int reply = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this hotel","Delete Hotel", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			int errorCode = adminDAO.deleteHotel(hotel);
			if (errorCode == 2) {
				JOptionPane.showMessageDialog(null, "This hotel have future booking so you can't delete it.");
				return "redirect:/deleteHotel";
			} else if (errorCode == 1) {
				JOptionPane.showMessageDialog(null, "Hotel Successfully Deleted");
				Global.getInstance();
				model.addAttribute("username", Global.user.getUsername());
				return "admin/WelcomeAdmin";
			} else {
				JOptionPane.showMessageDialog(null, "Error Deleting Hotel");
				return "redirect:/deleteHotel";
			}
		} else {
			return "redirect:/deleteHotel";
		}
		
	}

	public ModelMap addHotelScreenWithErrorMsg(String msg, ModelMap model, Hotel hotel) {
		model.addAttribute("hotel", hotel);
		model.addAttribute("message", msg);
		model.addAttribute("citiesList", staticDataDAO.getCitiesList());
		model.addAttribute("countriesList", staticDataDAO.getCountriesList());
		return model;
	}
	
	public ModelMap editHotelScreenWithErrorMsg(String msg, ModelMap model, Hotel hotel){
		model.addAttribute("hotelsList", adminDAO.getAllHotels());
		model.addAttribute("hotel", hotel);
		model.addAttribute("message", msg);
		return model;
	}
}
