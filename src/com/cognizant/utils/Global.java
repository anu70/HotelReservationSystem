package com.cognizant.utils;

import java.util.LinkedHashMap;
import java.util.Map;

//Singleton class
public class Global {
	private static Global obj;
	public static Map<String, String> rolesList,countriesList,citiesList;

	private Global() {
		rolesList = new LinkedHashMap<String, String>();
		rolesList.put("customer", "Customer");
		rolesList.put("admin", "Admin");
		
		loadCountires();
		loadCities();
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
	public static Global getInstance() {
		if (obj == null)
			obj = new Global();
		return obj;
	}
}
