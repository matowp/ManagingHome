/**
 * 
 */
package pl.codeprime.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import pl.codeprime.repositories.entity.bills.shopping.BoughtProduct;
import pl.codeprime.repositories.entity.bills.shopping.ShoppingBasket;

/**
 * @author MOwsians
 *
 */
public interface ShoppingBasketService {
	
	ShoppingBasket findById(Long id);
	List<ShoppingBasket> findByDate(Date date);
	
	/**
	 * @param shop
	 * @param products
	 * @param boughtDate
	 * @return
	 */
	ShoppingBasket add(String shopName, Set<BoughtProduct> products, Date boughtDate);
	
	/**
	 * @param name
	 * @return
	 */
	List<ShoppingBasket> findByName(String name);
	/**
	 * @param shoppingBasket
	 * @return
	 */
	ShoppingBasket save(ShoppingBasket shoppingBasket);
	
	List<ShoppingBasket> findAll();
	
}
