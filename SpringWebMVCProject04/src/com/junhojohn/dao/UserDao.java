package com.junhojohn.dao;

import java.sql.SQLException;

import com.junhojohn.models.UserVO;

public interface UserDao {

	public UserVO selectUserVO(final String id);
}
