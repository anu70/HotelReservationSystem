package com.cognizant.DAO;

import com.cognizant.models.HotelsList;
import com.cognizant.models.Trip;

public interface CustomerDAO {
	public HotelsList getAllAvailableHotels(Trip trip);
	
}
