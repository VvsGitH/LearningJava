<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%! private static final String DEFAULT_USER = "Guest"; %>
<%
	String user = request.getParameter("user");
	if(user == null)
		user = DEFAULT_USER;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello, <%= user %>!
	<br /><br />
	<form action="index.jsp" method="POST">
		Enter your name:<br />
		<input type="text" name="user" /><br />
		<input type="submit" value="Submit" />
	</form>
</body>
</html>