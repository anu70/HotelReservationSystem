package com.cognizant.models;

public class City {
	int id;
	int country_id;
	String name;
	
	public City(){}

	public City(int id, int country_id, String name) {
		this.id = id;
		this.country_id = country_id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
