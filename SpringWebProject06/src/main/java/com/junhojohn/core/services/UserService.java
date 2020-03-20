package com.junhojohn.core.services;

import java.sql.SQLException;
import java.util.List;

import com.junhojohn.core.models.UserVO;

public interface UserService {

	public List<UserVO> getAllUserList() throws SQLException;
	
	public UserVO getUser(final String id) throws SQLException;
	
	public int addUser(final UserVO userVO) throws SQLException;
	
	public int removeUser(final String id) throws SQLException;
	
	public int modifyUser(final UserVO userVO) throws SQLException;
}
