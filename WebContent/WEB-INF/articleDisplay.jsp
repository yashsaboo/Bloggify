<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/articlestyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Article</title>
</head>
<body>
	<% 
		HttpSession checkSession = request.getSession(false);
		String username = (String)checkSession.getAttribute("username");
		
		if (username == null)
			response.sendRedirect("WEB-INF/login.jsp");
	%>
	<header>
		<h1>Bloggify</h1>
		<nav>
			<ul id="nav">
				<li><a href="home.html" class="homered">HOME</a></li>
				<li><a href="about.html" class="homeblack">ABOUT ME</a></li>
				<li>
				<form action="#">
					<input type="text" placeholder="Search..." maxlength="20" id="search">
					<input type="submit" value="Find!" id="submit">
				</form></li> 
			</ul>	
		</nav>
	</header>
	<div class="divider"></div>

	<div class="container">	
		<div class="heading">
			<h2></h2>
		</div>
		<div class="subheading">
			<p class="subtitle"><span></span></p>
		</div>
		<br><br>
		<div class="data">
			<% 
				out.print(request.getAttribute("data"));
			%>
		</div>
		<br><br><br><br>
		<div class="clapbutton">
			<button><img src="images/clap.jpg"></button>
			<p class="count"></p>
		</div>
		
		<form action="Comment.html" method="get">
			<input type="submit" value="Comment">
		</form>
	</div>
</body>
</html>