package com.cognizant.DAOImplementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cognizant.DAO.CustomerDAO;
import com.cognizant.models.Hotel;
import com.cognizant.models.Trip;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public ArrayList<Hotel> getAllAvailableHotels(Trip trip) {
		// TODO : ADD FILTER
		String sql = "SELECT * FROM Hotel";
		List<Hotel> hotels = getJdbcTemplate().query(sql, new Object[] {}, new HotelMapper());
		return (ArrayList<Hotel>) hotels;
	}
	
	class HotelMapper implements RowMapper<Hotel> {
		@Override
		public Hotel mapRow(ResultSet result, int arg1) throws SQLException {
			Hotel hotel = new Hotel();
			hotel.setHotelId(result.getString("hotel_id"));
			hotel.setHotelName(result.getString("name"));
			hotel.setCity(result.getString("city"));
			hotel.setCountry(result.getString("country"));
			hotel.setAcRoomsCount(result.getInt("ac_rooms"));
			hotel.setNonACRoomsCount(result.getInt("non_ac_rooms"));
			hotel.setRateAdultAC(result.getInt("adult_ac_rate"));
			hotel.setRateChildAC(result.getInt("child_ac_rate"));
			hotel.setRateAdultNonAC(result.getInt("adult_non_ac_rate"));
			hotel.setRateChildNonAC(result.getInt("child_non_ac_rate"));
			hotel.setDescription(result.getString("description"));
			hotel.setIdentifyHotel(result.getString("hotel_id") + ".." + result.getString("name") + ".."
					+ result.getString("city") + ".." + result.getString("country"));
			return hotel;

		}
	}
}
