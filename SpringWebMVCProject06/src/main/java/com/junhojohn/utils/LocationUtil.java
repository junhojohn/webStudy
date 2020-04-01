package com.junhojohn.utils;

public class LocationUtil {

	private LocationUtil() {
		
	}
	
	public static String getActionPage(String requestURI) {
		if(requestURI == null || requestURI.isEmpty()) {
			return null;
		}
		
		int startIdx = requestURI.lastIndexOf("/") + 1;
		int endIdx = requestURI.lastIndexOf(".do");
		return requestURI.substring(startIdx, endIdx);
	}
}
