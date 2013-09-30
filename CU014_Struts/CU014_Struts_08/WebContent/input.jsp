<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>Inicio</title>
</head>
<body>
	<html:form action="/inputAction">
        Checkbox:
        <html:checkbox name="InputForm" property="checkbox" />
		<br />
        File:
        <html:file name="InputForm" property="file" />
		<br />
        Hidden:
        <html:hidden name="InputForm" property="hidden" value="valorHidden" />
		<br />
        Multibox:
        <html:multibox name="InputForm" property="multiboxItems" value="1" /> Opción 1
		<html:multibox name="InputForm" property="multiboxItems" value="2" /> Opción 2
		<br />
        Pasword:
        <html:password name="InputForm" property="password" />
		<br />
        Radio:
        <html:radio name="InputForm" property="radio" value="valor1" />
        <html:radio name="InputForm" property="radio" value="valor2" />
		<br />
        Select:
        <html:select property="select">
			<html:option value="0">Seleccione...</html:option>
			<html:optionsCollection name="InputForm" property="selectList"
				label="desc" value="id" />
		</html:select>
		<br />
        Text:
        <html:text name="InputForm" property="text" />
		<br />
        TextArea:
        <html:textarea name="InputForm" property="textarea" />
		<br />
		<html:submit property="method" value="enviar" />
	</html:form>
</body>
</html>