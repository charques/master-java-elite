<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags"  prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show</title>
</head>
<body>
Usuario: <s:property value="usuario" /><br>
Sexo: <s:property value="sex" /><br>
Provincia: <s:property value="provincia" /><br>
Comentarios: <s:property value="comentarios" /><br>
Multi opción: <s:property value="multi" /><br>
Opción simple: <s:property value="opcionSimple" />
</body>
</html>