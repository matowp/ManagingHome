/**
 * 
 */
package pl.codeprime.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.codeprime.common.EntityManagerProvider;
import pl.codeprime.common.OptionalUtils;
import pl.codeprime.converters.ObjectConverters;
import pl.codeprime.repositories.ProductRepository;
import pl.codeprime.repositories.entity.bills.shopping.Product;
import pl.codeprime.services.ProductService;
import pl.codeprime.webservices.rest.to.ProductTO;

/**
 * @author MOwsians
 *
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see pl.codeprime.services.ProductService#findByName(java.lang.String)
	 */
	@Override
	public List<Product> findByName(String productName) {
		
		CriteriaBuilder criteriaBuilder = EntityManagerProvider.criteriaBuilder(entityManager);
		CriteriaQuery<Product> createQuery = criteriaBuilder.createQuery(Product.class);
		
		Root<Product> from = createQuery.from(Product.class);
		createQuery.where(criteriaBuilder.equal(from.get("name"), productName));
		
		TypedQuery<Product> typedQuery = entityManager.createQuery(createQuery);
		List<Product> resultList = typedQuery.getResultList();

		return resultList;
	}

	/* (non-Javadoc)
	 * @see pl.codeprime.services.ProductService#update(pl.codeprime.repositories.entity.Product)
	 */
	@Override
	public void update(Product product) {
		add(product);
	}

	/* (non-Javadoc)
	 * @see pl.codeprime.services.ProductService#add(pl.codeprime.repositories.entity.Product)
	 */
	@Override
	public void add(Product product) {
		productRepository.save(product);
	}

	/* (non-Javadoc)
	 * @see pl.codeprime.services.ProductService#add(pl.codeprime.webservices.rest.to.ProductTO)
	 */
	@Override
	public void add(ProductTO productTO) {
		Product product = ObjectConverters.toProduct(productTO);
		add(product);
	}

	/* (non-Javadoc)
	 * @see pl.codeprime.services.ProductService#save(pl.codeprime.repositories.entity.Product)
	 */
	@Override
	public Product save(Product product) {
		Product save = productRepository.save(product);
		return save;
	}

	/* (non-Javadoc)
	 * @see pl.codeprime.services.ProductService#findAll()
	 */
	@Override
	public List<Product> findAll() {
		
		ArrayList<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		
		return products;
	}

	/* (non-Javadoc)
	 * @see pl.codeprime.services.ProductService#findById(java.lang.Long)
	 */
	@Override
	public Product findById(Long productId) {

		Product product = null;
		Optional<Product> findById = productRepository.findById(productId);
		if(OptionalUtils.isNotEmpty(findById)) {
			product = findById.get();
		}
		
		return product;
	}
}
