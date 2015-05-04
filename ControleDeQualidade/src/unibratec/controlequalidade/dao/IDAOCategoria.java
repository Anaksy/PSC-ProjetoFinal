package unibratec.controlequalidade.dao;

import javax.persistence.NoResultException;

import unibratec.controlequalidade.entidades.Categoria;

public interface IDAOCategoria extends IDAOGenerico<Categoria> {
	
	public boolean consultarCategoriaExistente(String categoria) throws NoResultException;

}
