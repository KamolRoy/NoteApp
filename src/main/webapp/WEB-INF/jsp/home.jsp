<%@ include file="/WEB-INF/includes/header.jsp"%>

<div id="wrap">
	<div id="main" class="container clear-top">
	
	
		<div class="wfhome">
			WebFM Home Page
		</div>
		<sec:authorize access="isAnonymous()">
					<div class="home_info color_cream">Login to Start.<br/> Default <span class="color_red">username: sample1@gmail.com, password: 1234</span> 
					<br/>Or, you can create your own account.</div>
		</sec:authorize>
	
	</div>
</div>


<%@ include file="/WEB-INF/includes/footer.jsp"%>
