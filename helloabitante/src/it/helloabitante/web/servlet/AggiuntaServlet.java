package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;

@WebServlet("/AggiuntaServlet")
public class AggiuntaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AggiuntaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;
		Integer etaDaAggiungereParsata = 0;
		Long idAbitanteDaAggiungereParsato = null;
		String etaDaAggiungereDefinitiva = null;
		String idDaAggiungereDefinitivo = null;
		String idAbitanteDaAggiungere = request.getParameter("idAbitante");
		String nomeDaAggiungere = request.getParameter("nomeInput");
		String cognomeDaAggiungere = request.getParameter("cognomeInput");
		String codiceFiscaleDaAggiungere = request.getParameter("codiceFiscaleInput");
		String etaDaAggiungere = request.getParameter("etaInput");
		String mottoDaAggiungere = request.getParameter("mottoInput");
		if (!etaDaAggiungere.isEmpty()) {
			etaDaAggiungereParsata = Integer.parseInt(etaDaAggiungere);
			etaDaAggiungereDefinitiva = etaDaAggiungereParsata.toString();
		}
		
		if (!idAbitanteDaAggiungere.isEmpty()) {
			idAbitanteDaAggiungereParsato = Long.parseLong(idAbitanteDaAggiungere);
			idDaAggiungereDefinitivo = idAbitanteDaAggiungereParsato.toString();
		}
		
		destinazione = "searchForm.jsp";

		try {
			if (!etaDaAggiungere.isEmpty()) {
				Abitante abitanteNuovo =  new Abitante();
				abitanteNuovo.setNome(nomeDaAggiungere);
				abitanteNuovo.setCognome(cognomeDaAggiungere);
				abitanteNuovo.setCodiceFiscale(codiceFiscaleDaAggiungere);
				abitanteNuovo.setEta(etaDaAggiungereParsata);
				abitanteNuovo.setMottoDiVita(mottoDaAggiungere);
				request.setAttribute("abitanteNuovo", MyServiceFactory.getAbitanteServiceInstance().aggiungiAbitante(abitanteNuovo));
			
			} else {
				
				Abitante abitanteNuovo =  new Abitante();
				abitanteNuovo.setNome(nomeDaAggiungere);
				abitanteNuovo.setCognome(cognomeDaAggiungere);
				abitanteNuovo.setCodiceFiscale(codiceFiscaleDaAggiungere);
				abitanteNuovo.setMottoDiVita(mottoDaAggiungere);
				request.setAttribute("abitanteNuovo", MyServiceFactory.getAbitanteServiceInstance().aggiungiAbitante(abitanteNuovo));
			}
			String aggiuntaRiuscita = "Nuovo utente aggiunto correttamente";
			request.setAttribute("aggiuntaRiuscita", aggiuntaRiuscita);
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
