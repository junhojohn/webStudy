package com.junhojohn.mappings;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junhojohn.models.CustomModelAndView;

public class CustomViewResolver {

	public CustomViewResolver() {
		// TODO Auto-generated constructor stub
	}
	
	public void forward(HttpServletRequest request, HttpServletResponse response, CustomModelAndView modelAndView) throws ServletException, IOException {
		System.out.println(getClass().getName() + ".forward() start.");
		ServletContext servletContext = request.getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(modelAndView.getViewName());
		requestDispatcher.forward(request, response);
		System.out.println(getClass().getName() + ".forward() end.");
	}
}
