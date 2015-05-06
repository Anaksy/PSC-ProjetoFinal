package unibratec.controlequalidade.negocio;

import java.util.Calendar;

import unibratec.controlequalidade.entidades.EstadoLoteEnum;
import unibratec.controlequalidade.entidades.EstadoProdutoEnum;
import unibratec.controlequalidade.entidades.Lote;
import unibratec.controlequalidade.entidades.Produto;

public class NegocioProdutoLote {

	public void associaLoteProduto(Lote lote, Produto produto, Calendar dataValidadeLote, int qtdProdutosLote){
		lote.setDataDeValidade(dataValidadeLote);
		lote.setQtdProdutos(qtdProdutosLote);
		produto.setLoteProduto(lote);
		lote.setEstadoLote(EstadoLoteEnum.FECHADO);
	}
}
