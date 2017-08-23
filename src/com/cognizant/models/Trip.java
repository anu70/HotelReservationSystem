package com.cognizant.models;

public class Trip {
	String country;
	String city;
	String startDate;
	String endDate;
	int adultCount;
	int childCount;

	public Trip() {
	}


	public Trip(String country, String city, String startDate, String endDate, int adultCount, int childCount) {
		super();
		this.country = country;
		this.city = city;
		this.startDate = startDate;
		this.endDate = endDate;
		this.adultCount = adultCount;
		this.childCount = childCount;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
}
