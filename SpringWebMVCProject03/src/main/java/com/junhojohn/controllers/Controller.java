package com.junhojohn.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junhojohn.models.CustomModelAndView;

public interface Controller {

	public CustomModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
