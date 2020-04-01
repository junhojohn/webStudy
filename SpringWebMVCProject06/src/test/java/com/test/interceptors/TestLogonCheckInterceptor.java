package com.test.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.junhojohn.consts.Const;
import com.junhojohn.consts.REQ_ACTION_PAGES_ENUM_006;
import com.junhojohn.models.UserVO;

public class TestLogonCheckInterceptor extends HandlerInterceptorAdapter {

	public TestLogonCheckInterceptor() {
		System.out.println(getClass().getName() + "() Constructor.");
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(getClass().getName() + ".preHandle() start.");
		String requestURI 	= request.getRequestURI();
		HttpSession session = request.getSession(true);
		if(session.isNew() || session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO) == null) {
			session.setAttribute(Const.SESSION_ATTR_KEY_USER_VO, new UserVO());
		}

		UserVO userVO = (UserVO)session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO);
		if(requestURI != null) {
			if(REQ_ACTION_PAGES_ENUM_006.getKindByRequestURI(requestURI).equals(REQ_ACTION_PAGES_ENUM_006.REQ_HOME) ||
					REQ_ACTION_PAGES_ENUM_006.getKindByRequestURI(requestURI).equals(REQ_ACTION_PAGES_ENUM_006.REQ_LOGOUT)) {
				if(userVO.isActive()) {
					System.out.println("UserVO session exists. Keep forwarding to " + requestURI);
					System.out.println(getClass().getName() + ".preHandle() end.");
					return true;
				}else {
					System.out.println("UserVO session not exists.");
					System.out.println(getClass().getName() + ".preHandle() end.");
					return false;
				}				
			}else if(REQ_ACTION_PAGES_ENUM_006.getKindByRequestURI(requestURI).equals(REQ_ACTION_PAGES_ENUM_006.REQ_LOGON_ACTION) ||
					REQ_ACTION_PAGES_ENUM_006.getKindByRequestURI(requestURI).equals(REQ_ACTION_PAGES_ENUM_006.REQ_LOGON)){
				System.out.println("Keep forwarding to " + requestURI);
				System.out.println(getClass().getName() + ".preHandle() end.");
				return true;
			}
		}else {
			System.out.println("Invalid request URI.");
			System.out.println(getClass().getName() + ".preHandle() end.");
			return false;
		}

		System.out.println(getClass().getName() + ".preHandle() end.");
		return false;
	}
}
