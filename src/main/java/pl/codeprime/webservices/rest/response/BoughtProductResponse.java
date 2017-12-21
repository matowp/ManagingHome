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
	private String shopName;
	private Date boughtDate;
	private Date addDate;
	private int quantity;
	private double price;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		
		return  new StringBuilder(getClass().getSimpleName())
						.append("[")
						  .append("[productId=").append(productId)
						  .append(", shop=").append(shopName)
						  .append(", boughtDate=").append(boughtDate)
						  .append(", addDate=").append(addDate)
						.append("]").toString();
	}
	
}
