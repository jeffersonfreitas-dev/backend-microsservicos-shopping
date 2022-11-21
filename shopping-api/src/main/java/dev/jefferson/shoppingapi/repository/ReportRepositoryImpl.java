package dev.jefferson.shoppingapi.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dev.jefferson.shoppingapi.dto.ShopReportDTO;
import dev.jefferson.shoppingapi.model.Shop;

public class ReportRepositoryImpl implements ReportRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Shop> getShopByFilter(Date dataInicio, Date dataFim, Float valorMinimo) {
		StringBuilder sb = new StringBuilder("select s from Shop s where s.date >= :dataInicio");
		if(dataFim != null) sb.append("and s.date <= :dataFim");
		if(valorMinimo != null) sb.append("and s.total <= :valorMinimo");
		
		Query query = manager.createQuery(sb.toString());
		query.setParameter("dataInicio", dataInicio);
		if(dataFim != null) query.setParameter("dataFim", dataFim);
		if(valorMinimo != null) query.setParameter("valorMinimo", valorMinimo);
		
		return query.getResultList();
	}

	
	@Override
	public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
		StringBuilder sb = new StringBuilder("select count(sp.id), sum(sp.total), avg(sp.total) "
				+ "from shopping.shop sp where sp.date >= :dataInicio and sp.date <= :dataFim");
		Query query = manager.createQuery(sb.toString());
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFim", dataFim);
		
		Object[] result = (Object[]) query.getSingleResult();
		ShopReportDTO dto = new ShopReportDTO();
		dto.setCount(((BigInteger) result[0]).intValue());
		dto.setTotal((Double) result[1]);
		dto.setMean((Double) result[2]);
		return dto;
	}

}
