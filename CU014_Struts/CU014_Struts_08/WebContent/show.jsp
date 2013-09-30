<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>Show</title>
</head>
<body>
	Checkbox:
	<bean:write name="InputForm" property="checkbox" />
	<br />
    File:
    <bean:write name="InputForm" property="file" />
	<br />
    Hidden:
    <bean:write name="InputForm" property="hidden"  />
	<br />
    Multibox:
    <logic:iterate id="iterator" name="InputForm" property="multiboxItems">
    	<bean:write name="iterator"/>
  	</logic:iterate>
	<br />
    Pasword:
    <bean:write name="InputForm" property="password" />
	<br />
    Radio:
    <bean:write name="InputForm" property="radio" />
	<br />
    Select:
    <bean:write name="InputForm" property="select" />
	<br />
    Text:
    <bean:write name="InputForm" property="text" />
	<br />
    TextArea:
    <bean:write name="InputForm" property="textarea" />
</body>
</html>