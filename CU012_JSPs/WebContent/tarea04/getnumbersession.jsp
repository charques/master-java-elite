<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GetNumberSession JSP</title>
</head>
<body>
	<h4>GetNumberSession JSP</h4>
	<%
		try {
			// Recupera el número de la sesión
			HttpSession sesion = request.getSession();
			int numero = (Integer) sesion.getAttribute("sNumber");
			
			out.println("<h4>Se ha recuperado el valor " + numero + " de la sesión.</h4>");
		}
		catch(NullPointerException e) {
			out.println("<h4>Error: El número no está almacena en sesión.</h4>");
		}
	%>
</body>
</html>