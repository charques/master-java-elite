<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SetNumberSession JSTL</title>
</head>
<body>
	<h4>SetNumberSession JSTL</h4>
	
	<c:choose>
		<c:when test="${empty param.num}">
			<h4><c:out value="Error: No se ha especificado el número." /></h4>
		</c:when>
		<c:otherwise>
			<c:set var="sNumber" value="${param.num}" scope="session" />
			<h4><c:out value="Se ha almacenado el valor ${param.num} en la sesión." /></h4>
		</c:otherwise>
	</c:choose>
	
</body>
</html>