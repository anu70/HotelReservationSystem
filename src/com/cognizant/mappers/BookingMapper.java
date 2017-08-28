package com.cognizant.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.models.Booking;

public class BookingMapper implements RowMapper<Booking>{

	@Override
	public Booking mapRow(ResultSet result, int arg1) throws SQLException {
		Booking booking = new Booking();
		booking.setId(result.getInt("id"));
		booking.setUser_id(result.getInt("user_id"));
		booking.setAdults_count(result.getInt("adults_count"));
		booking.setChild_count(result.getInt("child_count"));
		booking.setAc_rooms_count(result.getInt("ac_rooms_count"));
		booking.setNon_ac_rooms_count(result.getInt("non_ac_rooms_count"));
		booking.setHotel_id(result.getInt("hotel_id"));
		booking.setBooking_date(result.getString("booking_date"));
		booking.setStart_date(result.getString("start_date"));
		booking.setEnd_date(result.getString("end_date"));
		return booking;
	}

}
