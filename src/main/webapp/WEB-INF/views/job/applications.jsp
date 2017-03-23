<html>
<head>
<%@ include file="../include/head.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:if test="${pageContext.request.method == 'POST'}">
	<c:set var="showResults" value="true" />
</c:if>
<title>All application for ${job.title}</title>
</head>
<body>
	<div class="container">
		<%@ include file="../include/navbar.jsp"%>
		<div class="jumbotron">
			<h1>All applications for ${job.title }</h1>
			<br>
			<table class="table table-bordered table-striped">
				<tr>
					<th>ID</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Work experience</th>
					<c:if test="${showResults}">
						<th>score(%)</th>
						<th>bonus score</th>
					</c:if>
					<th>Education</th>
					<c:if test="${showResults}">
						<th>score(%)</th>
						<th>bonus score</th>
					</c:if>
					<th>Languages</th>
					<c:if test="${showResults}">
						<th>Total score</th>
						<th>Qualified</th>
					</c:if>					
					<th>Actions</th>
				</tr>

				<c:forEach items="${jobApplications}" var="jobApp"
					varStatus="loopCounter">
					<tr>
						<td>${jobApp.id }</td>
						<td>${jobApp.fname}</td>
						<td>${jobApp.lname}</td>
						<td><c:forEach items="${jobApp.workingExperience}"
								var="workExp" varStatus="workExpCounter">
					${workExp.title} at ${workExp.company}: <fmt:formatDate value="${workExp.startDate}" pattern="dd/MM/yyyy" /> - <fmt:formatDate value="${workExp.endDate}" pattern="dd/MM/yyyy" /><br>
							</c:forEach></td>
						<c:if test="${showResults}">
							<td>${jobApp.workingExperienceScore }</td>
							<td>${jobApp.workExperienceBonusScore }</td>
						</c:if>
						<td><c:forEach items="${jobApp.education}" var="education">
					${education.educationLevel.title} in ${education.degree} - ${education.school}
				</c:forEach></td>
						<c:if test="${showResults}">
							<td>${jobApp.educationScore }</td>
							<td>${jobApp.educationBonusScore }</td>
						</c:if>
						<td><c:forEach items="${jobApp.languages}" var="language">
							${language.language.name } (${language.level*10}%)
							</c:forEach></td>
						<c:if test="${showResults}">
							<td>${jobApp.totalScore }%</td>
							<td>${jobApp.qualified }</td>
						</c:if>						
						<td><a href="${contextPath}/jobApplication/${jobApp.id}">View</a></td>
					</tr>
				</c:forEach>
			</table>
	
				<form:form action="${contextPath}/job/${job.id}/applications"
				modelAttribute="criteria" method="POST" class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-2" for="workExperience">Work	Experience</label>					
					<div class="col-sm-2">
						<form:select path="workExperienceOperator" class="form-control">
							<form:option value="--">--</form:option>
							<form:option value="exacly">exacly</form:option>
							<form:option value="min">min</form:option>
							<form:option value="max">max</form:option>							
						</form:select>
					</div>
					<div class="col-sm-4">
					<form:select path="workExperienceRequired" class="form-control">
							<form:option value="0">0 year</form:option>
							<form:option value="1">1 year</form:option>
							<form:option value="2">2 years</form:option>
							<form:option value="3">3 years</form:option>
							<form:option value="4">4 years</form:option>
							<form:option value="5">5 years</form:option>
							<form:option value="6">6 years</form:option>
							<form:option value="7">7 years</form:option>
							<form:option value="8">8 years</form:option>
							<form:option value="9">9 years</form:option>
							<form:option value="10">10 years</form:option>
					</form:select>
					</div>
					<label class="control-label col-sm-1" for="workExperienceWeight">Weight</label>
					<div class="col-sm-3">
						<form:input path="workExperienceWeight" class="form-control"
							required="required" />
					</div>

				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="education degree">Education Degree:</label>
					<div class="col-sm-2">
						<form:select path="educationOperator" class="form-control">
							<form:option value="--">--</form:option>
							<form:option value="min">min</form:option>
							<form:option value="max">max</form:option>
							<form:option value="exacly">exacly</form:option>
						</form:select>

					</div>
					<div class="col-sm-4">
						<form:select path="educationLevel" class="form-control">
							<form:option value="0">--</form:option>
							<form:option value="5">Primary school</form:option>
							<form:option value="6">Secondary school</form:option>
							<form:option value="7">Post-Secondary</form:option>
							<form:option value="8">Bachelor</form:option>
							<form:option value="9">Master</form:option>
							<form:option value="10">Ph.D</form:option>
						</form:select>
					</div>
					<label class="control-label col-sm-1">Weight:</label>
					<div class="col-sm-3">
						<form:input path="educationWeight" cssClass="form-control"
							required="required" />
					</div>
				</div>
				<div class="form-group">
					<h4>Languages:</h4>
				</div>
				<div class="form-group row">
					<label class="control-label col-sm-1" for="Name">Name:</label>
					<div class="col-sm-2">
						<form:select path="languages[0].languageId" class="form-control">
							<c:forEach items="${availableLanguages}" var="language">
								<form:option value="${language.id}">${language.name}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<label class="control-label col-sm-1" for="Operator">Operator:</label>
					<div class="col-sm-2">
						<form:select path="languages[0].operator" class="form-control">
							<form:option value="--">--</form:option>
							<form:option value="min">min</form:option>
							<form:option value="max">max</form:option>
							<form:option value="exacly">exacly</form:option>
						</form:select>
					</div>
					<label class="control-label col-sm-1" for="Level">Level:</label>
					<div class="col-sm-2">
						<form:select path="languages[0].level" class="form-control">
							<form:option value="5">good</form:option>
							<form:option value="7">very-good</form:option>
							<form:option value="10">excellent</form:option>
						</form:select>
					</div>
					<label class="control-label col-sm-1" for="weight">Weight:</label>
					<div class="col-sm-2">
						<form:input path="languages[0].weight" class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-sm-1" for="Name">Name:</label>
					<div class="col-sm-2">
					<form:select path="languages[1].languageId" class="form-control">
						<c:forEach items="${availableLanguages}" var="language">
							<form:option value="${language.id}">${language.name}</form:option>
						</c:forEach>
					</form:select> 
					</div>
					<label class="control-label col-sm-1" for="Operator">Operator:</label> 
					<div class="col-sm-2">					
					<form:select path="languages[1].operator" class="form-control">
						<form:option value="--">--</form:option>
						<form:option value="min">min</form:option>
						<form:option value="max">max</form:option>
						<form:option value="exacly">exacly</form:option>
					</form:select> 
					</div>
					<label class="control-label col-sm-1" for="Level:">Level:</label> 
					<div class="col-sm-2">
					<form:select path="languages[1].level" class="form-control"> 
						<form:option value="5">good</form:option>
						<form:option value="7">very-good</form:option>
						<form:option value="10">excellent</form:option>
					</form:select>
					</div>
					 <label class="control-label col-sm-1" for="Weight">Weight:</label> 
					 <div class="col-sm-2">
					 <form:input path="languages[1].weight" class="form-control"/>
					 </div>
				</div>
				<div class="form-group">
					Min total score for qualification: <form:input id="minTotalScore" path="minTotalScore" />
				</div>
				<button type="submit" class="btn btn-primary btn-lg">Submit</button>
			</form:form>
			<!-- junbotron -->
		</div>
		<!-- footer -->
		<%@ include file="../include/footer.jsp"%>
		<!-- container -->
	</div>
</body>
</html>