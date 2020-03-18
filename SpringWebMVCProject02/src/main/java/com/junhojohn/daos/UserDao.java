package com.junhojohn.daos;

import com.junhojohn.models.UserVO;

public interface UserDao {

	public UserVO selectUserVO(final String id) throws Exception;
}
