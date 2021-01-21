package it.helloabitante.dao.abitante;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;

public class AbitanteDAOImpl implements AbitanteDAO {

	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Abitante> findByNomeAndCognome(String nome, String cognome) {
		List<Abitante> result = new ArrayList<>();

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getNome().startsWith(nome) && abitanteItem.getCognome().startsWith(cognome))
				result.add(abitanteItem);
		}
		return result;
	}

	@Override
	public List<Abitante> list() throws Exception {
		List<Abitante> result = new ArrayList<>();

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			result.add(abitanteItem);
		}
		return result;
	}

	@Override
	public Abitante get(Long id) throws Exception {
		Abitante result = new Abitante();

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getIdAbitante().equals(id))
				result = abitanteItem;
		}
		return result;
	}

	@Override
	public int update(Abitante input) throws Exception {
		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getIdAbitante().equals(input.getIdAbitante()))
				abitanteItem = input;

		}
		return 1;

	}

	@Override
	public int insert(Abitante input) throws Exception {
		List<Abitante> result = new ArrayList<>();
		result.add(input);
		return 1;
	}

	@Override
	public int delete(Abitante input) throws Exception {
		List<Abitante> result = new ArrayList<>();
		result.remove(input);
		return 1;
	}

}
