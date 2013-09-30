<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,edu.masterjava.ejb.tarea06.edu.masterjava.ejb.tarea06.Libro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EJBs - Tarea04</title>
</head>
<body>
	<form method="POST" action="usuario">
            Nombre: <input type="text" name="nombre" />
            Password: <input type="text" name="password" />
            <input type="submit" value="Añadir" />
        </form>
 
        <hr><ol> <%
 	@SuppressWarnings("unchecked") 
             List<Libro> usuarios = (List<Libro>)request.getAttribute("usuarios");
             if (usuarios != null) {
                 for (Libro usuario : usuarios) {
 %>
                    <li> <%= usuario %> </li> <%
                }
            } %>
        </ol><hr>
</body>
</html>