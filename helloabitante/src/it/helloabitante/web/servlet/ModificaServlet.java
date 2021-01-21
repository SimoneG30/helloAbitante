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

@WebServlet("/ModificaServlet")
public class ModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;
		Integer etaDaModificareParsata = 0;
		Long idAbitanteDaModificareParsato = null;
		String etaDaModificareDefinitiva = null;
		String idDaModificareDefinitivo = null;
		String idAbitanteDaModificare = request.getParameter("idAbitante");
		String nomeDaModificare = request.getParameter("nomeInput");
		String cognomeDaModificare = request.getParameter("cognomeInput");
		String codiceFiscaleDaModificare = request.getParameter("codiceFiscaleInput");
		String etaDaModificare = request.getParameter("etaInput");
		String mottoDaModificare = request.getParameter("mottoInput");
		if (!etaDaModificare.isEmpty()) {
			etaDaModificareParsata = Integer.parseInt(etaDaModificare);
			etaDaModificareDefinitiva = etaDaModificareParsata.toString();
		}
		
		if (!idAbitanteDaModificare.isEmpty()) {
			idAbitanteDaModificareParsato = Long.parseLong(idAbitanteDaModificare);
			idDaModificareDefinitivo = idAbitanteDaModificareParsato.toString();
		}
		
		destinazione = "searchForm.jsp";

		try {
			if (!etaDaModificare.isEmpty()) {
				//mi carico abitante grazie ad id
				Abitante abitanteAggiornato =  MyServiceFactory.getAbitanteServiceInstance().prendiUnoDaId(idAbitanteDaModificareParsato);
				//con l-abitante caricato faccio il set di tutti i campi visibili nel form
				abitanteAggiornato.setNome(nomeDaModificare);
				abitanteAggiornato.setCognome(cognomeDaModificare);
				abitanteAggiornato.setCodiceFiscale(codiceFiscaleDaModificare);
				abitanteAggiornato.setEta(etaDaModificareParsata);
				abitanteAggiornato.setMottoDiVita(mottoDaModificare);
				//a quel punto posso passare l-oggetto in questione al modifica del service
				request.setAttribute("abitanteModificato", MyServiceFactory.getAbitanteServiceInstance().modificaAbitante(abitanteAggiornato));
			
			} else {
				
				Abitante abitanteAggiornato =  MyServiceFactory.getAbitanteServiceInstance().prendiUnoDaId(idAbitanteDaModificareParsato);
				abitanteAggiornato.setNome(nomeDaModificare);
				abitanteAggiornato.setCognome(cognomeDaModificare);
				abitanteAggiornato.setCodiceFiscale(codiceFiscaleDaModificare);
				abitanteAggiornato.setMottoDiVita(mottoDaModificare);
				request.setAttribute("abitanteModificato", MyServiceFactory.getAbitanteServiceInstance().modificaAbitante(abitanteAggiornato));
			}
			String updateRiuscito = "Campi modificati correttamente";
			request.setAttribute("updateRiuscito", updateRiuscito);
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
