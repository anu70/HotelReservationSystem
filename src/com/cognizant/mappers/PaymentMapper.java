package com.cognizant.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.models.Payment;

public class PaymentMapper implements RowMapper<Payment>{

	@Override
	public Payment mapRow(ResultSet result, int arg1) throws SQLException {
		Payment payment = new Payment();
		payment.setId(result.getInt("id"));
		payment.setUser_id(result.getInt("user_id"));
		payment.setCard_type(result.getString("card_type"));
		payment.setCredit_card_no(result.getBigDecimal("credit_card_no").toBigInteger());
		payment.setName_on_card(result.getString("name_on_card"));
		payment.setExpiry_date(result.getString("expiry_date"));
		payment.setCvv(result.getInt("cvv"));
		payment.setAccount_no(result.getBigDecimal("account_no").toBigInteger());
		payment.setAtm_pin(result.getInt("atm_pin"));
		payment.setIs_senior_citizen(result.getBoolean("is_senior_citizen"));
		payment.setStatus(result.getInt("status"));
		payment.setBank_name(result.getString("bank_name"));
		return payment;
	}

}
