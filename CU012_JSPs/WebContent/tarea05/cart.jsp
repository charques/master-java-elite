<%@page import="edu.masterjava.jsp.tarea05_06.model.Product"%>
<%@ page language="java" import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Productos</title>
</head>
<body>
	<h2>Carro FotoTienda</h2>

	<%
		Map<String, Product> carroSesion = (Map<String, Product>) request
				.getAttribute("cart");
	
		if (carroSesion.size() == 0) {
	%>
	<h4>No hay productos en el carro.</h4>
	<%
		} else {
	%>
	<table cellpadding="10">
		<tbody>
			<tr>
				<td><b>Nombre</b></td>
				<td><b>Descripción</b></td>
				<td><b>Unidades</b></td>
				<td><b>Total</b></td>
			</tr>
			<%
				float totalCarro = 0;
					float totalProducto = 0;
					Product productoCarro = null;
					for (Map.Entry<String, Product> entry : carroSesion.entrySet())
					{
						out.print("<tr>");
						productoCarro = entry.getValue();
						totalProducto = productoCarro.getPrecio()
								* productoCarro.getUnidadesCarro();
						totalCarro += totalProducto;
						out.println("<td>" + productoCarro.getNombre() + "</td>");
						out.println("<td>" + productoCarro.getPrecio() + " €</td>");
						out.println("<td>" + productoCarro.getUnidadesCarro()
								+ "</td>");
						out.println("<td>" + totalProducto + " €</td>");
						out.print("</tr>");
					}
					out.print("<tr><td></td></tr>");
					out.print("<tr><td><b>Total: " + totalCarro
							+ " €</b></td></tr>");
			%>
		</tbody>
	</table>
	<%
		}
	%>
	<br>
	<a href='/CU012_JSPs/productsStatic'>Ver productos</a>
</body>
</html>