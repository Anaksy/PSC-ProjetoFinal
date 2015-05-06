package unibratec.controlequalidade.negocio;

import java.util.Calendar;

import javax.persistence.EntityManager;

import unibratec.controlequalidade.dao.DAOProduto;
import unibratec.controlequalidade.dao.IDAOProduto;
import unibratec.controlequalidade.entidades.EstadoLoteEnum;
import unibratec.controlequalidade.entidades.EstadoProdutoEnum;
import unibratec.controlequalidade.entidades.Lote;
import unibratec.controlequalidade.entidades.Produto;
import unibratec.controlequalidade.exceptions.dataDeValidadeMenorPermitidaCategoriaException;
import unibratec.controlequalidade.util.Funcoes;

public class NegocioProdutoLote {

	//Metodo que concluir o fluco de cria��o de um produto/lote
	public void associaLoteProduto(Lote lote, Produto produto, Calendar dataValidadeLote, int qtdProdutosLote) throws dataDeValidadeMenorPermitidaCategoriaException{
		Calendar dataAtual = Calendar.getInstance();
		
		//Validando data de validade inserida
		if (Funcoes.subtrairDiasDataCalendar(dataAtual, dataValidadeLote) <= produto.getCategoriaProduto().getNumeroDeDiasParaVencimento()) {
			throw new dataDeValidadeMenorPermitidaCategoriaException("Data de validade inserida menor que a permitida para essa categoria");
		}
		lote.setDataDeValidade(dataValidadeLote);
		lote.setQtdProdutos(qtdProdutosLote);
		produto.setLoteProduto(lote);
		lote.setEstadoLote(EstadoLoteEnum.FECHADO);
	}
}
