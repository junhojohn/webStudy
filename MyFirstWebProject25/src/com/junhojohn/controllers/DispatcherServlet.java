package com.junhojohn.controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junhojohn.consts.Const;
import com.junhojohn.utils.CommonUtil;

public class DispatcherServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("0. DispatcherServlet.init(ServletConfig).");
		super.init(config);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("1. DispatcherServlet.service() start.");

		// 1. set character encoding
		request.setCharacterEncoding(Const.EUC_KR);

		// 2. get action page uri from request uri
		String requestURI = request.getRequestURI();
		System.out.println("Client로 부터 요청된 URI:" + requestURI);
		System.out.println("Action page URI:" + CommonUtil.getActionPageURI(requestURI));

		// 3. get Controller from request action key
		AbstractController controller = ControllerMapping.getInstance().getControllerOfRequestURI(requestURI);
		controller.execute(request, response);
		
		System.out.println("1. DispatcherServlet.service() end.");
	}
	
}
