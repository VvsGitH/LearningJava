<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="com.classes.Post, java.util.stream.Stream"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
	Post[] postList = (Post[]) request.getAttribute("posts");
	Stream<Post> posts = java.util.Arrays.stream(postList);
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>POSTS</title>
</head>
<body>
	<h1>POSTS</h1>
	<br>
	<div>		
		<c:forEach items="${posts}" var="post">
			<h3><c:out value="${post.getTitle()}"/></h3>
			<p><c:out value="${post.getBody()}"/></p>
			<hr>
		</c:forEach>
	</div>
</body>
</html>