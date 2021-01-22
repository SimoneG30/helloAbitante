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

@WebServlet("/RimozioneServlet")
public class RimozioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RimozioneServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;
		String idAbitanteDaEliminare = request.getParameter("idAbitanteRimozione");
		Long idAbitanteDaModificareParsato = null;
		try {
			if (!idAbitanteDaEliminare.isEmpty()) {
				idAbitanteDaModificareParsato = Long.parseLong(idAbitanteDaEliminare);
				Abitante abitanteDaEliminare =  MyServiceFactory.getAbitanteServiceInstance().prendiUnoDaId(idAbitanteDaModificareParsato);
				request.setAttribute("abitanteEliminato", MyServiceFactory.getAbitanteServiceInstance().eliminaAbitante(abitanteDaEliminare));
				destinazione = "searchForm.jsp";
				String rimozioneRiuscita = "Abitante rimosso correttamente";
				request.setAttribute("rimozioneRiuscita", rimozioneRiuscita);
				RequestDispatcher rd = request.getRequestDispatcher(destinazione);
				rd.forward(request, response);
			}
			

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
