<%@page import="edu.masterjava.jsp.tarea07.model.CatalogoItem"%>
<%@ page language="java" import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Colección</title>
</head>
<body>
	<h2>Colección</h2>
	<hr>
	<a href='/CU012_JSPs/itemForm?action=new'>Añadir item</a>
	<hr>
	
	<%
		List<CatalogoItem> coleccion = (List<CatalogoItem>) request.getAttribute("coleccion");
	
		if (coleccion.size() == 0) {
	%>
	<h4>No hay elementos en el catálogo.</h4>
	<%
		} else {
	%>
	
	<table cellpadding='10'>
  		<tbody>
  		<tr>
			<td><b>Titulo</b></td>
			<td><b>Autor</b></td>
			<td><b>Tipo</b></td>
			<td><b>Soporte</b></td>
			<td><b>Año</b></td>
			<td></td>
			<td></td>
		</tr>
	  <%
	  for(CatalogoItem item : coleccion) {
			out.print("<tr>");
			out.println("<td>" + item.getTitulo() + "</td>");
			out.println("<td>" + item.getAutor() + "</td>");
			out.println("<td>" + item.getDescripTipo() + "</td>");
			out.println("<td>" + item.getDescripSoporte() + "</td>");
			out.println("<td>" + item.getAnio() + "</td>");
			out.println("<td><a href='/CU012_JSPs/itemForm?action=edit&id=" + item.getId() +"'>Editar</a></td>");
			out.println("<td><a href='/CU012_JSPs/itemForm?action=delete&id=" + item.getId() +"'>Eliminar</a></td>");
			out.print("</tr>");
		}
		out.print("<tr><td></td></tr>");
	  %>
  		</tbody>
  	</table>
  	<%
		}
	%>
  	<hr>
	<a href='/CU012_JSPs/itemForm?action=new'>Añadir item</a>
	<hr>
</body>
</html>