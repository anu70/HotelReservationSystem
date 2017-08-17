package com.cognizant.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.NotNull;


public class Login {
	@NotNull
	private String username;
	@Size(min=8, max=30)
	private String password;
	public Login(){}
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
