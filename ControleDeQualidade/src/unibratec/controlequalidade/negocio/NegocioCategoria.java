package unibratec.controlequalidade.negocio;

import javax.persistence.EntityManager;

import unibratec.controlequalidade.dao.DAOCategoria;
import unibratec.controlequalidade.dao.IDAOCategoria;
import unibratec.controlequalidade.entidades.Categoria;
import unibratec.controlequalidade.exceptions.CategoriaCadastradaException;

public class NegocioCategoria {

	private IDAOCategoria daoCategoria;

	public NegocioCategoria(EntityManager em) {
		this.daoCategoria = new DAOCategoria(em);
	}

	public void inserirCategoria(Categoria categoria) { 

		try {

			daoCategoria.consultaExisteCategoria(categoria.getNomeCategoria());

			daoCategoria.inserir(categoria);

		} catch (CategoriaCadastradaException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());

		}





		//		try {
			//
			//			if (daoCategoria.consultarCategoriaExistente(categoria.getNomeCategoria()) == true) {
		//				
		//				throw new CategoriaCadastradaException("Categoria já cadastrada no sistema.");
		//			
		//			} else {
		//				
		//				daoCategoria.inserir(categoria);
		//			}
		//			
		//		} catch (CategoriaCadastradaException e) {
		//
		//			e.printStackTrace();
		//			System.out.println(e.getMessage());
		//
		//		}
	}
}