<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../include/head.jsp"%>
<style>
.pull-right {
	float: right !important;
	padding-bottom: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../include/navbar.jsp"%>
		<div class="row">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<br>
			<div class="col-md-12">
				<div class="pull-right">
					<h3>You are logged in as: ${pageContext.request.userPrincipal.name}</h3>
						<a href="${contextPath}/job/add"><button class="btn btn-primary">Add New Job</button></a>
						<c:if test="${user.hasRole('ROLE_COMPANY')}">
							<a href="${contextPath}/company/${company.id}/edit"><button class="btn btn-success">Edit my profile</button></a>			
						</c:if>
						
						<c:if test="${user.hasRole('ROLE_CANDIDATE')}">
							<a href="${contextPath}/candidate/${candidate.id}/edit"><button class="btn btn-success">Edit my profile</button></a>			
						</c:if>
						
				</div>
				<div id="data-table">
					<div style="text-align: center; padding-top: 50px;">
						<h2>My jobs</h2>
					</div>
					<table class="table table-bordered table-striped">
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th style="max-width: 450px;">Description</th>
							<!-- <th>Posted</th> -->
							<th>Actions</th>
						</tr>
						<c:forEach items="${company.jobs}" var="job">
							<tr>
								<td>${job.id}</td>
								<td>${job.title}</td>
								<td style="max-width: 450px;">${job.description}</td>
								<!-- <td>${job.datePosted }</td> -->
								<td><a href="${contextPath}/job/${job.id}/applications"><button
											class="btn btn-info">Show applications</button></a> <a
									href="${contextPath}/job/${job.id}"><button
											class="btn btn-primary">View</button></a> <a href="${contextPath}/job/edit/${job.id}"><button
											class="btn btn-warning">Edit</button></a> <a href="${contextPath}/job/delete/${job.id}"><button
											class="btn btn-danger">Delete</button></a></td>
							</tr>
						</c:forEach>
					</table>
				</div>

				<%@ include file="../include/footer.jsp"%>
				<!-- /container -->
				<script
					src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
				<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
			</div>
		</div>
	</div>
</body>