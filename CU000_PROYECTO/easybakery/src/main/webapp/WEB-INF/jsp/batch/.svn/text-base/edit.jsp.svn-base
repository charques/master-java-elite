<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>
	<c:choose>
		<c:when test="${batch.id != null}">
			<fmt:message key="batch.form.title.edit" />
		</c:when>
		<c:otherwise>
			<fmt:message key="batch.form.title.new" />
		</c:otherwise>
	</c:choose>
</h1>

<div id="inner-content">
	<c:url var="url" value="/batch/edit" />
	<form:form action="${url}" commandName="batch">
		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="batchCost" />
		<form:input type="hidden" path="recipeId" />

		<div class="form-row" id="descRow">
			<form:label path="description">
				<fmt:message key="batch.form.description" />:</form:label>
			<form:input path="description" size="50" 
				onchange="checkDesc()"/>
			<div id="description.errors" class="error"></div>
		</div>
		<div class="form-row" id="amountRow">
			<form:label path="totalAmount">
				<fmt:message key="batch.form.totalAmount" />:</form:label>
			<form:input type="number" path="totalAmount"
				onchange="calcBatchAJAX()" />
			<div id="totalAmount.errors" class="error"></div>
		</div>
		<br/>
		<div class="form-row">
			<div id="recipeDetail">
				<c:forEach items="${batch.ingredients}" varStatus="loop">
					<input type="hidden" name="ingredients[${loop.index}].description" id="ingredients[${loop.index}].description" value="${batch.ingredients[loop.index].description}" />
					<input type="hidden" name="ingredients[${loop.index}].percentage" id="ingredients[${loop.index}].percentage" value="${batch.ingredients[loop.index].percentage}" />
					<input type="hidden" name="ingredients[${loop.index}].amount" id="ingredients[${loop.index}].amount" value="${batch.ingredients[loop.index].amount}" />
					<input type="hidden" name="ingredients[${loop.index}].feedstockPrice" id="ingredients[${loop.index}].feedstockPrice" value="${batch.ingredients[loop.index].feedstockPrice}" />
				</c:forEach>
				<table id="ingredients_table">
					<thead>
						<tr>
							<th>Ingrediente</th>
							<th>Porcentaje</th>
							<th>Cantidad</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${batch.ingredients}" varStatus="loop">
							<tr id="item${loop.index}">
								<td class="description"><c:out value="${batch.ingredients[loop.index].description}" /></td>
								<td class="percentage"><c:out value="${batch.ingredients[loop.index].percentage}" /></td>
								<td class="amount"><c:out value="${batch.ingredients[loop.index].amount}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<br />
		<br />
		<div class="form-buttons">
			<div class="button">
				<input name="submit" type="submit"
					value="<fmt:message key="button.save"/>" />
			</div>
		</div>
	</form:form>
</div>

<script type="text/javascript">

	$("#batch").submit(function( event ) {
		var isValidAmount = checkTotalAmount();
		var isValidDesc = checkDesc();
		
		if(!isValidAmount || !isValidDesc) {
			event.preventDefault();
		}
	});
	
	function checkTotalAmount() {
		var totalAmount = $('#totalAmount').val();
		
		$("[id^=totalAmount].error").html("");
		
		if (totalAmount == "") {
			$("[id^=totalAmount].error").html('La cantidad no puede ser nula!');
			return false;
		}
		else if (totalAmount == "0") {
			$("[id^=totalAmount].error").html('La cantidad no puede ser 0!');
			return false;
		}
		return true;
	}
	
	function checkDesc() {
		var desc = $('#description').val();
		
		$("[id^=description].error").html("");
		
		if (desc == "") {
			$("[id^=description].error").html('La descripción no puede ser nula!');
			return false;
		}
		return true;
	}

	function calcBatchAJAX() {

		var isValidAmount = checkTotalAmount();

		if (isValidAmount) {
			var recipeId = $('#recipeId').val();
			var totalAmount = $('#totalAmount').val();
			
			$.ajax({
						type : "POST",
						url : "/easybakery/batch/getRecipe",
						data : "recipeId=" + recipeId + "&totalAmount="
								+ totalAmount,
						success : function(response) {
							// we have the response
							if (response.status == "SUCCESS") {
								var batch = response.result;

								var numIngredients = batch.ingredients.length;
								var ingredients = batch.ingredients;
								for( var i = 0; i < numIngredients; i++) {
									$("#recipeDetail input[name*='ingredients[" + i + "].amount']").val(ingredients[i].amount);
									$("#item" + i + " td.amount").html(ingredients[i].amount);
								}
								
							} else {
								$('#recipeDetail').html("Sorry, there is some thing wrong with the data provided.");
							}
						},
						error : function(e) {
							alert('Error: ' + e);
						}
					});
		}
	}
</script>