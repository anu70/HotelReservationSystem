package com.cognizant.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import com.cognizant.models.Booking;
import com.cognizant.models.Hotel;
import com.cognizant.models.Trip;
import com.cognizant.models.User;

//Singleton class
public class Global {
	private static Global obj;
	public static Map<String, String> rolesList,countriesList,citiesList,cardTypes;
	public static User user;
	public static Trip trip;
	public static Hotel hotel;
	public static Booking booking;
	private Global() {
		rolesList = new LinkedHashMap<String, String>();
		rolesList.put("customer", "Customer");
		rolesList.put("admin", "Admin");
		
		loadCountires();
		loadCities();
		loadCreditCards();
	}
	public void setUser(User user){
		Global.user = user;
	}
	
	public void setTrip(Trip trip){
		Global.trip = trip;
	}
	
	public void setHotel(Hotel hotel){
		Global.hotel = hotel;
	}
	
	public void setBooking(Booking booking){
		Global.booking = booking;
	}
	
	public void loadCountires(){
		countriesList = new LinkedHashMap<String, String>();
		countriesList.put("india", "India");
		countriesList.put("usa", "USA");
		countriesList.put("australia", "Australia");
	}
	
	public void loadCities(){
		citiesList = new LinkedHashMap<String, String>();
		citiesList.put("chennai", "Chennai");
		citiesList.put("mumbai", "Mumbai");
		citiesList.put("delhi", "Delhi");
	}
	public void loadCreditCards(){
		cardTypes = new LinkedHashMap<String, String>();
		cardTypes.put("visa","VISA");
		cardTypes.put("mastercard","MasterCard");
		cardTypes.put("americanexpress","American Express");
		cardTypes.put("discover","Discover");
	}
	public static Global getInstance() {
		if (obj == null)
			obj = new Global();
		return obj;
	}
}
