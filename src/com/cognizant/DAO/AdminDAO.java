package com.cognizant.DAO;

import java.util.ArrayList;

import com.cognizant.models.Hotel;

public interface AdminDAO {
	int addHotel(Hotel hotel);
	int editHotel(Hotel hotel);
	ArrayList<Hotel> getAllHotels();
}
