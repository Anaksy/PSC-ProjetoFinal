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
	 * @param Nome da Categoria
	 *  
	 * @return true/false
	 */
	@Override
	public boolean consultarCategoriaExistente(String nome) throws NoResultException{

		TypedQuery<Categoria> query = this.entityManager.createNamedQuery(NAMED_QUERY_BYNOME, this.classePersistente);
		query.setParameter("nome", "%" + nome + "%");

		try {
			if (!query.setMaxResults(1).getSingleResult().equals(null)) {

				//System.out.println("Categoria ENCONTRADA");
				return true;

			}else {

				System.out.println("Categoria NÃO ENCONTRADA");
				return false;
			}

		} catch (NoResultException e) {
			e.printStackTrace();
			throw new NoResultException(e.getMessage());
		}

	}

}
