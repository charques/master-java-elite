<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>Productos</title>
</head>
<body>
	<h2>Productos</h2>
	
	<p />
	&nbsp;&nbsp;&nbsp;
	<table cellpadding="2" width="50%">
	    <col width="20%">
	    <col width="60%">
	    <col width="10%">
	    <col width="10%">
  		<tbody>
  		<tr>
			<td><b>Nombre</b></td>
			<td><b>Descripción</b></td>
			<td><b>Precio</b></td>
			<td>&nbsp;</td>
		</tr>
		
		<logic:iterate id="product" name="ProductsForm" property="products">
			<tr>
				<form name="modelDetail1" method="POST" action="cart.do">
					<input type="hidden" name="id" value="<bean:write name="product" property="id" />">
					<input type="hidden" name="description" value="<bean:write name="product" property="description" />">
					<input type="hidden" name="cost" value="<bean:write name="product" property="unitCost" format="###.##"/>">
					<input type="hidden" name="option" value="add">
				<td><bean:write name="product" property="id" /></td>
				<td><bean:write name="product" property="description" /></td>
				<td><bean:write name="product" property="unitCost" format="#,##0.00 €"/></td>
				<td><input type="submit" name="addToCart" value="Add To Cart"></td>
				</form>
			</tr>
		</logic:iterate>
	</table>
	
	<p>&nbsp;</p>
	<a href="cart.jsp">Ir al carro</a>
</body>
</html>