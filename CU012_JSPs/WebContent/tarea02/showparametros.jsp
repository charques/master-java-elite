<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.Map"%>
<%@ page import ="java.util.Map.Entry"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show parámetros JSP</title>
</head>
<body>
	<h4>Show parámetros JSP</h4>
	<%
		Map<String, String[]> mapa = request.getParameterMap();
	
		// recorre el mapa de parametros
		for (Entry<String, String[]> entry : mapa.entrySet()) {
			String[] values = entry.getValue();
			for (int i = 0; i < values.length; i++) {
				out.println(entry.getKey() + " = " + entry.getValue()[i] + "<br/>" );
			}
		}
		
		if(mapa.isEmpty()) {
			out.println("<br> No hay parámetros.");
		}
	%>
</body>
</html>