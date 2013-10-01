<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<h1>
	<fmt:message key="batch.title" />
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
		<c:when test="${fn:length(batchs) > 0}">
			<table>
				<thead>
					<tr>
						<th><fmt:message key="batch.form.description" /></th>
						<th><fmt:message key="batch.form.totalAmount" /></th>
						<th><fmt:message key="batch.form.date" /></th>
						<th><fmt:message key="batch.form.cost" /></th>
						<th></th>
						<sec:authorize ifAllGranted="ROLE_ADMIN">
							<th></th>
						</sec:authorize>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${batchs}" var="batch">
						<c:url var="editUrl" value="/batch/edit/${batch.id}" />
						<sec:authorize ifAllGranted="ROLE_ADMIN">
							<c:url var="deleteUrl" value="/batch/delete/${batch.id}" />
						</sec:authorize>
						<tr class="alt">
							<td><c:out value="${batch.description}" /></td>
							<td><c:out value="${batch.totalAmount}" /></td>
							<td><fmt:formatDate pattern="dd-MM-yyyy"
									value="${batch.modificationTime}" /></td>
							<td><fmt:setLocale value="es_ES" /> <fmt:formatNumber
									value="${batch.batchCost}" type="currency" /></td>
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
			<h3>
				<fmt:message key="batch.form.noList" />
			</h3>
		</c:otherwise>
	</c:choose>
</div>