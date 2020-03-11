package com.junhojohn.services;

import java.util.List;

import com.junhojohn.models.UserVO;

public interface UserService {

	
	public UserVO getUser(final UserVO userVO);
	
	public List<UserVO> getAllUserList();
	
	public int addUser(final UserVO userVO);
	
	public int replaceUser(final UserVO targetUserVO, final UserVO destUserVO);
	
	public void removeUser(final UserVO userVO);
	
	public void removeAllUserList();
}
