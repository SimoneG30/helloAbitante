<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo utente</title>
</head>
<body style = "background-color:lightblue; font-family: Segoe UI,Frutiger,Frutiger Linotype,Dejavu Sans,Helvetica Neue,Arial,sans-serif;">
<center>
	<% if(request.getAttribute("messaggioDiErrore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
	<%  } else { %>
		Inserire i nuovi dati<br>
	<%}    %>
	<form action="AggiuntaServlet" method="post">
		<label for="nomeInputId">NOME:</label><br>
		<input type="text" name="nomeInput" id="nomeInputId">
		<br>
		<label for="cognomeInputId">COGNOME:</label><br>
		<input type="text" name="cognomeInput" id="cognomeInputId">
		<br>
		<label for="codiceFiscaleInputId">CODICE FISCALE:</label><br>
		<input type="text" name="codiceFiscaleInput" id="codiceFiscaleInputId">
		<br>
		<label for="etaInputId">ETA:</label><br>
		<input type="text" name="etaInput" id="etaInputId">
		<br>
		<label for="mottoInputId">MOTTO:</label><br>
		<input type="text" name="mottoInput" id="mottoInputId">
		<br>
		<br><input type="hidden" name="idAbitante">
		<input type="submit" value="Conferma">
	</form>
	<center>
	
</body>
</html>