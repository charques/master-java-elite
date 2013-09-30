<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tablas JSP</title>
</head>
<body>
	<h4>Tablas JSP</h4>
	<%
		try {
			// Procesa la entrada
			String numeroStr = request.getParameter("num");
			int numero = Integer.valueOf(numeroStr);
			
			// Comprueba si el numero está entre 1 y 10
			if(numero>=1 && numero<=10) {
				out.println("<h4>La tabla del " + numero + "</h4>");
				int calc = 0;
				for(int i = 1; i <= 10; i++) {
					calc = i*numero;
					out.println(numero + "x" + i + " = " + calc + "<br>");
				}
			}
			else {
				out.println("<h4>Error: El número debe estar entre 1 y 10.</h4>");
			}
		}
		catch(NumberFormatException e) {
			out.println("<h4>Error: No se ha especificado el número.</h4>");
		}
	%>
</body>
</html>