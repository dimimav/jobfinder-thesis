<html>
<head>
<%@ include file="../include/head.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#edit-company-form {
	
	max-width:400px;
    margin: 0 auto;
}
.form-group {
    margin-bottom: 15px;
    padding-top: 35px;
}
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../include/navbar.jsp"%>
			<div class="row">
				<div class="jumbotron">
		<h1>Edit company</h1> 
		<form:form method="POST" modelAttribute="company"
			action="${pageContext.request.contextPath}/company/${company.id}/edit"
			id="edit-company-form">
			

			
				<div class="form-group">
					<label class="control-label col-sm-2 for="name">
						Name:</label>
					<div class="col-sm-10">
						<form:input path="name" type="text" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2 for="email">
						Email:</label>
					<div class="col-sm-10">
						<form:input path="email" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 for="country">
						Country:</label>
					<div class="col-sm-10">
						<form:input path="country" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 for="city">
						City:</label>
					<div class="col-sm-10">
						<form:input path="city" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 for="address">
						Address:</label>
					<div class="col-sm-10">
						<form:input path="address" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2 for="phone">
						Phone:</label>
					<div class="col-sm-10">
						<form:input path="telephone" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg">Edit</button>
				</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>