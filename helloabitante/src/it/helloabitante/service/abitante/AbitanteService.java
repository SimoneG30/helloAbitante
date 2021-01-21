package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteService {
	public void setAbitanteDAO(AbitanteDAO abitanteDAO);
	
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) throws Exception;
	public List<Abitante> listaAbitanti() throws Exception;
	public Abitante prendiUnoDaId(Long id) throws Exception;
	public int modificaAbitante(Abitante abitanteInput) throws Exception;
	public int aggiungiAbitante(Abitante abitanteInput) throws Exception;
	public int eliminaAbitante(Abitante abitanteInput) throws Exception;
}
