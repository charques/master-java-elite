package edu.masterjava.easybakery.persistence.model.feedstock;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Entidad que representa una unidad de medida.
 * 
 * @author carloshernandezarques
 */
@Entity
@Table(name = "unit")
public class Unit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "description", nullable = false)
	private String description = null;
	
	@Column(name = "creation_time", nullable = false)
	private Date creationTime = null;

	/**
	 * Obtiene un constructor para crear objetos Unit.
	 * 
	 * @param description
	 * @return
	 */
	public static Builder getBuilder(String description) {
		return new Builder(description);
	}

	public void update(String description) {
		this.description = description;
	}

	@PreUpdate
	public void preUpdate() {
	
	}

	@PrePersist
	public void prePersist() {
		Date now = new Date();
		creationTime = now;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * Clase constructor para crear objetos Unit. 
	 */
	public static class Builder {
		Unit built;

		/**
		 * Crea una instancia del constructor.
		 * 
		 * @param description
		 */
		Builder(String description) {
			built = new Unit();
			built.description = description;
		}

		/**
		 * Construye el nuevo objeto Unit.
		 * 
		 * @return
		 */
		public Unit build() {
			return built;
		}
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Date getCreationTime() {
		return creationTime;
	}

}
