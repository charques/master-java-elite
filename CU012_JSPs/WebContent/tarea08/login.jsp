<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	
	<form name='input' action='/CU012_JSPs/login?action=dologin' method='post'>
		<table>
			<tr>
				<td>Usuario</td>
				<td><input type='text' name='username'></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name='password'></td>
			</tr>
			<c:if test="${error != null}">
				<tr>
					<td colspan="2"><font size="3" color="red"><c:out value="${error}"/></font></td>
				</tr>
			</c:if>
			<tr>
				<td></td>
				<td><input type='submit' value='Login'></td>
			</tr>
			
		</table>
	</form>
</body>
</html>