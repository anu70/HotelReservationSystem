package com.cognizant.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.DAO.CustomerDAO;
import com.cognizant.DAO.ObjectFromidDAO;
import com.cognizant.DAO.StaticDataDAO;
import com.cognizant.models.Booking;
import com.cognizant.models.City;
import com.cognizant.models.Country;
import com.cognizant.models.Hotel;
import com.cognizant.models.HotelsList;
import com.cognizant.models.Payment;
import com.cognizant.models.Trip;
import com.cognizant.utils.Global;

@Controller
public class CustomerController {
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	StaticDataDAO staticDataDAO;
	@Autowired
	ObjectFromidDAO objectFromIdDAO;

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
		ArrayList<Country> countryList = staticDataDAO.getCountriesList();
		if(countryList.size()>0)
			model.addAttribute("startCountrycitiesList", staticDataDAO.getCitesOfCountry(countryList.get(0).getId()));
		else
			model.addAttribute("startCountrycitiesList",new ArrayList<City>());
		model.addAttribute("citiesList", staticDataDAO.getCitiesList());
		model.addAttribute("countriesList", countryList);
		model.addAttribute("todaysDate",Global.todaysDate);
		return "customer/WelcomeCustomer";
	}

	@RequestMapping(value = "/availableHotels", method = RequestMethod.POST)
	public String processSearch(@ModelAttribute("trip") Trip trip, ModelMap model) {
		ArrayList<Booking> bookedHotels = customerDAO.getBookedHotels(trip);
		Global.getInstance().setTrip(trip);
		HotelsList allHotels = customerDAO.getAllHotels(trip);
		int[][] roomsBookedCount = new int[allHotels.getHotelList().size()][2];
		ArrayList<Country> countryList = new ArrayList<Country>();
		ArrayList<City> cityList = new ArrayList<City>();
		
		for (int i = 0; i < bookedHotels.size(); i++) {
			int hotelid = bookedHotels.get(i).getHotel_id();
			for (int j = 0; j < allHotels.getHotelList().size(); j++) {
				if (allHotels.getHotelList().get(j).getHotelUniqueId() == hotelid) {
					roomsBookedCount[j][0] += bookedHotels.get(i).getAc_rooms_count();
					roomsBookedCount[j][1] += bookedHotels.get(i).getNon_ac_rooms_count();
					break;
				}
			}
		}
		
		for(int i=0;i<allHotels.hotelList.size();i++){
			countryList.add(objectFromIdDAO.getContryWithId(allHotels.hotelList.get(i).getCountryId()));
			cityList.add(objectFromIdDAO.getCityWithId(allHotels.hotelList.get(i).getCityId()));
		}
		model.addAttribute("roomsBookedCount", roomsBookedCount);
		model.addAttribute("hotel", new Hotel());
		model.addAttribute("hotelsList", allHotels);
		model.addAttribute("countryList",countryList);
		model.addAttribute("cityList",cityList);
		return "customer/AvailableHotels";
	}

	@RequestMapping(value = "/bookHotel", method = RequestMethod.POST)
	public String bookHotel(@ModelAttribute("hotel") Hotel hotel, ModelMap model) {
		Global.getInstance().setHotel(hotel);
		model.addAttribute("hotel", Global.hotel);
		model.addAttribute("booking", new Booking());
		model.addAttribute("todaysDate",Global.todaysDate);
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
		if (Global.hotel != null) {
			model.addAttribute("hotel", Global.hotel);
		} else {
			model.addAttribute("trip", Global.trip);
			return "redirect:/availableHotels";
		}
		try {
			System.out.println(new SimpleDateFormat("yyyy-dd-MM").parse(booking.getEnd_date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*int daysCount=1;
		Date startDate = new Date(booking.getStart_date());
		Calendar time  = Calendar.getInstance();
		time.set(Calendar.HOUR_OF_DAY, 0);
		time.set(Calendar.MINUTE, 0);
		time.set(Calendar.SECOND, 0);
		time.set(Calendar.MILLISECOND, 0);
		startDate = time.getTime();*/
		int totalCost = (booking.getAc_rooms_count() * Global.hotel.getRateAdultAC()
				+ booking.getNon_ac_rooms_count() * Global.hotel.getRateAdultNonAC());
		model.addAttribute("totalCost", totalCost);

		booking.setUser_id(Global.user.getId());
		booking.setHotel_id(Global.hotel.getHotelUniqueId());
		booking.setBooking_date(Global.todaysDate);
		booking.setTotal_cost(totalCost);
		Global.getInstance().setBooking(booking);
		model.addAttribute("booking", booking);
		return "customer/ReviewBooking";

	}

	@RequestMapping(value = "/makePayment", method = RequestMethod.POST)
	public String makePayment(ModelMap model, @RequestParam String action) {
		Global.getInstance();
		if (action.equals("edit")) {
			model.addAttribute("hotel", Global.hotel);
			model.addAttribute("booking", new Booking());
			return "customer/BookHotel";
		} else {
			model.addAttribute("payment", new Payment());
			Global.getInstance();
			model.addAttribute("cardTypes", Global.cardTypes);
			return "customer/Payment";
		}

	}

	@RequestMapping(value = "/bookingSuccessful", method = RequestMethod.POST)
	public String bookingSuccessful(@ModelAttribute("payment") Payment payment, ModelMap model) {
		if (Global.user != null) {
			payment.setUser_id(Global.user.getId());
			payment.setStatus(0);
		} else {
			return "redirect:/login";
		}
		int bookingId = customerDAO.bookHotel(Global.booking);
		int transactionId = customerDAO.makePayment(payment);
		Global.getInstance();
		model.addAttribute("BookingId", bookingId);
		model.addAttribute("TransactionId", transactionId);
		model.addAttribute("payment",payment);
		return "customer/BookingSuccessful";
	}

	@RequestMapping(value = "/allBookings", method = RequestMethod.GET)
	public String allBookings(ModelMap model) {
		Global.getInstance();
		if (Global.user == null)
			return "redirect:/login";
		ArrayList<Booking> bookings = customerDAO.getAllBookings(Global.user);
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		for(int i=0;i<bookings.size();i++){
			hotels.add(objectFromIdDAO.getHotelWithId(bookings.get(i).getHotel_id()));
		}
		model.addAttribute("bookingsList", bookings);
		model.addAttribute("hotelsList",hotels);
		model.addAttribute("booking", new Booking());
		return "customer/AllBookings";
	}

	@RequestMapping(value="/changeBooking",method=RequestMethod.POST)
	public String changeBooking(@ModelAttribute("booking") Booking booking,@RequestParam String action,ModelMap model){
		//System.out.println(booking.getHotel_id());
		Global.getInstance().setHotel(objectFromIdDAO.getHotelWithId(booking.getHotel_id()));
		if(action.equals("edit")){
			Global.getInstance();
			model.addAttribute("hotel", Global.hotel);
			model.addAttribute("booking",booking);
			return "customer/BookHotel";
		}
		else{
			int success = customerDAO.cancelBooking(booking);
			if(success==1)
				return allBookingPageWithAlertMessage(model,"booking successfully cancelled ",0);
			else
				return allBookingPageWithAlertMessage(model,"Error deleting booking.Please try again.",1);
		}
	}
	
	public String allBookingPageWithAlertMessage(ModelMap model,String alertMsg, int errorCode){
		Global.getInstance();
		if (Global.user == null)
			return "redirect:/login";
		ArrayList<Booking> bookings = customerDAO.getAllBookings(Global.user);
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		for(int i=0;i<bookings.size();i++){
			hotels.add(objectFromIdDAO.getHotelWithId(bookings.get(i).getHotel_id()));
		}
		model.addAttribute("bookingsList", bookings);
		model.addAttribute("hotelsList",hotels);
		model.addAttribute("booking", new Booking());
		model.addAttribute("alertMessage", alertMsg);
		model.addAttribute("errorCode", errorCode);
		return "customer/AllBookings";
	}
}
