package com.junhojohn.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.junhojohn.consts.Const;
import com.junhojohn.consts.REQ_ACTION_PAGES_ENUM;
import com.junhojohn.models.CustomModelAndView;
import com.junhojohn.models.UserVO;

public class HomeController implements Controller {

	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getClass().getName() + ".execute() start.");
		
		HttpSession session = request.getSession(true);
		if(session.isNew() || session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO) == null) {
			session.setAttribute(Const.SESSION_ATTR_KEY_USER_VO, new UserVO());
		}
		
		UserVO userVO = (UserVO) session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO);
		String actionPage = REQ_ACTION_PAGES_ENUM.REQ_LOGON.getJspPathURI();
		if(userVO.isActive()) {
			actionPage = REQ_ACTION_PAGES_ENUM.REQ_HOME.getJspPathURI();
		}
		
//		ServletContext servletContext = request.getServletContext();
//		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(actionPage);
//		requestDispatcher.forward(request, response);
		
		System.out.println(getClass().getName() + ".execute() end.");		
		return new CustomModelAndView(actionPage);

	}

}
