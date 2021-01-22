<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.helloabitante.model.Abitante"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

	th, td {
	  padding: 10px;
	}
	.center {
		margin-left: auto;
		margin-right: auto;
	}
</style>
</head>
<body style = "font-family: Segoe UI,Frutiger,Frutiger Linotype,Dejavu Sans,Helvetica Neue,Arial,sans-serif;">
	<table class="center">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Codice Fiscale</th>
				<th>Età</th>
				<th>Motto</th>
			</tr>
		</thead>
		<% Abitante abitanteDaServlet = (Abitante) request.getAttribute("abitanteAttributeNameDettaglio"); %>
				<tr>
					<td><%=abitanteDaServlet.getNome() %></td>
					<td><%=abitanteDaServlet.getCognome() %></td>
					<td><%=abitanteDaServlet.getCodiceFiscale() %></td>
					<td><%=abitanteDaServlet.getEta() %> </td>
					<td><%=abitanteDaServlet.getMottoDiVita() %></td>
				</tr>	
	</table>
</body>
</html>