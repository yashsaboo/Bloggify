<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Comment</title>
</head>
<body>
<% 
		HttpSession checkSession = request.getSession(false);
		String username = (String)checkSession.getAttribute("username");
		
		if (username == null)
			response.sendRedirect("WEB-INF/login.jsp");
	%>

<form name="form" action="displayComments.html" method="get">

<p>You can post comments comments here.</p>

<input type="text" name="commentdata" id="comnt" align="left" required="required"><br><br>
<input type="submit" value="Post Comment" >

</form>


</body>
</html>