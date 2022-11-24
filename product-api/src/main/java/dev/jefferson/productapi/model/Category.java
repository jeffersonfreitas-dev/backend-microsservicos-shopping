package dev.jefferson.productapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import dev.jefferson.shoppingclient.dto.CategoryDTO;

@Entity
@Table(name = "categorias")
public class Category {
	
	@Id
	@SequenceGenerator(name = "category_idcategory_seq", sequenceName = "category_idcategory_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_idcategory_seq")
	private long id;
	private final String nome;
	
	public Category(final long id, final String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public static Category convert(CategoryDTO dto) {
		return new Category(dto.getId(), dto.getNome());
	}
	
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

}
