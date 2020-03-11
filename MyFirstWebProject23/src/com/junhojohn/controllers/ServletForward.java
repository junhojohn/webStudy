package com.junhojohn.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.junhojohn.models.User;

public class ServletForward extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("0. ServletForward.init()");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("1. ServletForward.service() start.");
		
		// Character Encoding
		request.setCharacterEncoding("EUC_KR");
		
		// 1. Request Object Scope
		request.setAttribute("user", new User("junhojohn", 20));
		
		// 2. Session Object Scope
		HttpSession session = request.getSession();
		session.setAttribute("user", new User("Web Developer", 25));
		
		// 3. Application Object Scope
		ServletContext application = this.getServletContext();
		application.setAttribute("user", new User("Android Developer", 30));
		
		// 4. Binding jsp page into RequestDispatcher
		RequestDispatcher requestDispatcher = application.getRequestDispatcher("/view.jsp");
		
		// 5. Forward with request and response
		requestDispatcher.forward(request, response);
		
		System.out.println("1. ServletForward.service() end.");
	}
}
