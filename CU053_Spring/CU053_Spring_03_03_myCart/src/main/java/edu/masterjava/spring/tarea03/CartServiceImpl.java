package edu.masterjava.spring.tarea03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

// Commented this out since I want to specify the shippingOptions property in
// the config file.
@Service("cartService")
public class CartServiceImpl implements CartService {
	
	// This is session-scoped.  I don't like this because (1) I don't think
	// this service bean should be session-aware and (2) this seems like it ties
	// us to Spring.  But anyway.
	private ShoppingCart cart;
	
	private Map<Long, Product> products = new HashMap<Long, Product>();
	private List<Product> recommendations = new ArrayList<Product>();
	private List<String> shippingOptions;
	
	public CartServiceImpl() {
		addProduct(1L, "Bag of Skittles", 100, "skittles.jpg");
		addProduct(2L, "Dieselboy CD", 3995, "dieselboy.jpg");
		addProduct(3L, "Darth Vader Mask", 159995, "vader.jpg");
		addProduct(4L, "Lightsaber", 57950, "lightsaber.jpg");
	}
	
	private void addProduct(Long id, String desc, int priceInCents, String imgUrl) {
		Product product = new Product(id, desc, priceInCents, imgUrl);
		products.put(id, product);
		if (id == 3 || id == 4) {
			recommendations.add(product);
		}
	}
	
	@Override
	public ShoppingCart getShoppingCart() {
		return cart;
	}
	
	public void setShoppingCart(ShoppingCart cart) {
		this.cart = cart;
	}
	
	@Override
	public List<Product> getProducts() {
		List<Product> list = new ArrayList<Product>(products.values());
		Collections.sort(list);
		return list;
	}
	
	@Override
	public Product getProduct(long productId) {
		return products.get(productId);
	}
	
	@Override
	public List<Product> getRecommendations() {
		return recommendations;
	}
	
	@Override
	public List<String> getShippingOptions() {
		return shippingOptions;
	}
	
	public void setShippingOptions(List<String> options) {
		this.shippingOptions = options;
	}
	
	@Override
	public void submitOrderForPayment() {
		cart.clear();
	}
}
