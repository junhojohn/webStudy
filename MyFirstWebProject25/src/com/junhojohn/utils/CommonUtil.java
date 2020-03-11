package com.junhojohn.utils;

/**
 * 공통 유틸 클래스
 * @author junhojohn
 *
 */
public class CommonUtil {

	/**
	 * 공통 유틸 클래스
	 * new instance 생성 불가한 유틸 성격의 클래스
	 * @author junhojohn
	 *
	 */
	private CommonUtil() {
		
	}
	
	/**
	 * 주어진 requestURI로 요청한 actionPage URI를 얻는다. 
	 * @param requestURI
	 * @return
	 */
	public static String getActionPageURI(String requestURI) {
		
		// defence logic
		if(requestURI == null) {
			return null;
		}

		// Field
		int end				= -1;
		int start 			= -1;
		String actionPage 	= null;
		
		// Get action page
		start 		= requestURI.lastIndexOf("/")+1;
		end			= requestURI.lastIndexOf(".do");
		actionPage 	= requestURI.substring(start, end);
		
		return actionPage;
		
	}
}
