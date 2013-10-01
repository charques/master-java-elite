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
	<c:url var="url" value="/batch/add" />
	<form:form action="${url}" commandName="batch">
		<form:input type="hidden" path="batchCost" />

		<div class="form-row">
			<form:label path="recipeId">
				<fmt:message key="batch.form.recipe" />:</form:label>
			<br />
			<form:select path="recipeId" onchange="getRecipeAJAX()">
				<form:option value="" label="--Seleccione"></form:option>
				<form:options items="${recipes}" itemValue="id"
					itemLabel="description"></form:options>
			</form:select>
		</div>
		<div class="form-row" id="amountRow" style="display: none;">
			<form:label path="totalAmount">
				<fmt:message key="batch.form.totalAmount" />:</form:label>
			<form:input type="number" path="totalAmount"
				onchange="getRecipeAJAX()" />
			<div id="totalAmount.errors" class="error"></div>
		</div>
		
		<div class="form-row" id="descRow" style="display: none;">
			<form:label path="description">
				<fmt:message key="batch.form.description" />:</form:label>
			<form:input path="description" size="50" 
				onchange="checkDesc()" />
			<div id="description.errors" class="error"></div>
		</div>
		<div class="form-row">
			<div id="recipeDetail"></div>
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
		var isValidRecipe = checkRecipe();
		var isValidAmount = checkTotalAmount();
		var isValidDesc = checkDesc();
		
		if(!isValidRecipe || !isValidAmount || !isValidDesc) {
			event.preventDefault();
		}
	});
	
	function checkRecipe() {
		var recipeId = $('#recipeId').val();
		if (recipeId == "") {
			// clear form
			$('#recipeDetail').html("");
			$('#amountRow').hide();
			$('#descRow').hide();
			return false;
		}
		return true;
	}
	
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

	function getRecipeAJAX() {
		
		var isValidRecipe = checkRecipe();
		var isValidAmount = checkTotalAmount();
		
		if(isValidRecipe && isValidAmount) {
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

								var recipeHtml = '<br/>';
								var ingredients = batch.ingredients;

								// List of ingredients - HIDDEN
								for ( var i = 0; i < ingredients.length; i++) {
									recipeHtml += '<input type="hidden" name="ingredients['+i+'].description" id="ingredients['+i+'].description" value="' + ingredients[i].description + '" />';
									recipeHtml += '<input type="hidden" name="ingredients['+i+'].percentage" id="ingredients['+i+'].percentage" value="' + ingredients[i].percentage + '" />';
									recipeHtml += '<input type="hidden" name="ingredients['+i+'].amount" id="ingredients['+i+'].amount" value="' + ingredients[i].amount + '" />';
									recipeHtml += '<input type="hidden" name="ingredients['+i+'].feedstockPrice" id="ingredients['+i+'].feedstockPrice" value="' + ingredients[i].feedstockPrice + '" />';
								}

								recipeHtml += '<table class="alt">';
								recipeHtml += '<thead><tr>';
								recipeHtml += '<th>Ingrediente</th>';
								recipeHtml += '<th>Porcentaje</th>';
								recipeHtml += '<th>Cantidad</th>';
								recipeHtml += '</tr></thead>';
								recipeHtml += '<tbody>';
								for ( var i = 0; i < ingredients.length; i++) {
									recipeHtml += '<tr>';
									recipeHtml += '<td>'
											+ ingredients[i].description
											+ '</td>';
									recipeHtml += '<td>'
											+ ingredients[i].percentage
											+ '%</td>';
									recipeHtml += '<td>'
											+ ingredients[i].amount + '</td>';
									recipeHtml += '</tr>';
								}
								recipeHtml += '</tbody></table>';
								$('#recipeDetail').html(recipeHtml);

								$('#amountRow').show();

								$('#description').val(batch.description);
								$('#descRow').show();

								$('#batchCost').val(batch.batchCost);

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