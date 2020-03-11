package com.junhojohn.daos;

import java.util.List;

import com.junhojohn.models.UserVO;

public interface UserDao {

	public UserVO selectUser(final UserVO userVO);

	public List<UserVO> selectAllUser();
	
	public int insertUser(final UserVO userVO);
	
	public int updateUser(final UserVO targetUserVO, final UserVO destUserVO);
	
	public int deleteUser(final UserVO userVO);
	
	public void deleteAllUser();
}
