<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<%@ include file="include/head.jsp"%>

<style>
.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}
</style>
<body>

	<div class="container">
		<%@ include file="include/navbar.jsp"%>
		<div class="jumbotron">
			
				<form method="POST" action="${contextPath}/login"
					class="form-signin" action="#">
					<h2 class="form-signin-heading">Log in</h2>
					<div class="form-group ${error != null ? 'has-error' : ''}">
					<label>Username:</label>
					<input name="username" type="text" class="form-control"	placeholder="Username" autofocus="true" />
						
					</div>
					<div class="form-group">
					<label>Password:</label>
					 	<input name="password" type="password" class="form-control"	placeholder="Password" /> <span>${error}</span>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> <br>
					<div class='col-md-offset-3'>
						<button type="submit" class="btn btn-primary btn-lg">Log in</button>
					</div>
					<br>
					<h4 class="text-center">
						<a href="${contextPath}/registration">Create an account</a>
					</h4>
				</form>
			
		</div>
		<%@ include file="include/footer.jsp"%>
	</div>	
	<script type="text/javascript">
		$("#login-link").addClass("active");
	</script>

</body>
</html>
