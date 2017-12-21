/**
 * 
 */
package pl.codeprime.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.codeprime.repositories.BoughtProductRepository;
import pl.codeprime.repositories.entity.bills.shopping.BoughtProduct;
import pl.codeprime.services.BoughtProductService;

/**
 * @author MOwsians
 *
 */
@Service("boughtProductService")
public class BoughtProductServiceImpl implements BoughtProductService {

	@Autowired
	BoughtProductRepository  bProductRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see pl.codeprime.services.BoughtProductService#findByName(java.lang.String)
	 */
	@Override
	public BoughtProduct findByName(String productName) {
		return null;
	}

	/* (non-Javadoc)
	 * @see pl.codeprime.services.BoughtProductService#save(pl.codeprime.repositories.entity.bills.shopping.BoughtProduct)
	 */
	@Override
	public void save(BoughtProduct boughtProduct) {
		bProductRepository.save(boughtProduct);
	}

	/* (non-Javadoc)
	 * @see pl.codeprime.services.BoughtProductService#save(java.util.List)
	 */
	@Override
	public void save(List<BoughtProduct> boughtProducts) {
		boughtProducts.stream().forEachOrdered(this::save);
	}
	
}
