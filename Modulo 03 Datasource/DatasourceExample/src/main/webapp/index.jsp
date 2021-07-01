<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<sql:query var="rs" dataSource="jdbc/sakila">
select * from actor
</sql:query>

<html>
<head>
<title>Datasource Insert/Delete</title>
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

.inline>label {
	width: 120px;
}

.incol {
	display: flex;
	flex-direction: column;
}
</style>
</head>
<body>
	<h2>Inserimento</h2>
	<form class="incol" action="./insert" method="post">
		<div class="inline">
			<label for="nome">Id: </label><input type="text" name="id" />
		</div>
		<div class="inline">
			<label for="cognome">Nome: </label><input type="text"
				name="firstName" />
		</div>
		<div class="inline">
			<label for="settore">Cognome: </label><input type="text"
				name="lastName" />
		</div>
		<div class="inline">
			<input type="submit" value="Inserisci" />
		</div>
	</form>

	<h2>Risultati</h2>

	<table>
		<tbody>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Comandi</th>
			</tr>
			<c:forEach var="row" items="${rs.rows}">
				<tr>
					<td>${row.actor_id}</td>
					<td>${row.first_name}</td>
					<td>${row.last_name}</td>
					<td>
						<div class="inline">
							<form action="./update">
								<input type="hidden" value="${row.actor_id}" name="id" /> <input
									type="submit" value="Update" />
							</form>
							<form action="./delete" method="post">
								<input type="hidden" value="${row.actor_id}" name="id" /> <input
									type="submit" value="Delete" />
							</form>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>