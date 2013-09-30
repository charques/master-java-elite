<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tablas JSTL</title>
</head>
<body>
	<h4>Tablas JSTL</h4>
	
	<c:choose>
		<c:when test="${empty param.num}">
			<h4><c:out value="Error: No se ha especificado el número." /></h4>
		</c:when>
		
		<c:when test="${param.num>=1 && param.num<=10}">
			<c:forEach var="i" begin="1" end="10" step="1" varStatus ="status">
				<c:set var="calc" value="${param.num * i}"/>
				<c:out value="${param.num} x ${i} = ${calc}" />
				<br/>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h4><c:out value="Error: El número debe estar entre 1 y 10." /></h4>
		</c:otherwise>
	</c:choose>
</body>
</html>