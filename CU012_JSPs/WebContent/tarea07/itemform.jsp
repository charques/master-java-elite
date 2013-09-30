<%@page import="edu.masterjava.jsp.tarea07.model.Config"%>
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
	
	<%
		CatalogoItem item = (CatalogoItem) request.getAttribute("item");
		List<Config> tipos = (List<Config>) request.getAttribute("tipos");
		List<Config> soportes = (List<Config>) request.getAttribute("soportes");
	%>
	
	<%
		if(item == null) {
	%>
	<h2>Nuevo Item</h2>
	<form name='input' action='/CU012_JSPs/itemForm' method='get'>
		<input type='hidden' name='action' value='save'>
		Nombre: <input type='text' name='titulo'><br>
		Autor: <input type='text' name='autor'><br>
		Año: <input type='text' name='anio'><br>
		Tipo: <select name='tipo'>
		<%
		for(Config tipo : tipos) {
			out.print("<option value='" + tipo.getId() + "'>" + tipo.getDescripcion() + "</option>");
		}
		 %>
		</select><br>
		Soporte: <select name='soporte'>
		<%
		for(Config soporte : soportes) {
			out.print("<option value='" + soporte.getId() + "'>" + soporte.getDescripcion() + "</option>");
		}
		 %>
		</select><br><br>
		<input type='submit' value='Guardar'>
		<a href='/CU012_JSPs/coleccion'>Cancelar</a>
	</form>
	<%
		}
		else {
	%>
		<h2>Editar Item</h2>
		<form name='input' action='/CU012_JSPs/itemForm' method='get'>
			<input type='hidden' name='action' value='save'>
			<input type='hidden' name='id' value='<% out.print(item.getId()); %>'>
			Nombre: <input type='text' name='titulo' value='<% out.print(item.getTitulo()); %>'><br>
			Autor: <input type='text' name='autor' value='<% out.print(item.getAutor()); %>'><br>
			Año: <input type='text' name='anio' value='<% out.print(item.getAnio()); %>'><br>
			Tipo: <select name='tipo'>
			<%
			String selected = "";
			for(Config tipo : tipos) {
				selected = "";
				if(tipo.getId() == item.getIdTipo()) {
					selected = " selected='selected'";
				}
				out.print("<option" + selected + " value='" + tipo.getId() + "'>" + tipo.getDescripcion() + "</option>");
			}
			 %>
			</select><br>
			Soporte: <select name='soporte'>
			<%
			for(Config soporte : soportes) {
				selected = "";
				if(soporte.getId() == item.getIdSoporte()) {
					selected = " selected='selected'";
				}
				out.print("<option" + selected + " value='" + soporte.getId() + "'>" + soporte.getDescripcion() + "</option>");
			}
			 %>
			</select><br><br>
			<input type='submit' value='Actualizar'>
			<a href='/CU012_JSPs/coleccion'>Cancelar</a>
			</form>
	<%
		}
	%>
</body>
</html>