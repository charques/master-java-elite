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
	<logic:present header="accept-encoding">
		<bean:header id="acceptEncodingValue" name="accept-encoding"/>
		<b>El valor del campo ACCEPT-ENCODING es: </b><bean:write name="acceptEncodingValue"/>
	</logic:present>
	<logic:notPresent header="accept-encoding">
		<b>El valor del campo ACCEPT-ENCODING no existe. </b>
	</logic:notPresent>
	<br />
	<br />
	<logic:present header="accept">
		<bean:header id="acceptValue" name="accept"/>
		<b>El valor del campo ACCEPT es: </b><bean:write name="acceptValue"/>
	</logic:present>
	<logic:notPresent header="accept">
		<b>El valor del campo ACCEPT no existe. </b>
	</logic:notPresent>
	<br />
	<br />
	<logic:present header="authorization">
		<bean:header id="authorizationValue" name="authorization"/>
		<b>El valor del campo AUTHORIZATION es: </b><bean:write name="authorizationValue"/>
	</logic:present>
	<logic:notPresent header="authorization">
		<b>El valor del campo AUTHORIZATION no existe. </b>
	</logic:notPresent>
</body>
</html>