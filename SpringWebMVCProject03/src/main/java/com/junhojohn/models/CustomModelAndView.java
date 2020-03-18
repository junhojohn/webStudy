package com.junhojohn.models;

public class CustomModelAndView {

	private String viewName;
	private String targetObjectName;
	private Object targetObject;
	
	public CustomModelAndView() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomModelAndView(String viewName) {
		this.viewName = viewName;
	}
	
	public CustomModelAndView(String viewName, String targetObjectName, Object targetObject) {
		this.viewName = viewName;
		this.targetObjectName = this.targetObjectName;
		this.targetObject = targetObject;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getTargetObjectName() {
		return targetObjectName;
	}

	public void setTargetObjectName(String targetObjectName) {
		this.targetObjectName = targetObjectName;
	}

	public Object getTargetObject() {
		return targetObject;
	}

	public void setTargetObject(Object targetObject) {
		this.targetObject = targetObject;
	}

	@Override
	public String toString() {
		return "CustomModelAndView [viewName=" + viewName + ", targetObjectName=" + targetObjectName + ", targetObject="
				+ targetObject + "]";
	}
	
}
