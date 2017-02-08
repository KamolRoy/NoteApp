<%@ include file="/WEB-INF/includes/header.jsp"%>

<div id="wrap">
	<div id="main" class="container clear-top">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Please sing in</h3>
				</div>
				<!-- end of panel heading -->
		
				<div class="panel-body">
					<c:if test="${param.error != null }">
						<div class="alert alert-danger">Invalid username and password.
						</div>
					</c:if>
		
					<c:if test="${param.logout != null }">
						<div class="alert alert-danger">You have been logged out.</div>
					</c:if>
		
					<form:form role="form"	method="post">
						<div class="form-group">
							<label for="username">Email address</label>
							<input type="email" id="username" name="username" class="form-control" placeholder="Enter email" />
							<p class="help-block">Enter your email address</p>
						</div>
						<div class="from-group">
							<label for="password">Password</label>
							<input type="password" id="password" name="password" class="form-control" placeholder="Password"/>
							<form:errors cssClass="error" path="password"/>
						</div>
						
						<div class="up_space">
							<button type="submit" class="btn btn-primary">Sign In</button>
						</div>
		    	        
					</form:form>
		
		
				</div>
				<!-- end of panel-body -->
			</div>
			<!-- end of panel-primary -->
		</div>
		<!-- end of container  -->

</div>
<%@ include file="/WEB-INF/includes/footer.jsp"%>
