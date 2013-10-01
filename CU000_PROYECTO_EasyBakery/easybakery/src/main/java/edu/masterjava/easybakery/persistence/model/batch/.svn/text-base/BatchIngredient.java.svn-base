package edu.masterjava.easybakery.persistence.model.batch;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Entidad que representa un ingrediente asociado a un lote.
 * 
 * @author carloshernandezarques
 */
@Entity
@Table(name = "batch_ingredient")
public class BatchIngredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "batch_id")
	private Batch batch;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "percentage", nullable = false)
	private Integer percentage = null;
	
	@Column(name = "feedstock_price", columnDefinition = "decimal", precision = 7, scale = 2)
	private BigDecimal feedstockPrice;
	
	@Column(name = "amount", nullable = false)
	private Double amount = null;
	
	@Column(name = "creation_time", nullable = false)
	private Date creationTime = null;
	
	@Column(name = "modification_time", nullable = false)
	private Date modificationTime;

	/**
	 * Obtiene un constructor para crear objetos BatchIngredient.
	 * 
	 * @param batch
	 * @param ingredientId
	 * @param description
	 * @param percentage
	 * @param feedstockPrice
	 * @param amount
	 * @return
	 */
	public static Builder getBuilder(Batch batch, Integer ingredientId, String description, Integer percentage, BigDecimal feedstockPrice, Double amount) {
		return new Builder(batch, description, percentage, feedstockPrice, amount);
	}

	public void update(Double amount) {
		this.amount = amount;
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
	 * Clase constructor para crear objetos BatchIngredient.
	 */
	public static class Builder {
		BatchIngredient built;

		/**
		 * Crea una instancia del constructor.
		 * 
		 * @param batch
		 * @param ingredientId
		 * @param description
		 * @param percentage
		 * @param feedstockPrice
		 * @param amount
		 */
		Builder(Batch batch, String description, Integer percentage, BigDecimal feedstockPrice, Double amount) {
			built = new BatchIngredient();
			built.batch = batch;
			built.description = description;
			built.percentage = percentage;
			built.feedstockPrice = feedstockPrice;
			built.amount = amount;
		}

		/**
		 * Construye el nuevo objeto BatchIngredient.
		 * 
		 * @return
		 */
		public BatchIngredient build() {
			return built;
		}
	}

	public Integer getId() {
		return id;
	}

	public Batch getBatch() {
		return batch;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Integer getPercentage() {
		return percentage;
	}
	
	public BigDecimal getFeedstockPrice() {
		return feedstockPrice;
	}
	
	public Double getAmount() {
		return amount;
	}

	public Date getCreationTime() {
		return creationTime;
	}
	
	public Date getModificationTime() {
		return modificationTime;
	}

}
