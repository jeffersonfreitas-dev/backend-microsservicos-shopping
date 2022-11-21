package dev.jefferson.shoppingapi.dto;

import java.util.stream.Collectors;

import dev.jefferson.shoppingapi.model.Item;
import dev.jefferson.shoppingapi.model.Shop;
import dev.jefferson.shoppingclient.dto.ItemDTO;
import dev.jefferson.shoppingclient.dto.ShopDTO;

public class DTOConverter {
	
	public static ShopDTO convert(Shop shop) {
		ShopDTO dto = new ShopDTO();
		dto.setUserIdentifier(shop.getUserIdentifier());
		dto.setDate(shop.getDate());
		dto.setTotal(shop.getTotal());
		dto.setItems(shop.getItems().stream().map(DTOConverter::convert).collect(Collectors.toList()));
		return dto;
	}

	
	public static ItemDTO convert(Item item) {
		ItemDTO dto = new ItemDTO();
		dto.setProductIdentifier(item.getProductIdentifier());
		dto.setPrice(item.getPrice());
		return dto;
	}
}
