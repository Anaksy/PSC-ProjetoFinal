package unibratec.controlequalidade.negocio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import unibratec.controlequalidade.dao.DAOCategoria;
import unibratec.controlequalidade.dao.IDAOCategoria;
import unibratec.controlequalidade.entidades.Categoria;
import unibratec.controlequalidade.exceptions.CategoriaCadastradaException;

public class NegocioCategoria {

	private IDAOCategoria daoCategoria;

	public NegocioCategoria(EntityManager em) {
		this.daoCategoria = new DAOCategoria(em);
	}

	public void inserirCategoria(Categoria categoria) throws CategoriaCadastradaException { 

		try {

			if (daoCategoria.consultarCategoriaExistente(categoria.getNomeCategoria()) == true) {
				
				throw new CategoriaCadastradaException("ROLA NO CU DE PEDRO");
			}

		} catch (NoResultException e) {

			daoCategoria.inserir(categoria);

		} catch (CategoriaCadastradaException e) {

			throw new CategoriaCadastradaException(e.getMessage());
			
		} 

	}
}