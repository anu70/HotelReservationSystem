package com.cognizant.DAO;

import java.util.ArrayList;

import com.cognizant.models.Hotel;
import com.cognizant.models.Trip;

public interface CustomerDAO {
	public ArrayList<Hotel> getAllAvailableHotels(Trip trip);
	
}
