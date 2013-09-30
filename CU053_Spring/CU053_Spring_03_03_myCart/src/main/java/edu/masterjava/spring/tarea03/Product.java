package edu.masterjava.spring.tarea03;

import java.io.Serializable;

// Must be serializable so instance state can be saved between flow requests.
// See SWF 2.0 Reference Manual, section 2.8.
public class Product implements Comparable<Product>, Serializable {
	private static final long serialVersionUID = -6027340279914938585L;
	
	private long id;
	private String description;
	private int priceInCents;
	private String imageUrl;
	
	public Product(long id, String description, int priceInCents, String imageUrl) {
		this.id = id;
		this.description = description;
		this.priceInCents = priceInCents;
		this.imageUrl = imageUrl;
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public int getPriceInCents() {
		return priceInCents;
	}
	
	public String getPriceInDollars() {
		return Util.getPriceInDollars(priceInCents);
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof Product && id == ((Product) o).id;
	}
	
	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}
	
	@Override
	public int compareTo(Product p) {
		int c = description.compareTo(p.description);
		return (c == 0 ? ((Long) id).compareTo((Long) p.id) : c);
	}
}
