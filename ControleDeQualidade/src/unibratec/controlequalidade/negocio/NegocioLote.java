package unibratec.controlequalidade.negocio;

import javax.persistence.EntityManager;

import unibratec.controlequalidade.dao.DAOLote;
import unibratec.controlequalidade.dao.IDAOLote;
import unibratec.controlequalidade.entidades.Lote;
import unibratec.controlequalidade.exceptions.CategoriaCadastradaException;

public class NegocioLote {
	
	private IDAOLote daoLote;

	public NegocioLote(EntityManager em) {
		this.daoLote = new DAOLote(em);
	}

	public void inserirLote(Lote lote) { 

		try {

			if (daoLote.consultarLoteExistente(lote.getNomeLote()) == true) {
				
				throw new CategoriaCadastradaException("Lote já cadastrada no sistema.");
			
			} else {
				
				daoLote.inserir(lote);
			}
			
		} catch (CategoriaCadastradaException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());

		}
	}

}
