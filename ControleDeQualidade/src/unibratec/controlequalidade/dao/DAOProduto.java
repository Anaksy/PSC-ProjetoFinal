package unibratec.controlequalidade.dao;

import javax.persistence.EntityManager;
import unibratec.controlequalidade.entidades.Produto;

public class DAOProduto extends DAOGenerico<Produto> implements IDAOProduto {

	public DAOProduto(EntityManager em) {
		super(em);
	}

}
