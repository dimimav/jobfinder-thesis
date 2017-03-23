<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<%@ include file="../include/head.jsp"%>
<title>Apply for ${job.title}</title>
</head>

<body>
	<div class="container">
		<%@ include file="../include/navbar.jsp"%>

		<div class="row">
			<div class="jumbotron">
				<h1>Apply for ${job.title }</h1>

				<form:form method="POST" modelAttribute="jobApplicationForm" action="${pageContext.request.contextPath}/job/${job.id}/apply" class="form-horizontal" onsubmit="return validateJobApplication();">
					<div class="form-group">
						<label class="control-label col-sm-2" for="First name">First
							name:</label>
						<div class="col-sm-10">
							<form:input path="fname" type="text" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="First name">Last
							name:</label>
						<div class="col-sm-10">
							<form:input path="lname" type="text" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="email">Email:</label>
						<div class="col-sm-10">
							<form:input path="email" type="text" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="email">Address:</label>
						<div class="col-sm-10">
							<form:input path="address" type="text" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="phone">Phone:</label>
						<div class="col-sm-10">
							<form:input path="phone" type="text" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="coverLetter">Cover
							Letter:</label>
						<div class="col-sm-10">
							<form:textarea path="coverLetter" type="text"
								class="form-control" />
						</div>
					</div>
					<br>


					<div class="form-group">
						<h3>Work Experience</h3>
					</div>
					<c:set var="myVar" value="0" />
					<%
						for (int i = 0; i < 5; i += 1) {
					%>
					<c:set var="i" value="<%=i%>" />
					<div class="work-experience" id="work-experience-${i}">
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="workingExperience[${i}].title">Job title:</label>
							<div class="col-sm-4">
								<form:input path="workingExperience[${i}].title" type="text"
									class="form-control" />
							</div>
							<label class="control-label col-sm-2"
								for="workingExperience[${i}].startDate">Start Date:</label>
							<div class="col-sm-4">
								<form:input path="workingExperience[${i}].startDate" type="text"
									class="form-control datepicker" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="workingExperience[${i}].company">Company:</label>
							<div class="col-sm-4">
								<form:input path="workingExperience[${i}].company" type="text"
									class="form-control" />
							</div>

							<label class="control-label col-sm-2"
								for="workingExperience[${i}].endDate">End Date:</label>
							<div class="col-sm-4">
								<form:input path="workingExperience[${i}].endDate" type="text"
									class="form-control datepicker" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="workingExperience[${i}].industry">Industry:</label>
							<div class="col-sm-10">
								<form:input path="workingExperience[${i}].industry" type="text"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="workingExperience[${i}].description">Description:</label>
							<div class="col-sm-10">
								<form:input path="workingExperience[${i}].description"
									type="text" class="form-control" />
							</div>
						</div>
						<br> <br>
						<button type="button"
							class="btn btn-secondary btn-lg add-work-experience-btn"
							id="add-workExp-${i}">+ Add Work Experience</button>
					</div>

					<%
						}
					%>


					<div class="form-group">
						<h3>Education</h3>
					</div>

					<%
						for (int i = 0; i < 5; i += 1) {
					%>
					<c:set var="i" value="<%=i%>" />
					<div class="education" id="education-${i}">
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="education[${i}].degree">Degree:</label>
							<div class="col-sm-4">
								<form:input path="education[${i}].degree" type="text"
									class="form-control" />
							</div>
							<label class="control-label col-sm-2"
								for="education[${i}].school">School:</label>
							<div class="col-sm-4">
								<form:input path="education[${i}].school" type="text"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="education[${i}].fieldOfStudy">Field of study:</label>
							<div class="col-sm-10">
								<form:input path="education[${i}].fieldOfStudy" type="text"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="education[${i}].educationLevel.id">Level:</label>
							<div class="col-sm-10">
								<form:select path="education[${i}].educationLevel.id"
									type="text" class="form-control">
									<form:option value="1" label="Ph.d" />
									<form:option value="2" label="Master" />
									<form:option value="3" label="Bachelor" />
									<form:option value="4" label="Post-Secondary" />
									<form:option value="5" label="Secondary" />
									<form:option value="6" label="Primary" />
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="education[${i}].description">Description:</label>
							<div class="col-sm-10">
								<form:input path="education[${i}].description" type="text"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="education[${i}].grade">Grade:</label>
							<div class="col-sm-10">
								<form:input path="education[${i}].grade" type="text"
									class="form-control degree-grade" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="education[${i}].startDate">Start Date:</label>
							<div class="col-sm-10">
								<form:input path="education[${i}].startDate" type="text"
									class="form-control datepicker" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2"
								for="education[${i}].endDate">End Date:</label>
							<div class="col-sm-10">
								<form:input path="education[${i}].endDate" type="text"
									class="form-control datepicker" />
							</div>
						</div>
						<br>
						<br>
						<button type="button"
							class="btn btn-secondary btn-lg add-education-btn"
							id="add-education-${i}">+ Add Education</button>
					</div>
					<%
						}
					%>
					<div class="form-group">
						<h3>Languages</h3>
					</div>
					<%	for (int i = 0; i < 5; i += 1) { %>
					<c:set var="i" value="<%=i%>" />
					<div class="language" id="language-${i}">
						<label class="control-label col-sm-2" for="language">Name:</label>
							<div class="col-sm-10">
							 	<select name="languages[${i}].language.id" class="form-control">
									<c:forEach items="${languages}" var="language">
										<option value="${language.id}">${language.name}</option>
									</c:forEach>
								</select>
							</div>
							<br><br>
					<label class="control-label col-sm-2" for="language">Level:</label>
							<div class="col-sm-10">
							 	<select name="languages[${i}].level" class="form-control">
									 	<option value="0" selected>--</option>
										<option value="5">Good</option>
										<option value="7">Very Good</option>
										<option value="10">Excellent</option>
								</select>
							</div>
							<br><br>
						<button type="button" class="btn btn-secondary btn-lg add-language-btn" id="add-language-${i}">+ Add Language</button>
					</div>
					<% } %>
					<br><br>
					<button type="submit" class="btn btn-primary btn-lg">Submit Application</button>
				</form:form>

			</div>
			<%@ include file="../include/footer.jsp"%>
		</div>
	</div>
</body>
</html>