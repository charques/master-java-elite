<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html>
	<head>
		<title>Create an Account</title>
	</head>
	<body>
		<div id="bd">
			<div class="page-title">
				<h1 style="margin:0">Please Create an Account</h1>
			</div>
			
			<form method="post" action="${flowExecutionUrl}">
				<div style="width:240px">
					<div class="yui-g form-field">
						<div class="yui-u first">First Name:</div>
						<div class="yui-u"><input type="text" name="firstName" /></div>
					</div>
					<div class="yui-g form-field">
						<div class="yui-u first">Last Name:</div>
						<div class="yui-u"><input type="text" name="lastName" /></div>
					</div>
					<div class="yui-g form-field">
						<div class="yui-u first">E-mail:</div>
						<div class="yui-u"><input type="text" name="email" /></div>
					</div>
					<div class="yui-g form-field">
						<div class="yui-u first">Username:</div>
						<div class="yui-u"><input type="text" name="username" /></div>
					</div>
					<div class="yui-g form-field">
						<div class="yui-u first">Password:</div>
						<div class="yui-u"><input type="password" name="password" /></div>
					</div>
					<div class="yui-g form-field">
						<div class="yui-u first">Confirm Password:</div>
						<div class="yui-u"><input type="password" name="confirmPassword" /></div>
					</div>
					<div class="yui-g submit-button">
						<div class="yui-u first"></div>
						<div class="yui-g">
							<div class="yui-u first">
								<input type="submit" name="_eventId_submitRegistration" value="Submit" />
							</div>
							<div class="yui-u">
								<div style="padding-left:5px">
									<button onclick="window.location='${flowExecutionUrl}&_eventId=cancelRegistration'">Cancel</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div> <%-- end bd --%>
	</body>
</html>
