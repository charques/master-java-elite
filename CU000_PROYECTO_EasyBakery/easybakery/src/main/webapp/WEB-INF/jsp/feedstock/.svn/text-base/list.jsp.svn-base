<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<h1>
	<fmt:message key="feedstock.title" />
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
		<c:when test="${fn:length(feedstocks) > 0}">
			<table>
				<thead>
					<tr>
						<th><fmt:message key="feedstock.form.description" /></th>
						<th><fmt:message key="feedstock.form.price" /></th>
						<th><fmt:message key="feedstock.form.unitId" /></th>
						<th></th>
						<sec:authorize ifAllGranted="ROLE_ADMIN">
							<th></th>
						</sec:authorize>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${feedstocks}" var="feedstock">
						<c:url var="editUrl" value="/feedstock/edit/${feedstock.id}" />
						<sec:authorize ifAllGranted="ROLE_ADMIN">
							<c:url var="deleteUrl" value="/feedstock/delete/${feedstock.id}" />
						</sec:authorize>
						<tr class="alt">
							<td><c:out value="${feedstock.description}" /></td>
							<td><c:out value="${feedstock.price}" /></td>
							<td><c:out value="${feedstock.unit.description}" /></td>
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
			<h3><fmt:message key="feedstock.form.noList" /></h3>
		</c:otherwise>
	</c:choose>
</div>