<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>products</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function deleteProduct(id) {
		id = id.split("_")[1];
		$.ajax({
				url : "${pageContext.request.contextPath}/deleteProduct",
				type:"post",
				data : "productId=" + id,
				
				success : function(response)
				{
					var table = document.getElementById("productTable");
					var tr = document.getElementById("tr_"+id);
					table.deleteRow(tr.rowIndex);
					alert(response);
				},
				
				error : function(error)
				{
					alert(error);
				}
				
		});
	}
</script>
</head>
<body>

	<table border="1" id="productTable">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
			<th>Image</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${allProducts}" var="product">

			<tr align="center" id="tr_${product.id}">

				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.description}</td>
				<td><img width="250px" , height="200px"
					src='<c:url value = "/img/${product.image}"></c:url>'></td>
				<td><input type="button" value="Delete" id="btn_${product.id}"
					onclick="deleteProduct(this.id)"></td>

			</tr>



		</c:forEach>
	</table>

</body>
</html>