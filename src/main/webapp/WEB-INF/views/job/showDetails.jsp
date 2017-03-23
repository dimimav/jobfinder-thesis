<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<%@ include file="../include/head.jsp"%>
	<title>${job.title} - Job Details</title>
</head>
<body>
	<div class="container">
		<%@ include file="../include/navbar.jsp"%>
		<div class="row">
		<div class="jumbotron">
			<h1>Job Details</h1>
			<h4>${job.title}</h4>
			
			<p>Posted at: <fmt:formatDate value="${job.datePosted}" pattern="dd-M-Y H:m"/></p> 
			
			<p>Category: ${job.category.name }</p>
			<p>Employment Type: ${job.employmentType }</p>
			<p>Location: ${job.location }</p>
			<p>Salary: ${job.salary} EUR</p>
			<p>Required Experience: ${job.experience }</p>
			<p>Description: ${job.description }</p>
			<p>Telephone: ${job.telephone }</p>
			<p>Email: ${job.email }</p>
			<p><a class="btn btn-lg btn-outline-primary" href="${contextPath}/job/${job.id}/apply">Apply for this job</a>	
			</p>
		</div>
			<%@ include file="../include/footer.jsp"%>
		</div>
	</div>
</body>
</html>