package unibratec.controlequalidade.dao;

import unibratec.controlequalidade.entidades.Categoria;
import unibratec.controlequalidade.exceptions.CategoriaCadastradaException;

public interface IDAOCategoria extends IDAOGenerico<Categoria> {
	
	 public void consultaExisteCategoria(String categoria) throws CategoriaCadastradaException;
	
	//public boolean consultarCategoriaExistente(String categoria);

}
