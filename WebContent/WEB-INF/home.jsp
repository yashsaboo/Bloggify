<%@page import="java.util.List"%>
<%@page import="com.nc.Bloggify.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/homestyle.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home</title>
</head>
<body>
	<% 
		HttpSession checkSession = request.getSession(false);
		String username = (String)checkSession.getAttribute("username");
		
		if (username == null)
			response.sendRedirect("WEB-INF/login.jsp");
		HttpSession readSession = null;
		
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
				<li><a href="logout.html">Logout</a></li>
			</ul>	
		</nav>
	</header>
	<div class="divider"></div>

	<div class="section">
		<ul class="grid">
		
			<c:forEach items="${getArticleTitle}" var="article">
				<li>
					<div class="box article-one">
						<form method="get" action="articleDisplay.html">
							<h3>Article</h3>
							<h2 ><c:out value="${article.getTitle()}"></c:out></h2>
							<input type="hidden" value="${article.getTitle()}" name="articletitle"> 
							<span><input type="submit" value="Read" class="read"></span>
						</form>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>