<%@ page contentType="text/html; charset=utf-8"%>
<%
	Cookie cookie = new Cookie("key1","value1");
	cookie.setPath(request.getContextPath());// /week3_03
	cookie.setMaxAge(60*60*24*7); // 7days -7일 후 쿠키 삭제
 	response.addCookie(cookie);
%>