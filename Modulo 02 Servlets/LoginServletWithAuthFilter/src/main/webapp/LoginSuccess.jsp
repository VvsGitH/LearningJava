<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success Page</title>
</head>
<body>
<%
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies != null) {
	for (Cookie cookie: cookies) {
		if (cookie.getName().equals("user"))
			userName = cookie.getValue();
		if (cookie.getName().equals("JSESSIONID"))
			sessionID = cookie.getValue();
	}
}
%>
<h3>Hi <%=userName %>, Login successful. Your Session ID: <%=sessionID %></h3>
<br>
<a href="CheckoutPage.jsp">Checkout Page</a>
</body>
</html>