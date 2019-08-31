<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/loginstyle.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome to Bloggify!</title>
</head>
<body>
	<div class="container">
		<img src="images/Circle.png">
		<div class="title">LOGIN</div>
		<form method="post" action="FrontController">
			<div class="form-login">
				<input type="text" name="username" placeholder="Enter Username">
			</div>
			<div class="form-login">
				<input type="password" name="password" placeholder="Enter Password">
			</div>
			<div class="form-button">
				<input type="submit" name="Login" value="Login" >
			</div>
		</form>
		<form action="signup.html">
			<div class="form-button">
				<input type="submit" name="Signup" value="Signup">			
			</div>
		</form>
	</div>
</body>
</html>