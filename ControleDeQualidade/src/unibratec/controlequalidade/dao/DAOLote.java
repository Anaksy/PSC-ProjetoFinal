package unibratec.controlequalidade.dao;

import javax.persistence.EntityManager;
import unibratec.controlequalidade.entidades.Lote;

public class DAOLote extends DAOGenerico<Lote> implements IDAOLote {

	public DAOLote(EntityManager em) {
		super(em);
	}
}
