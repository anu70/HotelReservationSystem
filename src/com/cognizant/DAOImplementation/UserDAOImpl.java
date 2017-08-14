package com.cognizant.DAOImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.DAO.UserDAO;
import com.cognizant.models.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

	@Override
	public int register(User user) {
		String sql = "INSERT INTO User(name,role,email_id,password,dob,country,city,mobile,pincode) VALUES(?,?,?,?,?,?,?,?,?)";
        int returnValue = getJdbcTemplate().update(
                sql,
                new Object[] {user.getUsername(),user.getRole(),user.getEmail(),user.getPassword(),user.getDob(),user.getCountry(),user.getCity(),user.getMobile(),user.getPincode() });
        return returnValue;
	}
}
