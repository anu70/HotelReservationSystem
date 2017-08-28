package com.cognizant.models;

import java.math.BigInteger;

public class Payment {
	int id;
	int user_id;
	String card_type;
	BigInteger credit_card_no;
	String name_on_card;
	String expiry_date;
	int cvv;
	BigInteger account_no;
	int atm_pin;
	boolean is_senior_citizen;
	int status;
	
	public Payment(){}

	public Payment(int id, int user_id, String card_type, BigInteger credit_card_no, String name_on_card,
			String expiry_date, int cvv, BigInteger account_no, int atm_pin, boolean is_senior_citizen, int status) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.card_type = card_type;
		this.credit_card_no = credit_card_no;
		this.name_on_card = name_on_card;
		this.expiry_date = expiry_date;
		this.cvv = cvv;
		this.account_no = account_no;
		this.atm_pin = atm_pin;
		this.is_senior_citizen = is_senior_citizen;
		this.status = status;
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

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public BigInteger getCredit_card_no() {
		return credit_card_no;
	}

	public void setCredit_card_no(BigInteger credit_card_no) {
		this.credit_card_no = credit_card_no;
	}

	public String getName_on_card() {
		return name_on_card;
	}

	public void setName_on_card(String name_on_card) {
		this.name_on_card = name_on_card;
	}

	public String getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public BigInteger getAccount_no() {
		return account_no;
	}

	public void setAccount_no(BigInteger account_no) {
		this.account_no = account_no;
	}

	public int getAtm_pin() {
		return atm_pin;
	}

	public void setAtm_pin(int atm_pin) {
		this.atm_pin = atm_pin;
	}

	public boolean isIs_senior_citizen() {
		return is_senior_citizen;
	}

	public void setIs_senior_citizen(boolean is_senior_citizen) {
		this.is_senior_citizen = is_senior_citizen;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
