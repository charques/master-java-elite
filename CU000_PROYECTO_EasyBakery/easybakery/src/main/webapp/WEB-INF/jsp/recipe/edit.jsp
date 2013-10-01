<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script type="text/javascript">
    $(function() {

        // Start indexing at the size of the current list
        var index = ${fn:length(recipe.ingredientList)};

        // Add a new Ingredient
        $("#add").off("click").on("click", function() {
        	// clone the last visible row in the table
			var $tr = $('#ingredients_table').find("tbody tr:visible:last").clone();
        	
        	// set the id of the wrapper
        	$tr.attr("id", function() {
				return buildNewId(this.id, index);
			});

			// get the name attribute for the input and select fields
			$tr.find("input,select").attr("name", function() {
				// repeat for name attributes
				return buildNewId(this.id, index);
			}).attr("id", function() {
				// repeat for id attributes
				return buildNewId(this.id, index);
			});

			// clean input value (percentage)
			$tr.find("input[type='text']").val(1);
			
			// clean select value (feedstockId)
			$tr.find("select").find("option:first").attr("selected", true);
        	
			// show delete
			$tr.find("#dv_delete").show();
			
			// append the new row to the table
			$('#ingredients_table').find("tbody tr:last").after($tr);
        	
            index++;
            return false;
        });

        // Remove an Ingredient
        $("#del_ingredientRow").live("click", function() {
        	var $hidden = $(this).closest('tr').find('input[type="hidden"]');
			$hidden.attr("value", "1");
			$(this).closest('tbody tr').hide();
            return false;
        });
        
     	// Build a new id replacing te index.
		function buildNewId($input, $index) {
			console.debug($input);
			var $init = $input.lastIndexOf("[");
			var $end = $input.lastIndexOf("]");
			var $out = $input.substring(0, $init+1) + $index + $input.substring($end, $input.length);
			console.debug($out);
			return $out;
		}

    });
    </script>

<h1>
	<c:choose>
		<c:when test="${recipe.id != null}">
			<fmt:message key="recipe.form.title.edit" />
		</c:when>
		<c:otherwise>
			<fmt:message key="recipe.form.title.new" />
		</c:otherwise>
	</c:choose>
</h1>

<div id="inner-content">
	<c:url var="url" value="/recipe/edit" />
	<form:form action="${url}" modelAttribute="recipe" method="post"
		id="recipeForm">

		<form:input type="hidden" path="id" />

		<div class="form-row">
			<form:label path="description">
				<fmt:message key="recipe.form.description" />:</form:label>
			<form:input path="description" size="50" />
			<form:errors path="description" cssClass="error" element="div" />
		</div>
		<div class="form-row">
			<form:label path="comment">
				<fmt:message key="recipe.form.comment" />:</form:label>
			<br />
			<form:textarea path="comment" rows="5" cols="50" />
			<form:errors path="comment" cssClass="error" element="div" />
		</div>
		<br />

		<table id="ingredients_table">
			<thead>
				<tr>
					<th><fmt:message key="recipe.form.ingredients" /></th>
					<th><fmt:message key="recipe.form.percentage" /></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${recipe.ingredientList}" varStatus="loop">

					<tr class="alt">
						<td><spring:bind
								path="recipe.ingredientList[${loop.index}].feedstockId">
								<select name="<c:out value="${status.expression}"/>"
									id="<c:out value="${status.expression}"/>">
									<option value="" selected="selected">--Seleccione</option>
									<c:forEach var="feedstock" items="${feedstocks}">
										<option value="${feedstock.id}"
											<c:if test="${status.value == feedstock.id}">selected='selected'</c:if>>${feedstock.description}</option>
									</c:forEach>
								</select>
								
							</spring:bind></td>
						<td><spring:bind
								path="recipe.ingredientList[${loop.index}].percentage">
								<input type="text" size="3"
									name="<c:out value="${status.expression}"/>"
									id="<c:out value="${status.expression}"/>"
									value="<c:out value="${status.value}"/>" />
							</spring:bind></td>
						<td class="clean"><c:choose>
								<c:when test="${ingredientList[loop.index].delete eq 1}">
									<c:set var="hiddenValue" value="1" />
								</c:when>
								<c:otherwise>
									<c:set var="hiddenValue" value="0" />
								</c:otherwise>
							</c:choose> <spring:bind path="recipe.ingredientList[${loop.index}].delete">
								<input type="hidden"
									name="<c:out value="${status.expression}"/>"
									id="<c:out value="${status.expression}"/>"
									value="${hiddenValue}" />
							</spring:bind>
							<div style="display: ${(loop.index == 0)?'none':'block'}"
								id="dv_delete">
								<a href="#" id="del_ingredientRow"><fmt:message
										key="recipe.form.delete" /></a>
							</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:errors path="ingredientList" cssClass="error" element="div" />
		<div class="form-options">
			<button id="add" type="button">
				<fmt:message key="recipe.form.addIngredient" />
			</button>
		</div>

		<br />
		<br />
		<input type="submit" value="<fmt:message key="recipe.form.save" />"
			id="submit" />

	</form:form>

</div>