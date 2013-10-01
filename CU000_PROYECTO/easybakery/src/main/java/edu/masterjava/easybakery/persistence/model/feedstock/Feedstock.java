package edu.masterjava.easybakery.persistence.model.feedstock;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Entidad que representa una materia prima.
 * 
 * @author carloshernandezarques
 */
@Entity
@Table(name = "feedstock")
public class Feedstock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "description", nullable = false)
	private String description = null;

	@Column(name = "price", columnDefinition = "decimal", precision = 7, scale = 2)
	private BigDecimal price = null;

	@Column(name = "unit_id", nullable = false)
	private Integer unitId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="unit_id", insertable = false, updatable = false)
	private Unit unit;

	@Column(name = "creation_time", nullable = false)
	private Date creationTime;

	@Column(name = "modification_time", nullable = false)
	private Date modificationTime;

	/**
	 * Obtiene un constructor para crear objetos Feedstock.
	 * 
	 * @param description
	 * @param price
	 * @param unitId
	 * @return
	 */
	public static Builder getBuilder(String description, BigDecimal price,
			Integer unitId) {
		return new Builder(description, price, unitId);
	}

	public void update(String description, BigDecimal price, Integer unitId) {
		this.description = description;
		this.price = price;
		this.unitId = unitId;
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
	 * Clase constructor para crear objetos Feedstock.
	 */
	public static class Builder {
		Feedstock built;

		/**
		 * Crea una instancia del constructor.
		 * 
		 * @param description
		 * @param price
		 * @param unitId
		 */
		Builder(String description, BigDecimal price, Integer unitId) {
			built = new Feedstock();
			built.description = description;
			built.price = price;
			built.unitId = unitId;
		}

		/**
		 * Construye el nuevo objeto Feedstock.
		 * 
		 * @return
		 */
		public Feedstock build() {
			return built;
		}
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Integer getUnitId() {
		return unitId;
	}
	
	public Unit getUnit() {
		return unit;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

}