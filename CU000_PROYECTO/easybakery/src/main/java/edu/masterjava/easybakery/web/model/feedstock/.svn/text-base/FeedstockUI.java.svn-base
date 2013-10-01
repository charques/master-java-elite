package edu.masterjava.easybakery.web.model.feedstock;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Clase UI que se utilizara como objeto de formulario para crear y modificar
 * Materias Primas.
 * 
 * @author carloshernandezarques
 */
public class FeedstockUI {

	private Integer id;

	@NotEmpty 
	@Size(max=50)
	private String description = null;

	@NotNull  
	private BigDecimal price = new BigDecimal("0.00");  

	@NotNull
	private Integer unitId;

	private UnitUI unit;

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public UnitUI getUnit() {
		return unit;
	}

	public void setUnit(UnitUI unit) {
		this.unit = unit;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}