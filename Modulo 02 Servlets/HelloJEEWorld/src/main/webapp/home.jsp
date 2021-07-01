<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>Home Page</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<style>
			table, th, td {
				border: 1px solid black;
			}
		</style>
	</head>
	
	<body>
		<%-- Using JSTL forEach and out per loop --%>
		<table>
			<tbody>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Role</th>
				</tr>
				<c:forEach items="${requestScope.impList}" var="imp">
					<tr>
						<td><c:out value="${imp.id}"></c:out></td>
						<td><c:out value="${imp.name}"></c:out></td>
						<td><c:out value="${imp.role}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br><br>
		
		<%-- Semplice if e out per l'output --%>
		<c:if test="${requestScope.htmlTagData != null}">
			<c:out value="${requestScope.htmlTagData}" escapeXml="true"></c:out>
		</c:if>
		
		<%-- c:set esempio di istanza di una variabile --%>
		<c:set var="id" value="5" scope="request"></c:set>
		<c:out value="${requestScope.id}"></c:out>
		<br><br>
	</body>
</html>