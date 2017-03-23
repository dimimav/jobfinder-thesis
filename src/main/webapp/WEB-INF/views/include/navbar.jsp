<div class="masthead">
	<h3 class="text-muted">JobFinder</h3>
	<nav>
		<ul class="nav nav-justified">
			<li class="nav-item"><a id="home-link" class="nav-link"	href="${contextPath}">Home</a></li>
			<li class="nav-item"><a id="listJobs-link" class="nav-link"	href="${contextPath}/listJobs">Jobs</a></li>
			<li class="nav-item"><a class="nav-link" href="${contextPath}/candidates" id="candidates-link">Candidates</a></li>
			<li class="nav-item"><a class="nav-link" href="${contextPath}/companies" id="companies-link">Companies</a></li>
			<c:choose>
				<c:when test="${loggedIn}">
					<li class="nav-item"><a class="nav-link" href="${contextPath}/user/dashboard" id="dashboard-link">Dashboard</a></li>
					<li class="nav-item"><a class="nav-link" onclick="document.forms['logoutForm'].submit()" href="#">Logout</a></li>
				</c:when>
				<c:otherwise>
        			<li class="nav-item"><a class="nav-link" href="${contextPath}/login" id="login-link">Login</a></li>
					<li class="nav-item"><a class="nav-link" href="${contextPath}/registration" id="registration-link">Register</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
</div>