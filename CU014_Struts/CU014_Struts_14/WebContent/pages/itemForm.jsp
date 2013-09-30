<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title><bean:message key="label.item" /></title>
</head>
<body>
	<h1>
		<bean:message key="label.item" />
	</h1>
	<html:form action="/catalogItem">
		<html:hidden name="catalogItemForm" property="itemId"/>
		<html:hidden name="catalogItemForm" property="insertOrUpdate"/>
		<table>
			<tr>
				<td><bean:message key="label.name" />:</td>
				<td><html:text name="catalogItemForm" property="itemName"
						size="40" /></td>
			</tr>
			<tr>
				<td><bean:message key="label.autor" />:</td>
				<td><html:text name="catalogItemForm" property="autorName"
						size="40" /></td>
			</tr>
			<tr>
				<td><bean:message key="label.pubYear" />:</td>
				<td><html:text name="catalogItemForm" property="pubYear"
						size="20" /></td>
			</tr>
			<tr>
				<td><bean:message key="label.category" />:</td>
				<td><html:select name="catalogItemForm" property="categoryId">
						<html:optionsCollection name="catalogItemForm"
							property="categories" label="categoryName" value="categoryId" />
					</html:select></td>
			</tr>
			<tr>
				<td colspan="2"><br /> 
				<input type="submit" name="option" value="<bean:message key="opcion.save"/>" /> 
				&nbsp;&nbsp;&nbsp; 
				<input type="submit" name="option" value="<bean:message key="opcion.cancel"/>" />
				</td>
			</tr>
		</table>
	</html:form>

</body>
</html>