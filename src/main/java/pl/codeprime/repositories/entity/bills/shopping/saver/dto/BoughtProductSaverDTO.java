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
	private double quantity;
	
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
	
	public double getQuantity() {
		return quantity;
	}
	
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
}
