package unibratec.controlequalidade.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import unibratec.controlequalidade.dao.DAOCategoria;
import unibratec.controlequalidade.dao.DAOLote;
import unibratec.controlequalidade.dao.DAOProduto;
import unibratec.controlequalidade.entidades.Categoria;
import unibratec.controlequalidade.entidades.EstadoProdutoEnum;
import unibratec.controlequalidade.entidades.Lote;
import unibratec.controlequalidade.entidades.Produto;
import unibratec.controlequalidade.exceptions.ContateOAdministradorException;
import unibratec.controlequalidade.negocio.NegocioCategoria;
import unibratec.controlequalidade.negocio.NegocioLote;
import unibratec.controlequalidade.negocio.NegocioProduto;
import unibratec.controlequalidade.negocio.NegocioProdutoLote;
import unibratec.controlequalidade.negocio.NegocioVenda;

public class TesteControleDeQualidade {

	public static void main(String[] args) {
		//############# ENTITY MANAGER ############# 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("controleDeQualidadePSC");
		EntityManager etManager = emf.createEntityManager(); 
		//############# ENTITY MANAGER #############

//   ============================================================================================		
/*		//Simulando o comboBox de categoria previamente definidas
		Categoria c0 = new Categoria("Cosmetico", 30);
		NegocioCategoria negocioCategoria = new NegocioCategoria(etManager);
		negocioCategoria.inserirCategoria(c0);

		//Simulando o campo de data de validade
		Calendar cl0 = Calendar.getInstance();
		cl0.set(2020, 4, 10);

		//Simulando campo de quantidade de produtos
		int qtdProdutos = 200;

		Lote l0 = new Lote();
		Produto p0 = new Produto("Macarrão", "Pilar", c0, 1.50);

		NegocioProdutoLote npl = new NegocioProdutoLote();
		npl.associaLoteProduto(l0, p0, cl0, qtdProdutos);

		//Inserindo lote ja associado ao produto
		NegocioLote negocioLote = new NegocioLote(etManager);
		negocioLote.gerarLote(l0);

		//Inserindo produto ja associado ao lote
		NegocioProduto np = new NegocioProduto(etManager);
		np.inserirProduto(p0);
*/
	//============================================================================================

		//Teste de retorno da lista de produtos prestes a vencer
		
		NegocioVenda nv = new NegocioVenda(etManager);
		
		try {
			
			for (Produto p : nv.retornaListaProdutosPrestesAVencer()) {
				
				System.out.println(p.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
	//============================================================================================	
			
		
		

	}

}
