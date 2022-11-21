package dev.jefferson.shoppingapi.repository;

import java.util.Date;
import java.util.List;

import dev.jefferson.shoppingapi.dto.ShopReportDTO;
import dev.jefferson.shoppingapi.model.Shop;

public interface ReportRepository {
	
	public List<Shop> getShopByFilter(final Date dataInicio, final Date dataFim, final Float valorMinimo);
	public ShopReportDTO getReportByDate(final Date dataInicio, final Date dataFim);

}
