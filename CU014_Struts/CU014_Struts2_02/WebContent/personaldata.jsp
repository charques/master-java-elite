<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Datos personales</title>
</head>

<body>
	<h2>Datos personales</h2>

	<s:form action="personaldata.action" method="post" validate="true">
		<s:textfield name="name" key="name" size="20" />
		<s:textfield name="surname" key="surname" size="20" />
		<s:textfield name="numChilds" key="numChilds" size="20" />
		<s:textfield name="birthday" key="birthday" format="dd/MM/yyyy" />
		<s:textfield name="salary" key="salary" size="20" />
		<s:textfield name="email" key="email" size="20" />
		<s:textfield name="telephone" key="telephone" size="20" />
		<s:submit method="addPersonalData" key="label.add.personalData"
			align="center" />
	</s:form>
</body>
</html>
