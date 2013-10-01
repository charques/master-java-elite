<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>
	<c:choose>
		<c:when test="${feedstock.id != null}">
			<fmt:message key="feedstock.form.title.edit" />
		</c:when>
		<c:otherwise>
			<fmt:message key="feedstock.form.title.new" />
		</c:otherwise>
	</c:choose>
</h1>

<div id="inner-content">
	<c:url var="url" value="/feedstock/edit" />
	<form:form action="${url}" commandName="feedstock">
		<!--<form:errors path="*" cssClass="errorblock" element="div" />-->
		<form:input type="hidden" path="id" />
		<div class="form-row">
			<form:label path="description">
				<fmt:message key="feedstock.form.description" />:</form:label>
			<form:input path="description" size="50" />
			<form:errors path="description" cssClass="error" element="div" />
		</div>
		<div class="form-row">
			<form:label path="price">
				<fmt:message key="feedstock.form.price" />:</form:label>
			<form:input path="price" size="4"/>
			<form:errors path="price" cssClass="error" element="div" />
		</div>
		<div class="form-row">
			<form:label path="unitId">
				<fmt:message key="feedstock.form.unitId" />:</form:label>
			<br />
			<form:select path="unitId">
				<option value="" selected="selected">--Seleccione</option>
				<c:forEach items="${units}" var="unit">
					<option value="${unit.id}"
						<c:if test="${feedstock.unitId == unit.id}">selected='selected'</c:if>>${unit.description}</option>
				</c:forEach>
			</form:select>
			<form:errors path="unitId" cssClass="error" element="div" />
		</div>

		<br />
		<br />
		<input name="submit" type="submit"
			value="<fmt:message key="button.save"/>" />
	</form:form>
</div>