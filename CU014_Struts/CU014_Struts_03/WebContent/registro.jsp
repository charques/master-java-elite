<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
<title>Registro</title>
</head>
<body>
	<html:errors />
	<html:javascript formName="RegistroForm" />

    <html:form action="/registrar" >
        <bean:message key="label.usuario" />
        <html:text name="RegistroForm" property="usuario" />
        <br />
        <bean:message key="label.password" />
        <html:password name="RegistroForm" property="password" />
        <br />
        <bean:message key="label.telefono" />
        <html:text name="RegistroForm" property="telefono" />
        <br />
        <html:submit value="Registrar" />
    </html:form>
</body>
</html>