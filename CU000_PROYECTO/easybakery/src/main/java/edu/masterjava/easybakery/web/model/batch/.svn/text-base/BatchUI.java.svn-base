package edu.masterjava.easybakery.web.model.batch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Clase UI que se utilizara como objeto de formulario para crear y modificar
 * Lotes.
 * 
 * @author carloshernandezarques
 */
public class BatchUI {

	private Integer id;

	private String description = null;

	private Integer recipeId = null;

	private Double totalAmount = null;

	@SuppressWarnings("unchecked")
	private List<BatchIngredientUI> ingredients = LazyList.decorate(new ArrayList<BatchIngredientUI>(),
			FactoryUtils.instantiateFactory(BatchIngredientUI.class));

	private Date modificationTime;

	private BigDecimal batchCost;

	public BatchUI() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<BatchIngredientUI> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<BatchIngredientUI> ingredients) {
		this.ingredients = ingredients;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}

	public BigDecimal getBatchCost() {
		return batchCost;
	}

	public void setBatchCost(BigDecimal batchCost) {
		this.batchCost = batchCost;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
