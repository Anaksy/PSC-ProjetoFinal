package unibratec.controlequalidade.dao;

import javax.persistence.EntityManager;
import unibratec.controlequalidade.entidades.Categoria;

public class DAOCategoria extends DAOGenerico<Categoria> implements
		IDAOCategoria {

	public DAOCategoria(EntityManager em) {
		super(em);
	}
}
