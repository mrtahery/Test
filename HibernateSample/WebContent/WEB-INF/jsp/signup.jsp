<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Sign up here</title>


<script type="text/javascript">
	function doValidations() {
		 var username = document.getElementById("username").value;
		 if(parseInt(username.length) < 4)
			 {
			 	alert('Username must be at least 4 characters long');
			 	return false;
			 }
		 
		 var password = document.getElementById("password").value;
		 var repassword = document.getElementById("repassword").value;
		 
		 if(parseInt(password.length) < 6)
		 {
		 	alert('password must be at least 6 characters long');
		 	return false;
		 }
		 
		 if (password != repassword) {
			 alert('password and re-password do not match');
			 	return false;		
		}
		 
		 return true;
	}
</script>


</head>
<body>
	<div>

		<label>${status}</label>

		<form action="${pageContext.request.contextPath}/signup" method="post"
			enctype="multipart/form-data" onsubmit="return doValidations()">

			<table border="1">
				<tr>
					<td><label> Enter Username : </label></td>
					<td><input id="username" type="text" name="username"></td>
				</tr>
				<tr>
					<td><label> Enter password : </label></td>
					<td><input id="password" type="password" name="password"></td>
				</tr>
				<tr>
					<td><label> Re-Enter password : </label></td>
					<td><input id="repassword" type="password" name="repassword"></td>
				</tr>
				<tr>
					<td><label> Choose gender : </label></td>
					<td><input type="radio" name="gender" value="Male"> Male<input
						type="radio" name="gender" value="Female"> Female</td>
				</tr>
				<tr>
					<td><label> Choose vehicle : </label></td>
					<td><input type="checkbox" name="vehicle" value="car">Car<input
						type="checkbox" name="vehicle" value="bike">Bike</td>
				</tr>



				<tr>
					<td><label> Select country : </label></td>
					<td><select name="country">
							<option value="India">INDIA</option>
							<option value="USA" selected="selected">USA</option>
							<option value="UK">United Kingdom</option>
					</select></td>
				</tr>

				<tr>
					<td><label> Select image : </label></td>
					<td><input type="file" name="image"></td>
				</tr>

				<tr>
					<td align="center"><input type="submit" value="Sign up"></td>
				</tr>

			</table>


		</form>

	</div>

</body>
</html>