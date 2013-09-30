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
	<h3>Tablas:</h3>
	<logic:iterate id="tabla" name="TablesForm" property="tablas">
		<html:link page="/detail.do" paramId="tableName" paramName="tabla">
			<bean:write name="tabla" />
		</html:link>
		,&nbsp 
	</logic:iterate>


	<logic:notEmpty name="TablesForm" property="descTabla">
		<h3>Descripción <bean:write name="TablesForm" property="nombreTabla" />:</h3>
		<logic:iterate id="descripcion" name="TablesForm" property="descTabla">
			<bean:write name="descripcion" />
			<br />
		</logic:iterate>
	</logic:notEmpty>

	<br />
	<br />
	<html:link page="/index.jsp">Volver</html:link>
</body>
</html>