package com.cognizant.DAOImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.DAO.CustomerDAO;
import com.cognizant.mappers.BookingMapper;
import com.cognizant.mappers.HotelMapper;
import com.cognizant.models.Booking;
import com.cognizant.models.Hotel;
import com.cognizant.models.HotelsList;
import com.cognizant.models.Payment;
import com.cognizant.models.Trip;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public HotelsList getAllHotels(Trip trip) {
		String sql = "SELECT * FROM Hotel";
		List<Hotel> hotels = getJdbcTemplate().query(sql, new Object[] {}, new HotelMapper());
		return new HotelsList((ArrayList<Hotel>) hotels);
	}

	@Override
	public ArrayList<Booking> getBookedHotels(Trip trip) {
		String sql = "SELECT * from Booking WHERE NOT (start_date>=? OR end_date<=?)";
		List<Booking> bookings = getJdbcTemplate().query(sql, new Object[] { trip.getEndDate(), trip.getStartDate() },
				new BookingMapper());
		return (ArrayList<Booking>) bookings;
	}

	@Override
	public int bookHotel(Booking booking) {
		String sql = "INSERT INTO Booking(hotel_id,user_id,booking_date,start_date,end_date,adults_count,child_count,ac_rooms_count,non_ac_rooms_count) VALUES(?,?,?,?,?,?,?,?,?)";
		int returnValue = getJdbcTemplate().update(sql,
				new Object[] { booking.getHotel_id(), booking.getUser_id(), booking.getBooking_date(),
						booking.getStart_date(), booking.getEnd_date(), booking.getAdults_count(),
						booking.getChild_count(), booking.getAc_rooms_count(), booking.getNon_ac_rooms_count() });
		return returnValue;
	}

	@Override
	public int makePayment(Payment payment) {
		String sql = "INSERT INTO Payment(user_id,card_type,credit_card_no,name_on_card,expiry_date,cvv,account_no,atm_pin,is_senior_citizen,status) VALUES(?,?,?,?,?,?,?,?,?,?)";
		int returnValue = getJdbcTemplate().update(sql,
				new Object[] { payment.getUser_id(), payment.getCard_type(), payment.getCredit_card_no(),
						payment.getName_on_card(), payment.getExpiry_date(), payment.getCvv(), payment.getAccount_no(),
						payment.getAtm_pin(), payment.isIs_senior_citizen(), payment.getStatus() });
		return returnValue;
	}

}
