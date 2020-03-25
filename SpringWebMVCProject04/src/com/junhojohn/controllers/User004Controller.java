package com.junhojohn.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.junhojohn.consts.Const;
import com.junhojohn.consts.REQ_ACTION_PAGES_ENUM_004;
import com.junhojohn.dao.UserDao;
import com.junhojohn.dao.impl.UserDaoImpl;
import com.junhojohn.models.UserVO;
import com.junhojohn.service.UserService;
import com.junhojohn.service.impl.UserServiceImpl;

@Controller
public class User004Controller {

	@RequestMapping(value="logon.do", method=RequestMethod.GET)
	public ModelAndView logon() {
		System.out.println(getClass().getName() + ".logon() start.");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_004.REQ_LOGON.getJspPathURI());
		modelAndView.addObject("message", "Logon!!! Please enter id and password.");
		
		System.out.println(getClass().getName() + ".logon() end.");
		return modelAndView;
	}

	@RequestMapping(value="home.do")
	public ModelAndView home() {
		System.out.println(getClass().getName() + ".home() start.");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_004.REQ_HOME.getJspPathURI());
		modelAndView.addObject("message", "Home!!! Welcome ");
		
		System.out.println(getClass().getName() + ".home() end.");
		return modelAndView;
	}
	
	@RequestMapping(value="logout.do")
	public ModelAndView logout(HttpSession session) {
		System.out.println(getClass().getName() + ".logout() start.");

		session.removeAttribute(Const.SESSION_ATTR_KEY_USER_VO);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_004.REQ_LOGON.getJspPathURI());
		modelAndView.addObject("message", "Logout!!! Please enter id and password.");
		
		System.out.println(getClass().getName() + ".logout() end.");
		return modelAndView;
	}
	
	@RequestMapping(value="logonAction.do", method=RequestMethod.GET)
	public ModelAndView logonAction() {
		System.out.println(getClass().getName() + ".logonAction() GET start.");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_004.REQ_LOGON.getJspPathURI());
		modelAndView.addObject("message", "LogonAction... Invalid access.");
		
		System.out.println(getClass().getName() + ".logonAction() GET end.");
		return modelAndView;
	}
	
	@RequestMapping(value="logonAction.do", method=RequestMethod.POST)
	public ModelAndView logonAction(HttpSession session,
			@RequestParam(value=Const.REQ_PARAM_KEY_USER_ID, required=true) String id, 
			@RequestParam(value=Const.REQ_PARAM_KEY_USER_PWD, required=false) String pwd) {
		System.out.println(getClass().getName() + ".logonAction() POST start.");
		String viewName			= null;
		String message			= null;
		UserDao userDao 		= new UserDaoImpl();
		UserService userService = new UserServiceImpl(userDao);
		UserVO userVO 			= userService.getUserVO(id);
		
		if(userVO.isActive()) {
			viewName 	= REQ_ACTION_PAGES_ENUM_004.REQ_HOME.getJspPathURI();
			message		= "LogonAction!!! Welcome ";
			session.setAttribute(Const.SESSION_ATTR_KEY_USER_VO, userVO);
		}else {
			viewName 	= REQ_ACTION_PAGES_ENUM_004.REQ_LOGON.getJspPathURI();
			message		= "LogonAction... Fail to logon. Please check id or password.";
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		modelAndView.addObject("message", message);
		
		System.out.println(getClass().getName() + ".logonAction() POST end.");
		return modelAndView;
	}

}
