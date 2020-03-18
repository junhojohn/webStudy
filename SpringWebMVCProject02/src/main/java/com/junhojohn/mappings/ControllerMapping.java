package com.junhojohn.mappings;

import javax.servlet.http.HttpServletRequest;

import com.junhojohn.consts.REQ_ACTION_PAGES_ENUM;
import com.junhojohn.controllers.Controller;
import com.junhojohn.controllers.HomeController;
import com.junhojohn.controllers.LogonActionController;
import com.junhojohn.controllers.LogonController;

public class ControllerMapping {

	private ControllerMapping() {
		
	}
	
	public static Controller getController(HttpServletRequest request) {
		if(request == null) {
			return null;
		}
		String requestURI = request.getRequestURI();
		return getController(requestURI);
	}
	
	private static Controller getController(String requestURI) {
		if(requestURI == null || requestURI.isEmpty()) {
			return null;
		}
		REQ_ACTION_PAGES_ENUM kind = REQ_ACTION_PAGES_ENUM.getKindByRequestURI(requestURI);
		return getController(kind);
	}
	
	private static Controller getController(REQ_ACTION_PAGES_ENUM kind) {
		Controller controller = null;
		if(kind == null) {
			return controller;
		}

		switch (kind) {
		case REQ_HOME:
			controller = new HomeController();
			break;
		case REQ_LOGON:
			controller = new LogonController();
			break;
		case REQ_LOGON_ACTION:
			controller = new LogonActionController();
			break;
		default:
			break;
		}
		
		return controller;
	}
}
