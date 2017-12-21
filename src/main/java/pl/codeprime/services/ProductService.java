/**
 * 
 */
package pl.codeprime.services;

import java.util.List;

import pl.codeprime.repositories.entity.bills.shopping.Product;
import pl.codeprime.webservices.rest.to.ProductTO;

/**
 * @author MOwsians
 *
 */
public interface ProductService {

	List<Product> findByName(String productName);
	void add(Product product);
	void update(Product product);
	
	/**
	 * @param productTO
	 */
	void add(ProductTO productTO);
	/**
	 * @param product
	 * @return
	 */
	Product save(Product product);
	/**
	 * @return
	 */
	List<Product> findAll();
	/**
	 * @param productId
	 */
	Product findById(Long productId);
}
