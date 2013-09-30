<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input</title>
</head>
<body>
	<s:form action="Input">
		<s:textfield name="usuario" label="Usuario" />
		<s:password name="password" label="Password" />
		<s:radio name="sex" label="Sexo" list="{'Hombre','Mujer'}" />
		<s:select name="provincia" list="listaProvincias" listKey="id"
			listValue="desc" headerKey="0" headerValue="Provincia"
			label="Selecciona una provincia" />
		<s:textarea name="comentarios" label="Comentarios" />
		<s:checkboxlist list="multiList" name="multi"
			label="Opciones" />
		<s:checkbox name="opcionSimple"
			label="¿Desea seleccionar esta opción?" />
		<s:submit />
	</s:form>
</body>
</html>