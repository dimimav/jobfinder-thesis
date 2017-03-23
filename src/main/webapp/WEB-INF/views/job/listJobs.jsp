<html>
<head>
<title>All available jobs</title>
<%@ include file="../include/head.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="../include/navbar.jsp"%>
		<div style="padding-top: 36px; text-align: center">
			<h1>All available jobs</h1>
		</div>
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-8">
				<c:forEach items="${jobList}" var="job" varStatus="loopCounter">
					<div class="job-container">
						<div class="job-image-container">
							<img src="${contextPath}/resources/images/job-icon.png"
								width="120" height="120" />
						</div>
						<div class="job-info-container">
							<h3>${job.title}</h3>
							<p>${job.description}</p>
							<p>
								<a class="btn btn-primary" href="${contextPath}/job/${job.id}"
									role="button">View details &raquo;</a>
							</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- footer -->
		<%@ include file="../include/footer.jsp"%>
		<!-- container -->
	</div>
	<script type="text/javascript">
		$("#listJobs-link").addClass("active");
	</script>
</body>

</html>