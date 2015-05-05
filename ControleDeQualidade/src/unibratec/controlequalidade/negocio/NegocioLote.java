package unibratec.controlequalidade.negocio;

import javax.persistence.EntityManager;
import unibratec.controlequalidade.dao.DAOLote;
import unibratec.controlequalidade.dao.IDAOLote;
import unibratec.controlequalidade.entidades.Lote;
import unibratec.controlequalidade.exceptions.ContateOAdministradorException;
import unibratec.controlequalidade.exceptions.LoteCadastradoException;

public class NegocioLote {

	private IDAOLote daoLote;

	public NegocioLote(EntityManager em) {
		this.daoLote = new DAOLote(em);
	}

	// Método que gera um lote e verifica se nome gerado já existe no sistema.
	// O nome do lote é criado automaticamente através do método geraNomeLote(),
	// que garante um nome único, porém caso mesmo assim um mesmo nome já se
	// encontre cadastrado na base de dados, uma exceção será levantada.

	public void gerarLote(Lote lote) {

		try {
			daoLote.consultarLoteExistente(lote.getNomeLote()); 
			daoLote.inserir(lote);

		} 
		catch (LoteCadastradoException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			lote.setNomeLote();
			System.out.println("Alterando nome do lote para inserção na base de dados.");
			daoLote.inserir(lote);
		}
	}


}


