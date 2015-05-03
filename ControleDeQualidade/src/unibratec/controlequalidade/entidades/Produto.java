package unibratec.controlequalidade.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "TB_PRODUTO")
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProduto;

	@Column(name = "NOME_PRODUTO", nullable = false)
	private String nomeProduto;

	@Column(name = "FABRICANTE_PRODUTO", nullable = false)
	private String fabricanteProduto;

	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private Categoria categoriaProduto;

	@Column(name = "PRECO_PRODUTO", nullable = false)
	private double precoProduto;

	@ManyToOne
	@JoinColumn(name = "idLote")
	private Lote loteProduto;

	@Enumerated(EnumType.STRING)
	private EstadoProdutoEnum estadoProduto;

	public Produto() {
	}

	public Produto(String nome, String fabricante, Categoria categoria,
			double preco, Lote lote, EstadoProdutoEnum situacao) {

		this.setNomeProduto(nome);
		this.setFabricanteProduto(fabricante);
		this.setCategoriaProduto(categoria);
		this.setPrecoProduto(preco);
		this.setLoteProduto(lote);
		this.setEstadoProduto(situacao);
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getFabricanteProduto() {
		return fabricanteProduto;
	}

	public void setFabricanteProduto(String fabricanteProduto) {
		this.fabricanteProduto = fabricanteProduto;
	}

	public String getCategoriaProduto() {
		return categoriaProduto.getNomeCategoria();
	}

	public void setCategoriaProduto(Categoria categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getLoteProduto() {
		return loteProduto.getNomeLote();
	}

	public void setLoteProduto(Lote loteProduto) {
		this.loteProduto = loteProduto;
	}

	public EstadoProdutoEnum getEstadoProduto() {
		return estadoProduto;
	}

	public void setEstadoProduto(EstadoProdutoEnum estadoProduto) {
		this.estadoProduto = estadoProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((fabricanteProduto == null) ? 0 : fabricanteProduto
						.hashCode());
		result = prime * result
				+ ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
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
		Produto other = (Produto) obj;
		if (fabricanteProduto == null) {
			if (other.fabricanteProduto != null)
				return false;
		} else if (!fabricanteProduto.equals(other.fabricanteProduto))
			return false;
		if (nomeProduto == null) {
			if (other.nomeProduto != null)
				return false;
		} else if (!nomeProduto.equals(other.nomeProduto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto: " + (this.getNomeProduto()) + ", Marca: "
				+ (this.getFabricanteProduto()) + ", Categoria: "
				+ (this.getCategoriaProduto()) + ", Preço: " + (this.getPrecoProduto())
				+ ", Lote: " + (this.getLoteProduto()) + "Situação: "
				+ (this.getEstadoProduto() + ".");
	}
}
