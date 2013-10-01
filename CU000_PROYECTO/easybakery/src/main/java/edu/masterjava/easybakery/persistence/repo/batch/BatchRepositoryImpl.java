package edu.masterjava.easybakery.persistence.repo.batch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Expression;
import com.mysema.query.types.Predicate;

import edu.masterjava.easybakery.common.util.toolset.CommonUtils;
import edu.masterjava.easybakery.persistence.model.batch.BatchStatistics;
import edu.masterjava.easybakery.persistence.model.batch.QBatch;

/**
 * Implementaci—n del repositorio de operaciones personalizadas de lotes.
 * 
 * @author carloshernandezarques
 */
public class BatchRepositoryImpl implements BatchRepositoryCustom {

	private static final Logger LOGGER = LoggerFactory.getLogger(BatchRepositoryImpl.class);

	private static final String PRODUCCION = "PR";
	private static final String COSTE = "CO";

	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Integer> getBatchYears() {
		JPAQuery query = new JPAQuery(em);
		List<Integer> years = query.from(QBatch.batch).listDistinct(QBatch.batch.modificationTime.year());
		Collections.reverse(years);
		return years;
	}

	@Override
	public BatchStatistics getBatchStatisticsByYear(BatchStatistics statistics) {
		Integer recipeId = statistics.getRecipeId();
		Integer year = statistics.getYear();
		String type = statistics.getType();
		Date from = CommonUtils.stringToDate("01/01/" + year);
		Date to = CommonUtils.stringToDate("01/12/" + year);

		Predicate wherePredicate = null;
		if ((from != null) && (to != null)) {
			if (recipeId != null) {
				wherePredicate = QBatch.batch.modificationTime.between(from, to).and(QBatch.batch.recipeId.eq(recipeId));
			} else {
				wherePredicate = QBatch.batch.modificationTime.between(from, to);
			}
		}
		
		if (wherePredicate != null) {
			JPAQuery query = new JPAQuery(em);
			Expression<Integer> groupByExpression = QBatch.batch.modificationTime.month();
			
			if (COSTE.equals(type)) {
				LOGGER.info("Obteniendo estadisticas COSTE");
				Expression<BigDecimal> batchCostSumExp = QBatch.batch.batchCost.sum();
				List<Object[]> costsObjects = query.from(QBatch.batch).where(wherePredicate).groupBy(groupByExpression).list(QBatch.batch.modificationTime.month(), batchCostSumExp);
				statistics.setData(buildCostArray(costsObjects));
				statistics.setTotal(buildCostTotal(costsObjects));
			} 
			else if (PRODUCCION.equals(type)) {
				LOGGER.info("Obteniendo estadisticas PRODUCCION");
				Expression<Double> batchTotalAmountExp = QBatch.batch.totalAmount.sum();
				List<Object[]> amountObjects = query.from(QBatch.batch).where(wherePredicate).groupBy(groupByExpression).list(QBatch.batch.modificationTime.month(), batchTotalAmountExp);
				statistics.setData(buildAmountArray(amountObjects));
				statistics.setTotal(buildAmountTotal(amountObjects));
			}
		}
		return statistics;
	}
	
	private Double buildCostTotal(List<Object[]> list) {
		Double total = 0d;
		for(int i = 0; i < list.size(); i++) {
			Object[] obj = list.get(i);
			BigDecimal cost = (BigDecimal) obj[1];
			Double costDouble = cost.doubleValue();
			total += costDouble;
		}
		return Math.round(total*100.0)/100.0;
	}
	
	private Integer[] buildCostArray(List<Object[]> list) {
		Integer costsInt[] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		for(int i = 0; i < list.size(); i++) {
			Object[] obj = list.get(i);
			int month = ((Integer) obj[0])-1;
			BigDecimal cost = (BigDecimal) obj[1];
			cost = cost.setScale(0, RoundingMode.HALF_UP); 
			Integer costInt = cost.intValueExact();
			costsInt[month] = costInt;
		}
		return costsInt;
	}
	
	private Double buildAmountTotal(List<Object[]> list) {
		Double total = 0d;
		for(int i = 0; i < list.size(); i++) {
			Object[] obj = list.get(i);
			Double amount = (Double) obj[1];
			amount = amount / 1000;
			total += amount;
		}
		return Math.round(total*100.0)/100.0;
	}
	
	private Integer[] buildAmountArray(List<Object[]> list) {
		Integer costsInt[] = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		for(int i = 0; i < list.size(); i++) {
			Object[] obj = list.get(i);
			int month = ((Integer) obj[0])-1;
			Double amount = (Double) obj[1];
			amount = amount / 1000;
			amount = Math.round(amount*100.0)/100.0;
			Integer amountInt = amount.intValue();
			costsInt[month] = amountInt;
		}
		return costsInt;
	}

}