package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {

	private AbitanteDAO abitanteDAO;

	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) {
		// abitanteDAO.setConnection(MyConnection.getConnection());
		return abitanteDAO.findByNomeAndCognome(nome, cognome);
	}

	@Override
	public List<Abitante> listaAbitanti() throws Exception {
		return abitanteDAO.list();

	}

	@Override
	public Abitante prendiUnoDaId(Long id) throws Exception {
		return abitanteDAO.get(id);

	}

	@Override
	public int modificaAbitante(Abitante abitanteInput) throws Exception {
		abitanteDAO.update(abitanteInput);
		return 1;
	}

	@Override
	public int aggiungiAbitante(Abitante abitanteInput) throws Exception {
		abitanteDAO.insert(abitanteInput);
		return 1;
	}

	@Override
	public int eliminaAbitante(Abitante abitanteInput) throws Exception {
		abitanteDAO.delete(abitanteInput);
		return 1;
	}

}
