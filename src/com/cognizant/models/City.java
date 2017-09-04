package com.cognizant.models;

public class City {
	Integer id;
	int country_id;
	String name;

	public City() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public City(Integer id, int country_id, String name) {
		super();
		this.id = id;
		this.country_id = country_id;
		this.name = name;
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
