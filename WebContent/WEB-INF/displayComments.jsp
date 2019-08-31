<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Comments</title>
</head>
<body>

<pre> 
    <c:forEach items="${comments123}" var="comment_data">
    <c:out value="${comment_data.getCommentdata()}"></c:out>
    </c:forEach>
</pre><br><br>

</body>
</html>