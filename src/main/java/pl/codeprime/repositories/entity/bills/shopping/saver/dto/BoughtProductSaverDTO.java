/**
 * 
 */
package pl.codeprime.repositories.entity.bills.shopping.saver.dto;

/**
 * @author MOwsians
 *
 */
public class BoughtProductSaverDTO {

	private ProductSaverDTO product;
	private double price;
	private int quantity;
	
	public ProductSaverDTO getProduct() {
		return product;
	}
	
	public void setProduct(ProductSaverDTO product) {
		this.product = product;
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
	
}
