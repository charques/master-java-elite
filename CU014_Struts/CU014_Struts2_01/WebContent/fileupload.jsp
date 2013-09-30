<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FileUpload</title>
</head>
<body>
	<h2>FileUpload</h2>
	<s:form action="uploadFile" enctype="multipart/form-data" method="post">
		<s:file name="file" label="Seleccione un fichero" size="30" />
		<br />
		<br />
		<s:submit value="upload" />
	</s:form>
</body>
</html>