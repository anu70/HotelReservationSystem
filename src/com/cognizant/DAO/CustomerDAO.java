package com.cognizant.DAO;

import java.util.ArrayList;

import com.cognizant.models.Booking;
import com.cognizant.models.HotelsList;
import com.cognizant.models.Payment;
import com.cognizant.models.Trip;

public interface CustomerDAO {
	public HotelsList getAllHotels(Trip trip);
	public ArrayList<Booking> getBookedHotels(Trip trip);
	public int bookHotel(Booking booking);
	public int makePayment(Payment payment);
}
