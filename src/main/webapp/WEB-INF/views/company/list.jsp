<html>
<head>
<%@ include file="../include/head.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="../include/navbar.jsp"%>
		<div style="padding-top: 36px; text-align: center">
			<h1>All companies</h1>
		</div>
		<br>
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-8">
				<c:forEach items="${companies}" var="company">
					<div class="job-container">
						<div class="job-image-container">
							<img src="${contextPath}/resources/images/company-icon.png"	width="120" height="120" />
						</div>
						<div class="job-info-container">
							<h3>${company.name }</h3>
							<p>${company.address }</p>
							<p>${company.telephone }</p>
							<p>${company.email }</p>
							<p>
							<a class="btn btn-primary" href="${contextPath}/company/${company.id}" role="button">View details &raquo;</a>
							</p>
						</div>
					</div>

					<br>
				</c:forEach>
			</div>
		</div>
		<!-- footer -->
		<%@ include file="../include/footer.jsp"%>
	</div>
	<script type="text/javascript">
		$("#companies-link").addClass("active");
	</script>
</body>
</html>