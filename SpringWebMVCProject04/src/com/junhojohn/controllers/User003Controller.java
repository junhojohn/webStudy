package com.junhojohn.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.junhojohn.consts.Const;
import com.junhojohn.consts.REQ_ACTION_PAGES_ENUM_003;
import com.junhojohn.dao.UserDao;
import com.junhojohn.dao.impl.UserDaoImpl;
import com.junhojohn.models.UserVO;
import com.junhojohn.service.UserService;
import com.junhojohn.service.impl.UserServiceImpl;

//@Controller
public class User003Controller {

	@RequestMapping("/logon.do")
	public ModelAndView logon(HttpSession session) {
		System.out.println(getClass().getName() + ".logon() start.");
		
		UserVO userVO 	= null;
		String viewName	= null;
		String message	= null;
		
		if(session.isNew() || session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO) == null) {
			session.setAttribute(Const.SESSION_ATTR_KEY_USER_VO, new UserVO());
		}
		
		userVO = (UserVO)session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO);
		
		if(userVO.isActive()) {
			viewName	= REQ_ACTION_PAGES_ENUM_003.REQ_HOME.getJspPathURI();
			message		= "Logon success!!! Welcome ";
		}else {
			viewName	= REQ_ACTION_PAGES_ENUM_003.REQ_LOGON.getJspPathURI();
			message		= "Logon failed... Please check id or password.";
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		modelAndView.addObject("message", message);

		System.out.println(getClass().getName() + ".logon() end.");
		return modelAndView;
	}
	
	@RequestMapping("/home.do")
	public ModelAndView home(HttpSession session) {
		System.out.println(getClass().getName() + ".home() start.");
		
		UserVO userVO	= null;
		String viewName	= null;
		String message	= null;
		
		if(session.isNew() || session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO) == null) {
			session.setAttribute(Const.SESSION_ATTR_KEY_USER_VO, new UserVO());
		}
		
		userVO = (UserVO)session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO);
		
		if(userVO.isActive()) {
			viewName	= REQ_ACTION_PAGES_ENUM_003.REQ_HOME.getJspPathURI();
			message		= "Home!!! Welcome ";
		}else {
			viewName	= REQ_ACTION_PAGES_ENUM_003.REQ_LOGON.getJspPathURI();
			message		= "Home... Please check id or password.";
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		modelAndView.addObject("message", message);
		
		System.out.println(getClass().getName() + ".home() end.");
		return modelAndView;
	}
	
	@RequestMapping(value="logonAction.do", method=RequestMethod.GET)
	public ModelAndView logonAction() {
		System.out.println(getClass().getName() + ".logonAction() GET start.");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_003.REQ_LOGON.getJspPathURI());
		modelAndView.addObject("message", "LogonAction...GET 방식은 잘못된 접근입니다.");
		
		System.out.println(getClass().getName() + ".logonAction() GET end.");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/logonAction.do", method=RequestMethod.POST)
	public ModelAndView logonAction(HttpSession session,
			@RequestParam(value=Const.REQ_PARAM_KEY_USER_ID, required=true) String id,
			@RequestParam(value=Const.REQ_PARAM_KEY_USER_PWD) String pwd) {
		System.out.println(getClass().getName() + ".logonAction() POST start.");
		
		UserVO userVO 	= null;
		String viewName = null;
		String message	= null;
		
		UserDao userDao = new UserDaoImpl();
		UserService userService = new UserServiceImpl(userDao);
		userVO = userService.getUserVO(id);
		
		if(userVO.isActive()) {
			session.setAttribute(Const.SESSION_ATTR_KEY_USER_VO, userVO);
			viewName	= REQ_ACTION_PAGES_ENUM_003.REQ_HOME.getJspPathURI();
			message		= "LogonAction!!! Welcome ";
		}else {
			viewName	= REQ_ACTION_PAGES_ENUM_003.REQ_LOGON.getJspPathURI();
			message		= "LogonAction... Please enter id and password.";
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		modelAndView.addObject("message", message);
		
		System.out.println(getClass().getName() + ".logonAction() POST end.");
		return modelAndView;
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) {
		System.out.println(getClass().getName() + ".logout() start.");
		
		session.removeAttribute(Const.SESSION_ATTR_KEY_USER_VO);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_003.REQ_LOGON.getJspPathURI());
		modelAndView.addObject("message", "Logout...Please login.");
		System.out.println(getClass().getName() + ".logout() end.");
		return modelAndView;
	}
	
	
}
