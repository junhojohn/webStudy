package com.junhojohn.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.junhojohn.consts.Const;
import com.junhojohn.consts.REQ_ACTION_PAGES_ENUM_001;
import com.junhojohn.models.UserVO;
import com.junhojohn.utils.LocationUtil;

public class LogonCheckInterceptor extends HandlerInterceptorAdapter {

	public LogonCheckInterceptor() {
		System.out.println(getClass().getName() + "() Constructor.");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(getClass().getName() + ".preHandle() start.");
		
		HttpSession session = request.getSession(true);
		String requestURI 	= request.getRequestURI();
		String actionPage 	= LocationUtil.getActionPage(requestURI);
		
		//세션체크
		if(session.isNew() || session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO) == null) {
			session.setAttribute(Const.SESSION_ATTR_KEY_USER_VO, new UserVO());
		}
		
		UserVO userVO = (UserVO)session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO);
		
		if(actionPage != null) {
			if(actionPage.equals(REQ_ACTION_PAGES_ENUM_001.REQ_LOGON.getRequestActionKey()) 	||
				actionPage.equals(REQ_ACTION_PAGES_ENUM_001.REQ_HOME.getRequestActionKey()) 	||
				actionPage.equals(REQ_ACTION_PAGES_ENUM_001.REQ_LOGOUT.getRequestActionKey())) {
				if(userVO.isActive()) {
					System.out.println("You've already logged on!!!");
					request.getServletContext().getRequestDispatcher(REQ_ACTION_PAGES_ENUM_001.REQ_HOME.getJspPathURI()).forward(request, response);
					System.out.println(getClass().getName() + ".preHandle() end.");
					return true;					
				}else {
					System.out.println("Please logon first...");
					request.getServletContext().getRequestDispatcher(REQ_ACTION_PAGES_ENUM_001.REQ_LOGON.getJspPathURI()).forward(request, response);
					System.out.println(getClass().getName() + ".preHandle() end.");
					return false;
				}

			}else if(actionPage.equals(REQ_ACTION_PAGES_ENUM_001.REQ_LOGON_ACTION.getRequestActionKey())) {
				System.out.println("Logon in progress...");
				System.out.println(getClass().getName() + ".preHandle() end.");
				return true;
			}
		}
		
		System.out.println(getClass().getName() + ".preHandle() end.");
		return false;
	}
	
	
}
