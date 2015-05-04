package unibratec.controlequalidade.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Categoria.findByNome", query="Select c from Categoria c where c.nomeCategoria like :nome")

public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCategoria;
	private String nomeCategoria;
	private int numeroDeDiasParaVencimento;

	public Categoria() {
	}

	public Categoria(String nomeCategoria, int numeroDeDiasParaVencimento) {
		this.setNomeCategoria(nomeCategoria);
		this.setNumeroDeDiasParaVencimento(numeroDeDiasParaVencimento);
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public int getNumeroDeDiasParaVencimento() {
		return numeroDeDiasParaVencimento;
	}

	public void setNumeroDeDiasParaVencimento(int numeroDeDiasParaVencimento) {
		this.numeroDeDiasParaVencimento = numeroDeDiasParaVencimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeCategoria == null) ? 0 : nomeCategoria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (nomeCategoria == null) {
			if (other.nomeCategoria != null)
				return false;
		} else if (!nomeCategoria.equals(other.nomeCategoria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria: " + (this.getNomeCategoria())
				+ ", Número de dias para o vencimento: "
				+ (this.getNumeroDeDiasParaVencimento()) + ".";
	}

}
