<%@page import="edu.masterjava.jsp.tarea07.model.CatalogoItem"%>
<%@ page language="java" import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catálogo</title>
</head>
<body>

	<%
		String itemId = (String) request.getAttribute("itemId");
		out.println("<p>El item " + itemId + " se ha eliminado satisfactoriamente.</p>");
	%>
	
	<a href='/CU012_JSPs/coleccion'>Volver al catálogo</a>
</body>
</html>