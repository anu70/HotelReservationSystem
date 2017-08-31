package com.cognizant.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.cognizant.models.Booking;
import com.cognizant.models.City;
import com.cognizant.models.Country;
import com.cognizant.models.Hotel;
import com.cognizant.models.Trip;
import com.cognizant.models.User;


public class Global {
	private static Global obj;
	public static ArrayList<Country> countriesList;
	public static ArrayList<City> citiesList;
	public static Map<String, String> rolesList, cardTypes;
	public static User user;
	public static Trip trip;
	public static Hotel hotel;
	public static Booking booking;
	
	public Global() {
		rolesList = new LinkedHashMap<String, String>();
		rolesList.put("customer", "Customer");
		rolesList.put("admin", "Admin");
	
		//loadCountires();
		//loadCities();
		loadCreditCards();
	}

	public void setUser(User user) {
		Global.user = user;
	}

	public void setTrip(Trip trip) {
		Global.trip = trip;
	}

	public void setHotel(Hotel hotel) {
		Global.hotel = hotel;
	}

	public void setBooking(Booking booking) {
		Global.booking = booking;
	}

	/*public void loadCountires() {
		if(countriesList==null)
			countriesList = dataLoader.getCountryList();
	}

	public void loadCities() {
		if(citiesList==null)
			citiesList = dataLoader.getCitiesList();
	}*/

	public void loadCreditCards() {
		cardTypes = new LinkedHashMap<String, String>();
		cardTypes.put("visa", "VISA");
		cardTypes.put("mastercard", "MasterCard");
		cardTypes.put("americanexpress", "American Express");
		cardTypes.put("discover", "Discover");
	}

	public static Global getInstance() {
		if (obj == null)
			obj = new Global();
		return obj;
	}
}
