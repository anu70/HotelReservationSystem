 package com.cognizant.models;

public class Booking {
	int id;
	int hotel_id;
	int user_id;
	String booking_date;
	String start_date;
	String end_date;
	int adults_count;
	int child_count;
	int ac_rooms_count;
	int non_ac_rooms_count;
	
	public Booking(){}
	
	

	public Booking(int id, int hotel_id, int user_id, String booking_date, String start_date, String end_date,
			int adults_count, int child_count, int ac_rooms_count, int non_ac_rooms_count) {
		super();
		this.id = id;
		this.hotel_id = hotel_id;
		this.user_id = user_id;
		this.booking_date = booking_date;
		this.start_date = start_date;
		this.end_date = end_date;
		this.adults_count = adults_count;
		this.child_count = child_count;
		this.ac_rooms_count = ac_rooms_count;
		this.non_ac_rooms_count = non_ac_rooms_count;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getHotel_id() {
		return hotel_id;
	}



	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}



	public String getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getAdults_count() {
		return adults_count;
	}
	public void setAdults_count(int adults_count) {
		this.adults_count = adults_count;
	}
	public int getChild_count() {
		return child_count;
	}
	public void setChild_count(int child_count) {
		this.child_count = child_count;
	}
	public int getAc_rooms_count() {
		return ac_rooms_count;
	}
	public void setAc_rooms_count(int ac_rooms_count) {
		this.ac_rooms_count = ac_rooms_count;
	}
	public int getNon_ac_rooms_count() {
		return non_ac_rooms_count;
	}
	public void setNon_ac_rooms_count(int non_ac_rooms_count) {
		this.non_ac_rooms_count = non_ac_rooms_count;
	}
}
