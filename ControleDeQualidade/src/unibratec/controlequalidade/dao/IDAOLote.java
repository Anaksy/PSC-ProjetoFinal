package unibratec.controlequalidade.dao;

import unibratec.controlequalidade.entidades.Lote;
import unibratec.controlequalidade.exceptions.LoteCadastradoException;

public interface IDAOLote extends IDAOGenerico<Lote> {
	
	public void consultarLoteExistente(String lote) throws LoteCadastradoException;

}
