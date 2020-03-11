package com.junhojohn.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.junhojohn.models.User;

public class ServletRedirect extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("0. ServletRedirect.init()");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1. ServletRedirect.service() start.");
		
		request.setCharacterEncoding("EUC_KR");
		
		request.setAttribute("user", new User("junhojohn", 20));
		
		HttpSession session = request.getSession();
		session.setAttribute("user", new User("Web Developer", 25));
		
		ServletContext application = this.getServletContext();
		application.setAttribute("user", new User("Android Developer", 30));
		
		System.out.println("/MyFirstWebProject23/view.jsp 로 Redirection.");
		response.sendRedirect("/MyFirstWebProject23/view.jsp");
		System.out.println("1. ServletRedirect.service() end.");
	}
}
