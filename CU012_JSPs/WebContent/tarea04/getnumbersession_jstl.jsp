<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GetNumberSession JSTL</title>
</head>
<body>
	<h4>GetNumberSession JSTL</h4>
	
	<c:choose>
		<c:when test="${empty sessionScope.sNumber}">
			<h4><c:out value="Error: El número no está almacena en sesión." /></h4>
		</c:when>
		<c:otherwise>
			<h4><c:out value="Se ha recuperado el valor  ${sessionScope.sNumber}  de la sesión." /></h4>
		</c:otherwise>
	</c:choose>
	
</body>
</html>