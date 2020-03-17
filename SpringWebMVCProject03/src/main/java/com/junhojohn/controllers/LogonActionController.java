package com.junhojohn.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogonActionController implements Controller {

	public LogonActionController() {
		// TODO Auto-generated constructor stub
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(getClass().getName() + ".execute() start.");
	}

}
