/**
 * 
 */
package pl.codeprime.webservices.rest.response;

import java.util.List;

/**
 * @author MOwsians
 *
 */
public class ShoppingBasketResponse {
	
	private String shopName;
	private List<BoughtProductResponse> boughtProducts;
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public List<BoughtProductResponse> getBoughtProducts() {
		return boughtProducts;
	}
	public void setBoughtProducts(List<BoughtProductResponse> boughtProducts) {
		this.boughtProducts = boughtProducts;
	}
	
	@Override
	public String toString() {
		
		return  new StringBuilder(getClass().getSimpleName())
						.append("[")
						  .append(", shop=").append(shopName)
						  .append(", boughtDate=").append(boughtProducts)
						.append("]").toString();
	}

}
