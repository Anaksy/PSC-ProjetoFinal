package unibratec.controlequalidade.negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import unibratec.controlequalidade.dao.DAOProduto;
import unibratec.controlequalidade.entidades.EstadoProdutoEnum;
import unibratec.controlequalidade.entidades.Produto;
import unibratec.controlequalidade.exceptions.ProdutoNaoEncontradoExcecption;
import unibratec.controlequalidade.exceptions.ProdutoNaoPrestesAVencerException;

public class NegocioVenda {

	private DAOProduto daoProduto;

	public NegocioVenda(EntityManager em) {
		this.daoProduto = new DAOProduto(em);
	}
	
	// Método que retorna uma lista com o produtos prestes a vencer
	public List<Produto> retornaListaProdutosPrestesAVencer() throws ProdutoNaoEncontradoExcecption {

		List<Produto> produtosList = this.daoProduto.pesquisarProdutoPorEstadoList(EstadoProdutoEnum.EM_ESTOQUE);
		
		List<Produto> produtosPrestesAVencerList = new ArrayList<Produto>();
	
		Calendar dataAtual = Calendar.getInstance();
				
		for (Produto p : produtosList) {

			if ((subtrairDiasDataCalendar(dataAtual, p.getLoteProduto().getDataDeValidade()) <= p.getCategoriaProduto().getNumeroDeDiasParaVencimento())) {
				
				produtosPrestesAVencerList.add(p);
			}
		}
		
		return produtosPrestesAVencerList;
	}
	
	// Método que retorna uma produto prestes a vencer
	public Produto retornaProdutoPrestesAVencer(Produto produto) throws ProdutoNaoPrestesAVencerException, ProdutoNaoEncontradoExcecption {
		
		Produto p = this.daoProduto.pesquisarProdutoPorEstado(produto);
				
		Calendar dataAtual = Calendar.getInstance();
				
		if ((subtrairDiasDataCalendar(dataAtual, p.getLoteProduto().getDataDeValidade()) <= p.getCategoriaProduto().getNumeroDeDiasParaVencimento())) {
				
				return p;
				
		} else {
			
			throw new ProdutoNaoPrestesAVencerException("O produto não está prestes a vencer.");
		}

	}

	// Método que dar desconto no produto
	public void darDescontoProdutoPrestesAVencer(Produto produto, double desconto) {
		
		produto.setPrecoProduto(produto.getPrecoProduto() - desconto);
		
		daoProduto.alterar(produto);
	}

	// Método que retorna o resultado da subtração de duas datas
	private long subtrairDiasDataCalendar(Calendar primeiraDataCalendar, Calendar seundaDataCalendar){

		Date primeiraDataDate = primeiraDataCalendar.getTime();     
		Date segundaDataDate = seundaDataCalendar.getTime();     
		
		long resultado = segundaDataDate.getTime() - primeiraDataDate.getTime();     
		
		System.out.println("Diferenca em dias: " + (resultado/1000/60/60/24));     

		return resultado/1000/60/60/24;
	}

}
