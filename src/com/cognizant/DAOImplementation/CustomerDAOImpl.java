package com.cognizant.DAOImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.DAO.CustomerDAO;
import com.cognizant.mappers.BookingMapper;
import com.cognizant.mappers.HotelMapper;
import com.cognizant.mappers.PaymentMapper;
import com.cognizant.models.Booking;
import com.cognizant.models.Hotel;
import com.cognizant.models.HotelsList;
import com.cognizant.models.Payment;
import com.cognizant.models.Trip;
import com.cognizant.models.User;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public HotelsList getAllHotels(Trip trip) {
		String sql = "SELECT * FROM Hotel where city=? AND country=?";
		List<Hotel> hotels = getJdbcTemplate().query(sql, new Object[] {trip.getCityId(),trip.getCountryId()}, new HotelMapper());
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
		if (booking.getId() != 0)
			return editBooking(booking);
		String sql = "INSERT INTO Booking(hotel_id,user_id,booking_date,start_date,end_date,adults_count,child_count,ac_rooms_count,non_ac_rooms_count,total_cost) VALUES(?,?,?,?,?,?,?,?,?,?)";
		int returnValue = getJdbcTemplate().update(sql,
				new Object[] { booking.getHotel_id(), booking.getUser_id(), booking.getBooking_date(),
						booking.getStart_date(), booking.getEnd_date(), booking.getAdults_count(),
						booking.getChild_count(), booking.getAc_rooms_count(), booking.getNon_ac_rooms_count(),
						booking.getTotal_cost() });
		if (returnValue == 1) {
			sql = "Select * from Booking where hotel_id=? AND user_id=? AND booking_date =? AND start_date =? AND end_date =? AND adults_count =? AND child_count =? AND ac_rooms_count =? AND non_ac_rooms_count=?";
			List<Booking> bookings = getJdbcTemplate().query(sql,
					new Object[] { booking.getHotel_id(), booking.getUser_id(), booking.getBooking_date(),
							booking.getStart_date(), booking.getEnd_date(), booking.getAdults_count(),
							booking.getChild_count(), booking.getAc_rooms_count(), booking.getNon_ac_rooms_count() },
					new BookingMapper());
			return bookings.get(bookings.size() - 1).getId();
		}
		return 0;
	}

	public int editBooking(Booking booking) {
		String sql = "UPDATE Booking SET start_date=?,end_date=?,ac_rooms_count=?,non_ac_rooms_count=?,total_cost=?,child_count=?,adults_count=? WHERE id = ?";
		int returnValue = getJdbcTemplate().update(sql,
				new Object[] { booking.getStart_date(), booking.getEnd_date(), booking.getAc_rooms_count(),
						booking.getNon_ac_rooms_count(), booking.getTotal_cost(),booking.getChild_count(),booking.getAdults_count(),booking.getId() });
		if (returnValue == 1)
			return booking.getId();
		return 0;
	}

	@Override
	public int makePayment(Payment payment) {
		String sql = "INSERT INTO Payment(user_id,card_type,credit_card_no,name_on_card,expiry_date,cvv,account_no,atm_pin,is_senior_citizen,status) VALUES(?,?,?,?,?,?,?,?,?,?)";
		int returnValue = getJdbcTemplate().update(sql,
				new Object[] { payment.getUser_id(), payment.getCard_type(), payment.getCredit_card_no(),
						payment.getName_on_card(), payment.getExpiry_date(), payment.getCvv(), payment.getAccount_no(),
						payment.getAtm_pin(), payment.isIs_senior_citizen(), payment.getStatus() });
		if (returnValue == 1) {
			sql = "Select * from Payment where user_id=? AND card_type=? AND credit_card_no=? AND name_on_card=? AND expiry_date=? AND cvv=? AND account_no=? AND atm_pin=? AND is_senior_citizen=? AND status=?";
			List<Payment> transactions = getJdbcTemplate().query(sql,
					new Object[] { payment.getUser_id(), payment.getCard_type(), payment.getCredit_card_no(),
							payment.getName_on_card(), payment.getExpiry_date(), payment.getCvv(),
							payment.getAccount_no(), payment.getAtm_pin(), payment.isIs_senior_citizen(),
							payment.getStatus() },
					new PaymentMapper());
			return transactions.get(transactions.size() - 1).getId();
		}
		return 0;
	}

	@Override
	public ArrayList<Booking> getAllBookings(User user) {
		String sql = "SELECT * from Booking WHERE user_id=?";
		List<Booking> bookings = getJdbcTemplate().query(sql, new Object[] { user.getId() }, new BookingMapper());
		return (ArrayList<Booking>) bookings;
	}

	@Override
	public int cancelBooking(Booking booking) {
		String sql = "DELETE from Booking WHERE id=?";
		int returnValue = getJdbcTemplate().update(sql, new Object[] { booking.getId() });

		if (returnValue == 1) {
			String sql1 = "INSERT INTO cancelled_bookings(booking_id,hotel_id,user_id,booking_date,start_date,end_date,adults_count,child_count,ac_rooms_count,non_ac_rooms_count,total_cost) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			int returnValue1 = getJdbcTemplate().update(sql1,
					new Object[] { booking.getId(), booking.getHotel_id(), booking.getUser_id(),
							booking.getBooking_date(), booking.getStart_date(), booking.getEnd_date(),
							booking.getAdults_count(), booking.getChild_count(), booking.getAc_rooms_count(),
							booking.getNon_ac_rooms_count(), booking.getTotal_cost() });
			return returnValue1;
		}
		return 0;
	}

}
