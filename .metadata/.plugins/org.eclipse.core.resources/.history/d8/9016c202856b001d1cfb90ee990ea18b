package dev.jefferson.productapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import dev.jefferson.shoppingclient.dto.ProductDTO;

@Entity
@Table(name = "produtos", schema = "products")
public class Product {
	
	@Id
	@SequenceGenerator(name = "product_idproduct_seq", sequenceName = "product_idproduct_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_idproduct_seq")
	private long id;
	private final String nome;
	private final Float preco;
	private final String descricao;
	private final String productIdentifier;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private final Category category;
	
	public Product(final String nome, final Float preco, final String descricao, final String productIdentifier, 
			final Category category) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.productIdentifier = productIdentifier;
		this.category = category;
	}
	
	
	public static Product convert(final ProductDTO dto) {
		Category category = dto.getCategoryDTO() != null ? Category.convert(dto.getCategoryDTO()) : null;
		return new Product(dto.getNome(), dto.getPreco(), dto.getDescricao(), dto.getProductIdentifier(), category);
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public Float getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getProductIdentifier() {
		return productIdentifier;
	}

	public Category getCategory() {
		return category;
	}
	
	
	

}
