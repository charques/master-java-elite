<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SetNumberSession JSP</title>
</head>
<body>
	<h4>SetNumberSession JSP</h4>
	<%
		try {
			// Procesa la entrada
			String numeroStr = request.getParameter("num");
			int numero = Integer.valueOf(numeroStr);
			
			// Guarda número en la sesión
			HttpSession sesion = request.getSession();
			sesion.setAttribute("sNumber", numero);
			
			out.println("<h4>Se ha almacenado el valor " + numero + " en la sesión.</h4>");
		}
		catch(NumberFormatException e) {
			out.println("<h4>Error: No se ha especificado el número.</h4>");
		}
	%>
</body>
</html>