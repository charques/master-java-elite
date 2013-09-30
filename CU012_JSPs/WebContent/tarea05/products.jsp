<%@page import="edu.masterjava.jsp.tarea05_06.model.Product"%>
<%@ page language="java" import="java.util.Collection" %>
<%@ page language="java" import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Productos</title>
</head>
<body>
	<h2>FotoTienda</h2>
	<table cellpadding="2" width="100%">
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
	  <%
	  	Collection collection = (Collection)request.getAttribute("productos");
	  	
	  	for (Iterator iter = collection.iterator(); iter.hasNext();) {
	  		Product element = (Product) iter.next();
			out.println("<tr>");
			out.println("<td>" + element.getNombre() + "</td>");
			out.println("<td>" + element.getDescripcion() + "</td>");
			out.println("<td>" + element.getPrecio() + "€</td>");
			out.println("<td widht='200'><a href='/CU012_JSPs/cartStatic?add=" + element.getId() + "'>Añadir al carro</a></td>");
			out.println("</tr>");
	  	}
	  %>
  		</tbody>
  	</table>
  	<br>
  	<a href='/CU012_JSPs/cartStatic'>Ir al carro</a>
</body>
</html>