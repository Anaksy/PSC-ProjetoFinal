package unibratec.controlequalidade.entidades;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "TB_LOTE")
@Entity
public class Lote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLote;

	@Column(name = "NOME_LOTE", nullable = false)
	private String nomeLote;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_DE_VALIDADE_LOTE", nullable = false)
	private Calendar dataDeValidade;

	public Lote() {
	}

	public Lote(String nome, Calendar dataDeValidade) {
		this.setNomeLote(nome);
		this.setDataDeValidade(dataDeValidade);
	}

	public String getNomeLote() {
		return nomeLote;
	}

	public void setNomeLote(String nomeLote) {
		this.nomeLote = nomeLote;
	}

	public Calendar getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(Calendar dataDeValidade) {
		// Formatação da data fica a cargo da regra de negocio.
		this.dataDeValidade = dataDeValidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeLote == null) ? 0 : nomeLote.hashCode());
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
		Lote other = (Lote) obj;
		if (nomeLote == null) {
			if (other.nomeLote != null)
				return false;
		} else if (!nomeLote.equals(other.nomeLote))
			return false;
		return true;
	}

	@Override
	public String toString() {

		return "Nome do Lote: " + (this.getNomeLote()) + ", Data de validade: "
				+ (this.getDataDeValidade() + ".");
	}

}
