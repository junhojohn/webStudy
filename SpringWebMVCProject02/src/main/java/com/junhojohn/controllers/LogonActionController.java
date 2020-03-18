package com.junhojohn.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.junhojohn.consts.Const;
import com.junhojohn.consts.REQ_ACTION_PAGES_ENUM;
import com.junhojohn.daos.UserDao;
import com.junhojohn.daos.UserDaoImpl;
import com.junhojohn.models.UserVO;
import com.junhojohn.services.UserService;
import com.junhojohn.services.UserServiceImpl;

public class LogonActionController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getClass().getName() + ".execute() start.");
		String userId 						= null;
		String userPwd 						= null;
		String actionPage					= null;
		HttpSession session 				= null; 
		UserVO loggedOnUserVO				= null;
		ServletContext servletContext 		= null;
		RequestDispatcher requestDispatcher = null;
		
		request.setCharacterEncoding(Const.EUC_KR);
		userId	= request.getParameter(Const.REQ_PARAM_KEY_USER_ID);
		userPwd	= request.getParameter(Const.REQ_PARAM_KEY_USER_PWD);
		session	= request.getSession(true);
		
		UserDao userDao 		= new UserDaoImpl();
		UserService userService = new UserServiceImpl(userDao);
		loggedOnUserVO 		= userService.getUserVO(userId);
		
		if(loggedOnUserVO.isActive()) {
			actionPage = REQ_ACTION_PAGES_ENUM.REQ_HOME.getJspPathURI();
			session.setAttribute(Const.SESSION_ATTR_KEY_USER_VO, loggedOnUserVO);
		}else {
			actionPage = REQ_ACTION_PAGES_ENUM.REQ_LOGON.getJspPathURI();
		}
		
		
		servletContext 		= request.getServletContext();
		requestDispatcher 	= servletContext.getRequestDispatcher(actionPage);
		requestDispatcher.forward(request, response);
		
		System.out.println(getClass().getName() + ".execute() end.");
		
	}

}
