package edu.masterjava.easybakery.web.model.dashboard;

/**
 * Clase UI que se utilizara como dataset de grafico.
 * 
 * @author carloshernandezarques
 */
public class GraphDataSetsUI {

	private String fillColor;
	private String strokeColor;
	private Integer data[];

	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	public String getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(String strokeColor) {
		this.strokeColor = strokeColor;
	}

	public Integer[] getData() {
		return data;
	}

	public void setData(Integer[] data) {
		this.data = data;
	}

}
