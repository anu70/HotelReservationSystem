package com.cognizant.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.DAO.CustomerDAO;
import com.cognizant.models.Booking;
import com.cognizant.models.Hotel;
import com.cognizant.models.HotelsList;
import com.cognizant.models.Payment;
import com.cognizant.models.Trip;
import com.cognizant.utils.Global;

@Controller
public class CustomerController {
	@Autowired
	CustomerDAO customerDAO;

	@RequestMapping(value = "/welcomeCustomer", method = RequestMethod.GET)
	public String showSearchPage(ModelMap model) {
		Global.getInstance();
		Global.getInstance().setBooking(null);
		Global.getInstance().setHotel(null);
		Global.getInstance().setTrip(null);
		if (Global.user == null) {
			return "redirect:/login";
		}
		model.addAttribute("trip", new Trip());
		model.addAttribute("username", Global.user.getUsername());
		model.addAttribute("citiesList", Global.citiesList);
		model.addAttribute("countriesList", Global.countriesList);
		return "customer/WelcomeCustomer";
	}

	@RequestMapping(value = "/availableHotels", method = RequestMethod.POST)
	public String processSearch(@ModelAttribute("trip") Trip trip, ModelMap model) {
		ArrayList<Booking> bookedHotels = customerDAO.getBookedHotels(trip);
		Global.getInstance().setTrip(trip);
		HotelsList allHotels = customerDAO.getAllHotels(trip);
		boolean[] isAvailable = new boolean[allHotels.getHotelList().size()];
		Arrays.fill(isAvailable, true);

		for (int i = 0; i < bookedHotels.size(); i++) {
			int hotelid = bookedHotels.get(i).getHotel_id();
			for (int j = 0; j < allHotels.getHotelList().size(); j++) {
				if (allHotels.getHotelList().get(j).getHotelUniqueId() == hotelid) {
					isAvailable[j] = false;
					break;
				}
			}
		}
		model.addAttribute("availableHotels", isAvailable);
		model.addAttribute("hotel", new Hotel());
		model.addAttribute("hotelsList", allHotels);
		return "customer/AvailableHotels";
	}

	@RequestMapping(value = "/bookHotel", method = RequestMethod.POST)
	public String bookHotel(@ModelAttribute("hotel") Hotel hotel, ModelMap model) {
		Global.getInstance().setHotel(hotel);
		model.addAttribute("hotel", Global.hotel);
		model.addAttribute("booking", new Booking());
		return "customer/BookHotel";
	}

	@RequestMapping(value = "/reviewBooking", method = RequestMethod.POST)
	public String reviewBooking(@ModelAttribute("booking") Booking booking, ModelMap model) {
		Global.getInstance();
		if (Global.user != null) {
			model.addAttribute("user", Global.user);
		} else {
			return "redirect:/login";
		}
		if (Global.trip != null) {
			model.addAttribute("trip", Global.trip);
		} else {
			return "redirect:/welcomeCustomer";
		}
		if (Global.hotel != null) {
			model.addAttribute("hotel", Global.hotel);
		} else {
			model.addAttribute("trip", Global.trip);
			return "redirect:/availableHotels";
		}
		int totalCost = booking.getAc_rooms_count() * Global.hotel.getRateAdultAC()
				+ booking.getNon_ac_rooms_count() * Global.hotel.getRateAdultNonAC();
		model.addAttribute("totalCost", totalCost);
		
		booking.setUser_id(Global.user.getId());
		booking.setHotel_id(Global.hotel.getHotelUniqueId());
		booking.setBooking_date("2017/08/29");
		booking.setAdults_count(Global.trip.getAdultCount());
		booking.setChild_count(Global.trip.getChildCount());
		booking.setStart_date(Global.trip.getStartDate());
		booking.setEnd_date(Global.trip.getEndDate());
		booking.setTotal_cost(totalCost);
		Global.getInstance().setBooking(booking);
		model.addAttribute("booking", booking);
		return "customer/ReviewBooking";
	}
	
	@RequestMapping(value = "/allBookings", method = RequestMethod.GET)
	public String allBookings(ModelMap model){
		if(Global.user==null)
			return "redirect:/login";
		ArrayList<Booking> bookings = customerDAO.getAllBookings(Global.user);
		model.addAttribute("bookingsList", bookings);
		return "customer/AllBookings";
	}
	
	@RequestMapping(value="/makePayment",method=RequestMethod.POST)
	public String makePayment(ModelMap model){
		model.addAttribute("payment",new Payment());
		Global.getInstance();
		model.addAttribute("cardTypes",Global.cardTypes);
		return "customer/Payment";
	}
	
	@RequestMapping(value="/bookingSuccessful",method=RequestMethod.POST)
	public String bookingSuccessful(@ModelAttribute("payment") Payment payment,ModelMap model){
		if (Global.user != null) {
			payment.setUser_id(Global.user.getId());
			payment.setStatus(0);
		} else {
			return "redirect:/login";
		}
		int bookingId = customerDAO.bookHotel(Global.booking);
		int transactionId = customerDAO.makePayment(payment);
		Global.getInstance();
		model.addAttribute("BookingId",bookingId);
		model.addAttribute("TransactionId",transactionId);
		return "customer/BookingSuccessful";
	}
	
}
