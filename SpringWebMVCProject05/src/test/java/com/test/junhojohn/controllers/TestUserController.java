package com.test.junhojohn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.junhojohn.consts.Const;
import com.test.junhojohn.consts.REQ_ACTION_PAGES_ENUM_TEST;

@Controller
public class TestUserController {

	public TestUserController() {
		System.out.println(getClass().getName() + "() Constructor.");
	}
	
	@RequestMapping("logon.do")
	public ModelAndView logon() {
		System.out.println(getClass().getName() + ".logon() start.");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_TEST.REQ_LOGON.getJspPathURI());
		modelAndView.addObject("message", "LOGON.DO CALLED.");
		
		System.out.println(getClass().getName() + ".logon() end.");
		return modelAndView;
	}
	
	@RequestMapping(value="logonAction.do", method=RequestMethod.GET)
	public ModelAndView logonAction(@RequestParam(value=Const.REQ_PARAM_KEY_USER_ID, required=true) String id,
			@RequestParam(value=Const.REQ_PARAM_KEY_USER_PWD, required=false) String pwd) {
		System.out.println(getClass().getName() + ".logonAction() start.");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_TEST.REQ_LOGON_ACTION.getJspPathURI());
		modelAndView.addObject("message", "LOGON ACTION CALLED.");
		
		System.out.println(getClass().getName() + ".logonAction() end.");
		return modelAndView;
	}

	@RequestMapping("logout.do")
	public ModelAndView logout() {
		System.out.println(getClass().getName() + ".logout() start.");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_TEST.REQ_LOGOUT.getJspPathURI());
		modelAndView.addObject("message", "LOGOUT CALLED.");

		System.out.println(getClass().getName() + ".logout() end.");
		return modelAndView;
	}
	
	@RequestMapping("home.do")
	public ModelAndView home() {
		System.out.println(getClass().getName() + ".home() start.");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_TEST.REQ_HOME.getJspPathURI());
		modelAndView.addObject("message", "HOME CALLED.");
		
		System.out.println(getClass().getName() + ".home() end.");
		return modelAndView;
	}
}
