<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<h1>
	<fmt:message key="recipe.title" />
</h1>

<div class="messages">
	<c:if test="${feedbackMessage != null}">
		<div class="messageblock">
			<c:out value="${feedbackMessage}" />
		</div>
	</c:if>
	<c:if test="${errorMessage != null}">
		<div class="errorblock">
			<c:out value="${errorMessage}" />
		</div>
	</c:if>
</div>

<div id="inner-content">
	<c:choose>
		<c:when test="${fn:length(recipes) > 0}">
			<table>
				<thead>
					<tr>
						<th><fmt:message key="recipe.form.description" /></th>
						<th><fmt:message key="recipe.form.comment" /></th>
						<th><fmt:message key="recipe.form.numIngredients" /></th>
						<th></th>
						<sec:authorize ifAllGranted="ROLE_ADMIN">
							<th></th>
						</sec:authorize>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${recipes}" var="recipe">
						<c:url var="editUrl" value="/recipe/edit/${recipe.id}" />
						<sec:authorize ifAllGranted="ROLE_ADMIN">
							<c:url var="deleteUrl" value="/recipe/delete/${recipe.id}" />
						</sec:authorize>
						<tr class="alt">
							<td><c:out value="${recipe.description}" /></td>
							<td><c:out value="${recipe.comment}" /></td>
							<td><c:out value="${fn:length(recipe.ingredientList)}" /></td>
							<td class="clean"><a href="${editUrl}"><fmt:message
										key="button.edit" /></a></td>
							<sec:authorize ifAllGranted="ROLE_ADMIN">
								<td class="clean"><a href="${deleteUrl}"><fmt:message
											key="button.delete" /></a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<h3><fmt:message key="recipe.form.noList" /></h3>
		</c:otherwise>
	</c:choose>
</div>