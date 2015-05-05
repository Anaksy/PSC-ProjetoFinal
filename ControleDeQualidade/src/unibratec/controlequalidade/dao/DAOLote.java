package unibratec.controlequalidade.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import unibratec.controlequalidade.entidades.Categoria;
import unibratec.controlequalidade.entidades.Lote;
import unibratec.controlequalidade.exceptions.LoteCadastradoException;

public class DAOLote extends DAOGenerico<Lote> implements IDAOLote {

	protected String NAMED_QUERY_BYNOME = "Lote.findByNome";

	public DAOLote(EntityManager em) {
		super(em);
	}


	/**
	 * Verifica a existencia de um lote no banco de dados
	 * 
	 * @param Nome do lote
	 * 
	 * @return true/false
	 * @throws LoteCadastradoException 
	 */
	@Override
	public void consultarLoteExistente(String nomeLote) throws LoteCadastradoException {
		TypedQuery<Lote> query = this.entityManager.createNamedQuery(
				NAMED_QUERY_BYNOME, this.classePersistente);
		query.setParameter("nomeLote", "%" + nomeLote + "%");

		try {
			query.setMaxResults(1).getSingleResult();
			throw new LoteCadastradoException("Lote já cadastro no sistema.");

		} catch (NoResultException e) {
			e.printStackTrace();
			e.getMessage();
		}

	}

}


