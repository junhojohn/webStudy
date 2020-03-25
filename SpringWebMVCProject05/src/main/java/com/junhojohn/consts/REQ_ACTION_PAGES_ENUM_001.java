package com.junhojohn.consts;

/**
 * Request Action에 대한 매핑 정보(request action, request uri)를 모아둔 enum 클래스
 * @author junhojohn
 *
 */
public enum REQ_ACTION_PAGES_ENUM_001 {

	REQ_HOME		("home", 		"/005Views/home.jsp", 			"/SpringWebMVCProject05/home.do"),
	REQ_LOGON		("logon", 		"/005Views/logon.jsp", 			"/SpringWebMVCProject05/logon.do"),
	REQ_LOGOUT		("logout", 		"/005Views/logout.jsp", 		"/SpringWebMVCProject05/logout.do"),
	REQ_LOGON_ACTION("logonAction", "/005Views/logonAction.jsp", 	"/SpringWebMVCProject05/logonAction.do");
	
	private String requestActionKey;
	private String jspPathURI;
	private String requestURI;
	
	private REQ_ACTION_PAGES_ENUM_001(String requestActionKey, String jspPathURI, String requestURI) {
		this.requestActionKey	= requestActionKey;
		this.jspPathURI			= jspPathURI;
		this.requestURI			= requestURI;
	}

	public static String getRequestActionKeyByJSPPathURI(String jspPathURI) {
		for(REQ_ACTION_PAGES_ENUM_001 actionKind : REQ_ACTION_PAGES_ENUM_001.values()) {
			if(actionKind.getJspPathURI().equals(jspPathURI)) {
				return actionKind.getRequestActionKey();
			}
		}
		return null;
	}
	
	public static String getRequestActionKeyByRequestURI(String requestURI) {
		for(REQ_ACTION_PAGES_ENUM_001 actionKind : REQ_ACTION_PAGES_ENUM_001.values()) {
			if(actionKind.getRequestURI().equals(requestURI)) {
				return actionKind.getRequestActionKey();
			}
		}
		return null;
	}
	
	public static String getJSPPathByRequestActionKey(String requestActionKey) {
		for(REQ_ACTION_PAGES_ENUM_001 actionKind : REQ_ACTION_PAGES_ENUM_001.values()) {
			if(actionKind.getRequestActionKey().equals(requestActionKey)) {
				return actionKind.getJspPathURI();
			}
		}
		return null;
	}
	
	public static String getJSPPathByRequestURI(String requestURI) {
		for(REQ_ACTION_PAGES_ENUM_001 actionKind : REQ_ACTION_PAGES_ENUM_001.values()) {
			if(actionKind.getRequestURI().equals(requestURI)) {
				return actionKind.getJspPathURI();
			}
		}
		return null;
	}
	
	public static String getRequestURIByRequestActionKey(String requestActionKey) {
		for(REQ_ACTION_PAGES_ENUM_001 actionKind : REQ_ACTION_PAGES_ENUM_001.values()) {
			if(actionKind.getRequestActionKey().equals(requestActionKey)) {
				return actionKind.getRequestURI();
			}
		}
		return null;
	}
	
	public static String getRequestURIByJSPPathURI(String jspPathURI) {
		for(REQ_ACTION_PAGES_ENUM_001 actionKind : REQ_ACTION_PAGES_ENUM_001.values()) {
			if(actionKind.getJspPathURI().equals(jspPathURI)) {
				return actionKind.getRequestURI();
			}
		}
		return null;
	}
	
	public static REQ_ACTION_PAGES_ENUM_001 getKindByRequestActionKey(String requestActionKey) {
		for(REQ_ACTION_PAGES_ENUM_001 actionKind : REQ_ACTION_PAGES_ENUM_001.values()) {
			if(actionKind.getRequestActionKey().equals(requestActionKey)) {
				return actionKind;
			}
		}
		return null;		
	}
	
	public static REQ_ACTION_PAGES_ENUM_001 getKindByJSPPathURI(String jspPathURI) {
		for(REQ_ACTION_PAGES_ENUM_001 actionKind : REQ_ACTION_PAGES_ENUM_001.values()) {
			if(actionKind.getJspPathURI().equals(jspPathURI)) {
				return actionKind;
			}
		}
		return null;		
	}
	
	public static REQ_ACTION_PAGES_ENUM_001 getKindByRequestURI(String requestURI) {
		for(REQ_ACTION_PAGES_ENUM_001 actionKind : REQ_ACTION_PAGES_ENUM_001.values()) {
			if(actionKind.getRequestURI().equals(requestURI)) {
				return actionKind;
			}
		}
		return null;		
	}
	
	
	public String getRequestActionKey() {
		return requestActionKey;
	}

	public String getJspPathURI() {
		return jspPathURI;
	}

	public String getRequestURI() {
		return requestURI;
	}	
}
