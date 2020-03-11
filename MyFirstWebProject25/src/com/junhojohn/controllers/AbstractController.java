package com.junhojohn.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller를 추상화한 클래스
 * @param HttpServletRequest 객체
 * @param HttpServletResponse 객체
 * @throws ServletException
 * @throws IOException
 */
public abstract class AbstractController {

	/**
	 * Controller를 추상화한 클래스
	 * @param HttpServletRequest 객체
	 * @param HttpServletResponse 객체
	 * @throws ServletException
	 * @throws IOException
	 */
	public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
