<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show parámetros</title>
</head>
<body>
	<h4>Show parámetros</h4>

	<c:set var="pageParameters" value="${param}" />

	<logic:notEmpty name="pageParameters">
		<logic:iterate id="item" name="pageParameters">
			<bean:write name="item" property="key" />: <bean:write name="item" property="value" />
			<br />
		</logic:iterate>
	</logic:notEmpty>
	
	<logic:empty name="pageParameters">
		No hay parámetros.
	</logic:empty>
</body>
</html>
