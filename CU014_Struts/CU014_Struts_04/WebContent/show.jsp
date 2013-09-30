<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>Show</title>
</head>
<body>
	
    Nombre:
    <bean:write name="pSession" property="nombre" scope="session" />
    <br />
    Edad:
    <bean:write name="pSession" property="edad" scope="session" />
</body>
</html>