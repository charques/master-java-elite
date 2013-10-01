<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<script type="text/javascript">
	function getGraphAJAX() {
		var graphType = $('#graphType').val();
		var recipeId = $('#recipeId').val();
		var year = $('#year').val();
		//alert('graphType ' + graphType + ' recipeId ' + recipeId + ' year ' + year);

		$.ajax({
					type : "POST",
					url : "/easybakery/dashboard/getBatchGraph",
					data : "graphType=" + graphType + "&recipeId=" + recipeId
							+ "&year=" + year,
					success : function(response) {
						// we have the response
						if (response.status == "SUCCESS") {
							var graph = response.result;
							
							// set chart
							var chart = new Chart(document.getElementById(
									'graphContainer').getContext("2d"))
									.Bar(graph);
							
							// set total
							var total = graph.total;
							var totalDiv = $('#total');
							if(graphType == "PR") {
								totalDiv.html("Total: " + total + " kg");
							}
							else {
								totalDiv.html("Total: " + total + " &#8364;");
							}
						} else {
							$('#batchGraph')
									.html("Sorry, there is some thing wrong with the data provided.");
						}
					},
					error : function(e) {
						console.debug(e);
						alert('Error: ' + e);
					}
				});
	}
</script>

<h1>
	<fmt:message key="dashboard.title" />
</h1>

<div id="inner-content">
	<c:url var="url" value="/dashboard/view" />
	<form:form action="${url}" commandName="batchgraph">
		<div>
			<form:select path="graphType" onchange="getGraphAJAX()">
				<form:options items="${graphtypes}"></form:options>
			</form:select>
			<br />
			<br />
			<div class="subform">
			<form:label path="recipeId">
				<fmt:message key="dashboard.form.recipe" />:</form:label>
			<form:select path="recipeId" onchange="getGraphAJAX()">
				<form:option value="" label="Todas"></form:option>
				<form:options items="${recipes}" itemValue="id"
					itemLabel="description"></form:options>
			</form:select>
			<form:label path="year">
				<fmt:message key="dashboard.form.year" />:</form:label>
			<form:select path="year" onchange="getGraphAJAX()">
				<form:options items="${years}"></form:options>
			</form:select>
			</div>
			<br />
			<label id="total" class="total">Total: 0.00 kg</label>
			<br /> <br />
			<div id="batchGraph" class="batchGraph" >
				<canvas id="graphContainer" height="380" width="900"></canvas>
			</div>
		</div>
	</form:form>
</div>

<script type="text/javascript">
	window.onload = getGraphAJAX;
</script>