<%@ page contentType="text/html; charset=utf-8"%>
<%
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie:cookies){
		String name = cookie.getName();
		String value = cookie.getValue();
		out.print("name="+name+ "<br>");
		out.print("value="+value+"<br>");
	}
%>