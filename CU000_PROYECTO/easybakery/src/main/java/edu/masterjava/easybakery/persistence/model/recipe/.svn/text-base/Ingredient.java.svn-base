package edu.masterjava.easybakery.persistence.model.recipe;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import edu.masterjava.easybakery.persistence.model.feedstock.Feedstock;

/**
 * Entidad que representa un ingrediente.
 * 
 * @author carloshernandezarques
 */
@Entity
@Table(name = "ingredient")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;

	@Column(name = "feedstock_id", nullable = false)
	private Integer feedstockId = null;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="feedstock_id", insertable = false, updatable = false)
	private Feedstock feedstock;

	@Column(name = "percentage", nullable = false)
	private Integer percentage;

	@Column(name = "creation_time", nullable = false)
	private Date creationTime;

	@Column(name = "modification_time", nullable = false)
	private Date modificationTime;

	/**
	 * Obtiene un constructor para crear objetos Ingredient.
	 * 
	 * @param recipe
	 * @param feedstockId
	 * @param percentage
	 * @return
	 */
	public static Builder getBuilder(Recipe recipe, Integer feedstockId, Integer percentage) {
		return new Builder(recipe, feedstockId, percentage);
	}

	public void update(Integer feedstockId, Integer percentage) {
		this.feedstockId = feedstockId;
		this.percentage = percentage;
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
	 * Clase constructor para crear objetos Ingredient. 
	 */
	public static class Builder {
		Ingredient built;

		/**
		 * Crea una instancia del constructor.
		 * 
		 * @param recipe
		 * @param feedstockId
		 * @param percentage
		 */
		Builder(Recipe recipe, Integer feedstockId, Integer percentage) {
			built = new Ingredient();
			built.recipe = recipe;
			built.feedstockId = feedstockId;
			built.percentage = percentage;
		}

		/**
		 * Construye el nuevo objeto Ingredient.
		 * 
		 * @return
		 */
		public Ingredient build() {
			return built;
		}
	}

	public Integer getId() {
		return id;
	}

	public Integer getFeedstockId() {
		return feedstockId;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public Recipe getRecipe() {
		return recipe;
	}
	
	public Feedstock getFeedstock() {
		return feedstock;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

}