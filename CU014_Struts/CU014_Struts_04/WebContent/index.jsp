<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>Inicio</title>
</head>
<body>
	<html:form action="/inputAction">
        Nombre:
        <html:text name="Persona" property="nombre" />
		<br />
        Edad:
        <html:text name="Persona" property="edad" />
		<br />
		<html:submit value="Enviar" />
	</html:form>
</body>
</html>