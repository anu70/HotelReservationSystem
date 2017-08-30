package com.cognizant.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.models.Country;

public class CountryMapper implements RowMapper<Country>{

	@Override
	public Country mapRow(ResultSet result, int arg1) throws SQLException {
		Country country = new Country();
		country.setId(result.getInt("id"));
		country.setName(result.getString("name"));
		return country;
	}

}
