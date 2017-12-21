/**
 * 
 */
package pl.codeprime.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.codeprime.repositories.entity.bills.shopping.Product;

/**
 * @author MOwsians
 *
 */
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends CrudRepository<Product,Long> {

}
