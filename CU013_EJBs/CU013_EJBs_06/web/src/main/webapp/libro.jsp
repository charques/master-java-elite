<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,edu.masterjava.ejb.tarea06.entity.Libro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EJBs - Tarea06</title>
</head>
<body>
	<form method="POST" action="libro">
		Titulo: <input type="text" name="titulo" /> 
		Autor: <input type="text"	name="autor" /> <input type="submit" value="Añadir" />
	</form>

	<hr>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Libro> libros = (List<Libro>) request.getAttribute("libros");
			if (libros != null) {
				for (Libro libro : libros) {
				%>
				<li><%=libro%></li>
				<%
			}
			}
		%>
	</ol>
	<hr>
</body>
</html>