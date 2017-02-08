<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html data-ng-app="noteApp">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebFM</title>

<!-- Bootstrap -->
<link
	href="/public/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet"/>
<link
	href="/public/css/main.css"
	rel="stylesheet"/>
	
<body>
	<div class="container">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">WebFM</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="/">Home <span class="sr-only">(current)</span></a></li>
					<sec:authorize access="isAuthenticated()">
						<li><a href="/userhome">Create/Update/Delete</a></li>
						<li><a href="/userhomeSF">Sort/Filter</a></li>
					</sec:authorize>
				</ul>
				
				<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="isAnonymous()">
						<li><a href="<c:url value='/singupWF' />" >
						<span class="glyphicon glyphicon-list-alt"></span> Sign Up
						</a></li>
						<li><a href="<c:url value='/login' />" >
						<span class="glyphicon glyphicon-log-in"></span> Login
						</a></li>
					</sec:authorize>
					
					<sec:authorize access="isAuthenticated()">
					<li>
						<a href="#">
							Welcome <sec:authentication property="principal.user.name" /> !  
						</a>
					</li>
					<li><c:url var="logoutUrl" value="/logout" /> <form:form
										id="logoutForm" action="${logoutUrl }" method="post">
									</form:form> <a href="#"
									onclick="document.getElementById('logoutForm').submit()"><span
										class="glyphicon glyphicon-log-out"></span> Sing out</a></li>
					</sec:authorize>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
		</div>
		
		<c:if test="${not empty flashMessage }">
		<div class="alert alert-${flashKind} alert-dismissible container">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			${flashMessage }
		</div>
		</c:if>