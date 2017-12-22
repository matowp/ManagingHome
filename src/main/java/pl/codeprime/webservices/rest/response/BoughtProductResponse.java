/**
 * 
 */
package pl.codeprime.webservices.rest.response;

import java.util.Date;

/**
 * @author MOwsians
 *
 */
public class BoughtProductResponse {

	private Long productId;
	private Date boughtDate;
	private Date addDate;
	private double quantity;
	private double price;
	private String name;
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Date getBoughtDate() {
		return boughtDate;
	}

	public void setBoughtDate(Date boughtDate) {
		this.boughtDate = boughtDate;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		
		return  new StringBuilder(getClass().getSimpleName())
						.append("[")
						  .append("[productId=").append(productId)
						  .append(", name=").append(name)
						  .append(", boughtDate=").append(boughtDate)
						  .append(", addDate=").append(addDate)
						.append("]").toString();
	}
	
}
