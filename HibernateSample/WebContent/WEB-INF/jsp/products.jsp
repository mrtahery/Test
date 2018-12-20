<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>products</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
			<th>Image</th>
		</tr>
		<c:forEach items="${allProducts}" var="product">

			<tr align="center">

				<td>${product.name}</td>
				<td>$ ${product.price}</td>
				<td>${product.description}</td>
				<td><img width="250px" , height="200px"
					src='<c:url value = "/img/${product.image}"></c:url>'></td>

			</tr>



		</c:forEach>
	</table>

</body>
</html>