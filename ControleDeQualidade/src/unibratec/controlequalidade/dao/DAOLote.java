package unibratec.controlequalidade.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import unibratec.controlequalidade.entidades.Categoria;
import unibratec.controlequalidade.entidades.Lote;

public class DAOLote extends DAOGenerico<Lote> implements IDAOLote {

	protected String NAMED_QUERY_BYNOME = "Lote.findByNome";
	
	public DAOLote(EntityManager em) {
		super(em);
	}


	/**
	 * Verifica a existencia de uma categoria no banco de dados
	 * 
	 * @param Nome do lote
	 * 
	 * @return true/false
	 */
	@Override
	public boolean consultarLoteExistente(String nomeLote) {
		TypedQuery<Lote> query = this.entityManager.createNamedQuery(
				NAMED_QUERY_BYNOME, this.classePersistente);
		query.setParameter("nomeLote", "%" + nomeLote + "%");

		try {
			if (!query.setMaxResults(1).getSingleResult().equals(null)) {

				return true;
			}

		} catch (NoResultException e) {
			e.printStackTrace();
			e.getMessage();

			return false;
			//throw new NoResultException(e.getMessage());
		}

		return false;
	}

}


