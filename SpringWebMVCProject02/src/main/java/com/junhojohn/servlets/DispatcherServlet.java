package com.junhojohn.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junhojohn.controllers.Controller;
import com.junhojohn.mappings.ControllerMapping;
import com.junhojohn.utils.LocationUtil;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println(getClass().getName() + ".init()");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println(getClass().getName() + ".destroy()");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getClass().getName() + ".service() start.");
		
		String requestURI = request.getRequestURI();
		String actionPage = LocationUtil.getActionPage(requestURI);
		System.out.println("requested URI:" + requestURI);
		System.out.println("action page:" + actionPage);
		Controller controller = ControllerMapping.getController(request);
		controller.execute(request, response);
		
		System.out.println(getClass().getName() + ".service() end.");
	}

}
