package com.junhojohn.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.junhojohn.consts.Const;
import com.junhojohn.consts.REQ_ACTION_PAGES_ENUM;
import com.junhojohn.models.UserVO;

/**
 * Home request URI(/home.do)를 처리하는 Controller 클래스
 * @param HttpServletRequest 객체
 * @param HttpServletResponse 객체
 * @throws ServletException
 * @throws IOException
 */
public class HomeController extends AbstractController {

	/**
	 * Home request URI(/home.do)를 처리하는 Controller 클래스
	 * @param HttpServletRequest 객체
	 * @param HttpServletResponse 객체
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2. HomeController.execute() start.");
		
		HttpSession session = request.getSession(true);
		if(session.isNew() || session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO) == null) {
			session.setAttribute(Const.SESSION_ATTR_KEY_USER_VO, new UserVO());
		}
		
		UserVO userVO = (UserVO) session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO);
		String actionPage = REQ_ACTION_PAGES_ENUM.REQ_LOGON.getJspPathURI();
		if(userVO.isActive()) {
			actionPage = REQ_ACTION_PAGES_ENUM.REQ_HOME.getJspPathURI();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(actionPage);
		requestDispatcher.forward(request, response);
		
		System.out.println("2. HomeController.execute() end.");
	}

}
