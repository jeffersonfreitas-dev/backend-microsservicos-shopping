package dev.jefferson.shoppingapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import dev.jefferson.shoppingclient.dto.ProductDTO;
import dev.jefferson.shoppingclient.exceptions.ProductNotFoundException;

@Service
public class ProductService {
	
	@Value("${PRODUCT_API_URL:http://localhost:8081/product/}")
	private String productApiUrl;
	
	public ProductDTO getProductByIdentifier(final String productIdentifier) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = productApiUrl + productIdentifier;
			ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
			return response.getBody();
		} catch (HttpClientErrorException.NotFound e) {
			throw new ProductNotFoundException(e.getMessage());
		}
	}

}
