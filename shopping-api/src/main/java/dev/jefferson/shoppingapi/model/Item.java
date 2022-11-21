package dev.jefferson.shoppingapi.model;

import javax.persistence.Embeddable;

import dev.jefferson.shoppingclient.dto.ItemDTO;

@Embeddable
public class Item {

	private String productIdentifier;
	private float price;
	
	public static Item convert(ItemDTO dto) {
		Item item = new Item();
		item.setProductIdentifier(dto.getProductIdentifier());
		item.setPrice(dto.getPrice());
		return item;
	}
	
	public String getProductIdentifier() {
		return productIdentifier;
	}
	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
