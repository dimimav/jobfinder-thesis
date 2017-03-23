<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<sec:authorize var="loggedIn" access="isAuthenticated()" />

<meta http-equiv="Content-Type" content="text/html; utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="icon" href="../../favicon.ico">

<!-- JQuery -->
<script src="${contextPath}/resources/lib/jquery/jquery-1.10.2.js"></script>
<script src="${contextPath}/resources/lib/jquery/jquery-ui-1.12.1.js"></script>
  
<!-- Custom js -->
<script src="${contextPath}/resources/js/custom.js"></script>

<!-- Bootstrap -->
<link href="${contextPath}/resources/lib/bootstrap/bootstrap.min.css" rel="stylesheet">
<script src="${contextPath}/resources/lib/bootstrap/bootstrap.min.js"></script>

<!-- Custom styles  -->
<link href="${contextPath}/resources/css/justified-nav.css" rel="stylesheet">
<link href="${contextPath}/resources/css/custom.css" rel="stylesheet">

<link rel="stylesheet" href="${contextPath}/resources/css/jquery-ui.css">


