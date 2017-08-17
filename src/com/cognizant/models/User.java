package com.cognizant.models;


public class User {
	String username;
	String role;
	String email;
	String password;
	String dob;
	String country;
	String city;
	String mobile;
	String pincode;
	
	public User(){}
	
	
	public User(String username, String role, String email, String password, String dob, String country, String city,
			String mobile, String pincode) {
		super();
		this.username = username;
		this.role = role;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.country = country;
		this.city = city;
		this.mobile = mobile;
		this.pincode = pincode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
