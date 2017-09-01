package com.cognizant.DAO;

import com.cognizant.models.City;
import com.cognizant.models.Country;
import com.cognizant.models.Hotel;

public interface ObjectFromidDAO {
	Hotel getHotelWithId(int id);
	Country getContryWithId(int id);
	City getCityWithId(int id);
}
