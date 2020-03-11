package com.junhojohn.controllers;

import com.junhojohn.consts.DB_CONNECTION_INFO_ENUM;
import com.junhojohn.consts.REQ_ACTION_PAGES_ENUM;
import com.junhojohn.utils.CommonUtil;

/**
 * AbstractController 하위 클래스 인스턴스를 반환하는 매핑 클래스
 * @author junhojohn
 *
 */
public class ControllerMapping {

	private static volatile ControllerMapping instance;
	
	private ControllerMapping() {

	}
	
	/**
	 * AbstractController 하위 클래스 인스턴스를 반환하는 매핑 클래스를 얻는다.
	 * @singleton
	 * @author junhojohn
	 * @return ControllerMapping 클래스
	 *
	 */
	public static ControllerMapping getInstance() {
		if(instance == null) {
			synchronized (ControllerMapping.class) {
				if(instance == null) {
					instance = new ControllerMapping();						
				}

			}
		}			
		return instance;
	}

	/**
	 * Request Action URI에 맞는 Controller 클래스를 반환한다.
	 * @param Request URI (예) /MyFirstWebProject25/logon.do
	 * @return AbstractController
	 */
	public AbstractController getControllerOfRequestURI(String requestURI) {
		String requestActionKey = CommonUtil.getActionPageURI(requestURI);
		return getControllerOfRequestActionKey(requestActionKey);
	}
	
	/**
	 * Request Action URI에 맞는 Controller 클래스를 반환한다.
	 * @param Request Action key (예) /MyFirstWebProject25/logon.do 에서 logon
	 * @return AbstractController
	 */
	public AbstractController getControllerOfRequestActionKey(String requestActionKey) {
		REQ_ACTION_PAGES_ENUM requestActionKind = REQ_ACTION_PAGES_ENUM.getKindByRequestActionKey(requestActionKey);
		return getController(requestActionKind);
	}
	
	/**
	 * Request Action URI에 맞는 Controller 클래스를 반환한다.
	 * @param Request Action Kind(enum 타입)
	 * @return AbstractController
	 */
	private AbstractController getController(REQ_ACTION_PAGES_ENUM enumKind) {
		AbstractController controller = null;
		
		switch (enumKind) {
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
