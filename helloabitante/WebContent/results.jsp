<%@page import="java.util.List"%>
<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina dei risultati</title>
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
<center>
<body style = "background-color:lightblue; font-family: Segoe UI,Frutiger,Frutiger Linotype,Dejavu Sans,Helvetica Neue,Arial,sans-serif;">
	<table class="center">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Azione</th>
			</tr>
		</thead>

		<%
		List<Abitante> listaDaServlet = (List<Abitante>) request.getAttribute("listAbitantiAttributeName");
		for (Abitante abitanteItem : listaDaServlet) {
		%>
		<tr>
			<td><%=abitanteItem.getNome()%></td>
			<td><%=abitanteItem.getCognome()%></td>
			<td><a
				href="VisualizzaDettaglioServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante()%>">Dettaglio</a>
				<a
				href="PreparaModificaServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante()%>">Modifica</a>
				<a
				href="PreparaRimozioneServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante()%>">Rimuovi</a>
			</td>
		</tr>
		<%
		}
		%>

	</table>
	<br>
	<a href="PreparaAggiuntaServlet">Nuovo abitante</a>
			</td>
</center>
</body>
</html>