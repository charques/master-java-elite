package edu.masterjava.easybakery.web.model.recipe;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Clase UI que se utilizara como objeto de formulario para crear y modificar
 * Recetas.
 * 
 * @author carloshernandezarques
 */
public class RecipeUI {

	private Integer id;

	@NotEmpty 
	@Size(max=50)
	private String description = null;

	@NotEmpty 
	@Size(max=50)
	private String comment = null;

	@SuppressWarnings("unchecked")
	private List<IngredientUI> ingredientList = LazyList.decorate(new ArrayList<IngredientUI>(),
			FactoryUtils.instantiateFactory(IngredientUI.class));

	public RecipeUI() {
	}

	public RecipeUI(List<IngredientUI> ingredientList) {
		this.ingredientList = ingredientList;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<IngredientUI> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<IngredientUI> ingredientList) {
		this.ingredientList = ingredientList;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
