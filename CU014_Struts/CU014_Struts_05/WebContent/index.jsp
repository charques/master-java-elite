<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>Inicio</title>
</head>
<body>
	<logic:present header="User-Agent">
		<bean:header id="browsertype" name="User-Agent"/>
		<b>El navegador es: </b><bean:write name="browsertype"/>
	</logic:present>
</body>
</html>