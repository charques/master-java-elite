<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>Ejecutar sentencia SQL</title>
</head>
<body>
	<html:errors />
	<html:javascript formName="SqlStatementForm" />

	<html:form action="/sqlstatement">

		<h3><bean:message key="label.sentencia" /></h3>
		<html:textarea name="SqlStatementForm" property="query" rows="6" cols="50"/>
		<br />
		<html:submit value="Ejecutar" />
	</html:form>
	
	<logic:notEmpty name="SqlStatementForm" property="sqlError">
		<h3>Error SQL:</h3>
		<bean:write name="SqlStatementForm" property="sqlError"/>
		<br />	
	</logic:notEmpty>

	<logic:notEmpty name="SqlStatementForm" property="results">
		<h3>Resultados:</h3>
		<table border="1">
		<logic:iterate id="fila" name="SqlStatementForm" property="results" >
			<tr>
			<logic:iterate id="item" name="fila" property="value" >
				<td><bean:write name="item"/></td>
			</logic:iterate>
			</tr>
		</logic:iterate>
		</table>
	</logic:notEmpty>
	<br />
	<html:link page="/index.jsp">Volver</html:link>
</body>
</html>