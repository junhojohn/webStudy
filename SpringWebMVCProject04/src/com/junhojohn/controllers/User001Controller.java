package com.junhojohn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.junhojohn.consts.REQ_ACTION_PAGES_ENUM_001;

//@Controller
public class User001Controller {

	public User001Controller() {
		System.out.println(getClass().getName() + " start.");
	}
	
	@RequestMapping("/logon.do")
	public ModelAndView logon() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_001.REQ_LOGON.getJspPathURI());
		return modelAndView;
	}
	
	@RequestMapping("/logonAction.do")
	public ModelAndView logonAction() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_001.REQ_LOGON_ACTION.getJspPathURI());
		return modelAndView;
	}
	
	@RequestMapping("/home.do")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_001.REQ_HOME.getJspPathURI());
		return modelAndView;
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REQ_ACTION_PAGES_ENUM_001.REQ_LOGOUT.getJspPathURI());
		return modelAndView;
	}
	
}
