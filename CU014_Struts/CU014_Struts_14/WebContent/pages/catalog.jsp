<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title><bean:message key="label.catalog" /></title>
</head>
<body>
	<h1>
		<bean:message key="label.catalog" />
	</h1>

	<html:link action="catalogItem.do?option=Nuevo">
		<bean:message key="label.addNewItem" />
	</html:link>

	<br />
	<br />
	<table cellpadding="5" border="1">
		<tr>
			<th><bean:message key="label.name" /></th>
			<th><bean:message key="label.autor" /></th>
			<th><bean:message key="label.pubYear" /></th>
			<th><bean:message key="label.category" /></th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
		</tr>
		
		<logic:iterate id="item" name="catalogForm" property="catalog">
			<tr>
			<html:form method="POST" action="catalogItem.do">
				<input type='hidden' name='itemId' value='<bean:write name="item" property="itemId" />' />
				<td><bean:write name="item" property="itemName" /></td>
				<td><bean:write name="item" property="autorName" /></td>
				<td><bean:write name="item" property="pubYear" /></td>
				<td><bean:write name="item" property="categoryDesc" /></td>
				<td><input type="submit" name="option" value="<bean:message key="opcion.edit" />"></td>
				<td><input type="submit" name="option" value="<bean:message key="opcion.delete" />"></td>
				</html:form>
			</tr>
		</logic:iterate>
	</table>

</body>
</html>