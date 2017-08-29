package com.cognizant.DAOImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.DAO.UserDAO;
import com.cognizant.mappers.UserMapper;
import com.cognizant.models.Login;
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
		if(alreadyexist(user)){
			return 2;
		}
		String sql = "INSERT INTO User(name,role,email_id,password,dob,country,city,mobile,pincode) VALUES(?,?,?,?,?,?,?,?,?)";
		int returnValue = getJdbcTemplate().update(sql,
				new Object[] { user.getUsername().trim(), user.getRole().trim(), user.getEmail().trim(),
						user.getPassword().trim(), user.getDob().trim(), user.getCountry().trim(),
						user.getCity().trim(), user.getMobile().trim(), user.getPincode().trim() });
		return returnValue;
	}

	@Override
	public User validateUser(Login login) {
		String sql = "SELECT * from User where email_id = ? and password = ?";
		List<User> users = getJdbcTemplate().query(sql, new Object[] { login.getEmail(),login.getPassword() }, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}
	
	public boolean alreadyexist(User user){
		String sql = "SELECT * from User where email_id=?";
		List<User> users = getJdbcTemplate().query(sql, new Object[] { user.getEmail() }, new UserMapper());
		return users.size() > 0 ? true:false;
	}

	
}
