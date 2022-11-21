package dev.jefferson.shoppingapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.jefferson.shoppingapi.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository{
	
	public List<Shop> findAllByUserIdentifier(final String userIdentifier);
	public List<Shop> findAllByTotalGreaterThan(final Float total);
	public List<Shop> findAllByDate(final Date date);

}
