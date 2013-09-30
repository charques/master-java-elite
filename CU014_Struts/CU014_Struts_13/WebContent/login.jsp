<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<html:errors />
	<html:javascript formName="LoginForm" />

	<html:form action="/login">
	
		<!--<html:messages id="msg" message="true">
			<li><bean:write name="msg" /></li>
		</html:messages>-->
	
		<bean:message key="label.usuario" />
		<html:text name="LoginForm" property="username" />
		<br />
		<bean:message key="label.password" />
		<html:password name="LoginForm" property="password" />
		<br />
		<html:submit value="Login" />
	</html:form>
</body>
</html>