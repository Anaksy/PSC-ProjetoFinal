package unibratec.controlequalidade.entidades;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "TB_LOTE")
@Entity

@NamedQuery(name="Lote.findByNome", query="Select l from Lote l where l.nomeLote like :nomeLote")
public class Lote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_LOTE")
	private long idLote;

	@Column(name = "NOME_LOTE", nullable = false)
	private String nomeLote;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_DE_VALIDADE_LOTE", nullable = true)
	private Calendar dataDeValidade;

	@Column(name = "QTD_PRODUTOS_LOTE", nullable = true)
	private int qtdProdutos;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADO_LOTE")
	private EstadoLoteEnum estadoLote;

	@SuppressWarnings("static-access")
	public Lote() {
		this.setNomeLote();
		this.setEstadoLote(estadoLote.ABERTO);
	}

	public String getNomeLote() {
		return nomeLote;
	}

	public void setNomeLote() {
		this.nomeLote = geraNomeLote();
	}

	public Calendar getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(Calendar dataDeValidade) {
		// Formatação da data fica a cargo da regra de negocio.
		this.dataDeValidade = dataDeValidade;
	}

	public int getQtdProdutos() {
		return qtdProdutos;
	}

	public void setQtdProdutos(int qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}

	public EstadoLoteEnum getEstadoLote() {
		return estadoLote;
	}

	public void setEstadoLote(EstadoLoteEnum estadoLote) {
		this.estadoLote = estadoLote;
	}

	//Método que gera o nome do lote.
	@SuppressWarnings("static-access")
	private String geraNomeLote(){
		String nomeLote = null;
		Calendar c = Calendar.getInstance();
		nomeLote = "LT" + c.get(c.YEAR) +  getNomeMesDeInt(c.get(c.MONTH)) + c.get(c.DAY_OF_MONTH) + 
				"-" + "T" +  String.valueOf(c.getTimeInMillis()).substring(7);
		return nomeLote; 		
	}

	//Método que "traduz" o número do mês na abreviação do mesmo.
	private String getNomeMesDeInt(int mes){
		String[] meses = {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEC"};
		return meses[mes];
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
