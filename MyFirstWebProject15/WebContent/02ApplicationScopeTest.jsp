<%@ page contentType="text/html; charset=EUC-KR"%>

<%
	Integer count = (Integer)application.getAttribute("count");
	
	if(count == null){
		out.println("This is the first vist.");
		application.setAttribute("count", new Integer(1));
	}else{
		int changeCount = count.intValue() + 1;
		out.println("This is the " + changeCount + " times visit.");
		application.setAttribute("count", new Integer(changeCount));
	}
%>