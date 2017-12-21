/**
 * 
 */
package pl.codeprime.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import pl.codeprime.common.OptionalUtils;
import pl.codeprime.converters.ObjectConverters;
import pl.codeprime.repositories.ShoppingBasketRepository;
import pl.codeprime.repositories.entity.bills.shopping.BoughtProduct;
import pl.codeprime.repositories.entity.bills.shopping.ShoppingBasket;
import pl.codeprime.services.BoughtProductService;
import pl.codeprime.services.ProductService;
import pl.codeprime.services.ShoppingBasketService;

/**
 * @author MOwsians
 *
 */
@Service("shoppingBasketService")
public class ShoppingBasketServiceImpl implements ShoppingBasketService {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	BoughtProductService boughtProductService;
	
	@Autowired
	ShoppingBasketRepository shoppingBasketRepository;
	
	@PersistenceContext
    EntityManager entityManager;
	
	


	/* (non-Javadoc)
	 * @see pl.codeprime.services.ShoppingBasketService#findById(java.lang.Long)
	 */
	@Override
	public ShoppingBasket findById(Long id) {
		
		Optional<ShoppingBasket> findById = shoppingBasketRepository.findById(id);
		ShoppingBasket shoppingBasket = null;
		
		if(OptionalUtils.isNotEmpty(findById)) {
			 shoppingBasket = findById.get();
		}
		
		return shoppingBasket;
	}

	/* (non-Javadoc)
	 * @see pl.codeprime.services.ShoppingBasketService#findByDate(java.util.Date)
	 */
	@Override
	public List<ShoppingBasket> findByDate(Date date) {
		
		CriteriaBuilder crBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ShoppingBasket> createQuery = crBuilder.createQuery(ShoppingBasket.class);
		
		Root<ShoppingBasket> from = createQuery.from(ShoppingBasket.class);
		createQuery.where(crBuilder.equal(from.get("boughtDate"), date));
		
		TypedQuery<ShoppingBasket> query = entityManager.createQuery(createQuery);
		List<ShoppingBasket> resultList = query.getResultList();
		
		return resultList;
	}


	/* (non-Javadoc)
	 * @see pl.codeprime.services.ShoppingBasketService#add(pl.codeprime.repositories.entity.Shop, java.util.List, java.util.Date)
	 */
	@Override
	public ShoppingBasket add(String shopName, Set<BoughtProduct> products, Date boughtDate) {
		
		ShoppingBasket basket = ObjectConverters.toShoppingBasket(shopName, products, boughtDate);
		ShoppingBasket save = shoppingBasketRepository.save(basket);
		
		return save;
	}


	/* (non-Javadoc)
	 * @see pl.codeprime.services.ShoppingBasketService#findByName(java.lang.String)
	 */
	@Override
	public List<ShoppingBasket> findByName(String name) {
		
		CriteriaBuilder crBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ShoppingBasket> createQuery = crBuilder.createQuery(ShoppingBasket.class);
		
		Root<ShoppingBasket> from = createQuery.from(ShoppingBasket.class);
		createQuery.where(crBuilder.equal(from.get("name"), name));
		
		TypedQuery<ShoppingBasket> query = entityManager.createQuery(createQuery);
		List<ShoppingBasket> resultList = query.getResultList();
		
		if(CollectionUtils.isEmpty(resultList)) {
			resultList = Lists.newArrayList();
		}
		
		return resultList;
	}


	/* (non-Javadoc)
	 * @see pl.codeprime.services.ShoppingBasketService#save(pl.codeprime.repositories.entity.ShoppingBasket)
	 */
	@Override
	public ShoppingBasket save(ShoppingBasket shoppingBasket) {
		
		ShoppingBasket save = shoppingBasketRepository.save(shoppingBasket);
		return save;
	}

}
