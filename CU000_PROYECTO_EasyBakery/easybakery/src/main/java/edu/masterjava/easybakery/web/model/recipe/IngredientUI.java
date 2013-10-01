package edu.masterjava.easybakery.web.model.recipe;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import edu.masterjava.easybakery.web.model.feedstock.FeedstockUI;

/**
 * Clase UI que se utilizara como objeto de formulario para crear y modificar
 * ingredientes de recetas.
 * 
 * @author carloshernandezarques
 */
public class IngredientUI {

	private Integer id;
	
	@NotEmpty 
	@Size(max=50)
	private String description = null;
	
	@NotNull
	private Integer feedstockId;
	
	private FeedstockUI feedstock;
	
	@NotNull
	private Integer percentage;
	
	private Integer delete;

	public IngredientUI() {
	}

	public IngredientUI(Integer feedstockId, Integer percentage) {
		this.feedstockId = feedstockId;
		this.percentage = percentage;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public Integer getFeedstockId() {
		return feedstockId;
	}

	public void setFeedstockId(Integer feedstockId) {
		this.feedstockId = feedstockId;
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

	public Integer getDelete() {
		return delete;
	}

	public void setDelete(Integer delete) {
		this.delete = delete;
	}

	public FeedstockUI getFeedstock() {
		return feedstock;
	}

	public void setFeedstock(FeedstockUI feedstock) {
		this.feedstock = feedstock;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
