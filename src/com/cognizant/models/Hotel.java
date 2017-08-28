package com.cognizant.models;

public class Hotel {
	int hotelUniqueId;
	String hotelId;
	String hotelName;
	String city;
	String country;
	String description;
	String identifyHotel;
	int acRoomsCount;
	int nonACRoomsCount;
	int rateChildAC;
	int rateAdultAC;
	int rateChildNonAC;
	int rateAdultNonAC;
	public Hotel(){}
	
	public Hotel(int hotelUniqueId, String hotelId, String hotelName, String city, String country, String description,
			String identifyHotel, int acRoomsCount, int nonACRoomsCount, int rateChildAC, int rateAdultAC,
			int rateChildNonAC, int rateAdultNonAC) {
		super();
		this.hotelUniqueId = hotelUniqueId;
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.city = city;
		this.country = country;
		this.description = description;
		this.identifyHotel = identifyHotel;
		this.acRoomsCount = acRoomsCount;
		this.nonACRoomsCount = nonACRoomsCount;
		this.rateChildAC = rateChildAC;
		this.rateAdultAC = rateAdultAC;
		this.rateChildNonAC = rateChildNonAC;
		this.rateAdultNonAC = rateAdultNonAC;
	}

	public int getHotelUniqueId() {
		return hotelUniqueId;
	}

	public void setHotelUniqueId(int hotelUniqueId) {
		this.hotelUniqueId = hotelUniqueId;
	}

	public String getIdentifyHotel() {
		return identifyHotel;
	}
	public void setIdentifyHotel(String identifyHotel) {
		this.identifyHotel = identifyHotel;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAcRoomsCount() {
		return acRoomsCount;
	}
	public void setAcRoomsCount(int acRoomsCount) {
		this.acRoomsCount = acRoomsCount;
	}
	public int getNonACRoomsCount() {
		return nonACRoomsCount;
	}
	public void setNonACRoomsCount(int nonACRoomsCount) {
		this.nonACRoomsCount = nonACRoomsCount;
	}
	public int getRateChildAC() {
		return rateChildAC;
	}
	public void setRateChildAC(int rateChildAC) {
		this.rateChildAC = rateChildAC;
	}
	public int getRateAdultAC() {
		return rateAdultAC;
	}
	public void setRateAdultAC(int rateAdultAC) {
		this.rateAdultAC = rateAdultAC;
	}
	public int getRateChildNonAC() {
		return rateChildNonAC;
	}
	public void setRateChildNonAC(int rateChildNonAC) {
		this.rateChildNonAC = rateChildNonAC;
	}
	public int getRateAdultNonAC() {
		return rateAdultNonAC;
	}
	public void setRateAdultNonAC(int rateAdultNonAC) {
		this.rateAdultNonAC = rateAdultNonAC;
	}
	
}
