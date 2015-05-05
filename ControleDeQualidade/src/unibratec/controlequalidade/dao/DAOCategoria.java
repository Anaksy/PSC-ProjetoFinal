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
	
	  public void excluir(Long id) {

		    EntityManager entityManager = getEntityManager();

		    try {

		      // Inicia uma transação com o banco de dados.

		      entityManager.getTransaction().begin();

		      // Consulta a pessoa na base de dados através do seu ID.

		      Categoria ct = entityManager.find(Categoria.class, id);

		      //System.out.println("Excluindo os dados de: " + ct.get);

		      // Remove a pessoa da base de dados.

		      entityManager.remove(ct);

		      // Finaliza a transação.

		      entityManager.getTransaction().commit();

		    } finally {

		      entityManager.close();

		    }

		  }

}
