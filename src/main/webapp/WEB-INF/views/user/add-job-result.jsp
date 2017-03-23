<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>new job submitted</title>
</head>
<body>
<h2>submitted values:</h2>
   <table>
    <tr>
        <td>id</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>title</td>
        <td>${title}</td>
    </tr>
    <tr>
        <td>description</td>
        <td>${description}</td>
    </tr>
</table> 
<p>job.toString(): ${job.toString() }</p>
</body>
</html>