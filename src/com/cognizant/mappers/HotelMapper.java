package com.cognizant.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.models.Hotel;

public class HotelMapper implements RowMapper<Hotel> {
	@Override
	public Hotel mapRow(ResultSet result, int arg1) throws SQLException {
		Hotel hotel = new Hotel();
		hotel.setHotelUniqueId(result.getInt("hotel_unique_id"));
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
