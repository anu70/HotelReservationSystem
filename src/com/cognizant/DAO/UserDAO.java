package com.cognizant.DAO;

import com.cognizant.models.Login;
import com.cognizant.models.User;

public interface UserDAO {
	int register(User user);
	User validateUser(Login login);
	boolean adminAlreadyExist();
}
