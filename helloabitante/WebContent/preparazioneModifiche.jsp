<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento modifiche abitante</title>
</head>
<body style = "background-color:lightblue; font-family: Segoe UI,Frutiger,Frutiger Linotype,Dejavu Sans,Helvetica Neue,Arial,sans-serif;">
<center>
	<% if(request.getAttribute("messaggioDiErrore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
	<%  } else { %>
		Inserire dati da modificare<br>
	<%}    %>
	<% Abitante abitanteInPagina = (Abitante)request.getAttribute("abitanteAttributeModifica"); %>
	<form action="ModificaServlet" method="post">
		<label for="nomeInputId">NOME:</label><br>
		<input type="text" name="nomeInput" id="nomeInputId" value="<%=abitanteInPagina.getNome()%>">
		<br>
		<label for="cognomeInputId">COGNOME:</label><br>
		<input type="text" name="cognomeInput" id="cognomeInputId" value="<%=abitanteInPagina.getCognome()%>">
		<br>
		<label for="codiceFiscaleInputId">CODICE FISCALE:</label><br>
		<input type="text" name="codiceFiscaleInput" id="codiceFiscaleInputId" value="<%=abitanteInPagina.getCodiceFiscale()%>">
		<br>
		<label for="etaInputId">ETA:</label><br>
		<input type="text" name="etaInput" id="etaInputId" value="<%=abitanteInPagina.getEta()%>">
		<br>
		<label for="mottoInputId">MOTTO:</label><br>
		<input type="text" name="mottoInput" id="mottoInputId" value="<%=abitanteInPagina.getMottoDiVita()%>">
		<br>
		<br><input type="hidden" name="idAbitante" value="<%=abitanteInPagina.getIdAbitante()%>">
		<input type="submit" value="Conferma">
	</form>
	<center>
	
</body>
</html>