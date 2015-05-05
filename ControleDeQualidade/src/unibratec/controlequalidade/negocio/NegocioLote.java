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

	// M�todo que gera um lote e verifica se nome gerado j� existe no sistema.
	// O nome do lote � criado automaticamente atrav�s do m�todo geraNomeLote(),
	// que garante um nome �nico, por�m caso mesmo assim um mesmo nome j� se
	// encontre cadastrado na base de dados, uma exce��o ser� levantada.

	public void gerarLote(Lote lote) throws ContateOAdministradorException {

		try {
			if (daoLote.consultarLoteExistente(lote.getNomeLote()) == true) {
	
				throw new LoteCadastradoException("Lote j� cadastrada no sistema.");

			} else {
				daoLote.inserir(lote);
			}

		} catch (LoteCadastradoException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			lote.setNomeLote();
			System.out.println("Alterando nome do lote para inser��o na base de dados.");
		}
	}


}


