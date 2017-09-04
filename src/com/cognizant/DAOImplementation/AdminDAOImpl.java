package com.cognizant.DAOImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.DAO.AdminDAO;
import com.cognizant.mappers.BookingMapper;
import com.cognizant.mappers.HotelMapper;
import com.cognizant.models.Booking;
import com.cognizant.models.Hotel;
import com.cognizant.utils.Global;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public int addHotel(Hotel hotel) {
		String sql = "INSERT INTO Hotel(hotel_id,name,country,city,ac_rooms,non_ac_rooms,adult_ac_rate,child_ac_rate,adult_non_ac_rate,child_non_ac_rate,description,delete_status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		if (alreadyexist(hotel))
			return 2;
		int returnValue = getJdbcTemplate().update(sql,
				new Object[] { hotel.getHotelId(), hotel.getHotelName(), hotel.getCountryId(), hotel.getCityId(),
						hotel.getAcRoomsCount(), hotel.getNonACRoomsCount(), hotel.getRateAdultAC(),
						hotel.getRateChildAC(), hotel.getRateAdultNonAC(), hotel.getRateChildNonAC(),
						hotel.getDescription(),0 });
		return returnValue;

	}

	public boolean alreadyexist(Hotel hotel) {
		String sql = "SELECT * from Hotel where hotel_id=? AND delete_status=?";
		List<Hotel> hotels = getJdbcTemplate().query(sql, new Object[] { hotel.getHotelId(),0}, new HotelMapper());
		return hotels.size() > 0 ? true : false;
	}

	@Override
	public ArrayList<Hotel> getAllHotels() {
		String sql = "SELECT * from Hotel WHERE delete_status=?";
		List<Hotel> hotels = getJdbcTemplate().query(sql, new Object[] {0}, new HotelMapper());
		return (ArrayList<Hotel>) hotels;
	}

	@Override
	public int editHotel(Hotel hotel) {
		String sql = "UPDATE Hotel SET name=?,ac_rooms=?,non_ac_rooms=?,adult_ac_rate=?,child_ac_rate=?,adult_non_ac_rate=?,child_non_ac_rate=?,description=? WHERE hotel_unique_id = ?";
		int returnValue = getJdbcTemplate().update(sql,
				new Object[] { hotel.getHotelName(), hotel.getAcRoomsCount(), hotel.getNonACRoomsCount(),
						hotel.getRateAdultAC(), hotel.getRateChildAC(), hotel.getRateAdultNonAC(),
						hotel.getRateChildNonAC(), hotel.getDescription(), hotel.getHotelUniqueId() });
		return returnValue;
	}

	@Override
	public int deleteHotel(Hotel hotel) {
		if(haveFutureBooking(hotel)>0)
			return 2;
		else{
			String sql = "UPDATE Hotel SET delete_status=? WHERE hotel_unique_id=?";
			int returnValue = getJdbcTemplate().update(sql,
					new Object[] {1,hotel.getHotelUniqueId()});
			return returnValue;
		}	
	}
	
	public int haveFutureBooking(Hotel hotel){
		String sql = "SELECT * from Booking where hotel_id=? AND end_date>?";
		Global.getInstance();
		//System.out.println(hotel.getHotelUniqueId()+" "+Global.todaysDate);
		List<Booking> bookings = getJdbcTemplate().query(sql,new Object[]{hotel.getHotelUniqueId(),Global.todaysDate},new BookingMapper());
		System.out.println(bookings.toString());
		return bookings.size();
	}
}
