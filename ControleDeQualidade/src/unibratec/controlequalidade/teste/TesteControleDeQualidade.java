package unibratec.controlequalidade.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import unibratec.controlequalidade.dao.DAOCategoria;
import unibratec.controlequalidade.dao.DAOLote;
import unibratec.controlequalidade.dao.DAOProduto;
import unibratec.controlequalidade.entidades.Categoria;
import unibratec.controlequalidade.entidades.EstadoProdutoEnum;
import unibratec.controlequalidade.entidades.Lote;
import unibratec.controlequalidade.entidades.Produto;
import unibratec.controlequalidade.exceptions.CategoriaCadastradaException;
import unibratec.controlequalidade.negocio.NegocioCategoria;

public class TesteControleDeQualidade {

	public static void main(String[] args) {
		//############# ENTITY MANAGER ############# 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("controleDeQualidadePSC");
		EntityManager etManager = emf.createEntityManager(); 
		//############# ENTITY MANAGER #############

		//############# CATEGORIA #############
		Categoria c0 = new Categoria("laticínios", 15);
		Categoria c1 = new Categoria("Pedro", 30);
		//System.out.println(c0);


		/*
		DAOCategoria daoCategoria= new DAOCategoria(etManager);
		daoCategoria.inserir(c0);
		//############# CATEGORIA #############

		//############# LOTE #############
		Calendar cl0 = Calendar.getInstance();
		cl0.set(2018, 12, 10);
		Lote l0 = new Lote("pt00", cl0);
		System.out.println(l0);

		DAOLote daoLote = new DAOLote(etManager);
		daoLote.inserir(l0);
		//############# LOTE #############

		//############# PRODUTO #############
		Produto p0 = new Produto("Toddynho", "Pepsico", c0, 1.50, l0, EstadoProdutoEnum.EM_ESTOQUE);
		System.out.println(p0);

		DAOProduto daoProduto = new DAOProduto(etManager);
		daoProduto.inserir(p0);
		//############# PRODUTO #############
		 */

		NegocioCategoria nc = new NegocioCategoria(etManager);

		try {
			
			nc.inserirCategoria(c1);
			
		} catch (CategoriaCadastradaException e) {

			System.out.println(e.getMessage());
		}
		

	}

}
