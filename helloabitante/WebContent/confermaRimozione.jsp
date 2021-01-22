<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="it.helloabitante.model.Abitante"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conferma rimozione</title>

</head>
<body style = "font-family: Segoe UI,Frutiger,Frutiger Linotype,Dejavu Sans,Helvetica Neue,Arial,sans-serif;">
	<center>
	<h1 style="color:red;">Attenzione! questa azione non può essere annullata</h1>
		<h3>Sei sicuro di voler elminare questo utente?</h3>
		<br>
		<%
		Abitante abitanteDaRimuovereInPagina = (Abitante) request.getAttribute("abitanteDaEliminare");
		%>
		<b>Nome: </b><i><%=abitanteDaRimuovereInPagina.getNome() %></i><br>
		<b>Cognome: </b><i><%=abitanteDaRimuovereInPagina.getCognome() %></i>
			<form action="RimozioneServlet" method="post">
		<br><input type="hidden" name="idAbitanteRimozione" value="<%=abitanteDaRimuovereInPagina.getIdAbitante()%>">
				<input type="submit" value="Conferma">
		
		<center>
</body>
</html>