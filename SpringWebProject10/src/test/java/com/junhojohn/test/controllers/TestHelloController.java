package com.junhojohn.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestHelloController {
	
	private String viewName = "/test/testHello.jsp";
	
	@RequestMapping("/testHello01.do")
	public ModelAndView testHello01() {
		return new ModelAndView(viewName);
	}
	
	@RequestMapping("/testHello02.do")
	public String testHello02() {
		return viewName;
	}
	
	@RequestMapping("/testHello03.do")
	public String testHello03(@RequestParam("abc") int no, @RequestParam("def") String name) {
		System.out.println("no: " + no);
		System.out.println("name: " + name);
		return viewName;
	}
	
	@RequestMapping("/testHello04.do")
	public String testHello04(@RequestParam(value="abc") int no, @RequestParam(value="def", required=false) String name) {
		System.out.println("no: " + no);
		System.out.println("name: " + name);
		return viewName;
	}
	
	@RequestMapping("/testHello05.do")
	public String testHello05(@RequestParam(value="abc", defaultValue="1") int no, @RequestParam(value="def", required=false) String name) {
		System.out.println("no: " + no);
		System.out.println("name: " + name);
		return viewName;
	}
}
