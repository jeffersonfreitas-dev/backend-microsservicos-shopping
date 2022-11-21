package dev.jefferson.productapi.dto;

import dev.jefferson.productapi.model.Category;
import dev.jefferson.productapi.model.Product;
import dev.jefferson.shoppingclient.dto.CategoryDTO;
import dev.jefferson.shoppingclient.dto.ProductDTO;

public class DTOConverter {
	
	public static CategoryDTO convert(Category category) {
		return new CategoryDTO(category.getId(), category.getNome());
	}

	public static ProductDTO convert(Product product) {
		CategoryDTO categoryDTO = product.getCategory() != null ? DTOConverter.convert(product.getCategory()) : null;
		return new ProductDTO(product.getNome(), product.getPreco(), product.getDescricao(), product.getProductIdentifier(), categoryDTO);
	}

}
