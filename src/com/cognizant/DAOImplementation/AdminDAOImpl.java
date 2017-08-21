package com.cognizant.DAOImplementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cognizant.DAO.AdminDAO;
import com.cognizant.models.Hotel;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public int addHotel(Hotel hotel) {
		String sql = "INSERT INTO Hotel(hotel_id,name,country,city,ac_rooms,non_ac_rooms,adult_ac_rate,child_ac_rate,adult_non_ac_rate,child_non_ac_rate,description) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		if (alreadyexist(hotel))
			return 2;
		int returnValue = getJdbcTemplate().update(sql,
				new Object[] { hotel.getHotelId(), hotel.getHotelName(), hotel.getCountry(), hotel.getCity(),
						hotel.getAcRoomsCount(), hotel.getNonACRoomsCount(), hotel.getRateAdultAC(),
						hotel.getRateChildAC(), hotel.getRateAdultNonAC(), hotel.getRateChildNonAC(),
						hotel.getDescription() });
		return returnValue;

	}

	public boolean alreadyexist(Hotel hotel) {
		String sql = "SELECT * from Hotel where hotel_id=?";
		List<Hotel> hotels = getJdbcTemplate().query(sql, new Object[] { hotel.getHotelId() }, new HotelMapper());
		return hotels.size() > 0 ? true : false;
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

	@Override
	public ArrayList<Hotel> getAllHotels() {
		String sql = "SELECT * from Hotel";
		List<Hotel> hotels = getJdbcTemplate().query(sql, new Object[] {}, new HotelMapper());
		return (ArrayList<Hotel>) hotels;
	}

	@Override
	public int editHotel(Hotel hotel) {
		String sql = "UPDATE Hotel SET name=?,ac_rooms=?,non_ac_rooms=?,adult_ac_rate=?,child_ac_rate=?,adult_non_ac_rate=?,child_non_ac_rate=?,description=? WHERE hotel_id = ?";
		int returnValue = getJdbcTemplate().update(sql,
				new Object[] { hotel.getHotelName(), hotel.getAcRoomsCount(), hotel.getNonACRoomsCount(),
						hotel.getRateAdultAC(), hotel.getRateChildAC(), hotel.getRateAdultNonAC(),
						hotel.getRateChildNonAC(), hotel.getDescription(), hotel.getHotelId() });
		return returnValue;
	}
}
