package com.cognizant.DAO;

import java.util.ArrayList;

import com.cognizant.models.City;
import com.cognizant.models.Country;

public interface StaticDataDAO {
	public ArrayList<Country> getCountriesList();

	public ArrayList<City> getCitiesList();
	
	public ArrayList<City> getCitesOfCountry(int countryId);
}
