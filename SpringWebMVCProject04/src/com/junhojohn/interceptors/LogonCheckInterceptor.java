package com.junhojohn.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.junhojohn.consts.Const;
import com.junhojohn.consts.REQ_ACTION_PAGES_ENUM_004;
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
	
		String requestURI 	= request.getRequestURI();
		String actionPage 	= LocationUtil.getActionPage(requestURI);
		
		HttpSession session = request.getSession(true);
		
		if(session.isNew() || session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO) == null) {
			session.setAttribute(Const.SESSION_ATTR_KEY_USER_VO, new UserVO());
		}

		
		UserVO userVO = (UserVO)session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO);
		if(actionPage != null) {
			if(actionPage.equals(REQ_ACTION_PAGES_ENUM_004.REQ_HOME.getRequestActionKey()) 	||
				actionPage.equals(REQ_ACTION_PAGES_ENUM_004.REQ_LOGOUT.getRequestActionKey())) {

				if(userVO.isActive()) {
					// 로그인이 되어 있다면,
					System.out.println("[로그인 상태... 로그인 후 불필요한 요구...");
					request.getServletContext().getRequestDispatcher(REQ_ACTION_PAGES_ENUM_004.REQ_HOME.getJspPathURI()).forward(request, response);
					System.out.println(getClass().getName() + ".preHandle() end.");
					return true;
				}else {
					// 로그인이 되어 있지 않다면,
					System.out.println("로그인 시도 상태...");
					request.getServletContext().getRequestDispatcher(REQ_ACTION_PAGES_ENUM_004.REQ_LOGON.getJspPathURI()).forward(request, response);
					System.out.println(getClass().getName() + ".preHandle() end.");
					return false;
				}
				
			}else if(actionPage.equals(REQ_ACTION_PAGES_ENUM_004.REQ_LOGON_ACTION.getRequestActionKey()) ||
					actionPage.equals(REQ_ACTION_PAGES_ENUM_004.REQ_LOGON.getRequestActionKey())) {
				System.out.println("로그인 시도 상태...");
				System.out.println(getClass().getName() + ".preHandle() end.");
				return true;
			}
		}
		
		System.out.println(getClass().getName() + ".preHandle() end.");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
