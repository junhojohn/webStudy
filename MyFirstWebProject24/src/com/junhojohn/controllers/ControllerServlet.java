package com.junhojohn.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.junhojohn.daos.UserDao;
import com.junhojohn.models.UserVO;

public class ControllerServlet extends HttpServlet {

	private String requestPage = "/logon.jsp";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set Character set
		request.setCharacterEncoding("EUC_KR");
		
		// get Request URI
		String actionPage = this.getURI(request.getRequestURI());
		System.out.println("URI?=>:" + request.getRequestURI());
		System.out.println("Client의 요구사항은? =>:" + actionPage);
		
		// get Session Object Scope Data 
		HttpSession session = request.getSession(true);
		if(session.isNew() || session.getAttribute("userVO") == null) {
			session.setAttribute("userVO", new UserVO());
		}
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		
		// determine forwarding page url
		if(userVO != null && userVO.isActive()) {
			requestPage = "/home.jsp";
		}else if(actionPage.equals("logon")) {
			// Nothing
		}else if(actionPage.equals("logonAction")) {
			String userId = request.getParameter("userId");
			String userPwd = request.getParameter("userPwd");
			userVO.setId(userId);
			userVO.setPwd(userPwd);
			
			UserDao userDao = new UserDao();
			userVO = userDao.getUserVO(userVO);
			
			if(userVO.isActive()) {
				requestPage = "/home.jsp";
			}else {
				requestPage = "/logon.jsp";
			}
		}else if(actionPage.equals("home")) {
			// Nothing			
		}
		
		// Forwarding given requestPage URI
		ServletContext servletContext = this.getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(requestPage);
		requestDispatcher.forward(request, response);
	}
	
	private String getURI(String requestURI) {
		int start = requestURI.lastIndexOf('/')+1;
		int end = requestURI.lastIndexOf(".do");
		String actionPage = requestURI.substring(start, end);
		return actionPage;
	}
}
