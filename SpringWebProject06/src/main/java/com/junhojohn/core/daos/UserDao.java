package com.junhojohn.core.daos;

import java.sql.SQLException;
import java.util.List;

import com.junhojohn.core.models.UserVO;

public interface UserDao {

	public List<UserVO> selectAllUserList() throws SQLException;
	
	public UserVO selectUser(final String id) throws SQLException;
	
	public int insertUser(final UserVO userVO) throws SQLException;

	public int deleteUser(final String id) throws SQLException;
	
	public int updateUser(final UserVO userVO) throws SQLException;
}
