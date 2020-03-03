<%@ page contentType="text/html;charset=EUC_KR" %>

<%
	//==> Implicit Object: request,session,out,application
	//==> able to use them in scriptlet,expression tag.

	//1. get "name = count" in session object.
	Integer count = (Integer)session.getAttribute("count");

	//2. If not exists,
	//==> set attribute to  name = "count", value=new Integer(1).
	if(count == null){
		out.println("This is the first visit.");
		session.setAttribute("count",new Integer(1));
	}
	
	//3. If exists,
	//==> print get data from session object.
	//==> set attribute to name = "count", value = count++..
	else{
		int changeCount = count.intValue()+1;
		out.println("This is " + changeCount+ " times visit.");
		session.setAttribute("count",new Integer(changeCount) );
	}
%>