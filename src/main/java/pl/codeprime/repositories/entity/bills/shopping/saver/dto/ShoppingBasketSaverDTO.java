/**
 * 
 */
package pl.codeprime.repositories.entity.bills.shopping.saver.dto;

import java.util.List;

/**
 * @author MOwsians
 *
 */
public class ShoppingBasketSaverDTO {
	
	private List<ProductSaverDTO> products;
	private List<BoughtProductSaverDTO> boughtProducts;
	private String shopName;
	
	public List<ProductSaverDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductSaverDTO> products) {
		this.products = products;
	}
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public List<BoughtProductSaverDTO> getBoughtProducts() {
		return boughtProducts;
	}
	
	public void setBoughtProducts(List<BoughtProductSaverDTO> boughtProducts) {
		this.boughtProducts = boughtProducts;
	}

}
