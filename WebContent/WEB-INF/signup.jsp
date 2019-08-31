<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/signupstyle.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>New One</title>
</head>
<body>
	<div id="nav">
		<p>New One!</p><br>
		<form action="SignupController" method="post">
			<input type="text" name="fName" placeholder="First Name" required="required">
			<input type="text" name="lName" placeholder="Last Name" required="required"><br>
			<input type="text" name="email" placeholder="Email" required="required"><br>
			<input type="password" name="password" placeholder="Enter Password " maxlength="10" required pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" title="Uppercase Lowercase Numbers">
			<input type="password" name="repassword" placeholder="Re-Enter Password" required="required"><br>
			<input type="submit" name="signup" value="Join">
		</form>
	</div>
</body>
</body>
</html>