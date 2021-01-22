<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca abitante</title>
</head>
<body style = "font-family: Segoe UI,Frutiger,Frutiger Linotype,Dejavu Sans,Helvetica Neue,Arial,sans-serif;">
<center>
	<% if(request.getAttribute("messaggioDiErrore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
	<%  }else{ %>
		<h3>Inserire i dati da ricercare</h3>
		<br>
	<%}    %>
	<form action="SearchServlet" method="post">
		<label for="nomeInputId">NOME:</label><br>
		<input type="text" name="nomeInput" id="nomeInputId">
		<br>
		<br>
		<label for="cognomeInputId">COGNOME:</label><br>
		<input type="text" name="cognomeInput" id="cognomeInputId">
		<br><br>
		<input type="submit" value="CERCA">
	</form>
	<br>
<% if(request.getAttribute("updateRiuscito") != null) {%>
		<p style="color: red;"><%=request.getAttribute("updateRiuscito") %></p>
<%} %>
<% if(request.getAttribute("rimozioneRiuscita") != null) {%>
		<p style="color: red;"><%=request.getAttribute("rimozioneRiuscita") %></p>
<%} %>
<% if(request.getAttribute("aggiuntaRiuscita") != null) {%>
		<p style="color: red;"><%=request.getAttribute("aggiuntaRiuscita") %></p>
<%} %>
<br>
	<a href="PreparaAggiuntaServlet">Nuovo abitante</a>

</center>
</body>
</html>