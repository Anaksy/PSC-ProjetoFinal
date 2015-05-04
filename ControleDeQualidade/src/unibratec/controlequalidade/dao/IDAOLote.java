package unibratec.controlequalidade.dao;

import unibratec.controlequalidade.entidades.Lote;

public interface IDAOLote extends IDAOGenerico<Lote> {
	
	public boolean consultarLoteExistente(String lote);

}
