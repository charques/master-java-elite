<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>
	<fmt:message key="login.title" />
</h1>

<div class="section">
	<table class="login">
		<tr>
			<th><fmt:message key="login.username" /></th>
			<th><fmt:message key="login.password" /></th>
			<th><fmt:message key="login.role" /></th>
		</tr>
		<tr>
			<td>admin</td>
			<td>admin</td>
			<td>ROLE_USER, ROLE_ADMIN</td>
		</tr>
		<tr>
			<td>user</td>
			<td>user</td>
			<td>ROLE_USER</td>
		</tr>
	</table>
</div>

<div class="messages">
	<c:if test="${not empty param.login_error}">
		<div class="errorblock">
			<fmt:message key="login.msg.failure" />
			<br />
			<br />
			<fmt:message key="login.failure.reason" />
			: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
</div>

<div class="section">
	<form name="f" action="<c:url value="/loginProcess" />" method="post">
		<fieldset>
			<div class="field">
				<div class="label">
					<label for="j_username"><fmt:message key="login.username" />:</label>
				</div>
				<div class="output">
					<input type="text" name="j_username" id="j_username"
						value="${SPRING_SECURITY_LAST_USERNAME}" />
				</div>
			</div>
			<div class="field">
				<div class="label">
					<label for="j_password"><fmt:message key="login.password" />:</label>
				</div>
				<div class="output">
					<input type="password" name="j_password" id="j_password" />
				</div>
			</div>
			<div class="field">
				<div class="label">
					<label for="remember_me"><fmt:message
							key="login.rememberMe" />:</label>
				</div>
				<div class="output">
					<input type="checkbox" name="_spring_security_remember_me"
						id="remember_me" />
				</div>
			</div>
			<br />
			<div class="form-buttons">
				<div class="button">
					<input name="submit" id="submit" type="submit"
						value="<fmt:message key="button.login"/>" />
				</div>
			</div>
		</fieldset>
	</form>
</div>
