<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Hi Rasool</title>
<link href='<c:url value="/css/style.css"></c:url>' rel="stylesheet">
<script type="text/javascript" src='<c:url value="/js/demo.js"></c:url>'></script>
</head>
<body>

<h1>Welcome to the Spring world</h1>
<br>
<a class="demo" href="${pageContext.request.contextPath}/login">Login</a>
<br>

<img alt="demo" src='<c:url value = "/img/Koala.jpg"></c:url>'>
<br>
<a class="demo" href="${pageContext.request.contextPath}/signup">Sing up</a>
</body>
</html>