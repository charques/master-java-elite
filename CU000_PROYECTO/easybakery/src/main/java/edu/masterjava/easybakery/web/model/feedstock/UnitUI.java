package edu.masterjava.easybakery.web.model.feedstock;


/**
 * Clase UI que representa una unidad de medida.
 * 
 * @author carloshernandezarques
 */
public class UnitUI {

	private Integer id;

	private String description = null;

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
}
