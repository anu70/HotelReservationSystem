package com.cognizant.models;

import java.util.ArrayList;

public class HotelsList {
	public ArrayList<Hotel> hotelList;
	public HotelsList(){}

	public HotelsList(ArrayList<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	public ArrayList<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(ArrayList<Hotel> hotelList) {
		this.hotelList = hotelList;
	}
	
}
