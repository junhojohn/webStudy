<%@ page contentType="text/html; charset=EUC-KR"%>

<%
	Integer count = (Integer)request.getAttribute("count");

	if(count == null){
		out.println("This is the first visit.");
		request.setAttribute("count", count);
	}else{
		int changeCount = count.intValue() + 1;
		out.println("This is the " + changeCount + " times visit.");
		request.setAttribute("count", new Integer(changeCount));
	}
%>