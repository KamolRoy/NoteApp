<%@ include file="/WEB-INF/includes/header.jsp"%>

<div id="wrap">
	<div id="main" class="container clear-top">

			<!-- 
			Sign up form to create new account for time assistance user.
			The attribute path is the Path to the property for the data binding. 
		 	-->
			<div class="panel panel-default">
				
				<div class="panel-heading">
					<h3 class="panel-title">Signup with WebFM</h3>
				</div>
				
				<div class="panel-body">
				<form:form modelAttribute="signupForm" role="form">
					
					<form:errors/>
					
					<div class="form-group">
						<form:label path="email">Email Address</form:label>
						<form:input path="email" type="email" class="form-control" placeholder="Enter your email" />
						<form:errors cssClass="error" path="email"></form:errors>
						<p class="help-block">Enter a unique email address. It will also be your login id.</p>
					</div>
					
					<div class="form-group">
						<form:label path="name">Name</form:label>
						<form:input path="name" type="text" class="form-control" placeholder="Enter your name"></form:input>
						<form:errors cssClass="error" path="name"></form:errors>
						<p class="help-block">Enter your display name</p>
					</div>
					
					<div class="form-group">
						<form:label path="password">Password</form:label>
						<form:input path="password" type="password" class="form-control" placeholder="password"></form:input>
						<form:errors cssClass="error" path="password"></form:errors>
					</div>
					
					<button type="submit" class="btn btn-primary">Submit</button>
					
				</form:form>
			</div>
				
			</div>
			
		</div>


</div>

<%@ include file="/WEB-INF/includes/footer.jsp"%>
