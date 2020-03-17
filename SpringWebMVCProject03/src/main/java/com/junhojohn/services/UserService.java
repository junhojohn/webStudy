package com.junhojohn.services;

import java.sql.SQLException;

import com.junhojohn.models.UserVO;

public interface UserService {

	public UserVO getUser(final String id) throws SQLException;
	
}
