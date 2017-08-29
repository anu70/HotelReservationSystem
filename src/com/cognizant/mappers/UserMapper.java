package com.cognizant.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.models.User;

public class UserMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet result, int arg1) throws SQLException {
		User user = new User();
		user.setId(result.getInt("id"));
		user.setUsername(result.getString("name"));
		user.setCity(result.getString("city"));
		user.setCountry(result.getString("country"));
		user.setDob(result.getString("dob"));
		user.setEmail(result.getString("email_id"));
		user.setMobile(result.getString("mobile"));
		user.setPincode(result.getString("pincode"));
		user.setRole(result.getString("role"));
		user.setPassword(result.getString("password"));
		return user;
	}

}