<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<%@ include file="../include/head.jsp"%>
<style>
#add-job-form {
	text-align: center;
}

.form-group {
	padding-top: 35px;
}
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../include/navbar.jsp"%>
		<div class="row">
			<div style="text-align: center;">
			<br>
				<h1>Add a new job</h1>
				<form:form method="POST" modelAttribute="jobForm"
					action="${pageContext.request.contextPath}/job/add"
					class="form-horizontal" id="add-job-form">
					<div class="form-group">
						<label class="control-label col-sm-2" for="title">Title:</label>
						<div class="col-sm-10">
							<form:input path="title" type="text" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="description">Description:</label>
						<div class="col-sm-10">
							<form:input path="description" type="text" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="employmentType">employmentType:</label>
						<div class="col-sm-10">
							<form:select path="employmentType" type="text"
								class="form-control">
								<form:option value="full-time" label="Full-time" />
								<form:option value="part-time" label="Part-time" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="salary">salary:</label>
						<div class="col-sm-10">
							<form:input path="salary" type="text" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="experience">experience:</label>
						<div class="col-sm-10">
							<form:input path="experience" type="text" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="location">location:</label>
						<div class="col-sm-10">
							<form:input path="location" type="text" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="telephone">Telephone:</label>
						<div class="col-sm-10">
							<form:input path="telephone" type="text" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="email">email</label>
						<div class="col-sm-10">
							<form:input path="email" type="text" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="category">Category</label>
						<div class="col-sm-10">

							<form:select type="text" class="form-control" path="category.id">
								<c:forEach items="${jobCategories}" var="category">
									<form:option value="${category.id}" label="${category.name}" />
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div><br><br>
						<button type="submit" class="btn btn-success">Submit</button>

					</div>
				</form:form>

			</div>
		</div>
	</div>
</body>
</html>