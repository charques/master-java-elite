<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
<title>Struts Tarea02</title>
</head>
<body>
	<html:link action="/toIngles">
		<bean:message key="label.english" />
	</html:link>
	<html:link action="/toEspanol">
		<bean:message key="label.spanish" />
	</html:link>

</body>
</html>