package unibratec.controlequalidade.negocio;

import java.util.List;

import unibratec.controlequalidade.dao.DAOFactory;
import unibratec.controlequalidade.dao.IDAOCategoria;
import unibratec.controlequalidade.entidades.Categoria;
import unibratec.controlequalidade.exceptions.CategoriaCadastradaException;
import unibratec.controlequalidade.exceptions.CategoriaNaoCadastradaException;
import unibratec.controlequalidade.util.MensagensExceptions;

public class NegocioCategoria {

	private IDAOCategoria daoCategoria;

	public NegocioCategoria() {

		this.daoCategoria = DAOFactory.getCategoriaDAO();

	}

	/**
	 * M�todo para inserir uma Categoria
	 * 
	 * @param categoria
	 * @throws CategoriaCadastradaException
	 */
	public void inserirCategoria(Categoria categoria) throws CategoriaCadastradaException { 

		if (daoCategoria.existeCategoria(categoria)) {

			throw new CategoriaCadastradaException(MensagensExceptions.CATEGORIA_CADASTRADA_EXCEPTION);

		} else {

			daoCategoria.inserir(categoria);
		}
	}

	/**
	 * M�todo para listar todas as Categoria cadastradas na base
	 * 
	 * @return List<Categoria>
	 */
	public List<Categoria> listaTodasCategorias(){

		return daoCategoria.consultarTodos();
	}

	/**
	 * M�todo para buscar uma Categoria a partir de um nome. 
	 * 
	 * @param nomeCategoria
	 * @return
	 * @throws CategoriaNaoCadastradaException
	 */
	public Categoria buscaCategoriaPorNomeCategoria(String nomeCategoria) throws CategoriaNaoCadastradaException{

		Categoria cat = daoCategoria.buscaCategoria(nomeCategoria);

		if (cat != null) {

			return cat;

		} else {

			throw new CategoriaNaoCadastradaException(MensagensExceptions.CATEGORIA_NAO_CADASTRADA_EXCEPTION);
		}		
	}

	/**
	 *  M�todo para buscar uma Categoria por id. 
	 * 
	 * @param categoria
	 * @return
	 * @throws CategoriaNaoCadastradaException
	 */
	public Categoria buscaCategoriaPorId(long idCategoria) throws CategoriaNaoCadastradaException{

		Categoria cat = daoCategoria.consultarPorId(idCategoria);

		if (cat != null) {

			return cat;

		} else {

			throw new CategoriaNaoCadastradaException(MensagensExceptions.CATEGORIA_NAO_CADASTRADA_EXCEPTION);
		}		
	}

	/**
	 * M�todo para alterar nome e n�mero de dias para vencer de uma Categoria.
	 * 
	 * @param categoria
	 * @param novoNomeCategoria
	 * @param novoNumeroDeDiasParaVencimento
	 * @throws CategoriaCadastradaException
	 */
	public void alteraCategoria(Categoria categoria, String novoNomeCategoria, long novoNumeroDeDiasParaVencimento) throws CategoriaNaoCadastradaException, CategoriaCadastradaException{

		Categoria cat = daoCategoria.buscaCategoria(categoria.getNomeCategoria());

		if (cat != null) {

			cat.setNomeCategoria(novoNomeCategoria);
			cat.setNumeroDeDiasParaVencimento(novoNumeroDeDiasParaVencimento);

			if (daoCategoria.existeCategoria(cat)) {

				throw new CategoriaCadastradaException(MensagensExceptions.CATEGORIA_CADASTRADA_EXCEPTION);

			} else {

				daoCategoria.alterar(cat);
			}

		} else {

			throw new CategoriaNaoCadastradaException(MensagensExceptions.CATEGORIA_NAO_CADASTRADA_EXCEPTION);
		}

	}

	/**
	 * M�todo para alterar nome de uma Categoria.
	 * 
	 * @param categoria
	 * @param novoNomeCategoria
	 * @param novoNumeroDeDiasParaVencimento
	 * @throws CategoriaCadastradaException
	 * @throws CategoriaNaoCadastradaException 
	 */
	public void alteraNomeCategoria(Categoria categoria, String novoNomeCategoria) throws CategoriaCadastradaException, CategoriaNaoCadastradaException{

		Categoria cat = daoCategoria.buscaCategoria(categoria.getNomeCategoria());

		if (cat != null) {

			cat.setNomeCategoria(novoNomeCategoria);

			if (daoCategoria.existeCategoria(cat)) {

				throw new CategoriaCadastradaException(MensagensExceptions.CATEGORIA_CADASTRADA_EXCEPTION);

			} else {

				daoCategoria.alterar(cat);
			}

		} else {

			throw new CategoriaNaoCadastradaException(MensagensExceptions.CATEGORIA_NAO_CADASTRADA_EXCEPTION);
		}
	}

	/**
	 * M�todo para alterar o n�mero de dias para vencer de uma Categoria.
	 * 
	 * @param categoria
	 * @param novoNomeCategoria
	 * @param novoNumeroDeDiasParaVencimento
	 * @throws CategoriaCadastradaException
	 * @throws CategoriaNaoCadastradaException 
	 */
	public void alteraDiasParaVencerCategoria(Categoria categoria, long novoNumeroDeDiasParaVencimento) throws CategoriaCadastradaException, CategoriaNaoCadastradaException{

		Categoria cat = daoCategoria.buscaCategoria(categoria.getNomeCategoria());

		if (cat != null) {

			cat.setNumeroDeDiasParaVencimento(novoNumeroDeDiasParaVencimento);

			if (daoCategoria.existeCategoria(cat)) {

				throw new CategoriaCadastradaException(MensagensExceptions.CATEGORIA_CADASTRADA_EXCEPTION);

			} else {

				daoCategoria.alterar(cat);
			}

		} else {

			throw new CategoriaNaoCadastradaException(MensagensExceptions.CATEGORIA_NAO_CADASTRADA_EXCEPTION);
		}
	}

	/**
	 * M�todo para remover uma Categoria.
	 * 
	 * @param categoria
	 * @throws CategoriaNaoCadastradaException 
	 */
	public void removeCategoria(Categoria categoria) throws CategoriaNaoCadastradaException {

		Categoria cat = daoCategoria.buscaCategoria(categoria.getNomeCategoria());

		if (cat != null) {

			daoCategoria.remover(cat);

		} else {

			throw new CategoriaNaoCadastradaException(MensagensExceptions.CATEGORIA_NAO_CADASTRADA_EXCEPTION);
		}
	}
}