<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Login Page</title>
</head>
<body>

	<h1>Login Here</h1>
	<label>${hits}</label>
	<br>
	<br>
	<br>
	<label style="color: red;">${error_msg}</label>

	<form:form action="${pageContext.request.contextPath}/login"
		commandName="clients" method="post">


		<table>
			<tr>
				<td><label>Enter User name : </label></td>
				<td><form:input type="text" path="username" name="username" /><br />
					<form:errors path="username" style="color:red;"></form:errors></td>
			</tr>
			<tr>
				<td><label>Enter Password : </label></td>
				<td><form:input type="password" path="password" name="password" />
					<br /> <form:errors path="password" style="color:red;"></form:errors></td>
			</tr>
			<tr>
				<td>&nbsp</td>
				<td align="center"><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>