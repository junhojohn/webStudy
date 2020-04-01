package com.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.junhojohn.consts.Const;
import com.junhojohn.consts.REQ_ACTION_PAGES_ENUM_006;

@Controller
public class TestUserController {

	public TestUserController() {
		System.out.println(getClass().getName() + "() Constructor.");
	}
	
	@RequestMapping("logon.do")
	public ModelAndView logon() {
		System.out.println(getClass().getName() + ".logon() start.");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_006.REQ_LOGON.getJspPathURI());
		modelAndView.addObject("message", "Test logon.do success!!");
		System.out.println(getClass().getName() + ".logon() end.");
		return modelAndView;
	}
	
	@RequestMapping("home.do")
	public ModelAndView home() {
		System.out.println(getClass().getName() + ".home() start.");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_006.REQ_HOME.getJspPathURI());
		modelAndView.addObject("message", "Test home.do success!!");
		System.out.println(getClass().getName() + ".home() end.");
		return modelAndView;		
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout() {
		System.out.println(getClass().getName() + ".logout() start.");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_006.REQ_LOGOUT.getJspPathURI());
		modelAndView.addObject("message", "Test logout.do success!!");
		System.out.println(getClass().getName() + ".logout() end.");
		return modelAndView;
	}
	
	@RequestMapping(value="logonAction.do")
	public ModelAndView logonAction(
			@RequestParam(value=Const.REQ_PARAM_KEY_USER_ID, required=true) String id, 
			@RequestParam(value=Const.REQ_PARAM_KEY_USER_PWD, required=false) String pwd,
			@RequestParam(value=Const.REQ_PARAM_KEY_AGE, required=false) int age) {
		System.out.println(getClass().getName() + ".logonAction() start.");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_006.REQ_LOGON_ACTION.getJspPathURI());
		modelAndView.addObject("message", "Test logonAction.do success!!");
		System.out.println(getClass().getName() + ".logonAction() end.");
		return modelAndView;
	}
	
}
