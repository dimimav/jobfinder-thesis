<html>
<head>
<%@ include file="../include/head.jsp"%>
<title>Company Details</title>
</head>
	<body>
	<div class="container">
		<%@ include file="../include/navbar.jsp"%>
			<div class="row">
				<div class="jumbotron">
					<img src="${contextPath}/resources/images/company-icon.png" width="120" height="120" />
					<h1>${company.name }</h1>
					<p>Address: ${company.address}</p>
					<p>Telephone: ${company.telephone}</p>
					<p>Email: ${company.email}</p>
					<p>Tax Number: ${company.taxNumber}</p>		
					<a href="${contextPath}/company/${company.id}/jobs">View all jobs from this company</a>			
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$("#companies-link").addClass("active");
		</script>
	</body>
</html>