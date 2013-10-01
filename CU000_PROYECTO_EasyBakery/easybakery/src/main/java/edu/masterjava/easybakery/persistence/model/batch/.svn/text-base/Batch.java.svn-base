package edu.masterjava.easybakery.persistence.model.batch;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Entidad que representa un lote.
 * 
 * @author carloshernandezarques
 */
@Entity
@Table(name = "batch")
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "description", nullable = false)
	private String description = null;
	
	@Column(name = "recipe_id", nullable = false)
	private Integer recipeId = null;
	
	@Column(name = "total_amount", nullable = false)
	private Double totalAmount = null;
	
	@OneToMany(mappedBy = "batch", fetch = FetchType.EAGER)
	@OrderBy("id ASC")
	private Set<BatchIngredient> ingredients = new HashSet<BatchIngredient>(0);
	
	@Column(name = "batch_cost", columnDefinition = "decimal", precision = 7, scale = 2)
	private BigDecimal batchCost;
	
	@Column(name = "creation_time", nullable = false)
	private Date creationTime = null;
	
	@Column(name = "modification_time", nullable = false)
	private Date modificationTime;

	/**
	 * Obtiene un constructor para crear objetos Batch.
	 * @param description
	 * @param recipeId
	 * @param totalAmount
	 * @param batchCost
	 * @return
	 */
	public static Builder getBuilder(String description, Integer recipeId, Double totalAmount, BigDecimal batchCost) {
		return new Builder(description, recipeId, totalAmount, batchCost);
	}

	public void update(String description, Double totalAmount, BigDecimal batchCost) {
		this.description = description;
		this.totalAmount = totalAmount;
		this.batchCost = batchCost;
	}

	@PreUpdate
	public void preUpdate() {
		modificationTime = new Date();
	}

	@PrePersist
	public void prePersist() {
		Date now = new Date();
		creationTime = now;
		modificationTime = now;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * Clase constructor para crear objetos Batch.
	 */
	public static class Builder {
		Batch built;

		/**
		 * Crea una instancia del constructor.
		 * 
		 * @param description
		 * @param recipeId
		 * @param totalAmount
		 * @param batchCost
		 */
		Builder(String description, Integer recipeId, Double totalAmount, BigDecimal batchCost) {
			built = new Batch();
			built.description = description;
			built.recipeId = recipeId;
			built.totalAmount = totalAmount;
			built.batchCost = batchCost;
		}

		/**
		 * Construye el nuevo objeto Batch.
		 * 
		 * @return
		 */
		public Batch build() {
			return built;
		}
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public Integer getRecipeId() {
		return recipeId;
	}
	
	public Double getTotalAmount() {
		return totalAmount;
	}
	
	public BigDecimal getBatchCost() {
		return batchCost;
	}
	
	public Set<BatchIngredient> getIngredients() {
		return ingredients;
	}

	public Date getCreationTime() {
		return creationTime;
	}
	
	public Date getModificationTime() {
		return modificationTime;
	}
}
