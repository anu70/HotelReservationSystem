package com.cognizant.DAOImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.DAO.StaticDataDAO;
import com.cognizant.mappers.CityMapper;
import com.cognizant.mappers.CountryMapper;
import com.cognizant.models.City;
import com.cognizant.models.Country;

@Repository("staticDataDAO")
public class StaticDataDAOImpl implements StaticDataDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public ArrayList<Country> getCountriesList() {
		String sql = "Select * from Country";
		List<Country> countries =  getJdbcTemplate().query(sql,new Object[] {},new CountryMapper());
		return (ArrayList<Country>) countries;
	}

	@Override
	public ArrayList<City> getCitiesList() {
		String sql = "Select * from City";
		List<City> cities =  getJdbcTemplate().query(sql,new Object[] {},new CityMapper());
		return (ArrayList<City>) cities;
	}

	@Override
	public ArrayList<City> getCitesOfCountry(int countryId) {
		String sql = "Select * from City WHERE country_id=?";
		List<City> cities =  getJdbcTemplate().query(sql,new Object[] {countryId},new CityMapper());
		return (ArrayList<City>) cities;
	}

}
