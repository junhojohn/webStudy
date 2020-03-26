package com.junhojohn.dao;

import com.junhojohn.models.UserVO;

public interface UserDao {

	public UserVO selectUserVO(final String id);
}
