/**
 * 
 */
package pl.codeprime.webservices.rest.controller.request.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author MOwsians
 *
 */
public class ShopBasketRequestDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2240568515624534562L;
	private String shopName;
	private Date shoppingDate;
	private List<ProductRequestDTO> products;
	
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Date getShoppingDate() {
		return shoppingDate;
	}

	public void setShoppingDate(Date shoppingDate) {
		this.shoppingDate = shoppingDate;
	}

	public List<ProductRequestDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductRequestDTO> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "ShopBasketRequestDTO [shopName=" + shopName + ", shoppingDate=" + shoppingDate + ", products="
				+ products + "]";
	}

}
