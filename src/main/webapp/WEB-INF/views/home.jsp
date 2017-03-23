<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="include/head.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="include/navbar.jsp"%>
		<div class="jumbotron">
			<h1>JobFinder</h1>
			<p class="lead">Find the job you want, or the right candidate for your company.</p>
			<p>
				<a class="btn btn-lg btn-outline-primary" href="${contextPath}/listJobs" role="button">Browse jobs</a>
				<a class="btn btn-lg btn-outline-primary" href="${contextPath}/job/add"  role="button">Post a job</a>
			</p>
		</div>
		<%@ include file="include/footer.jsp"%>
	</div>
	<script type="text/javascript">
		$("#home-link").addClass("active");
	</script>
</body>
</html>