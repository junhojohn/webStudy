package com.junhojohn.controllers;

import java.io.IOException;
import java.sql.SQLException;

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

	public LogonActionController() {
		// TODO Auto-generated constructor stub
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		System.out.println(getClass().getName() + ".execute() start.");
		
		UserVO loggedOnuserVO 	= null;
		String actionPage		= null;
		String userId 			= request.getParameter(Const.REQ_PARAM_KEY_USER_ID);
		String userPwd 			= request.getParameter(Const.REQ_PARAM_KEY_USER_PWD);
		HttpSession session 	= request.getSession(true);
		
		if(session.isNew() || session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO) == null) {
			session.setAttribute(Const.SESSION_ATTR_KEY_USER_VO, new UserVO());
		}
		
		loggedOnuserVO 	= (UserVO)session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO);
		actionPage 		= REQ_ACTION_PAGES_ENUM.REQ_LOGON.getJspPathURI();
		if(loggedOnuserVO.isActive()) {
			actionPage = REQ_ACTION_PAGES_ENUM.REQ_HOME.getJspPathURI();
		}else {
			
			loggedOnuserVO = new UserVO();
			UserDao userDao = new UserDaoImpl();
			UserService service = new UserServiceImpl(userDao);
			try {
				loggedOnuserVO = service.getUser(userId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(loggedOnuserVO.isActive()) {
				actionPage = REQ_ACTION_PAGES_ENUM.REQ_HOME.getJspPathURI();
				session.setAttribute(Const.SESSION_ATTR_KEY_USER_VO, loggedOnuserVO);
			}
		}
		

		ServletContext servletContext = request.getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(actionPage);
		requestDispatcher.forward(request, response);

	}

}
