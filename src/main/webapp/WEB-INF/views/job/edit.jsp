<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../include/head.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#edit-company-form {
	
	max-width:300px;
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
		<h1>Edit job</h1> 
		<form:form method="POST" modelAttribute="job"
			action="${pageContext.request.contextPath}/job/edit/${job.id}"
			id="edit-company-form">
			

			
				<div class="form-group">
					<label class="control-label col-sm-4 for="experience">
						experience:</label>
					<div class="col-sm-8">
						<form:input path="experience" type="text" class="form-control" />
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