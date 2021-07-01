<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<sql:query var="rs" dataSource="jdbc/sakila">
	select * from actor where actor_id = ?
	<sql:param value = "${param.id}" />
</sql:query>

<html>
  <head>
    <title>Datasource Update</title>
  </head>
  <style>
	table {
		border-spacing: 0;
	}
	td, th {
		padding: 4px;
		border: 1px solid black;
	}
	.inline {
		display: flex;
		padding: 4px;
	}
	.inline > label {
		width: 120px;
	}
	.incol {
		display: flex;
		flex-direction: column;
	}
</style>
  <body>
  	<h2>Aggiornamento</h2>
	<c:forEach var="row" items="${rs.rows}">
	  	<form action="./update" method="post"> 
	        <input type="hidden" name="id" value="${row.actor_id}"/>
	        <div class="inline">
				<label for="firstName">Nome: </label><input type="text" name="firstName" value="${row.first_name}" />
			</div>
			<div class="inline">
				<label for="lastName">Cognome: </label><input type="text" name="lastName" value="${row.last_name}" />
			</div>
			<div class="inline">
				<input type="submit" value="Aggiorna"/>
			</div>
			<a href="./">
				<input type="button" value="Go to index" />
			</a>
	    </form>
	</c:forEach>
  </body>
</html>