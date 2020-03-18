package com.junhojohn.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junhojohn.consts.Const;
import com.junhojohn.controllers.Controller;
import com.junhojohn.mappings.ControllerMapping;
import com.junhojohn.mappings.CustomViewResolver;
import com.junhojohn.models.CustomModelAndView;
import com.junhojohn.utils.LocationUtil;

public class DispatcherServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println(getClass().getName() + ".init()");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getClass().getName() + ".service() start.");
		
		request.setCharacterEncoding(Const.EUC_KR);
		String requestURI = request.getRequestURI();
		String actionPage = LocationUtil.getActionPage(requestURI);
		System.out.println("requested URI:" + requestURI);
		System.out.println("action page:" + actionPage);
		Controller controller = ControllerMapping.getController(request);
		CustomModelAndView modelAndView = controller.execute(request, response);
		new CustomViewResolver().forward(request, response, modelAndView);
		
		System.out.println(getClass().getName() + ".service() end.");
	}
	
	@Override
	public void destroy() {
		System.out.println(getClass().getName() + ".destroy()");
	}
}
