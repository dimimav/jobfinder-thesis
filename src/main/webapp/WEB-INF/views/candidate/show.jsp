<html>
<head>
<%@ include file="../include/head.jsp"%>
<title>Candidate Details</title>
</head>
	<body>
	<div class="container">
		<%@ include file="../include/navbar.jsp"%>
			<div class="row">
				<div class="jumbotron">
					<img src="${contextPath}/resources/images/candidate-icon.png" width="120" height="120" />
					<h1>${candidate.fname} ${candidate.lname}</h1>
					<p>Age: ${candidate.age}</p>
					<p>Gender: ${candidate.gender}</p>
					<p>Address: ${candidate.address}</p>
					<p>Telephone: ${candidate.telephone}</p>
					<p>Email: ${candidate.email}</p>			
				</div>
			</div>
		<!-- footer -->
		<%@ include file="../include/footer.jsp"%>
	<script type="text/javascript">
		$("#candidates-link").addClass("active");
	</script>
	</body>
</html>

