package unibratec.controlequalidade.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
	
	public static String theMonth(int month){
	    String[] monthNames = {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEC"};
	    return monthNames[month];
	}

	public static void main(String[] args) {
//		// ############# ENTITY MANAGER #############
//		EntityManagerFactory emf = Persistence
//				.createEntityManagerFactory("controleDeQualidadePSC");
//		EntityManager etManager = emf.createEntityManager();
//		// ############# ENTITY MANAGER #############
//
//		// ############# CATEGORIA #############
//		Categoria c0 = new Categoria("laticínios", 15);
//		Categoria c1 = new Categoria("Pedro", 30);
//		Categoria c2 = new Categoria("Wilkie", 501);
//		Categoria c3 = new Categoria("Chico", 20);
//		// System.out.println(c0);

		/*
		 * DAOCategoria daoCategoria= new DAOCategoria(etManager);
		 * daoCategoria.inserir(c0); //############# CATEGORIA #############
		 * 
		 * //############# LOTE ############# Calendar cl0 =
		 * Calendar.getInstance(); cl0.set(2018, 12, 10); Lote l0 = new
		 * Lote("pt00", cl0); System.out.println(l0);
		 * 
		 * DAOLote daoLote = new DAOLote(etManager); daoLote.inserir(l0);
		 * //############# LOTE #############
		 * 
		 * //############# PRODUTO ############# Produto p0 = new
		 * Produto("Toddynho", "Pepsico", c0, 1.50, l0,
		 * EstadoProdutoEnum.EM_ESTOQUE); System.out.println(p0);
		 * 
		 * DAOProduto daoProduto = new DAOProduto(etManager);
		 * daoProduto.inserir(p0); //############# PRODUTO #############
		 */
//
//		NegocioCategoria nc = new NegocioCategoria(etManager);
//
//		nc.inserirCategoria(c3);
		
//		Date hoje  = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		
//		
//		System.out.println( sdf.format(hoje));
//		System.out.println(sdf.format(hoje).replace("/", ""));
		
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		System.out.println("LT" + c.get(c.YEAR) +  theMonth(c.get(c.MONTH)) + c.get(c.DAY_OF_MONTH) + 
				"-" + "T" + c.get(c.HOUR) + c.get(c.MINUTE) +  String.valueOf(c.getTimeInMillis()).substring(8));

		
		//System.out.println(c.get(c.MONTH) +1);
		
//		2015MAI04-2126Segundos
//		[21:28:02] Wilkie Guedes: 2015MAI04-2126MiliSsegundos
		

		


		

	}

}
