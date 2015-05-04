package unibratec.controlequalidade.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import unibratec.controlequalidade.entidades.Categoria;

public class DAOCategoria extends DAOGenerico<Categoria> implements
		IDAOCategoria {

	protected String NAMED_QUERY_BYNOME = "Categoria.findByNome";

	public DAOCategoria(EntityManager em) {
		super(em);
	}

	/**
	 * Verifica a existencia de uma categoria no banco de dados
	 * 
	 * @param Nome
	 *            da Categoria
	 * 
	 * @return true/false
	 */
	@Override
	public boolean consultarCategoriaExistente(String nome) {

		TypedQuery<Categoria> query = this.entityManager.createNamedQuery(
				NAMED_QUERY_BYNOME, this.classePersistente);
		query.setParameter("nome", "%" + nome + "%");

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
