<%@page import="com.nc.Bloggify.dto.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css'>
  	<link rel="stylesheet" type="text/css" href="css/profilestyle.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>About Me</title>
</head>
<body>
	<% 
		HttpSession checkSession = request.getSession(false);
		String username = (String)checkSession.getAttribute("username");
	
		if (username == null)
			response.sendRedirect("WEB-INF/login.jsp");
	%>
	<div class="container">
	  <header>
	   <h1>Bloggify</h1>
	    <nav>
	      <ul id="nav">
	        <li><a href="home.html" class="homered">HOME</a></li>
	      </ul> 
	    </nav>
	  </header>
	 </div>

	<main>
	    <div class="row">
	      	<div class="left col-lg-4">
	      		<h4 class="fname"><% String name = (String)request.getAttribute("user");
	      								out.print(name);
	      						   %></h4>
	        	<p class="info"><% out.print(username); %></p>
	        	<p class="claps">Claps count : <% out.print((String)request.getAttribute("claps")); %><span></span></p>
	        	
		       	<a href="newpost.html">
		       		<button type="submit" onclick="http://www.google.co.in" class="button" style="vertical-align: middle;"><span>New!</span></button>
		       	</a>
	    	</div>
		</div>
	</main>
	<div class="list">
			<ul>
				<c:forEach items="${getArticleTitle}" var="article">
					<li>
							<form method="get" action="articleDisplay.html">
								<h2><c:out value="${article.getTitle()}"></c:out></h2>
								<input type="hidden" value="${article.getTitle()}" name="articletitle"> 
								<span><input type="submit" value="Read" class="read"></span>
							</form>
					</li>
				</c:forEach>
			</ul>
			<br>
	</div>
</body>
</html>