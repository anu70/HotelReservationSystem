package com.cognizant.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.models.City;

public class CityMapper implements RowMapper<City>{

	@Override
	public City mapRow(ResultSet result, int arg1) throws SQLException {
		City city = new City();
		city.setCountry_id(result.getInt("country_id"));
		city.setId(result.getInt("id"));
		city.setName(result.getString("name"));
		return city;
	}

}
