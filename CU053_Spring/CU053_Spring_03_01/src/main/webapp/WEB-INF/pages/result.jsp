<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spring MVC - Usuarios</title>
</head>
<body>

	<h2>Spring MVC - Usuarios</h2>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Password</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td><c:out value="${usuario.id}" />
					<td><c:out value="${usuario.nombre}" />
					<td><c:out value="${usuario.password}" />
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<a href="/CU053_Spring_03_01/usuario">Nuevo usuario</a>

</body>
</html>