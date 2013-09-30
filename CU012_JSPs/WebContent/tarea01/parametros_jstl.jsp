<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parámetros JSTL</title>
</head>
<body>
	<h4>Parámetros JSTL</h4>
	<form method="post" action="parametros_jstl.jsp">
		<table>
		<tr><td>Nombre:</td><td><input type="text" size="20" name="nombre"/></td></tr>
		<tr><td>Email:</td><td><input type="text" size="20" name="email"/><br></td></tr>
		</table>
		<br/>
		<input type="submit" value="Enviar">
	</form>
	<c:if test="${!empty param.nombre}">
	<p>
		Nombre: ${param.nombre}<br/>
		Email: ${param.email}
	</p>
	</c:if>
</body>
</html>
