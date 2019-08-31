<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css'>
  	<link rel="stylesheet" href="css/newpoststyle.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Post</title>
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
	        <li><a href="about.html" class="homeblack">ABOUT ME</a></li>
	        <li>
	        <form action="#">
	          <input type="text" placeholder="Search..." maxlength="20" id="search">
	          <input type="submit" value="Find!" id="submit">
	        </form></li> 
	      </ul> 
	    </nav>
	  </header>
	
	
	  <main>
	    <div class="row">
	      <div class="newpost">
	        <p id="heading">ENTER YOUR THOUGHTS!</p>
	        
	        <br>
	          <form method="get" action="newpost-success.html">
	          	<input class="title" type="text" name="title" placeholder="Enter the Title" size="120">
	          	<textarea name="postArea" cols="120" rows="25" maxlength="4000" required="required"></textarea>
	           <!--  <div class="categories">
		            <input type="radio" name="category" value="Technology">Technology
		            <input type="radio" name="category" value="Lifestyle">Lifestyle
		            <input type="radio" name="category" value="Social">Social
		            <input type="radio" name="category" value="Fiction">Fiction 
	   			</div> -->
	          	<button class="button" type="submit" style="vertical-align: middle;"><span>Post it!</span></button>
	          </form> 
	      </div>
	  </main>
	</div>
</body>
</html>