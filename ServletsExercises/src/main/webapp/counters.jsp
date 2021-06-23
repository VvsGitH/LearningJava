<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="charset=UTF-8">
<title>Counters</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h2>Counter1: <c:out value="${requestScope.counter1}"></c:out></h2>
	<h2>Counter2: <c:out value="${requestScope.counter1}"></c:out></h2>
</body>
</html>