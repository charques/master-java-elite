package edu.masterjava.easybakery.persistence.model.batch;

/**
 * Estadisticas de lotes.
 * 
 * @author carloshernandezarques
 */
public class BatchStatistics {

	private String type;

	private Integer year;

	private Integer recipeId;

	private Integer data[];

	private Double total;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}

	public Integer[] getData() {
		return data;
	}

	public void setData(Integer[] data) {
		this.data = data;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
