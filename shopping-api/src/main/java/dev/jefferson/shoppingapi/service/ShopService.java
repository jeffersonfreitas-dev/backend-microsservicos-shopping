package dev.jefferson.shoppingapi.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.jefferson.shoppingapi.dto.DTOConverter;
import dev.jefferson.shoppingapi.dto.ShopReportDTO;
import dev.jefferson.shoppingapi.model.Shop;
import dev.jefferson.shoppingapi.repository.ShopRepository;
import dev.jefferson.shoppingclient.dto.ItemDTO;
import dev.jefferson.shoppingclient.dto.ProductDTO;
import dev.jefferson.shoppingclient.dto.ShopDTO;

@Service
public class ShopService {
	
	@Autowired
	private ShopRepository repository;
	@Autowired
	private UsuarioService userService;
	@Autowired
	private ProductService productService;
	
	
	public List<ShopDTO> getAll() {
		return repository.findAll().stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());
	}
	
	
	public List<ShopDTO> getByUser(final String userIdentifier) {
		return repository.findAllByUserIdentifier(userIdentifier).stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());
	}
	
	
	public List<ShopDTO> getByDate(final ShopDTO shopDTO) {
		return repository.findAllByDate(shopDTO.getDate()).stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());
	}
	
	public ShopDTO findById(final long productId) {
		return repository.findById(productId)
				.map(DTOConverter::convert)
				.orElseThrow(() -> new IllegalArgumentException("ProductId not found"));
	}
	
	
	public ShopDTO save(final ShopDTO dto) {
		
		if(userService.getUserByCpf(dto.getUserIdentifier()) == null) {
			return null;
		}
		
		if(!validateProducts(dto.getItems())) {
			return null;
		}
		
		dto.setTotal(dto.getItems().stream().map(i -> i.getPrice()).reduce(0f, Float::sum));
		Shop shop = Shop.convert(dto);
		shop.setDate(new Date());
		shop = repository.save(shop);
		return DTOConverter.convert(shop);
	}
	
	
	public List<ShopDTO> getShopsByFilter(final Date dataInicio, final Date dataFim, final Float valorMinimo) {
		return repository.getShopByFilter(dataInicio, dataFim, valorMinimo).stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());
	}
	
	public ShopReportDTO getReportByDate(final Date dataInicio, final Date dataFim) {
		return repository.getReportByDate(dataInicio, dataFim);
	}
	
	
	
	private boolean validateProducts(List<ItemDTO> items) {
		for(ItemDTO d : items) {
			ProductDTO product = productService.getProductByIdentifier(d.getProductIdentifier());
			if(product == null) {
				return false;
			}
			d.setPrice(product.getPreco());
		}
		return true;
	}

}
