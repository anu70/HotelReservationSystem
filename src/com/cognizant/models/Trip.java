package com.cognizant.models;

public class Trip {
	int cityId;
	int countryId;
	String startDate;
	String endDate;
	int adultCount;
	int childCount;

	public Trip() {
	}

	public Trip(int cityId, int countryId, String startDate, String endDate, int adultCount, int childCount) {
		super();
		this.cityId = cityId;
		this.countryId = countryId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.adultCount = adultCount;
		this.childCount = childCount;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
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
