package edu.masterjava.easybakery.persistence.model.recipe;

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
 * Entidad que representa una receta.
 * 
 * @author carloshernandezarques
 */
@Entity
@Table(name = "recipe")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "description", nullable = false)
	private String description = null;

	@Column(name = "comment", nullable = false)
	private String comment = null;

	@OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
	@OrderBy("id ASC")
	private Set<Ingredient> ingredientList = new HashSet<Ingredient>(0);

	@Column(name = "creation_time", nullable = false)
	private Date creationTime;

	@Column(name = "modification_time", nullable = false)
	private Date modificationTime;

	/**
	 * Obtiene un constructor para crear objetos Recipe.
	 * 
	 * @param description
	 * @param comment
	 * @return
	 */
	public static Builder getBuilder(String description, String comment) {
		return new Builder(description, comment);
	}

	public void update(String description, String comment) {
		this.description = description;
		this.comment = comment;
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
	 * Clase constructor para crear objetos Recipe. 
	 */
	public static class Builder {
		Recipe built;

		/**
		 * Crea una instancia del constructor.
		 * 
		 * @param description
		 * @param comment
		 */
		Builder(String description, String comment) {
			built = new Recipe();
			built.description = description;
			built.comment = comment;
		}

		/**
		 * Construye el nuevo objeto Recipe.
		 * 
		 * @return
		 */
		public Recipe build() {
			return built;
		}
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getComment() {
		return comment;
	}

	public Set<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

}