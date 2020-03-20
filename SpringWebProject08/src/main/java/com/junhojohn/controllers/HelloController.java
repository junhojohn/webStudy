package com.junhojohn.controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(getClass().getName() + ".handleRequest() start.");
		
		request.setCharacterEncoding("EUC_KR");
		request.setAttribute("request", "request scope 확인");
		
		HttpSession session = request.getSession();
		session.setAttribute("session", "session scope 확인");
		
		ServletContext application = request.getServletContext();
		application.setAttribute("application", "application scope 확인");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/test/test.jsp");
		modelAndView.addObject("message", "request message scope 확인");
		
		System.out.println(getClass().getName() + ".handleRequest() end.");
		return modelAndView;
	}

}
