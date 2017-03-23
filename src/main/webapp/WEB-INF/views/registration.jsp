<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.jobfinder.model.Consts" %> 

<!DOCTYPE html>
<html>
<head>
	<%@ include file="include/head.jsp"%>
	<title>Create an account</title>
</head>
<body>	
	<div class="container">
		<%@ include file="include/navbar.jsp"%>
		<form:form method="POST" modelAttribute="userForm" class="form-signin">
			<h2 class="form-signin-heading">Create your account</h2>
			<spring:bind path="username">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="username" class="form-control"
						placeholder="Username" autofocus="true"></form:input>
					<form:errors path="username"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="passwordConfirm"
						class="form-control" placeholder="Confirm your password"></form:input>
					<form:errors path="passwordConfirm"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="type">
				<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:select type="text" path="type" class="form-control" >
					<form:option value="<%=Consts.ROLE_COMPANY%>" label="Company"/>
					<form:option value="<%=Consts.ROLE_CANDIDATE%>" label="Candidate"/>
				</form:select>
				</div>
			</spring:bind>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>
		<%@ include file="include/footer.jsp"%>
	</div>
	<!-- /container -->
	<script type="text/javascript">
		$("#registration-link").addClass("active");
	</script>
	
</body>
</html>
