<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.helloabitante.model.Abitante"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conferma Modifiche</title>
</head>
<body>
<body>
<p>Abitante modificato:<p>
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
		<% Abitante abitanteDaServletModifica = (Abitante) request.getAttribute("abitanteModificato"); %>
				<tr>
					<td><%=abitanteDaServletModifica.getNome() %></td>
					<td><%=abitanteDaServletModifica.getCognome() %></td>
					<td><%=abitanteDaServletModifica.getCodiceFiscale() %></td>
					<td><%=abitanteDaServletModifica.getEta() %> </td>
					<td><%=abitanteDaServletModifica.getMottoDiVita() %></td>
				</tr>	
	</table>
</body>
</body>
</html>