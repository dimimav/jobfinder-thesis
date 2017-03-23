<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="../../include/head.jsp"%>
	</head>
</head>
<body>
	<div class="container">
		<%@ include file="../../include/navbar.jsp"%>
		<div class="row">
			<div class="jumbotron">
			
				<h4>${msg}</h4>
				
				<h1>You application submitted successfully!</h1>

				<p>First name: ${jobApplication.fname } </p>
				<p>Last name: ${jobApplication.lname}</p>
				<p>Email: ${jobApplication.email}</p>
				<p>Address: ${jobApplication.address}</p>
				<p>Cover letter: ${jobApplication.coverLetter}</p>
				<p>Phone: ${jobApplication.phone}</p>
				 
				 <c:if test="${jobApplication.workingExperience.size() > 0}">
					<h3>Work Experience:</h3>
						<c:forEach items="${jobApplication.workingExperience}" var="workingExperience">
							<p>	<fmt:formatDate value="${workingExperience.startDate}" pattern="dd-M-Y"/> - <fmt:formatDate value="${workingExperience.endDate}" pattern="dd-M-Y"/></p>
							<p>Job title: ${workingExperience.title}</p>
							<p>company: ${workingExperience.company }</p>
						</c:forEach>
				</c:if>
				
				 <c:if test="${jobApplication.education.size() > 0}">
					<h3>Education: </h3>
					<c:forEach items="${jobApplication.education}" var="education">
						<p>Degree: ${education.degree} </p> 
						<p>School: ${education.school}</p>
					</c:forEach>
				</c:if>

				 <c:if test="${jobApplication.languages.size() > 0}">
					<h3>Languages: </h3>
					<c:forEach items="${jobApplication.languages }" var="language">
						<p> ${language.language.name } : ${language.level }/10 </p>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>