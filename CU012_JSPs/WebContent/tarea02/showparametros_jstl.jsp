<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="java.util.Map"%>
<%@ page import ="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show parámetros JSTL</title>
</head>
<body>
	<h4>Show parámetros JSTL</h4>
	
	<c:forEach var="pageParameter" items="${param}">
       <c:out value="${pageParameter.key}" /> = <c:out value="${pageParameter.value}" /><br/>
	</c:forEach>
	
</body>
</html>
