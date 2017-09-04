package com.cognizant.DAOImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.DAO.ObjectFromidDAO;
import com.cognizant.mappers.CityMapper;
import com.cognizant.mappers.CountryMapper;
import com.cognizant.mappers.HotelMapper;
import com.cognizant.models.City;
import com.cognizant.models.Country;
import com.cognizant.models.Hotel;

@Repository("objectFromIdDAO")
public class ObjectFromidDAOImpl implements ObjectFromidDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	@Override
	public Hotel getHotelWithId(int id) {
		String sql = "SELECT * from Hotel where hotel_unique_id=?";
		List<Hotel> hotels = getJdbcTemplate().query(sql, new Object[] {id}, new HotelMapper());
		if(hotels.size()==0)
			return null;
		return hotels.get(0);
	}

	@Override
	public Country getContryWithId(int id) {
		String sql = "SELECT * from Country where id=?";
		List<Country> countries = getJdbcTemplate().query(sql, new Object[] {id}, new CountryMapper());
		if(countries.size()==0)
			return null;
		return countries.get(0);
	}

	@Override
	public City getCityWithId(int id) {
		String sql = "SELECT * from City where id=?";
		List<City> cities = getJdbcTemplate().query(sql, new Object[] {id}, new CityMapper());
		if(cities.size()==0)
			return null;
		return cities.get(0);
	}

}
