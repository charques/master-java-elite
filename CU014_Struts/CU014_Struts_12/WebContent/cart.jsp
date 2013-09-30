<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Carro</title>
</head>

<body>
	<p>
		<strong>Carro</strong>
	</p>

	<logic:notPresent name="shoppingCart" scope="session">
		<h4>No hay productos en el carro.</h4>
	</logic:notPresent>

	<logic:present name="shoppingCart" scope="session">

		<bean:define id="shoppingCart" name="shoppingCart" scope="session" />
	
		<logic:empty name="shoppingCart" property="items">
			<h4>No hay productos en el carro.</h4>
		</logic:empty>
	
		<logic:notEmpty name="shoppingCart" property="items">
			<table cellpadding="10">
				<tbody>
					<tr>
						<td><b>Nombre</b></td>
						<td><b>Descripción</b></td>
						<td><b>Cantidad</b></td>
						<td><b>Precio unitario</b></td>
						<td><b>Total</b></td>
						<td></td>
					</tr>
	
					<logic:iterate id="item" name="shoppingCart" property="items" indexId="counter">
						<html:form method="POST" action="cart.do">
						<tr>
							<input type='hidden' name='index' value='<bean:write name="counter"/>' />
	
							<td><bean:write name="item" property="id" /></td>
							<td><bean:write name="item" property="description" /></td>
							<td><input type='text' name="quantity"
								value='<bean:write name="item" property="quantity" />' /> <input
								type="submit" name="option" value="update" /></td>
							<td><bean:write name="item" property="unitCost" /></td>
							<td><bean:write name="item" property="totalCost" /></td>
							<td><input type="submit" name="option" value="delete" /></td>
						</tr>
						</html:form>
					</logic:iterate>
					<tr></tr>
					<tr>
						<td><b>Total: </b> <bean:write name="shoppingCart"
								property="cartTotal" /></td>
					</tr>
				</tbody>
			</table>
		</logic:notEmpty>
	
	</logic:present>

	<p>
		<a href="products.jsp">Ir a productos</a>
	</p>


</body>
</html>