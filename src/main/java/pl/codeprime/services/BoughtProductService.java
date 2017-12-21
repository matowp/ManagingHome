/**
 * 
 */
package pl.codeprime.services;

import java.util.List;

import pl.codeprime.repositories.entity.bills.shopping.BoughtProduct;

/**
 * @author MOwsians
 *
 */
public interface BoughtProductService {
	
	BoughtProduct findByName(String productName);
	void save(BoughtProduct boughtProduct);
	void save(List<BoughtProduct> boughtProducts);

}
