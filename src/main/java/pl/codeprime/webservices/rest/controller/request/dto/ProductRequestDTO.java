/**
 * 
 */
package pl.codeprime.webservices.rest.controller.request.dto;

import java.io.Serializable;

/**
 * @author MOwsians
 *
 */
public class ProductRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8563570571848673459L;
	private String name;
	private double price;
	private int quantity;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductRequestDTO [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}
